import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Smily extends Button{
	private double size = 40;
	private int state;
	private ImageView iFaceDead, iFaceO, iFaceSmile, iFaceWin;
	
	public Smily() {
		
		iFaceDead = new ImageView(new Image("File:res/face-dead.png"));
		iFaceO = new ImageView(new Image("File:res/face-O.png"));
		iFaceSmile = new ImageView(new Image("File:res/face-smile.png"));
		iFaceWin = new ImageView(new Image("File:res/face-win.png"));
		iFaceDead.setFitWidth(size);
		iFaceDead.setFitHeight(size);
		iFaceO.setFitWidth(size);
		iFaceO.setFitHeight(size);
		iFaceSmile.setFitWidth(size);
		iFaceSmile.setFitHeight(size);
		iFaceWin.setFitWidth(size);
		iFaceWin.setFitHeight(size);
		setMinWidth(size);
		setMaxWidth(size);
		setMinHeight(size);
		setMaxHeight(size);
		setSmile();

		
	}
	public void setSmile() {
		setGraphic(iFaceSmile);
		state = 0;
	}
	public void setDead() {
		setGraphic(iFaceDead);
		state = 1;
	}
	
	public void setO() {
		setGraphic(iFaceO);
	
	}
	public void setWin() {
		setGraphic(iFaceWin);
		state = 2;
		
	}
	public int getFace() {
		return state;
	}
}