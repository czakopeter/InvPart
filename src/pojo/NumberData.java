package pojo;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class NumberData {
  private final SimpleStringProperty id;
  private final SimpleStringProperty number;
  private SimpleIntegerProperty nameID;
  private SimpleIntegerProperty groupID;
  private SimpleBooleanProperty ownNet;
  private SimpleStringProperty validityDate;

  public NumberData(int id, String number, int nameID, int groupID, boolean ownNet, String validityDate) {
    this.id = new SimpleStringProperty(String.valueOf(id));
    this.number = new SimpleStringProperty(number);
    this.nameID = new SimpleIntegerProperty(nameID);
    this.groupID = new SimpleIntegerProperty(groupID);
    this.ownNet = new SimpleBooleanProperty(ownNet);
    this.validityDate = new SimpleStringProperty(validityDate);
  }

  public int getName() {
    return nameID.get();
  }

  public void setName(int name) {
    this.nameID.set(name);
  }

  public int getGroup() {
    return groupID.get();
  }

  public void setGroup(int group) {
    this.groupID.set(group);
  }

  public String getOwnNet() {
    return ownNet.getName();
  }

  public void setOwnNet(String ownNet) {
    this.ownNet.set(true);
  }
  
  public String getValidityDate() {
    return validityDate.get();
  }

  public void setValidityDate(String validityDate) {
    this.validityDate.get();
  }
}