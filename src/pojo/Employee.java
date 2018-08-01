package pojo;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class Employee {
  private final SimpleStringProperty id;
  private final SimpleStringProperty name;
  private SimpleBooleanProperty viewable;

  public Employee(int id, SimpleStringProperty name) {
    this.id = new SimpleStringProperty(String.valueOf(id));
    this.name = name;
    this.viewable.set(true);
  }
}