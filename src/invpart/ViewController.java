package invpart;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import pojo.LicensePlate;

public class ViewController implements Initializable {
  @FXML
  public StackPane menuPane;
  @FXML
  public TableView licensePlateListTableView;
  
  
  private final ObservableList<LicensePlate> licencePlateData = FXCollections.observableArrayList();
  
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
    
    treeView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
      @Override
      public void changed(ObservableValue observable, Object oldValue, Object newValue) {
        TreeItem<String> selectedItem = (TreeItem<String>) newValue;
        String selectedMenu;
        selectedMenu = selectedItem.getValue();
        
        if(null != selectedMenu) {
          switch (selectedMenu) {
            
            case Constants.MENU_EXIT:
              System.exit(0);
              break;
          }
        }
      }
    });
  }
  
  private void setLicensePlateTableList() {
    TableColumn licensePlateCol = new TableColumn("Rendszám");
    licensePlateCol.setMinWidth(100);
    licensePlateCol.setCellValueFactory(new PropertyValueFactory<LicensePlate, String>("licensePlate"));
    
    TableColumn usedInfoCol = new TableColumn("Használatban");
    usedInfoCol.setMinWidth(100);
    usedInfoCol.setCellValueFactory(new PropertyValueFactory<LicensePlate, String>("used"));
    
    TableColumn validityDateCol = new TableColumn("Érvényesség");
    validityDateCol.setMinWidth(100);
    validityDateCol.setCellValueFactory(new PropertyValueFactory<LicensePlate, String>("validityDate"));
    
    licensePlateListTableView.getColumns().addAll(licensePlateCol, usedInfoCol, validityDateCol);
    
  }
  
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    setMenuBar();
    setLicensePlateTableList();
  }  
  
}
