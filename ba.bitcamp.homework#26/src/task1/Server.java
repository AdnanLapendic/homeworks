package task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This class is representing one server which is receiving one String from
 * client. That string represents path to one file on Servers computer. Class
 * Server have one final static variable int PORT, and have one public static
 * method doesFileExists(String string) which checks does path sent from Client
 * represent file in Servers computer.
 * 
 * @author Adnan Lapendic
 *
 */
public class Server {

	public static final int PORT = 8787;

	public static void main(String[] args) {

		try {
			@SuppressWarnings("resource")
			ServerSocket server = new ServerSocket(PORT);
			Socket client = server.accept();

			System.out.println("Client is connected...");

			BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			String path = null;

			// Reading line from client
			while (client.isConnected()) {

				path = reader.readLine();
				if (path != null) {
					break;
				}
			}

			System.out.println("Message from client has been reicived.");

			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

			// Writing response to Client
			writer.write(doesFileExists(path));
			writer.newLine();
			writer.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method is checking if path received from client is a valid one. If
	 * file exist method will return "1", and if it does not, method will return
	 * "0".
	 * 
	 * @param path
	 *            - String received from Client
	 * @return 1 or 0
	 */
	public static String doesFileExists(String path) {
		File file = new File(path);

		if (file.exists() == true) {
			return "1";
		} else {
			return "0";
		}
	}

}
