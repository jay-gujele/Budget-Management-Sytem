/*
 Class: FinanceUI
 Author: Shahrzad Jahangirian
 Date: Jan 22, 2014
 Description: FinanceUI is the User Interface for this Application. User need to input
 a record of expense or income details at top of Application using Date, Description,
 Expense or Income Text boxes. It displays User Current Balance and all already saved
 transactions records that have been saved on Database.
 */
package pettycash;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.table.*;


public class FinanceUI
    extends JFrame {
  private JLabel statusBarLabel = new JLabel();
  private JLabel balanceTitleLabel = new JLabel();
  private JLabel balanceValueLabel = new JLabel();
  private JLabel dateLabel = new JLabel();
  private JLabel descriptionLabel = new JLabel();
  private JLabel expensesLabel = new JLabel();
  private JLabel incomeLabel = new JLabel();
  private JTextField dateTextField = new JTextField();
  private JTextField descriptionTextField = new JTextField();
  private JTextField expensesTextField = new JTextField();
  private JTextField incomeTextField = new JTextField();
  private JButton addButton = new JButton();
  private Object columnNames[] = {
      "Date", "Description", "Expense", "Income", "Balance"};
  private DefaultTableModel tableModel = new DefaultTableModel();
  private JTable financeTable = new JTable(tableModel);
  private JScrollPane financeScrollPane = new JScrollPane(financeTable);
  private static final long serialVersionUID = 12345678L;
  private FormatUI format = new FormatUI();
  private Transaction transaction = new Transaction();
  private Finance finance = new Finance();
  private boolean once = false;
  private DecimalFormat twoDecimal = new DecimalFormat("#.##");
  private int loggedUserId;

  public FinanceUI() {
    try {
      jbInit();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  public FinanceUI(int loggedUserId) {
    try {
      this.loggedUserId = loggedUserId;
      jbInit();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }


  private void jbInit() throws Exception {
    addButton.addActionListener(new FinanceUI_addButton_actionAdapter(this));

    formatUserInterfaces();
    displayTransaction();
    balanceValueLabel.setText("$" + twoDecimal.format(finance.getCurrentBalance(loggedUserId)));
    customizingTable();
    this.getContentPane().setBackground(new Color(236, 233, 231));
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    addToContentPane();
    this.setSize(850, 600);
    this.setResizable(false);
    this.getContentPane().setLayout(new BorderLayout());
    this.setTitle("Personal Finance");
  }

  public void formatUserInterfaces() {

    balanceTitleLabel = format.formatLabel(balanceTitleLabel, "Current Balance: ",
                                           15, 20,
                                           115, 25, 236, 233, 231, 100, 100,
                                           100,
                                           "Arial", 0, 14,
                                           SwingConstants.CENTER,
                                           SwingConstants.LEFT);

    balanceValueLabel = format.formatLabel(balanceValueLabel, "",
                                           130, 20,
                                           700, 25, 236, 233, 231, 100, 100,
                                           100,
                                           "Arial", 1, 18,
                                           SwingConstants.CENTER,
                                           SwingConstants.LEFT);
    dateLabel = format.formatLabel(dateLabel, "Date",
                                   15, 65,
                                   75, 25, 236, 233, 231, 100, 100, 100,
                                   "Arial", 0, 14,
                                   SwingConstants.CENTER,
                                   SwingConstants.LEFT);
    dateTextField = format.formatTextField(dateTextField, "",
                                           14, 90,
                                           150, 25, 255, 255, 255, 100, 100,
                                           100,
                                           "Arial", 0, 14);
    descriptionLabel = format.formatLabel(descriptionLabel, "Description",
                                          175, 65,
                                          125, 25, 236, 233, 231, 100, 100, 100,
                                          "Arial", 0, 14,
                                          SwingConstants.CENTER,
                                          SwingConstants.LEFT);
    descriptionTextField = format.formatTextField(descriptionTextField, "",
                                                  174, 90,
                                                  330, 25, 255, 255, 255, 100,
                                                  100, 100,
                                                  "Arial", 0, 14);
    expensesLabel = format.formatLabel(expensesLabel, "Expenses",
                                       515, 65,
                                       125, 25, 236, 233, 231, 100, 100, 100,
                                       "Arial", 0, 14,
                                       SwingConstants.CENTER,
                                       SwingConstants.LEFT);
    expensesTextField = format.formatTextField(expensesTextField, "",
                                               514, 90,
                                               150, 25, 255, 255, 255, 100, 100,
                                               100,
                                               "Arial", 0, 14);
    incomeLabel = format.formatLabel(incomeLabel, "Income",
                                     675, 65,
                                     125, 25, 236, 233, 231, 100, 100, 100,
                                     "Arial", 0, 14,
                                     SwingConstants.CENTER,
                                     SwingConstants.LEFT);
    incomeTextField = format.formatTextField(incomeTextField, "",
                                             674, 90,
                                             150, 25, 255, 255, 255, 100, 100,
                                             100,
                                             "Arial", 0, 14);
    addButton = format.formatButton(addButton, "Add", 714, 135, 110, 25, 100,
                                    100, 100, "Arial", Font.BOLD, 14);

    statusBarLabel = format.formatLabel(statusBarLabel, "",
                                        -3, 540,
                                        854, 25, 236, 233, 231, 100, 100, 100,
                                        "Arial", 0, 14,
                                        SwingConstants.CENTER,
                                        SwingConstants.LEFT);
    statusBarLabel.setBorder(BorderFactory.createLoweredBevelBorder());

    financeTable = format.formatTable(financeTable, 0, 200, 840,
                                      340, 255, 255, 255, 100, 100, 100,
                                      "Arial", 0, 16);

    financeScrollPane = format.formatScrollPane(financeScrollPane, 0, 200, 840,
                                                340, 255, 255, 255, 100, 100,
                                                100, "Arial", 0, 12);
    financeScrollPane.setPreferredSize(new Dimension(840, 340));

  }

  public void addToContentPane() {
    this.getContentPane().add(balanceTitleLabel, null);
    this.getContentPane().add(balanceValueLabel, null);
    this.getContentPane().add(dateLabel, null);
    this.getContentPane().add(dateTextField, null);
    this.getContentPane().add(descriptionLabel, null);
    this.getContentPane().add(descriptionTextField, null);
    this.getContentPane().add(expensesLabel, null);
    this.getContentPane().add(expensesTextField, null);
    this.getContentPane().add(incomeLabel, null);
    this.getContentPane().add(incomeTextField, null);
    this.getContentPane().add(addButton, null);
    this.getContentPane().add(statusBarLabel, null);
    this.getContentPane().add(financeScrollPane);
  }

  public boolean validateEntries() {
    boolean valid = true;

    if ( (dateTextField.getText().trim().length() > 25) ||
        (dateTextField.getText().trim().equals("") == true)) {
      valid = false;
      statusBarLabel.setText(
          " Error: Date needs value up to 25 Characters");
    }
    else if ( (descriptionTextField.getText().trim().length() > 150) ||
             (descriptionTextField.getText().trim().equals("") == true)) {
      valid = false;
      statusBarLabel.setText(
          " Error: Description needs value up to 150 Characters");
    }
    else if ( (expensesTextField.getText().trim().equals("") == false) &&
             (incomeTextField.getText().trim().equals("") == false)) {
      valid = false;
      statusBarLabel.setText(
          " Error: Only one field must have value (Expense or Income)");
    }
    else if ( (expensesTextField.getText().trim().equals("") == true) &&
             (incomeTextField.getText().trim().equals("") == true)) {
      valid = false;
      statusBarLabel.setText(
          " Error: Expense and Income are empty, one field must have value.");
    }
    return valid;
  }

  public boolean validateExpenseIncome() {
    boolean valid = false;
    if ( ( (finance.validateDouble(expensesTextField.getText().trim()) == true) &&
          (incomeTextField.getText().trim().equals("") == true)) ||
        ( (finance.validateDouble(incomeTextField.getText().trim()) == true) &&
         (expensesTextField.getText().trim().equals("") == true))
        ) {
      valid = true;
    }
    else {
      valid = false;
      statusBarLabel.setText(
          " Error: Either Expense or Income must have a Number value and other None");
    }
    return valid;
  }

  public void setLoggedUserId(int loggedUserId){
    this.loggedUserId = loggedUserId;
  }

  public void assign() {
    transaction = new Transaction();
    transaction.setTransactionDate(dateTextField.getText().trim());
    transaction.setDescription(descriptionTextField.getText().trim());
    if ( (expensesTextField.getText().trim().equals("") == false) &&
        (incomeTextField.getText().trim().equals("") == true)) {
      transaction.setExpense(Double.parseDouble(expensesTextField.getText().
                                                trim()));
      statusBarLabel.setText("");
    }
    else if ( (incomeTextField.getText().trim().equals("") == false) &&
             (expensesTextField.getText().trim().equals("") == true)) {
      transaction.setIncome(Double.parseDouble(incomeTextField.getText().trim()));
      statusBarLabel.setText("");
    }
    transaction.setPersonId(loggedUserId);
  }

  public void clearScreen() {
    dateTextField.setText("");
    descriptionTextField.setText("");
    expensesTextField.setText("");
    incomeTextField.setText("");
  }

  void addButton_actionPerformed(ActionEvent e) {
    boolean confirmation = false;

    if (validateEntries() == true) {
      if (validateExpenseIncome() == true) {
        assign();
        confirmation = finance.processTransaction(transaction);
        if (confirmation == true) {
          balanceValueLabel.setText("$" +
                                    twoDecimal.format(finance.getCurrentBalance(loggedUserId)));

          displayTransaction();
          statusBarLabel.setText(
              "Transaction has been saved successfully into the Database");
          clearScreen();
        }
        else {
          statusBarLabel.setText(
              "ERROR: Transaction has not been saved into the Database");
        }
      }
    }
  }

  public void displayVectorContents(Vector list) {
    Transaction t = new Transaction();
    for (int i = 0; i < list.size(); i++) {
      t = (Transaction) list.get(i);
      System.out.println(t.getTransactionId() + "  " + t.getTransactionDate() +
                         "  " + t.getDescription() + "  " + t.getExpense() +
                         "  " + t.getIncome() + "  " + t.getBalance());
      t = new Transaction();
    }
  }

  public void customizingTable() {
    financeTable.setRowHeight(35);
    financeTable.setShowGrid(true);
    financeTable.getTableHeader().setFont(new Font("Arial", 0, 18));
    financeTable.getTableHeader().setForeground(new Color(100, 100, 100));
  }


  public void displayTransaction() {
    Vector list = new Vector();
    list = finance.getTransactions(loggedUserId);
    transaction = new Transaction();
    Vector < String > row = new Vector < String > ();
    tableModel.setColumnIdentifiers(columnNames);
    int index = list.size() - 2;
    int counter = list.size() - 1;
    if (once == true) {
      for (int i = index; i >= 0; i--) {
        tableModel.removeRow(i);
      }
    }
    for (int i = counter; i >= 0; i--) {
      transaction = (Transaction) list.get(i);
      row.add(" " + transaction.getTransactionDate());
      row.add(" " + transaction.getDescription());
      if (String.valueOf(transaction.getExpense()).equals("0.0") == true) {
        row.add("");
      }
      else {
        row.add(" $" + twoDecimal.format(transaction.getExpense()));
      }

      if (String.valueOf(transaction.getIncome()).equals("0.0") == true) {
        row.add("");
      }
      else {
        row.add(" $" + twoDecimal.format(transaction.getIncome()));
      }
      row.add(" $" + twoDecimal.format(transaction.getBalance()));
      tableModel.addRow(row);
      transaction = new Transaction();
      row = new Vector < String > ();
      once = true;
    }
  }
}

class FinanceUI_addButton_actionAdapter
    implements java.awt.event.ActionListener {
  FinanceUI adaptee;

  FinanceUI_addButton_actionAdapter(FinanceUI adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.addButton_actionPerformed(e);
  }
}


					