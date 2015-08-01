package task1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client2 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		try {
			Socket client = new Socket(HttpServer.SERVER_ADDRESS, Server2.PORT_SERVER2);

			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		
			while(true){
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
