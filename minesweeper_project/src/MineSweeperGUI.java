
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MineSweeperGUI extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private int ColCount;
	private int RowCount;
	private MineGrid grid;
	private JButton[][] buttons;
	private ButtonHandler[][] buttonHandlerList;
	private int[][] mines;
	
	private ArrayList<JButton> FlagList = new ArrayList<JButton>();

	public MineSweeperGUI(int rows, int cols, int mines, JLabel Smile, MineSweeper mineSweeper) {
		this.RowCount = rows;
		this.ColCount = cols;

		this.setLayout(new GridLayout(rows, cols));
		this.setBackground(Color.GRAY);
		this.setBorder(BorderFactory.createBevelBorder(3));
		grid = new MineGrid(rows, cols, mines);

		buttons = new JButton[rows][cols];
		buttonHandlerList = new ButtonHandler[rows][cols];


		for (int i = 0; i < rows; i++) {
			buttons[i] = new JButton[cols];
			buttonHandlerList[i] = new ButtonHandler[cols];
			for (int j = 0; j < cols; j++) {
				JButton button = new JButton();

				button.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						if (e.getButton() == 3) { 
							button.getModel().setPressed(false);

							if (!checkFlag(button))
							{
								ImageIcon icon = new ImageIcon("flag.png");
								Image image = icon.getImage();
								Image newimage = image.getScaledInstance(40, 30, java.awt.Image.SCALE_SMOOTH);
								ImageIcon newIcon = new ImageIcon(newimage);
								button.setIcon(newIcon);

								mineSweeper.descreaseMineCount();
								
								FlagList.add(button);								
							}

							else
							{
								button.setIcon(null);
								mineSweeper.increaseMineCount();
								FlagList.remove(button);								
							}
						}
					}
				});
				
				this.add(button);
				ButtonHandler buttonHandler = new ButtonHandler(i, j, grid, buttons, rows, cols, Smile);
				button.addActionListener(buttonHandler);
				buttonHandlerList[i][j] = buttonHandler;
				buttons[i][j] = button;
			}

		}
	}
	private boolean checkFlag(JButton button)
	{
		for (JButton button1 : FlagList) {
			if (button1 == button)
			{
				return true;
			}
		}
		return false;
	}
	public void setUpdater(Thread updater) {

		for (int i = 0; i < RowCount; i++) {
			for (int j = 0; j < ColCount; j++) {
				buttonHandlerList[i][j].setUpdater(updater);
			}
		}
	}

	public void flagMines(int r, int c) {
		JButton flagButton = new JButton();
		try {
			ImageIcon icon = new ImageIcon("flag.png");
			Image image = icon.getImage();
			Image newimage = image.getScaledInstance(40, 30, java.awt.Image.SCALE_SMOOTH);
			ImageIcon newIcon = new ImageIcon(newimage);
			flagButton.setIcon(newIcon);
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	public void mineList(int r, int c) {
		if (grid.isMine(r, c)) {
			mines[r][c] = grid.getCellContent(r, c);
		}
	}
}



