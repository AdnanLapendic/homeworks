package task1;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
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

public class Server2 {
	public final static int PORT_SERVER2 = 8787;

	public static void main(String[] args) {

		try {
			FileWriter fStream = new FileWriter(
					"C:\\Users\\Adnan\\workspace\\homeworks\\ba.bitcamp.homework#25\\addresses.txt", true);
			

			ServerSocket server = new ServerSocket(PORT_SERVER2);
			Socket client = server.accept();

			BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			BufferedWriter writer = new BufferedWriter(
					new FileWriter("C:\\Users\\Adnan\\workspace\\homeworks\\ba.bitcamp.homework#25\\addresses.txt"));

			PrintWriter out = new PrintWriter(fStream);
			
			String link = "";
			String name = "";
			while (true) {

				String line = reader.readLine();
				String[] nameAndLink = line.split(" ");

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
			out.println(name + " " + link);
			out.flush();
			out.close();
			fStream.close();

		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}

	}

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
