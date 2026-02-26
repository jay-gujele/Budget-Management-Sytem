package pettycash;


import java.util.*;


public class Finance {

  private FinanceDB db = new FinanceDB();
  private boolean confirmed = true;

  public Finance() {

  }

  public boolean validateDouble(String number) {
    boolean valid = true;
    double d = 0.0;
    try {
      d = Double.parseDouble(number);
    }
    catch (Exception ex) {
      valid = false;
    }
    return valid;
  }

  public double getCurrentBalance(int loggedUserId) {
    return db.getClosingBalance(loggedUserId);
  }

  public boolean processTransaction(Transaction transaction) {
    int id = db.getNextId();
    double closingBalance = db.getClosingBalance(transaction.getPersonId());
    transaction.setTransactionId(id);
    if (transaction.getExpense() != 0.0) {
      closingBalance = closingBalance - transaction.getExpense();
    }
    else {
      closingBalance = closingBalance + transaction.getIncome();
    }
    transaction.setBalance(closingBalance);
    confirmed = db.saveRecord(transaction);
    return confirmed;
  }

  public Vector getTransactions(int loggedUserId){
    return db.getAllTransaction(loggedUserId);
  }
}


					