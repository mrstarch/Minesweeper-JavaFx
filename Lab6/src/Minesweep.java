import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
public class Minesweep extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage theStage) {

		GameMode game = new GameMode(1); // change game mode here easy = 0, medium = 1, hard =2

		int[][] minefield = game.getMinefield();
		BombCount bombcount = new BombCount(game.getNumMines(), minefield);
		BorderPane bPane = new BorderPane();
		BorderPane top = new BorderPane();
		Smily face = new Smily();
		Timer timer = new Timer();
		top.setLeft(bombcount);
		top.setRight(timer);
		top.setCenter(face);
		CustomCenter grid = new CustomCenter(minefield, face, bombcount, timer, game);
		bPane.setBottom(grid);
		bPane.setTop(top);
		Scene scene = new Scene(bPane);
		
		bPane.setStyle("-fx-background-color: #bfbfbf;-fx-border-color: #fafafa #787878 #787878 #fafafa; -fx-border-width: 3; -fx-border-radius: 0.001; -fx-padding: 7;");
        top.setStyle("-fx-background-color: #bfbfbf; -fx-border-color: #787878 #fafafa #fafafa #787878; -fx-border-width: 3; -fx-border-radius: 0.001;");
        grid.setStyle("-fx-background-color: #bfbfbf; -fx-border-color: #787878 #fafafa #fafafa #787878; -fx-border-width: 3; -fx-border-radius: 0.001;");
		theStage.setTitle("Minesweeper");
		theStage.setScene(scene);
		theStage.show();

		face.setOnMouseClicked( e-> {
			Minesweep m = new Minesweep();
			m.start(theStage);
		});
		
		/* Print out board (same code in GameMode under randomize)
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