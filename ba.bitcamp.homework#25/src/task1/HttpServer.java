package task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This class has been used to make HTTP Server. Server is reading from file a
 * list of links, and make a HTML file with read links and name of sites. After
 * making links.html the file is send to Client which has been connected to HTTP
 * Server. Class has 2 final static variables which are used ass port and IP
 * address.
 * 
 * @author Adnan Lapendic
 *
 */
public class HttpServer {
	public final static int PORT = 8787;
	public final static String SERVER_ADDRESS = "127.0.0.1";

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		String lineFromFile = "";

		File addresses = new File("C:\\Users\\Adnan\\workspace\\homeworks\\ba.bitcamp.homework#25\\addresses.txt");
		File links = new File("C:\\Users\\Adnan\\workspace\\homeworks\\ba.bitcamp.homework#25\\links.html");

		// Reading addresses from file
		// Writing links to HTML file
		try {

			BufferedReader reader = new BufferedReader(new FileReader(addresses));
			BufferedWriter writer = new BufferedWriter(new FileWriter(links));
			// Writing first lines in HTML document
			writer.write("<!DOCTYPE html>" + "\n" + "<html>" + "\n" + "<body>" + "\n" + "<h1>HTML Server</h1><br>"
					+ "<h2>BIT Camp</h2><br>");
			writer.newLine();
			writer.flush();
			// Writing links and names from file
			while (reader.ready()) {

				lineFromFile = reader.readLine();
				String[] nameAndLink = lineFromFile.split(" ");
				writer.write("<a href=" + nameAndLink[1] + ">" + nameAndLink[0] + "</a><br>\n");

			}

			// After all lines had been red and written, the end of file is
			// added
			writer.write("\n");
			writer.write("</body>" + "\n" + "</html>");
			writer.newLine();
			writer.flush();

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			ServerSocket server = new ServerSocket(PORT);
			System.out.println("Waiting client to connect...");

			// Waiting for client to connect
			Socket client = server.accept();
			System.out.println("Client connected.");

			while (true) {

				BufferedReader reader = new BufferedReader(new FileReader(links));
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

				// After client is connected, HTML file had been send.
				while (reader.ready()) {

					writer.write(reader.readLine());
					writer.newLine();
					writer.flush();
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("File has been sent");

	}

}
