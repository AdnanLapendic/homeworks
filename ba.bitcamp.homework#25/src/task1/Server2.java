package task1;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Server2 is a class in which server is receiving two strings from Client one
 * of string should be address of a web site, and other should be name of that
 * site. Server2 is checking those strings, and if web page is valid, it will be
 * written to file which HTTP Server is using to make HTML file.
 * 
 * @author Adnan Lapendic
 *
 */
public class Server2 {
	public final static int PORT_SERVER2 = 8787;

	public static void main(String[] args) {

		try {
			BufferedReader fReader = new BufferedReader(
					new FileReader("C:\\Users\\Adnan\\workspace\\homeworks\\ba.bitcamp.homework#25\\addresses.txt"));

			// Initializing server
			ServerSocket server = new ServerSocket(PORT_SERVER2);

			// Waiting for client
			System.out.println("Waiting for client to connect...");
			Socket client = server.accept();

			BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			FileWriter fStream = new FileWriter(
					"C:\\Users\\Adnan\\workspace\\homeworks\\ba.bitcamp.homework#25\\addresses.txt", true);
			PrintWriter out = new PrintWriter(fStream);

			String link = "";
			String name = "";

			// Reading Strings sent from client and splitting it on "name" and
			// "web address"
			while (true) {

				String line = reader.readLine();
				String[] nameAndLink = line.split(" ");

				// Checking which part of string is address
				if (isItLink(nameAndLink[1]) == true) {

					Desktop.getDesktop().browse(new URL(nameAndLink[1]).toURI());
					link = nameAndLink[1];
					name = nameAndLink[0];

				} else if (isItLink(nameAndLink[0]) == true) {

					Desktop.getDesktop().browse(new URL(nameAndLink[0]).toURI());
					link = nameAndLink[0];
					name = nameAndLink[1];
				} else {
					System.out.println("One String must be a link!!!");
				}
				break;

			}

			// Adding name and link to file so it can be used by HTTP Server
			//file += ();
			out.println(name + " " + link);
			out.flush();

			// Closing everything
			reader.close();
			out.close();
			fStream.close();
			fReader.close();
			client.close();
			server.close();

		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method is checking if the string is an URL link
	 * 
	 * @param link
	 *            - String which is checking
	 * @return true or false
	 */
	public static boolean isItLink(String link) {
		boolean bool = true;

		try {

			URL url = new URL(link);
			url.toURI();
			URLConnection conn = url.openConnection();
			conn.connect();

		} catch (Exception e) {
			bool = false;
		}
		return bool;
	}

}
