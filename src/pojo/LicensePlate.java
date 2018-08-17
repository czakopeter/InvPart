package pojo;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class LicensePlate {
  private final SimpleStringProperty id;
  private final SimpleStringProperty licensePlate;
  private SimpleBooleanProperty used;
  private SimpleStringProperty validityDate;

  public LicensePlate(String id, String licensePlate, boolean used, String validityDate) {
    this.id = new SimpleStringProperty(id);
    this.licensePlate = new SimpleStringProperty(licensePlate);
    this.used = new SimpleBooleanProperty(used);
    this.validityDate = new SimpleStringProperty(validityDate);
  }
}
