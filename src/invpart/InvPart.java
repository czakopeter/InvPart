package invpart;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InvPart extends Application {
  
  @Override
  public void start(Stage stage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("View.fxml"));
    
    Scene scene = new Scene(root);
    stage.setTitle(Constants.WINDOWS_TITLE);
    stage.setScene(scene);
    stage.setMinWidth(Constants.WINDOWS_MIN_WIDTH);
    stage.setMinHeight(Constants.WINDOWS_MIN_HEIGHT);
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
  
}
