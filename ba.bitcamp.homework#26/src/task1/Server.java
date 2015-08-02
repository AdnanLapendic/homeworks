package task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static final int PORT = 8787;

	public static void main(String[] args) {

		try {
			ServerSocket server = new ServerSocket(PORT);
			Socket client = server.accept();

			System.out.println("Client is connected...");

			BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			String path = null;

			while (client.isConnected()) {

				path = reader.readLine();
				if(path != null){
					break;
				}
				System.out.println(path);
			}

			System.out.println("Message from client has been reicived.");

			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			writer.write(doesFileExists(path));
			writer.newLine();
			writer.flush();
			
			System.out.println(doesFileExists(path) + "has been sent");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String doesFileExists(String path) {
		File file = new File(path);

		if (file.exists() == true) {
			return "1";
		} else {
			return "0";
		}
	}

}
