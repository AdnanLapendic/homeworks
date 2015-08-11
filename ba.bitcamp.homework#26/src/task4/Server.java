package task4;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This class represent one server.
 * Server is receiving file from client and saves it on disc. 
 * 
 * @author Adnan Lapendic
 *
 */
public class Server {

	private String filename = "image1";

	/**
	 * Getter for file name. 
	 * Returns the name of file/picture.
	 */
	public String getFilename() {
		return filename;
	}

	@SuppressWarnings("resource")
	public void runServer() {
		try {
			ServerSocket server = new ServerSocket(8001);
			Socket client = server.accept();
			
			InputStream is = client.getInputStream();
			FileOutputStream writeFile = new FileOutputStream("src/"
					+ getFilename() + ".jpg");

			byte[] buffer = new byte[1024];
			int readSoFar;
			
			while ((readSoFar = is.read(buffer, 0, buffer.length)) > 0) {
				writeFile.write(buffer, 0, readSoFar);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}