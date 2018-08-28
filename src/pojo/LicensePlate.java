package pojo;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class LicensePlate {
  private final SimpleStringProperty id;
  private final SimpleStringProperty licensePlate;
  private SimpleBooleanProperty used;
  private SimpleStringProperty validityDate;

  public LicensePlate(Integer id, String licensePlate, boolean used, String validityDate) {
    this.id = new SimpleStringProperty(String.valueOf(id));
    this.licensePlate = new SimpleStringProperty(licensePlate);
    this.used = new SimpleBooleanProperty(used);
    this.validityDate = new SimpleStringProperty(validityDate);
  }

  public boolean getUsed() {
    return used.get();
  }

  public void setUsed(boolean used) {
    this.used.set(used);
  }

  public String getValidityDate() {
    return validityDate.get();
  }

  public void setValidityDate(String validityDate) {
    this.validityDate.set(validityDate);
  }

  public String getId() {
    return id.get();
  }

  public String getLicensePlate() {
    return licensePlate.get();
  }
  
  
  
}
