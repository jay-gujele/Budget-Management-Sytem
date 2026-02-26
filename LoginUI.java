/*
 Class: LoginUI
 Author: Shahrzad Jahangirian
 Update Date: Feb 18, 2014
 Description: Login and Signup Gui to allow access to the Finance Application to a valid user.
 A valid user could be a previous registered Person with Username and Password that exist in
 Database or a New User that just Signed up.
 */

package pettycash;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class LoginUI
    extends JFrame implements Serializable {

  public static final long serialVersionUID = 12345678L;
  private JPanel loginPanel = new JPanel();
  private JLabel loginLabel = new JLabel();
  private JLabel userNameLabel = new JLabel();
  private JLabel passwordLabel = new JLabel();
  private JLabel signUpLabel = new JLabel();
  private JLabel repeatPassLabel = new JLabel();
  private JLabel statusBarLabel = new JLabel();
  private JTextField userNameTextField = new JTextField();
  private JPasswordField passwordTextField = new JPasswordField(8);
  private JPasswordField repeatPassTextField = new JPasswordField(8);
  private JButton loginButton = new JButton();
  private JRadioButton loginRadioButton = new JRadioButton();
  private JRadioButton signUpRadioButton = new JRadioButton();
  private ButtonGroup group = new ButtonGroup();
  private FormatUI format = new FormatUI();
  private User user = new User();
  private Login login = new Login();

  public LoginUI() {
    try {
      jbInit();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void jbInit() throws Exception {
    formatUserInterfaces();
    loginPanel.setBackground(new Color(244, 232, 213));
    loginPanel.setLayout(null);
    addToPanel();
    addListeners();
    group.add(loginRadioButton);
    group.add(signUpRadioButton);
    loginRadioButton.setSelected(true);
    loginButton.setText("LOGIN");
    repeatPassLabel.setVisible(false);
    repeatPassTextField.setVisible(false);
	this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("d:\\OO.jpg")))));
    this.getContentPane().setBackground(new Color(244, 232, 213));
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setResizable(true);
    this.setSize(290, 230);
    this.setResizable(false);
    this.getContentPane().setLayout(new BorderLayout());
    this.getContentPane().add(loginPanel, null);
    this.setTitle("Login/ Sign up");
    format.centerFrame(this);
  }

  public void addToPanel() {
    loginPanel.add(loginLabel);
    loginPanel.add(userNameLabel);
    loginPanel.add(passwordLabel);
    loginPanel.add(signUpLabel);
    loginPanel.add(repeatPassLabel);
    loginPanel.add(statusBarLabel);
    loginPanel.add(userNameTextField);
    loginPanel.add(passwordTextField);
    loginPanel.add(repeatPassTextField);
    loginPanel.add(loginButton);
    loginPanel.add(loginRadioButton);
    loginPanel.add(signUpRadioButton);

  }

  public void addListeners() {
    userNameTextField.addMouseListener(new
                                       LoginUI_userNameTextField_mouseAdapter(this));
    passwordTextField.addMouseListener(new
                                       LoginUI_passwordTextField_mouseAdapter(this));
    repeatPassTextField.addMouseListener(new
                                         LoginUI_repeatPassTextField_mouseAdapter(this));
    loginRadioButton.addActionListener(new
                                       LoginUI_loginRadioButton_actionAdapter(this));
    signUpRadioButton.addActionListener(new
                                        LoginUI_signUpRadioButton_actionAdapter(this));
    loginButton.addActionListener(new
                                        LoginUI_loginButton_actionAdapter(this));

  }

  public void formatUserInterfaces() {
    loginRadioButton = format.formatRadioButton(loginRadioButton, "Login", 15,
                                                15, 75,
                                                25, 244, 232, 213, 153, 135,
                                                109, "Arial",
                                                1, 14);
    signUpRadioButton = format.formatRadioButton(signUpRadioButton, "Sign Up",
                                                 130, 15, 150,
                                                 25, 244, 232, 213, 153, 135,
                                                 109, "Arial",
                                                 1, 14);

    userNameTextField = format.formatTextField(userNameTextField, "", 135,
                                               50, 125, 20, 255, 255, 255, 153,
                                               135, 109, "Arial", 1, 14);
    userNameLabel = format.formatLabel(userNameLabel, "User Name", 20, 50,
                                       100, 25, 244, 232, 213, 153, 135, 109,
                                       "Arial", 1, 12, SwingConstants.CENTER,
                                       SwingConstants.LEFT);

    passwordTextField = format.formatPasswordField(passwordTextField, "",
        135, 75, 125, 20, 255, 255, 255,
        153, 135, 109, "Arial", 1, 30);


    repeatPassTextField = format.formatPasswordField(repeatPassTextField, "",
        135, 100, 125, 20, 255, 255,
        255, 153, 135, 109, "Arial", 1,
        30);
    passwordLabel = format.formatLabel(passwordLabel, "Password", 20, 75,
                                       100, 25, 244, 232, 213, 153, 135, 109,
                                       "Arial", 1, 12,
                                       SwingConstants.CENTER,
                                       SwingConstants.LEFT);
    repeatPassLabel = format.formatLabel(repeatPassLabel, "Repeat Password",
                                         20, 100,
                                         105, 25, 244, 232, 213, 153, 135, 109,
                                         "Arial", 1, 12,
                                         SwingConstants.CENTER,
                                         SwingConstants.LEFT);
    statusBarLabel = format.formatLabel(statusBarLabel, " ", -3, 170,
                                        310, 25, 244, 232, 213, 153, 135, 109,
                                        "Arial", 1, 12, SwingConstants.CENTER,
                                        SwingConstants.LEFT);
    statusBarLabel.setBorder(BorderFactory.createLoweredBevelBorder());

    loginButton = format.formatButton(loginButton, "LOGIN", 170, 130, 90, 25,
                                      164, 86,
                                      84, 244, 232, 213, "Arial", 1, 12);
  }

  public boolean validateEntries() {
    boolean valid = true;

    if ((userNameTextField.getText().trim().equals("") == true) ||
        (String.valueOf(passwordTextField.getPassword()).trim().equals("") == true) ){
      valid = false;
      statusBarLabel.setText(
          " ERROR: User Name & Password needs values");
    }
    else if ((user.isValidLength(userNameTextField.getText().trim(), 8, 50)) == false) {
      valid = false;
      statusBarLabel.setText(
          " ERROR: User Name needs 8 to 50 characters");
    }
    else if ((user.isValidLength(String.valueOf(passwordTextField.getPassword()).trim(), 4, 8)) == false) {
      valid = false;
      statusBarLabel.setText(" ERROR: Password needs 4 to 8 characters");
    }
    else if (signUpRadioButton.isSelected() == true) {
      if (String.valueOf(repeatPassTextField.getPassword()).trim().equals("") == true) {
       valid = false;
       statusBarLabel.setText(" ERROR: Repeat your Password");
     }
     else if (user.isPasswordSame(String.valueOf(passwordTextField.getPassword()).trim(),
                         String.valueOf(repeatPassTextField.getPassword()).trim()) == false) {
        valid = false;
        statusBarLabel.setText(" ERROR: Passwords are not the same");
      }
    }

    return valid;
  }

  public void assign() {
    user.setUserName(userNameTextField.getText().trim());
    user.setPassword(String.valueOf(passwordTextField.getPassword()).trim());
    if (signUpRadioButton.isSelected() == true) {
      user.setNewUser(true);
    }
    else {
      user.setNewUser(false);
    }
  }

  public void loginButton_actionPerformed(ActionEvent e) {
    boolean found = false;
    int loggedUser=0;
    if (validateEntries() == true) {
      assign();
      if (loginRadioButton.isSelected() == true){
       found = login.findUser(user);
       if(found == true){
          loggedUser = login.getLoggedUserId();
          FinanceUI financeui = new FinanceUI(loggedUser);
          financeui.setVisible(true);
          userNameTextField.setText("");
          passwordTextField.setText("");
       }
       else{
         statusBarLabel.setText(" Your Username or Password is Wrong, Try Again");
       }
      }
      else if (signUpRadioButton.isSelected() == true){
        found = login.findUsername(user);
        if(found == true){
         statusBarLabel.setText(" This Username is already Exist, Please Try Again");
        }
        else{
          login.saveUser(user);
          statusBarLabel.setText(user.getUserName() +
                                 " has been successfully signed up.");
          userNameTextField.setText("");
          passwordTextField.setText("");
          repeatPassTextField.setText("");
        }
      }
    }
  }

  void userNameTextField_mouseExited(MouseEvent e) {
    statusBarLabel.setText(" ");
  }

  void userNameTextField_mouseEntered(MouseEvent e) {
    statusBarLabel.setText(" Enter User Name (8 to 50 characters)");
  }

  void passwordTextField_mouseEntered(MouseEvent e) {
    statusBarLabel.setText(" Enter Password (4 to 8 characters)");
  }

  void passwordTextField_mouseExited(MouseEvent e) {
    statusBarLabel.setText(" ");
  }

  void repeatPassTextField_mouseEntered(MouseEvent e) {
    statusBarLabel.setText(" Repeat Password");
  }

  void repeatPassTextField_mouseExited(MouseEvent e) {
    statusBarLabel.setText(" ");
  }

  void loginRadioButton_actionPerformed(ActionEvent e) {
    loginButton.setText("LOGIN");
    repeatPassLabel.setVisible(false);
    repeatPassTextField.setVisible(false);
  }

  void signUpRadioButton_actionPerformed(ActionEvent e) {
    loginButton.setText("SIGN UP");
    repeatPassLabel.setVisible(true);
    repeatPassTextField.setVisible(true);

  }
}

