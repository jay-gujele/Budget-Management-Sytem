package pettycash;


public class Transaction {

	  private int transactionId;
	  private String transactionDate = new String();
	  private String description = new String();
	  private double expense;
	  private double income;
	  private double balance;
	  private int personId;

	  public Transaction() {

	  }

	  public int getTransactionId() {
	    return transactionId;
	  }

	  public int getPersonId() {
	    return personId;
	  }

	  public String getTransactionDate() {
	    return transactionDate;
	  }

	  public String getDescription() {
	    return description;
	  }

	  public double getExpense() {
	    return expense;
	  }

	  public double getIncome() {
	    return income;
	  }

	  public double getBalance() {
	    return balance;
	  }

	  public void setTransactionId(int transactionId) {
	    this.transactionId = transactionId;
	  }

	  public void setPersonId(int personId) {
	    this.personId = personId;
	  }

	  public void setTransactionDate(String transactionDate) {
	    this.transactionDate = transactionDate;
	  }

	  public void setDescription(String description) {
	    this.description = description;
	  }

	  public void setExpense(double expense) {
	    this.expense = expense;
	  }

	  public void setIncome(double income) {
	    this.income = income;
	  }

	  public void setBalance(double balance) {
	    this.balance = balance;
	  }

	}


						