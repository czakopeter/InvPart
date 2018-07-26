package invpart;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;

public class ViewController implements Initializable {
  @FXML
  public StackPane menuPane;
  
  private void setMenuBar() {
    TreeItem<String> root = new TreeItem<>();
    
    TreeItem<String> settings = new TreeItem<>(Constants.MENU_SETTINGS);
    TreeItem<String> reports = new TreeItem<>(Constants.MENU_REPORT);
    TreeItem<String> exit = new TreeItem<>(Constants.MENU_EXIT);
    
    settings.getChildren().addAll(
            new TreeItem<>(Constants.MENU_LICENSE_PLATE)
    );
    reports.getChildren().addAll();
    
    
    root.getChildren().addAll(settings,reports,exit);
    
    TreeView<String> treeView = new TreeView<>(root);
    treeView.setShowRoot(false);
    menuPane.getChildren().addAll(treeView);
  }
  
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    setMenuBar();
  }  
  
}
