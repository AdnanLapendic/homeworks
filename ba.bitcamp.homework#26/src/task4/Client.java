package task4;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * This class is representing one client. After client connects to server, he
 * sends one file/picture on server.
 * 
 * @author Adnan Lapendic
 *
 */
public class Client {


	public static void main(String[] args) {

		try {
			
			//Connecting to server
			Socket client = new Socket("localhost", 8000);
			OutputStream writer = client.getOutputStream();
			
			//Reading picture
			FileInputStream reader = new FileInputStream("src/image1.jpg");

			byte[] buffer = new byte[1024];
			int bytesRead;
			
			//Sending picture in bytes
			while ((bytesRead = reader.read(buffer, 0, buffer.length)) > 0) {
				writer.write(buffer, 0, bytesRead);
			}
			
			client.close();
			reader.close();
			writer.close();
		} catch (IOException e) {
			System.err.println("Failed or interrupted I/O operation.");
			System.err.println("Message: " + e.getMessage());
		}
		

	}

}