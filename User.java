package pettycash;

public class User {

  private int userId;
  private String userName = new String();
  private String password = new String();
  private String repeatPassword = new String();
  private boolean newUser = false;

  public User() {

  }

  public boolean isPasswordSame(String password, String repeatPassword) {
    boolean valid = false;

    if (password.equals(repeatPassword) == true) {
      valid = true;
    }
    return valid;
  }

  public boolean isValidLength(String item, int minSize, int maxSize) {
    boolean valid = true;
    if ( (item.length() < minSize) || (item.length() > maxSize)) {
      valid = false;
    }
    return valid;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setRepeatPassword(String repeatPassword) {
    this.repeatPassword = repeatPassword;
  }

  public void setNewUser(boolean newUser) {
    this.newUser = newUser;
  }

  public int getUserId() {
    return userId;
  }

  public String getUserName() {
    return userName;
  }

  public String getPassword() {
    return password;
  }

  public String getRepeatPassword() {
    return repeatPassword;
  }

  public boolean getNewUser() {
    return newUser;
  }

}


					