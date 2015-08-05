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


	@SuppressWarnings("resource")
	public static void main(String[] args) {

		try {
			
			//Connecting to server
			Socket client = new Socket("127.0.0.1", 8000);
			OutputStream writer = client.getOutputStream();
			
			//Reading picture
			FileInputStream reader = new FileInputStream("C:\\Users\\Adnan\\Desktop\\img.jpg");

			byte[] buffer = new byte[1024];
			int bytesRead;
			
			//Sending picture in bytes
			while ((bytesRead = reader.read(buffer, 0, buffer.length)) > 0) {
				writer.write(buffer, 0, bytesRead);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}