/*
 Class: Login
 Author: Shahrzad Jahangirian
 Update Date: Feb 18, 2014
 Description: This class has all database methods to be used for Login and signup.
  It is a child class of ConnectionDB cllass.
 */

package pettycash;

import java.sql.*;
import java.lang.*;



public class Login
    extends ConnectionDB {
  private int loggedUserId;

  public Login() {
    super();
  }

  public int getNextId() {
    int nextId = 0;
    try {
      query = con.prepareStatement(
          "select personid from person1");
      rs = query.executeQuery();
  if (rs.first()== false) {
        nextId = 1;
      }
      while (rs.next()) {
        if (rs.last() == true) {
          nextId = rs.getInt(1) + 1;
        }
      }
    }
    catch (SQLException ex) {
      System.err.println("SQLException getNextId: " + ex.getMessage());
    }
    return nextId;
  }

  public void saveUser(User user) {
    int nextId = getNextId();
    try {
      query = con.prepareStatement(
          "insert into person1 (personid,username,passwd)values(?, ?, ?)");
      query.setInt(1, nextId);
      query.setString(2, user.getUserName());
      query.setString(3, user.getPassword());
      query.executeUpdate();
    }
    catch (SQLException ex) {
      System.err.println("SQLException saveNewRecord: " + ex.getMessage());
    }
  }

  public boolean findUser(User user) {
    ResultSet rs;
    boolean found = false;
    try {
      query = con.prepareStatement(
          "select * from person1 where username like ? and passwd like ?");
      query.setString(1, user.getUserName());
      query.setString(2, user.getPassword());
      rs = query.executeQuery();
      if (rs.first() == true) {
        found = true;
        loggedUserId = rs.getInt(1);
      }
    }
    catch (SQLException ex) {
      System.err.println("SQLException saveNewRecord: " + ex.getMessage());
    }
    return found;
  }

  public int getLoggedUserId() {
    return loggedUserId;
  }

  public boolean findUsername(User user) {
    ResultSet rs;
    boolean found = false;
    try {
      query = con.prepareStatement(
          "select * from person1 where username like ?");
      query.setString(1, user.getUserName());
      rs = query.executeQuery();
    //  if (rs.first() == true) {
    //    found = true;
   //   }
    }
    catch (SQLException ex) {
      System.err.println("SQLException saveNewRecord: " + ex.getMessage());
    }
    return found;
  }

}


					