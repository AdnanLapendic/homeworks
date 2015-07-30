package task1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * This class is used to make a mini GUI application which can make new root
 * directory, add files to that directory and delete files from any directory inside computer.
 * 
 * @author Adnan Lapendic
 *
 */
public class FileDistributer extends JFrame {

	private static final long serialVersionUID = 34317201060163638L;

	private JButton setRootDir;
	private JButton open;
	private JButton delete;
	private JPanel southPanel;
	private JFileChooser jfc = null;
	private ArrayList<String> pictures = new ArrayList<>();
	private ArrayList<String> audio = new ArrayList<>();
	private ArrayList<String> video = new ArrayList<>();
	private ArrayList<String> documents = new ArrayList<>();
	private String dirPicturePath;
	private String dirAudioPath;
	private String dirVideoPath;
	private String dirDocumentsPath;
	private String dirOtherPath;
	private JTextArea info = new JTextArea();

	/**
	 * Constructor
	 */
	public FileDistributer() {
		// adding extensions to ArrayList
		pictures.add("jpg");
		pictures.add("JPG");
		pictures.add("png");
		pictures.add("bmp");
		pictures.add("gif");
		audio.add("mp3");
		audio.add("wmv");
		video.add("mp4");
		video.add("avi");
		video.add("mkv");
		documents.add("txt");
		documents.add("doc");

		// Change LooK and Feel to be more natural
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {

			e.printStackTrace();
		}

		// adding and seting components
		setLayout(new BorderLayout());
		setDefaultLookAndFeelDecorated(rootPaneCheckingEnabled);
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		add(info, BorderLayout.CENTER);
		info.setEditable(false);
		info.setText(
				"1.First choose new Root directory \n2.Open is used to add files to new subdirectories \n3.Use Delete when you want to delete file");
		add(setRootDir = new JButton("Set new root directory"), BorderLayout.NORTH);
		setRootDir.addActionListener(new Action1());
		add(southPanel = new JPanel(), BorderLayout.SOUTH);
		southPanel.add(open = new JButton("Open"), BorderLayout.SOUTH);
		open.addActionListener(new Action2());
		southPanel.add(delete = new JButton("Delete"), BorderLayout.SOUTH);
		delete.addActionListener(new Action3());

		setVisible(true);
	}

	/**
	 * This class implements ActionListener. It is used to set new Root
	 * directory when application is started
	 *
	 */
	public class Action1 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (arg0.getSource() == setRootDir) {
				jfc = new JFileChooser();
				int action = jfc.showOpenDialog(null);
				if (action == JFileChooser.APPROVE_OPTION) {
					File dirRoot = new File(jfc.getCurrentDirectory(), "Root");
					dirRoot.mkdir();
					File dirPictures = new File(dirRoot.getAbsolutePath(), "Pictures");
					dirPictures.mkdir();
					dirPicturePath = dirPictures.getAbsolutePath();
					File dirAudio = new File(dirRoot.getAbsolutePath(), "Audio");
					dirAudio.mkdir();
					dirAudioPath = dirAudio.getAbsolutePath();
					File dirVideo = new File(dirRoot.getAbsolutePath(), "Video");
					dirVideo.mkdir();
					dirVideoPath = dirVideo.getAbsolutePath();
					File dirDocuments = new File(dirRoot.getAbsolutePath(), "Documents");
					dirDocuments.mkdir();
					dirDocumentsPath = dirDocuments.getAbsolutePath();
					File dirOther = new File(dirRoot.getAbsolutePath(), "Other");
					dirOther.mkdir();
					dirOtherPath = dirOther.getAbsolutePath();
				}
			}
		}
	}

	/**
	 * This class is used to parse file and get extension of selected file, and
	 * than move selected file to new location and new directory made just for
	 * this kind of files.
	 *
	 */
	public class Action2 implements ActionListener {
		String name;
		String ext;

		@Override
		public void actionPerformed(ActionEvent e) {
			File fileToBeCopyed = null;
			if (e.getSource() == open) {
				jfc = new JFileChooser();
				jfc.showOpenDialog(null);
				fileToBeCopyed = jfc.getSelectedFile();
				System.out.println(fileToBeCopyed.getAbsolutePath());
				String fileName = jfc.getSelectedFile().getName();
				StringTokenizer st = new StringTokenizer(fileName, ".");
				name = st.nextToken();
				ext = st.nextToken();
				System.out.println(ext);
			}
			// if selected file is picture
			if (pictures.contains(ext)) {
				File newPictureFile = new File(fileToBeCopyed.getAbsolutePath());
				if (newPictureFile.renameTo(new File(dirPicturePath + newPictureFile.getName()))) {
					info.setText("File: " + newPictureFile.getName() + " is moved successfuly!" + "\n" + "From "
							+ fileToBeCopyed.getAbsolutePath() + "\nto " + dirPicturePath);
				} else {
					info.setText(("File is failed to move!"));
				}

				// if selected file is video
			} else if (video.contains(ext)) {
				File newVideoFile = new File(fileToBeCopyed.getAbsolutePath());
				if (newVideoFile.renameTo(new File(dirVideoPath + newVideoFile.getName()))) {
					info.setText("File: " + newVideoFile.getName() + " is moved successfuly!" + "\n" + "From "
							+ fileToBeCopyed.getAbsolutePath() + "\nto " + dirPicturePath);
				} else {
					info.setText(("File is failed to move!"));
				}

				// if selected file is audio
			} else if (audio.contains(ext)) {
				File newAudioFile = new File(fileToBeCopyed.getAbsolutePath());
				if (newAudioFile.renameTo(new File(dirAudioPath + newAudioFile.getName()))) {
					info.setText("File: " + newAudioFile.getName() + " is moved successfuly!" + "\n" + "From "
							+ fileToBeCopyed.getAbsolutePath() + "\nto " + dirAudioPath);
				} else {
					info.setText(("File is failed to move!"));
				}

				// if selected file is document
			} else if (documents.contains(ext)) {
				File newDocFile = new File(fileToBeCopyed.getAbsolutePath());
				if (newDocFile.renameTo(new File(dirDocumentsPath + newDocFile.getName()))) {
					info.setText("File: " + newDocFile.getName() + " is moved successfuly!" + "\n" + "From "
							+ fileToBeCopyed.getAbsolutePath() + "\nto " + dirDocumentsPath);
				} else {
					info.setText(("File is failed to move!"));
				}

				// if selected file is other file
			} else {
				File newOtherFile = new File(fileToBeCopyed.getAbsolutePath());
				{
					if (newOtherFile.renameTo(new File(dirOtherPath + newOtherFile))) {
						info.setText("File: " + newOtherFile.getName() + " is moved successfuly!" + "\n" + "From "
								+ fileToBeCopyed.getAbsolutePath() + "\nto " + dirOtherPath);
					} else {
						info.setText(("File is failed to move!"));
					}
				}
			}

		}
	}

	/**
	 * This class implements ActionListener. It is used to delete selected file
	 * from JFileChooser.
	 *
	 */
	public class Action3 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			jfc = new JFileChooser();
			jfc.setApproveButtonText("Delete");
			jfc.showOpenDialog(null);
			File f = jfc.getSelectedFile();
			f.delete();
		}

	}

	public static void main(String[] args) {
		new FileDistributer();

	}

}
