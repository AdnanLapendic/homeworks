package task1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Class Client2 is used to connect to Server2. After connection is established
 * Client2 is sending two strings thru Console. One of strings should be web
 * address and other should be name of that address.
 * 
 * @author Adnan Lapendic
 *
 */
public class Client2 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		try {

			Socket client = new Socket(HttpServer.SERVER_ADDRESS, Server2.PORT_SERVER2);

			System.out.println("Connected to Server");

			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

			// Writing on Console
			System.out.println("Enter one web address an name of that web site.");
			System.out.println("Address must be in form \"http://website.ext\"");
			
			while (client.isConnected()) {

				writer.write(in.nextLine());
				writer.newLine();
				writer.flush();
			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
