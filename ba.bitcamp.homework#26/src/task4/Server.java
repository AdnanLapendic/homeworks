package task4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * This class represent one server. Server is receiving file from client and
 * saves it on disc.
 * 
 * @author Adnan Lapendic
 *
 */
public class Server {
	public static String fileName;

	public static void main(String[] args) {

		// Generating random name for new file
		Random rand = new Random();
		int randNum = rand.nextInt(10000);
		fileName = String.valueOf(randNum);

		try {

			ServerSocket server = new ServerSocket(8000);

			Socket client = server.accept();

			BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			String address = "src/index.html";
			BufferedWriter writer = new BufferedWriter(new FileWriter(address));
			writer.write(
					"<!DOCTYPE html><html><body><p>Here you can see picture that has been sent.</p><img src=\"image1.jpg\"><a href=\"http://t3.rbxcdn.com/c695611eaa7922bed0465d2cca560b93\">Open picture on web</a></body></html>");
			writer.newLine();
			writer.flush();

			InputStream is = client.getInputStream();
			FileOutputStream writeFile = new FileOutputStream("src/" + fileName + ".jpg");

			byte[] buffer = new byte[1024];
			int readSoFar;

			while ((readSoFar = is.read(buffer, 0, buffer.length)) > 0) {
				writeFile.write(buffer, 0, readSoFar);
			}
			server.close();
			client.close();
			reader.close();
			writer.close();
			writeFile.close();

		} catch (IOException e) {
			System.err.println("Failed or interrupted I/O operation.");
			System.err.println("Message: " + e.getMessage());
		}

	}
}
