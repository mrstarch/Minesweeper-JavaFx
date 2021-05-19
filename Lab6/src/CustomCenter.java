import javafx.geometry.Pos;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;

public class CustomCenter extends GridPane{
	private MineButton[][] buttons = null;
	private int count = 0;
	private boolean isFirstClick = true;
	public CustomCenter(int[][] minefield, Smily face, BombCount bombcount, Timer timer, GameMode game) {
		for(int i =0; i<minefield.length; i++) {
			buttons = new MineButton[minefield.length][minefield[i].length];
		}
		setAlignment(Pos.CENTER);
		for(int row = 0; row < minefield.length; row++) {
			for(int col = 0; col < minefield[row].length ; col++) {
				buttons[row][col] = new MineButton();
				MineButton b = buttons[row][col];
				add(b,col,row);
				b.setOnMousePressed(e -> {
					MouseButton button = e.getButton();
					if (b.getState() == 0 && button == MouseButton.PRIMARY) {
						face.setO();
						b.setImageLeftClick(0,bombcount);
					}
				});

				b.setOnMouseReleased(e-> {
					face.setSmile();
					int rowButton = CustomCenter.getRowIndex(b);
					int colButton = CustomCenter.getColumnIndex(b);
					
					
					MouseButton button = e.getButton();
					if(b.getState() != 1 && button == MouseButton.SECONDARY) {
						b.setImageRightClick(bombcount);
					}

					if (b.getState() == 0 && button == MouseButton.PRIMARY) {
						timer.startTime();
						if (isFirstClick && minefield[rowButton][colButton] != 0){
							isFirstClick = false;
							while (minefield[rowButton][colButton] != 0){
								game.randomize();
							}
						}
						else {
							isFirstClick = false;
						}
						b.checkfield(minefield, rowButton, colButton, buttons, bombcount);
						b.setState(1);
						if (minefield[rowButton][colButton] == 9) {
							face.setDead();
						}
					}
					if (b.getState() == 1 && button == MouseButton.PRIMARY) {
						b.checkbomb(minefield, rowButton, colButton, buttons, bombcount, face);
					}

					count = 0;
					for(int row1 = 0; row1 < minefield.length; row1++) {
						for(int col1 = 0; col1 < minefield[row1].length ; col1++) {
							if(buttons[row1][col1].getState() == 1) {
								count++;
							}
						}
					}
					
					if (face.getFace() == 1) {
						setMouseTransparent(true);
						timer.stopTime();
						for(int rowtemp = 0; rowtemp < minefield.length; rowtemp++) {
							for(int coltemp = 0; coltemp < minefield[rowtemp].length; coltemp++) {
								if (minefield[rowtemp][coltemp] == 9  && buttons[rowtemp][coltemp].getState() != 1) {
									buttons[rowtemp][coltemp].setImageLeftClick(10, bombcount);
								}
							}
						}
					}
					else if(bombcount.getNonBombTiles() - count == 0) {
						setMouseTransparent(true);
						face.setWin();
						timer.stopTime();
					}
				});	
			}
		}
	}
}