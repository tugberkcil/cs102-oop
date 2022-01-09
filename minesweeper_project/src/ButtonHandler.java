
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ButtonHandler implements ActionListener {
	private JButton[][] buttons;
	private JLabel Smile;
	private Thread updater;
    private MineGrid grid;
	private int row;
	private int col;
	private int rowCount;
	private int colCount;
	
	public ButtonHandler(int x, int y, MineGrid grid, JButton[][] buttons, int rows, int cols, JLabel smile) {
		this.row = x;
		this.col = y;
		this.grid = grid;
		this.buttons = buttons;
		this.rowCount = rows;
		this.colCount = cols;

		this.Smile = smile;
	}

	public void setUpdater(Thread updater) {
		this.updater = updater;
	}

	private void openAllMines() {
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				if (grid.isMine(i, j) && (i != row && j != col)) {
					ImageIcon icon = new ImageIcon("mine.png");
					Image img = icon.getImage();
					Image newimg = img.getScaledInstance(40, 30, java.awt.Image.SCALE_SMOOTH);
					ImageIcon newIcon = new ImageIcon(newimg);
					this.buttons[i][j].setIcon(newIcon);
					this.buttons[i][j].setBackground(Color.gray);
				}
			}
		}
	}
	private void openDominoEffect(int i, int j) {
		if (isInsideGrid(i - 1, j - 1) && grid.getCellContent(i - 1, j - 1) == 0)
			openEffect(i - 1, j - 1);

		if (isInsideGrid(i - 1, j) && grid.getCellContent(i - 1, j) == 0)
			openEffect(i - 1, j);

		if (isInsideGrid(i - 1, j + 1) && grid.getCellContent(i - 1, j + 1) == 0)
			openEffect(i - 1, j + 1);

		if (isInsideGrid(i, j - 1) && grid.getCellContent(i, j - 1) == 0)
			openEffect(i, j - 1);

		if (isInsideGrid(i, j + 1) && grid.getCellContent(i, j + 1) == 0)
			openEffect(i, j + 1);

		if (isInsideGrid(i + 1, j - 1) && grid.getCellContent(i + 1, j - 1) == 0)
			openEffect(i + 1, j - 1);

		if (isInsideGrid(i + 1, j) && grid.getCellContent(i + 1, j) == 0)
			openEffect(i + 1, j);

		if (isInsideGrid(i + 1, j + 1) && grid.getCellContent(i + 1, j + 1) == 0)
			openEffect(i + 1, j + 1);
	}
	private void openEffect(int i, int j) {
		int cellContent = grid.getCellContent(i, j);
		this.buttons[i][j].setText(String.valueOf(cellContent));
	}

	private boolean isInsideGrid(int i, int j) {
		return (i >= 0 && i < rowCount) && (j >= 0 && j < colCount);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (grid.isMine(row, col) && (e.getSource() instanceof JButton)) {

			JButton mineButton = (JButton) e.getSource();
			try {
				ImageIcon icon = new ImageIcon("red mine.png");
				Image img = icon.getImage();
				Image newimg = img.getScaledInstance(40, 30, java.awt.Image.SCALE_SMOOTH);
				ImageIcon newIcon = new ImageIcon(newimg);
				mineButton.setIcon(newIcon);
				mineButton.setBackground(Color.red);
				openAllMines();

				if (this.updater != null) {
					this.updater.stop();
				}

				
				try {
					ImageIcon iconSmile = new ImageIcon("sad face.png");
					Image imgSmile = iconSmile.getImage();
					Image newimgSmile = imgSmile.getScaledInstance(40, 30, java.awt.Image.SCALE_SMOOTH);
					ImageIcon newIconSmile = new ImageIcon(newimgSmile);
					Smile.setIcon(newIconSmile);
				} catch (Exception ex) {
					System.out.println(ex);
				}
			} catch (Exception ex) {
				System.out.println(ex);
			}
			JOptionPane.showMessageDialog(null, "You Lost!");
			System.exit(0);
		} else {
			if (e.getSource() instanceof JButton) {
				JButton button = (JButton) e.getSource();
				int cellContent = grid.getCellContent(row, col);
				button.setText(String.valueOf(cellContent));

				if (cellContent == 0) {
					openDominoEffect(row, col);
				} else if (cellContent == 1)
					button.setForeground(Color.BLUE);
				else if (cellContent == 2)
					button.setForeground(Color.GREEN);
				else if (cellContent == 3)
					button.setForeground(Color.RED);
				else if (cellContent == 4) {
					Color colPurple = new Color(77, 54, 90);
					button.setForeground(colPurple);
				} else if (cellContent == 7)
					button.setForeground(Color.BLACK);
				else if (cellContent == 5)
					button.setForeground(Color.GRAY);
				else if (cellContent == 5) {
					Color colPurple = new Color(128, 0, 0);
					button.setForeground(colPurple);
				} else if (cellContent == 6)
					button.setForeground(Color.CYAN);
			}
		}
	}
}


	