class LoginUI_loginButton_actionAdapter
    implements java.awt.event.ActionListener {
  LoginUI adaptee;

  LoginUI_loginButton_actionAdapter(LoginUI adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.loginButton_actionPerformed(e);
  }
}

class LoginUI_userNameTextField_mouseAdapter
    extends java.awt.event.MouseAdapter {
  LoginUI adaptee;

  LoginUI_userNameTextField_mouseAdapter(LoginUI adaptee) {
    this.adaptee = adaptee;
  }

  public void mouseEntered(MouseEvent e) {
    adaptee.userNameTextField_mouseEntered(e);
  }

  public void mouseExited(MouseEvent e) {
    adaptee.userNameTextField_mouseExited(e);
  }
}

class LoginUI_passwordTextField_mouseAdapter
    extends java.awt.event.MouseAdapter {
  LoginUI adaptee;

  LoginUI_passwordTextField_mouseAdapter(LoginUI adaptee) {
    this.adaptee = adaptee;
  }

  public void mouseExited(MouseEvent e) {
    adaptee.passwordTextField_mouseExited(e);
  }

  public void mouseEntered(MouseEvent e) {
    adaptee.passwordTextField_mouseEntered(e);
  }
}

class LoginUI_repeatPassTextField_mouseAdapter
    extends java.awt.event.MouseAdapter {
  LoginUI adaptee;

  LoginUI_repeatPassTextField_mouseAdapter(LoginUI adaptee) {
    this.adaptee = adaptee;
  }

  public void mouseEntered(MouseEvent e) {
    adaptee.repeatPassTextField_mouseEntered(e);
  }

  public void mouseExited(MouseEvent e) {
    adaptee.repeatPassTextField_mouseExited(e);
  }
}

class LoginUI_loginRadioButton_actionAdapter
    implements java.awt.event.ActionListener {
  LoginUI adaptee;

  LoginUI_loginRadioButton_actionAdapter(LoginUI adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.loginRadioButton_actionPerformed(e);
  }
}

class LoginUI_signUpRadioButton_actionAdapter
    implements java.awt.event.ActionListener {
  LoginUI adaptee;

  LoginUI_signUpRadioButton_actionAdapter(LoginUI adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.signUpRadioButton_actionPerformed(e);
  }
}


					