
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class MineSweeper implements Runnable {
	private int NUM_MINES = 100;
	private static final int SIZE = 20;
	private JTextField minesCount;
	private static JTextField timer;
	private long StartTime;
	private Thread updater;
	private boolean go;
	private long a;
	

	public MineSweeper() {
		JFrame frame = new JFrame("MineSweeper");

		final JPanel timerAndCounter = new JPanel(); 
		timerAndCounter.setLayout(new BorderLayout());

		minesCount = new JTextField("" + NUM_MINES, 3); 
		minesCount.setEditable(false);
		minesCount.setFont(new Font("Digital-7 Mono", Font.BOLD, 25));
		minesCount.setBackground(Color.BLACK);
		minesCount.setForeground(Color.RED);
		

		timer = new JTextField("000", 3);
		timer.setEditable(false);
		timer.setFont(new Font("Digital-7 Mono", Font.BOLD, 25));
		timer.setBackground(Color.BLACK);
		timer.setForeground(Color.RED);

		JLabel Smile = new JLabel();
		try {
			ImageIcon icon = new ImageIcon("smiley.png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(40, 30, java.awt.Image.SCALE_SMOOTH);
			ImageIcon newIcon = new ImageIcon(newimg);
			Smile.setIcon(newIcon);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		Smile.setHorizontalAlignment(JLabel.CENTER);
		Smile.setVerticalAlignment(JLabel.CENTER);
		timerAndCounter.add(minesCount, BorderLayout.WEST);
		timerAndCounter.add(timer, BorderLayout.EAST);
		timerAndCounter.add(Smile, BorderLayout.CENTER);

		timerAndCounter.setBorder(BorderFactory.createLoweredBevelBorder());

		MineSweeperGUI mineSweeperGUI = new MineSweeperGUI(SIZE, SIZE, NUM_MINES, Smile, this);

		frame.add(mineSweeperGUI, BorderLayout.CENTER);
		frame.add(timerAndCounter, BorderLayout.NORTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 600);
		frame.setVisible(true);

		Start();

		mineSweeperGUI.setUpdater(updater);
	}

	public void descreaseMineCount() {
		NUM_MINES = NUM_MINES - 1;
		minesCount.setText("" + NUM_MINES);
	}

	public void increaseMineCount() {
		NUM_MINES = NUM_MINES + 1;
		minesCount.setText("" + NUM_MINES);
	}
	public static void main(String[] args) {
		new MineSweeper();
	}

	Runnable displayUpdater = new Runnable() {

		public void run() {
			displayElapsedTime(a);
			a++;
		}
	};
	private void displayElapsedTime(long elapsedTime) {
		if (elapsedTime >= 0 && elapsedTime < 9) {
			timer.setText("00" + elapsedTime);
		} else if (elapsedTime > 9 && elapsedTime < 99) {
			timer.setText("0" + elapsedTime);
		} else if (elapsedTime > 99 && elapsedTime < 999) {
			timer.setText("" + elapsedTime);
		}
	}

	public void Start() {
		StartTime = System.currentTimeMillis();
		go = true;
		updater = new Thread((Runnable) this);
		updater.start();
	}
	public void run() {
		try {
			while (go) {
				SwingUtilities.invokeAndWait(displayUpdater);
				Thread.sleep(1000);
			}
		} catch (java.lang.reflect.InvocationTargetException ite) {
			ite.printStackTrace(System.err);
		} catch (InterruptedException ie) {
		}
	}

	public void stop() {
		long elapsed = a;
		go = false;
		try {
			updater.join();
		} catch (InterruptedException ie) {
		}
		displayElapsedTime(elapsed);
		a = 0;
	}

}
