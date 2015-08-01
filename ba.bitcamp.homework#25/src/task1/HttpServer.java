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

			writer.write("<!DOCTYPE html>" + "\n" + "<html>" + "\n" + "<body>" + "\n");
			writer.newLine();
			writer.flush();

			while (reader.ready()) {

				lineFromFile = reader.readLine();
				String[] nameAndLink = lineFromFile.split(" ");
				writer.write("<a href=" + nameAndLink[1] + ">" + nameAndLink[0] + "</a>\n");

			}

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

			// Waiting for client to connect
			while (true) {

				Socket client = server.accept();
				BufferedReader reader = new BufferedReader(new FileReader(links));
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

				while (reader.ready()) {

					writer.write(reader.readLine());
					writer.newLine();
					writer.flush();
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
