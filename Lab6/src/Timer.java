import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

public class Timer extends HBox {
	private int timer = 0;
	private Timeline animation;
	private ImageView d0,d1,d2;
	public Timer() {
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
		animation = new Timeline(new KeyFrame(Duration.millis(1000), e-> {
			timer++;
			d2.setImage(new Image("File:res/digits/" + timer % 10 + ".png")); 
			d1.setImage(new Image("File:res/digits/" + timer /10 % 10 + ".png")); 
			d0.setImage(new Image("File:res/digits/" + timer /100 % 10 + ".png")); 
		}));
		animation.setCycleCount(999);
	}
	
	public void startTime() {
		animation.play();
	}
	public void stopTime() {
		animation.stop();
	}
}