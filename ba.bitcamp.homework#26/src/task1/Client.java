package task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * This class represent one Client. Client writes on Console path to one file on
 * Servers computer. That path is sent to Server and after Server checked does
 * file exist, Server return response to Client.
 * 
 * @author Adnan Lapendic
 *
 */
public class Client {
	public static Scanner in;
	public static Socket client;
	public static BufferedWriter writer;
	public static BufferedReader reader;

	public static void main(String[] args) {

		in = new Scanner(System.in);

		try {
			client = new Socket("127.0.0.1", Server.PORT);

			System.out.println("Enter path of file.");

			writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

			//Writing path on Console
			while (client.isConnected()) {

				writer.write(in.nextLine());
				writer.newLine();
				writer.flush();
				System.out.println("Path to file has been sent.");
				break;
			}

			reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			String msgFromServer = reader.readLine();
			
			//Checking response from Server
			while (client.isConnected()) {
				
				if ("1".equals(msgFromServer)) {
					System.out.println("File does exist");
					break;
				} else if ("0".equals(msgFromServer)) {
					System.err.println("File does not exist.");
					break;
				} else {
					System.err.println("ERROR");
					break;
				}
				
			}
		} catch (UnknownHostException e) {
			System.err.println("IP address of a host could not be determined");
			System.err.println("Message: " +e.getMessage());
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Failed or interrupted I/O operation");
			System.err.println("Message: " + e.getMessage());
			System.exit(1);
			
		}

		in.close();
		try {
			client.close();
			reader.close();
			writer.close();
		} catch (IOException e) {
			System.err.println("Failed or interrupted I/O operation");
			System.err.println("Message: " + e.getMessage());
		}
	}

}
