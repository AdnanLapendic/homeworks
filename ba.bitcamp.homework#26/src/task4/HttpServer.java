package task4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
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

	public static void main(String[] args) {

		try {
			ServerSocket httpServer = new ServerSocket(8787);
			while (true) {
				Socket client = httpServer.accept();

				File htmlFile = new File("src/index.html");
				BufferedReader reader = new BufferedReader(new FileReader(htmlFile));
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

				while (reader.ready()) {
					writer.write(reader.readLine());
					writer.newLine();
					writer.flush();
				}
				httpServer.close();
				reader.close();
				writer.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}