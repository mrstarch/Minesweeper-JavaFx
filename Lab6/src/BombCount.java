import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

class BombCount extends HBox{
	private int bombCount;
	private int nonBombTiles = 0;
	private ImageView d0,d1,d2;
	private int initialBomb;
	public BombCount(int initialBomb, int [][]minefield) {
		this.initialBomb = initialBomb;
		bombCount = initialBomb;;
		for(int i = 0; i < minefield.length; i++) {
			nonBombTiles += minefield[i].length;
		}

		nonBombTiles -= bombCount; 
		d0 = new ImageView(new Image("File:res/digits/0.png"));
		d1 = new ImageView(new Image("File:res/digits/0.png"));
		d2 = new ImageView(new Image("File:res/digits/0.png"));
		d0.setFitWidth(20);
		d0.setFitHeight(40);
		d1.setFitWidth(20);
		d1.setFitHeight(40);
		d2.setFitWidth(20);
		d2.setFitHeight(40);
		
		getChildren().addAll(d0,d1,d2);
		setAlignment(Pos.CENTER);

		d2.setImage(new Image("File:res/digits/" + bombCount % 10 + ".png")); 
		d1.setImage(new Image("File:res/digits/" + bombCount/10 % 10 + ".png")); 
		d0.setImage(new Image("File:res/digits/" + bombCount /100 % 10 + ".png")); 
	}

	public int getNonBombTiles() {
		return nonBombTiles;
	}

	public int getBombCount() {
		return bombCount;
	}

	public void setBombCountMinus() {
		bombCount--;
		if(bombCount >= 0) {
			d2.setImage(new Image("File:res/digits/" + bombCount % 10 + ".png")); 
			d1.setImage(new Image("File:res/digits/" + bombCount/10 % 10 + ".png")); 
			d0.setImage(new Image("File:res/digits/" + bombCount /100 % 10 + ".png"));
		}
	}
	public void setBombCountPlus() {
		bombCount++;
		if (bombCount > 0 && bombCount <= initialBomb) {
			d2.setImage(new Image("File:res/digits/" + bombCount % 10 + ".png")); 
			d1.setImage(new Image("File:res/digits/" + bombCount/10 % 10 + ".png")); 
			d0.setImage(new Image("File:res/digits/" + bombCount /100 % 10 + ".png"));
		}
	}
}