package task1;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * This class extends JFrame. GUI is used to make a simple chat application.
 * This class is one of two classes needed for this program to work. It is very
 * simple to use, type message in field and click button "Send". It has one
 * private class Action and has one method getAction() which can open web site,
 * delete or run files and programs on computer.
 * 
 * @author Adnan Lapendic
 *
 */
public class Server extends JFrame {

	private static final long serialVersionUID = 8955243869222692807L;

	private JPanel southPanel;
	private JTextField msgField;
	private JButton sendButton;
	private JTextArea msgTextArea;
	@SuppressWarnings("unused")
	private JScrollBar scroll;
	private String textFromClient;
	private ServerSocket server;
	private Socket client;

	/**
	 * Constructor for object Server
	 */
	public Server() {

		setLayout(new BorderLayout());
		setSize(430, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("GUI Chat Server");
		add(southPanel = new JPanel(), BorderLayout.SOUTH);
		southPanel.add(msgField = new JTextField(30));
		southPanel.add(sendButton = new JButton("Send"));
		add(msgTextArea = new JTextArea());
		msgTextArea.setEditable(false);
		add(scroll = new JScrollBar(), BorderLayout.EAST);
		sendButton.addActionListener(new Action());

		setVisible(true);
		// Making ServerSocker and waiting for client to connect
		try {
			
			server = new ServerSocket(2307);
			client = server.accept();
		
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Infinite loop used for listening ports and writing on GUI panel
		// received messages
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			while (true) {
				textFromClient = reader.readLine();
				msgTextArea.append("Client: " + textFromClient + "\n");
				getAction(textFromClient);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This private class implements ActionListener, it has one method
	 * actionPerformed() which is used to send messages when button "Send" is
	 * clicked.
	 * 
	 * @author Adnan Lapendic
	 *
	 */
	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == sendButton) {

				String msg = msgField.getText();

				try {
					// Writing and sending messages
					BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
					writer.write(msg);
					writer.newLine();
					writer.flush();
					// Appending messages to TextArea
					msgTextArea.append("Me: " + msg + "\n");

				} catch (IOException e1) {
					e1.printStackTrace();
				}
				// Deleting sent message from TextField
				msgField.setText("");
			}

		}
	}

	/**
	 * This method is checking every message for "special" commands from Task#2
	 * /open - open file, /web - open web page, /delete - delete file specified
	 * in path, /list - write all files in that directory
	 * 
	 * @param text
	 *            - Received messages
	 */
	private void getAction(String text) {

		try {

			String[] line = text.split(" ", 2);
			File file = new File(line[1]);

			if (line[0].equals("/open")) {
				Desktop.getDesktop().open(file);

			} else if (line[0].equals("/web")) {
				Desktop.getDesktop().browse(new URL("http://" + line[1]).toURI());

			} else if (line[0].equals("/delete")) {
				file.delete();

			} else if (line[0].equals("/list")) {
				String[] list = file.list();

				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
				writer.write("Files in folder " + file);
				writer.newLine();

				for (String string : list) {
					writer.write(string);
					writer.newLine();
				}
				writer.flush();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		new Server();

	}

}