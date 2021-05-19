import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

class MineButton extends Button{
	private double size = 20;
	private int state = 0;
	private ImageView iCover, i0, i1, i2,i3,i4,i5,i6,i7,i8,iFlag, iMineGrey, iMineRed, iMineMisflag;
	public MineButton() {
		setMinWidth(size);
		setMaxWidth(size);
		setMinHeight(size);
		setMaxHeight(size);

		iCover = new ImageView(new Image("File:res/cover.png"));
		i0 = new ImageView(new Image("File:res/0.png"));
		i1 = new ImageView(new Image("File:res/1.png"));
		i2 = new ImageView(new Image("File:res/2.png"));
		i3 = new ImageView(new Image("File:res/3.png"));
		i4 = new ImageView(new Image("File:res/4.png"));
		i5 = new ImageView(new Image("File:res/5.png"));
		i6 = new ImageView(new Image("File:res/6.png"));
		i7 = new ImageView(new Image("File:res/7.png"));
		i8 = new ImageView(new Image("File:res/8.png"));
		iFlag = new ImageView(new Image("File:res/flag.png"));
		iMineGrey = new ImageView(new Image("File:res/mine-grey.png"));
		iMineRed = new ImageView(new Image("File:res/mine-red.png"));
		iMineMisflag = new ImageView(new Image("File:res/mine-misflagged.png"));

		iCover.setFitWidth(size);
		iCover.setFitHeight(size);
		i0.setFitWidth(size);
		i0.setFitHeight(size);
		i1.setFitWidth(size);
		i1.setFitHeight(size);
		i2.setFitWidth(size);
		i2.setFitHeight(size);
		i3.setFitWidth(size);
		i3.setFitHeight(size);
		i4.setFitWidth(size);
		i4.setFitHeight(size);
		i5.setFitWidth(size);
		i5.setFitHeight(size);
		i6.setFitWidth(size);
		i6.setFitHeight(size);
		i7.setFitWidth(size);
		i7.setFitHeight(size);
		i8.setFitWidth(size);
		i8.setFitHeight(size);
		iFlag.setFitWidth(size);
		iFlag.setFitHeight(size);
		iMineGrey.setFitWidth(size);
		iMineGrey.setFitHeight(size);
		iMineRed.setFitWidth(size);
		iMineRed.setFitHeight(size);
		iMineMisflag.setFitWidth(size);
		iMineMisflag.setFitHeight(size);
		setGraphic(iCover);
	}

	public void setImageRightClick(BombCount count) {

		if(getGraphic().equals(iFlag)) {
			setGraphic(iCover);
			state =0;
			count.setBombCountPlus();
		}
		else {//if(count.getBombCount() != 0){
			setGraphic(iFlag);
			state =2;
			count.setBombCountMinus();
		}
	}

	public void checkfield(int[][] minefield, int row, int col, MineButton[][] buttons, BombCount bcount) {
		buttons[row][col].setImageLeftClick(minefield[row][col], bcount);
		if(minefield[row][col] == 0) {	
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
					if (buttons[row1][col1].getState() == 0) {
						buttons[row1][col1].setState(1);
						checkfield(minefield, row1, col1, buttons, bcount);
					}
				}
			}
		}
	}

	public void checkbomb(int[][] minefield, int row, int col, MineButton[][] buttons, BombCount bcount, Smily face) {
		int rowlimit = 3;
		int collimit = 3;
		int count = 0;
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
				if (buttons[row1][col1].getState() == 2) {
					count ++;
				}
			}
		}
		if(count == minefield[row][col]) {
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
					if (buttons[row1][col1].getState() == 0) {
						buttons[row1][col1].setImageLeftClick(minefield[row1][col1], bcount);
						buttons[row1][col1].setState(1);
						if(minefield[row1][col1] == 9) {
							face.setDead();
							buttons[row1][col1].setImageLeftClick(9, bcount);
						}
						if(minefield[row1][col1] == 0) {
							checkfield(minefield, row1, col1, buttons, bcount);
						}
					}
				}
			}
		}
	}

	public void setImageLeftClick(int x, BombCount bcount) {
		switch (x){
		case 0:
			setGraphic(i0);
			break;
		case 1:
			setGraphic(i1);
			break;
		case 2:
			setGraphic(i2);
			break;
		case 3:
			setGraphic(i3);
			break;
		case 4:
			setGraphic(i4);
			break;
		case 5:
			setGraphic(i5);
			break;
		case 6:
			setGraphic(i6);
			break;
		case 7:
			setGraphic(i7);
			break;
		case 8:
			setGraphic(i8);
			break;
		case 9:
			setGraphic(iMineRed);
			break;
		case 10:
			setGraphic(iMineGrey);
			break;
		case 11:
			setGraphic(iMineMisflag); 
			break;
		}
	}

	public int getState() {
		return state;
	}

	public void setState(int x) {
		state = x;
	}
}