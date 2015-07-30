package ba.bitcamp.task9;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * This class is asking from user to enter one text file path in Text box, after
 * pressing Enter on keyboard on screen in text area will appear file content
 * 
 * @author LAPA
 *
 */
public class Task9ImportTextFile extends JFrame {

	private static final long serialVersionUID = -4681466326988201520L;

	private JPanel panel = new JPanel();
	private JTextField file = new JTextField(25);
	private JLabel location = new JLabel("Enter file location");
	private JTextArea textArea = new JTextArea();

	public Task9ImportTextFile() {
		setSize(300, 500);
		add(panel);
		panel.add(location);
		panel.add(file);
		panel.add(textArea);
		file.addActionListener(new Action());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		setVisible(true);

	}

	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			String fileLocation = file.getText();

			try {
				@SuppressWarnings("resource")
				BufferedReader br = new BufferedReader(new FileReader(
						fileLocation));

				StringBuilder sb = new StringBuilder();
				String line = br.readLine();

				while (line != null) {
					sb.append(line);
					sb.append(System.lineSeparator());
					line = br.readLine();
				}
				String everything = sb.toString();
				textArea.setText(everything);
				System.out.println(everything);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "File didn't found");
			}

		}
	}

	public static void main(String[] args) {
		new Task9ImportTextFile();
	}
}
