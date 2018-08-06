package pojo;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class LicencePlate {
  private final SimpleStringProperty id;
  private final SimpleStringProperty licensePlate;
  private SimpleBooleanProperty used;
  private SimpleStringProperty validityDate;

  public LicencePlate(String id, String licensePlate, boolean used, String validityDate) {
    this.id = new SimpleStringProperty(id);
    this.licensePlate = new SimpleStringProperty(licensePlate);
    this.used.set(used);
    this.validityDate.set(validityDate);
  }
  
  
}
