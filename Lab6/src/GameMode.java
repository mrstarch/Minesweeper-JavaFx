public class GameMode {
	private int[][] minefield;
	private int numMines;
	
	public GameMode(int mode){ //mode 0=Beginner, 1=Intermediate, 2=Expert
		if(mode == 0) {
			minefield=new int[8][8];
			numMines = 10;

			for (int i=0; i<numMines ;i++) {
				int row = (int)(Math.random() * minefield.length);
				int col = (int)(Math.random() * minefield[row].length);
				if(minefield[row][col] == 9) {
					i--;
				}
				else {
					minefield[row][col] = 9;
				}
			}
		}

		else if(mode == 1) {
			minefield=new int[16][16];
			numMines = 40;
			for (int i=0; i<numMines ;i++) {
				int row = (int)(Math.random() * minefield.length);
				int col = (int)(Math.random() * minefield[row].length);
				if(minefield[row][col] == 9) {
					i--;
				}
				else {
					minefield[row][col] = 9;
				}
			}
		}
		else if(mode == 2) {
			minefield=new int[16][32];
			numMines = 99;
			for (int i=0; i<numMines ;i++) {
				int row = (int)(Math.random() * minefield.length);
				int col = (int)(Math.random() * minefield[row].length);
				if(minefield[row][col] == 9) {
					i--;
				}
				else {
					minefield[row][col] = 9;
				}
			}
		}
		populateField();
	}


	public int[][] getMinefield(){
		return minefield;
	}
	public int getNumMines() {
		return numMines;
	}
	public static boolean validField(int x, int y, int[][] minefield){
		return minefield[x][y] !=9;
	}
	public void populateField() {
		for(int row = 0; row < minefield.length; row++) {
			for(int col = 0; col < minefield[row].length ; col++) {

				if(minefield[row][col] == 9) {
					int rowlimit = 3;
					int collimit = 3;
					if(row == 0 || row == minefield.length-1) {
						rowlimit--;
					}
					if(col == 0 || col == minefield[row].length-1) {
						collimit--;
					}

					for(int rowtemp = 0; rowtemp < rowlimit; rowtemp++) {
						for(int coltemp = 0; coltemp < collimit; coltemp++) {
							int col1 = col + coltemp -1;
							int row1 = row + rowtemp -1;
							if(col == 0) {
								col1++;
							}
							if(col == minefield[row].length) {
								col1--;
							}
							if(row == 0) {
								row1++;
							}
							if(row == minefield.length) {
								row1--;
							}
							if (minefield[row1][col1] < 9) {
								minefield[row1][col1]++;
							}
						}
					}
				}
			}
		}
	}
	public void randomize() {
		for(int row = 0; row < minefield.length; row++) {
			for(int col = 0; col < minefield[row].length; col++) {
				minefield[row][col] = 0;
			}
		}
		for (int i=0; i<numMines ;i++) {
			int row = (int)(Math.random() * minefield.length);
			int col = (int)(Math.random() * minefield[row].length);
			if(minefield[row][col] == 9) {
				i--;
			}
			else {
				minefield[row][col] = 9;
			}
		}
		populateField();
		/* Print board (same code in Minesweep)
		 * 
		for(int row = 0; row < minefield.length; row++) {
			for(int col = 0; col < minefield[row].length ; col++) {
				System.out.print(minefield[row][col]+", ");
			}
			System.out.println();
		}
		System.out.println();
		*/
	}
}
