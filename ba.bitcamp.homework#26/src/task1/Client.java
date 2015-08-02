package task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		try {
			Socket client = new Socket("127.0.0.1", Server.PORT);
			
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			
			while(client.isConnected()){
				
				writer.write(in.nextLine());
				writer.newLine();
				writer.flush();
				System.out.println("Path to file has been sent.");
				break;
			}
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			
			
			
			while(true){
				if(reader.readLine().equals("1")){
					System.out.println("File does exist");
					break;
				}else if(reader.readLine().equals("0")){
					System.out.println("File does not exist.");
					break;
				}else {
					System.out.println("ERROR");
				}
				break;
			}
			System.out.println("");
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
