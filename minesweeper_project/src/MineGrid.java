
import java.util.Random;

public class MineGrid {
	private int[][] mineInformation;
	private static final int MINE = -1;
	private int[][] mines;
	
	public MineGrid(int rows, int cols, int numMines) {
		mineInformation = new int[rows][cols];
		initializeCells();
		placeMines(numMines);
		setMineInformation();
	}

	private void initializeCells() {
		for (int i = 0; i < mineInformation.length; i++) {
			for (int j = 0; j < mineInformation[0].length; j++) {
				mineInformation[i][j] = 0;
			}
		}
	}

	private void placeMines(int numMines) {
		Random random = new Random();
		for (int i = 0; i < numMines; i++) {
			int r = random.nextInt(mineInformation.length);
			int c = random.nextInt(mineInformation[0].length);
			if (mineInformation[r][c] != MINE)
				mineInformation[r][c] = MINE;
			else
				i--;
		}
	}
	private void increaseMineCountAt(int i, int j) {
		if (!isMine(i, j) && isInsideGrid(i, j))
			mineInformation[i][j]++;

	}

	private void setMineInformation() {
		for (int i = 0; i < mineInformation.length; i++) {
			for (int j = 0; j < mineInformation[0].length; j++) {
				if (mineInformation[i][j] == MINE) {
					if (isInsideGrid(i - 1, j - 1))
						increaseMineCountAt(i - 1, j - 1);

					if (isInsideGrid(i - 1, j))
						increaseMineCountAt(i - 1, j);

					if (isInsideGrid(i - 1, j + 1))
						increaseMineCountAt(i - 1, j + 1);

					if (isInsideGrid(i, j - 1))
						increaseMineCountAt(i, j - 1);

					if (isInsideGrid(i, j + 1))
						increaseMineCountAt(i, j + 1);

					if (isInsideGrid(i + 1, j - 1))
						increaseMineCountAt(i + 1, j - 1);

					if (isInsideGrid(i + 1, j))
						increaseMineCountAt(i + 1, j);

					if (isInsideGrid(i + 1, j + 1))
						increaseMineCountAt(i + 1, j + 1);
				}
			}
		}
	}
	private boolean isInsideGrid(int i, int j) {
		return (i >= 0 && i < mineInformation.length) && (j >= 0 && j < mineInformation[0].length);
	}

	public boolean isMine(int i, int j) {
		return mineInformation[i][j] == MINE;
	}

	public int getCellContent(int i, int j) {
		return mineInformation[i][j];
	}
	public void mineList(int i, int j) {
		if(isMine(i, j)) {
			mines[i][j]=getCellContent(i,j);
		}		
	}
}

	