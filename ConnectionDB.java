package pettycash;





import java.sql.*;


public class ConnectionDB {
  protected Connection con;
  protected Statement stmt;
  protected PreparedStatement query;
  protected ResultSet rs;

  public ConnectionDB() {
    dbConnect();
  }

  public void dbConnect() {
   
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
    }
    catch (java.lang.ClassNotFoundException e) {
      System.err.print("ClassNotFoundException: ");
      System.err.println(e.getMessage());
    }
    try {
      con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jay","jay");
      stmt = con.createStatement();
     // stmt.execute("use SFINANCE");
    }
    catch (SQLException ex) {
      System.err.println("SQLException dbConnect: " + ex.getMessage());
    }
  }

  public void dbClose() {
    try {
      stmt.close();
      con.close();
    }
    catch (SQLException ex) {
      System.err.println("SQLException dbClose: " + ex.getMessage());
    }
  }
}

