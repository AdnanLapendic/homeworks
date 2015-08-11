package task4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Class HTTPServer starts Server class that receives file from client, after
 * that HTTPServer write in html file link of that picture which can be shown if
 * we click on link.
 * 
 * @author Adnan Lapendic
 *
 */
public class HttpServer {

	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) {

		Server s = new Server();
		s.runServer();

		try {
			ServerSocket httpServer = new ServerSocket(8000);
			while (true) {
				Socket client = httpServer.accept();

				BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));

				String address = "C:\\Users\\Adnan\\workspace\\homeworks\\ba.bitcamp.homework#26\\src\\index.html";
				BufferedWriter writer = new BufferedWriter(new FileWriter(address));

				writer.write(
						"<!DOCTYPE html><html><body><a href=\"http://i477.photobucket.com/albums/rr136/DeathNCash/rock_tux.png\">Picture</a></body></html>");
				writer.newLine();
				writer.flush();

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}