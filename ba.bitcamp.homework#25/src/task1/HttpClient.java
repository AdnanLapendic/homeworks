package task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * This class is represent one Client which will be connected to HTTP Server.
 * After connection is established Client will receive HTML file from server.
 * 
 * @author Adnan
 *
 */
public class HttpClient {

	@SuppressWarnings({ "resource" })
	public static void main(String[] args) {

		try {

			Socket client = new Socket(HttpServer.SERVER_ADDRESS, HttpServer.PORT);
			BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));

			BufferedWriter writer = new BufferedWriter(new FileWriter(new File("Adnan")));

			while (reader.ready()) {

				writer.write(reader.readLine());
				writer.newLine();
				writer.flush();
				// System.out.println(reader.readLine());

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
