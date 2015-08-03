package task3;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AbcThread extends JFrame {

	private static final long serialVersionUID = -6656642029200918546L;

	private static JLabel abc;
	private JButton stop;
	public static int BREAK = 100;
	private Thread t;

	public AbcThread() {
		setLayout(new BorderLayout());
		setSize(300, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		add(abc = new JLabel(), BorderLayout.CENTER);
		add(stop = new JButton("Stop"), BorderLayout.SOUTH);
		stop.addActionListener(new Action());
		t = new Thread(new MyThread());
		t.start();

		setVisible(true);

	}

	class Action implements ActionListener {

		MyThread mt = null;

		@Override
		public void actionPerformed(ActionEvent arg0) {

			if (arg0.getSource() == stop) {

				t.interrupt();

			}

		}

	}

	public static void main(String[] args) {

		AbcThread abc = new AbcThread();

	}

	static class MyThread implements Runnable {
		Thread t = new Thread();

		@Override
		public void run() {
			String s = "";
			for (int i = 65; i < 90; i++) {

				s += (char) i + " ";
				abc.setText(s);

				try {

					t.sleep(1000);
				
				} catch (InterruptedException e) {
					i = BREAK;
				}
			}
		}

	}

}
