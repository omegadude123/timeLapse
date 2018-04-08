package timelapse;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class gui {
	private JFrame frame;
	WindowAdapter adapter;
	static JLabel text;
	static JLabel lblNewLabel = new JLabel();

	/**
	 * Launch the application.
	 */
	public static void updateImage(BufferedImage newframe) {

		lblNewLabel.setIcon(new ImageIcon(newframe.getScaledInstance(2000, 1000, Image.SCALE_FAST)));

	}

	public static void fps(long time) {
		text.setText(Long.toString(time));
	}

	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui window = new gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {

		text = new JLabel("fps");
		frame = new JFrame();
		frame.setBounds(100, 100, 1106, 640);

		frame.getContentPane().setLayout(null);

		text.setBounds(0, 0, 93, 46);
		frame.getContentPane().add(text);
		text.setFont(new Font("Coolvetica Rg", Font.BOLD, 25));
		text.setForeground(Color.GREEN);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setBounds(0, 0, 2000, 1000);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent event) {
				exitProcedure();
			}

			private void exitProcedure() {
				Main.shouldRun = false;
				frame.dispose();
				System.exit(0);

			}
		});

	}

}
