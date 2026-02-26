package pettycash;



import java.sql.*;
import java.util.*;


import java.lang.*;


public class FinanceDB extends ConnectionDB {

  public FinanceDB() {
    super();
  }

  public int getNextId() {
    int nextId = 0;
    try {
      query = con.prepareStatement(
          "select * from TRANSACTION1");
      rs = query.executeQuery();
      while(rs.next())
     if (rs.isLast()) {
        nextId = 0;
     }
     else {
        rs.last();
        nextId = rs.getInt(1) + 1;
     }
    }
    catch (SQLException ex) {
      System.err.println("SQLException getNextId: " + ex.getMessage());
    }
    return nextId;
  }


  public double getClosingBalance(int loggedUser) {
	 
    double closingBalance = 0.0;
    try {
      query = con.prepareStatement(
          "select * from TRANSACTION1 where personid = ?");
      query.setInt(1, loggedUser);
      rs = query.executeQuery();
      if (!rs.next()) {
        closingBalance = 0.0;
      }
      else {
      rs.last();
        closingBalance = rs.getDouble(6);
      }
    }
    catch (SQLException ex) {
      System.err.println("SQLException getClosingBalance: " + ex.getMessage());
    }
    return closingBalance;
  }


  public boolean saveRecord(Transaction record) {
    boolean ok = true;
    try {
      query = con.prepareStatement( "insert into TRANSACTION1 (transactionid,transactiondate,description,expense,income,balance,personid)values (?, ?, ?, ?, ?, ?, ?)");
      query.setInt(1, record.getTransactionId());
      query.setString(2, record.getTransactionDate());
      query.setString(3, record.getDescription());
      query.setDouble(4, record.getExpense());
      query.setDouble(5, record.getIncome());
      query.setDouble(6, record.getBalance());
      query.setInt(7, record.getPersonId());
      query.executeUpdate();
    }
    catch (SQLException ex) {
      ok = false;
      System.err.println("SQLException saveRecord: " + ex.getMessage());
    }
    return ok;
  }

  public Vector < Transaction > getAllTransaction(int loggedUserId) {
    Vector < Transaction > list = new Vector < Transaction > ();
    Transaction record = new Transaction();
    try {
      PreparedStatement query =
          con.prepareStatement(
          "select * from TRANSACTION1 where personid = ?");
      query.setInt(1, loggedUserId);
      rs = query.executeQuery();
      while (rs.next()) {
        record.setTransactionId(rs.getInt(1));
        record.setTransactionDate(rs.getString(2));
        record.setDescription(rs.getString(3));
        record.setExpense(rs.getDouble(4));
        record.setIncome(rs.getDouble(5));
        record.setBalance(rs.getDouble(6));
        record.setTransactionId(rs.getInt(7));
        list.add(record);
        record = new Transaction();
      }
    }
    catch (SQLException ex) {
      System.err.println("SQLException getAllTransaction: " + ex.getMessage());
    }
    return list;
  }
 /* public static int delete(int id){
		int status=0;
		try{ 
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from transaction where description=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);
		return status;
	}

}*/
}

					