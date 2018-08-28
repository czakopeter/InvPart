package invpart;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import pojo.LicensePlate;

public class DBConnection {
  final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
  final String URL = "jdbc:derby:invPartDB;create=true";
  final String USERNAME = "";
  final String PASSWORD = "";
  
  Connection conn = null;
  Statement creatStatement = null;
  DatabaseMetaData dbmd = null;

  public DBConnection() {
    //Connect to database
    try {
      conn = DriverManager.getConnection(URL);
      System.out.println("Can connect");
    } catch (SQLException ex) {
      System.err.println("Can't connect");
    }
    
    if(conn != null) {
      try {
        creatStatement = conn.createStatement();
        System.out.println("Creat statement");
      } catch (SQLException ex) {
        System.err.println("Can't creat statement");
      }
    }
    
    try {
       dbmd = conn.getMetaData();
       System.out.println("Get meta data");
    } catch (SQLException ex) {
      System.err.println("Can't get meta data");
    }
    
    try {
      ResultSet rs = dbmd.getTables(null, "APP", "CONTACTS", null);
      if(!rs.next()) {
        String creatLicensePlateTable = "create table licensePlate(";
        String sqlPrimaryKey = "id INT not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)";
        String sqlLicensePlateColl = ",licensePlate varchar(6), used int(1), validityDate varchar(8)";
        creatStatement.execute(creatLicensePlateTable.concat(sqlPrimaryKey.concat(sqlLicensePlateColl)));
      }
    } catch (SQLException ex) {
      System.err.println("Catn't creat table");
    }
  }
  
  public ArrayList<LicensePlate> getAllLicensePlate() {
    String sql = "select * from licensePlate";
    ArrayList<LicensePlate> allLicensePlate = null;
    try {
      ResultSet rs = creatStatement.executeQuery(sql);
      allLicensePlate = new ArrayList<>();
      while (rs.next()) {
        LicensePlate actualLP = new LicensePlate(
                rs.getInt("id"),
                rs.getString("licensePlate"),
                rs.getBoolean("used"),
                rs.getString("validityDate"));
        allLicensePlate.add(actualLP);
      }
    }catch(SQLException ex) {
      System.err.println("Can't get result");
    }
    return allLicensePlate;
  }
}
