package pettycash;


import javax.swing.*;
import java.awt.*;
import java.awt.*;
import javax.swing.*;
import java.lang.Exception;
import java.lang.*;

public class FormatUI {

  public FormatUI() {

  }

  public void centerFrame(JFrame anObject) {
   Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
   int screenWidth = screenSize.width;
   int screenHeight = screenSize.height;
   Dimension frameSize = anObject.getSize();
   int x = (screenWidth - frameSize.width) / 2;
   int y = (screenHeight - frameSize.height) / 2;
   anObject.setLocation(x, y);
 }

  /* A method to return a formatted JLabel
   formatLabel(variable name,text,x-cordinate,y-cordinate,
     width,height,background Red RGB color,background Green RGB color,
   background Blue RGB color, foreground Red RGB color, foreground Green RGB color,
   foreground Blue RGB color, font face string,
   font style number(PLAIN, BOLD, ITALIC, or BOLD+ITALIC), font size.
   */
  public JLabel formatLabel(JLabel aLabel, String txt, int x, int y, int width,
                            int height, int Bred, int Bgreen, int Bblue,
                            int Fred, int Fgreen, int Fblue, String fontFace,
                            int fontStyle, int fontSize, int vert, int horz) {
    aLabel.setOpaque(true);
    aLabel.setText(txt);
    aLabel.setBounds(new Rectangle(x, y, width, height));
    aLabel.setBackground(new Color(Bred, Bgreen, Bblue));
    aLabel.setForeground(new Color(Fred, Fgreen, Fblue));
    aLabel.setFont(new java.awt.Font(fontFace, fontStyle, fontSize));
    aLabel.setVerticalAlignment(vert);
    aLabel.setHorizontalAlignment(horz);

    return aLabel;
  }

   public JLabel formatLabel(JLabel aLabel, int x, int y, int width,
                            int height, int Bred, int Bgreen, int Bblue,
                            int Fred, int Fgreen, int Fblue, String fontFace,
                            int fontStyle, int fontSize, int vert, int horz) {
    aLabel.setOpaque(true);
    aLabel.setBounds(new Rectangle(x, y, width, height));
    aLabel.setBackground(new Color(Bred, Bgreen, Bblue));
    aLabel.setForeground(new Color(Fred, Fgreen, Fblue));
    aLabel.setFont(new java.awt.Font(fontFace, fontStyle, fontSize));
    aLabel.setVerticalAlignment(vert);
    aLabel.setHorizontalAlignment(horz);

    return aLabel;
  }


  public JRadioButton formatRadioButton(JRadioButton aRadioButton, String txt, int x, int y, int width,
                           int height, int Bred, int Bgreen, int Bblue,
                           int Fred, int Fgreen, int Fblue, String fontFace,
                           int fontStyle, int fontSize) {
   aRadioButton.setOpaque(true);
   aRadioButton.setText(txt);
   aRadioButton.setBounds(new Rectangle(x, y, width, height));
   aRadioButton.setBackground(new Color(Bred, Bgreen, Bblue));
   aRadioButton.setForeground(new Color(Fred, Fgreen, Fblue));
   aRadioButton.setFont(new java.awt.Font(fontFace, fontStyle, fontSize));
   return aRadioButton;
 }


  public JTextField formatTextField(JTextField aTextField, String txt, int x,
                                    int y, int width, int height, int Bred,
                                    int Bgreen,
                                    int Bblue, int Fred, int Fgreen, int Fblue,
                                    String fontFace, int fontStyle,
                                    int fontSize
                                    ) {
    aTextField.setBorder(BorderFactory.createCompoundBorder());
    aTextField.setOpaque(true);
    aTextField.setText(txt);
    aTextField.setBounds(new Rectangle(x, y, width, height));
    aTextField.setBackground(new Color(Bred, Bgreen, Bblue));
    aTextField.setForeground(new Color(Fred, Fgreen, Fblue));
    aTextField.setFont(new java.awt.Font(fontFace, fontStyle, fontSize));
    return aTextField;
  }

  public JPasswordField formatPasswordField(JPasswordField aPasswordField, String txt, int x,
                                   int y, int width, int height, int Bred,
                                   int Bgreen,
                                   int Bblue, int Fred, int Fgreen, int Fblue,
                                   String fontFace, int fontStyle,
                                   int fontSize
                                   ) {
   aPasswordField.setBorder(BorderFactory.createCompoundBorder());
   aPasswordField.setOpaque(true);
   aPasswordField.setText(txt);
   aPasswordField.setBounds(new Rectangle(x, y, width, height));
   aPasswordField.setBackground(new Color(Bred, Bgreen, Bblue));
   aPasswordField.setForeground(new Color(Fred, Fgreen, Fblue));
   aPasswordField.setFont(new java.awt.Font(fontFace, fontStyle, fontSize));
   return aPasswordField;
 }


  public JFormattedTextField formatFormattedTextField(JFormattedTextField
      aFormattedTextField, int x, int y, int width, int height, String option,
      int Bred, int Bgreen,
      int Bblue, int Fred, int Fgreen, int Fblue, String fontFace,
      int fontStyle, int fontSize
      ) throws
      Exception {
    aFormattedTextField.setBorder(BorderFactory.createLoweredBevelBorder());
    aFormattedTextField.setOpaque(true);
    aFormattedTextField.setBounds(new Rectangle(x, y, width, height));
    aFormattedTextField.setBackground(new Color(Bred, Bgreen, Bblue));
    aFormattedTextField.setForeground(new Color(Fred, Fgreen, Fblue));
    aFormattedTextField.setFont(new java.awt.Font(fontFace, fontStyle, fontSize));
    return aFormattedTextField;
  }



  public JComboBox formatComboBox(JComboBox aComboBox, int x, int y, int width,
                                  int height, boolean editable,
                                  boolean selected,
                                  int index, int Bred, int Bgreen,
                                  int Bblue, int Fred, int Fgreen, int Fblue,
                                  String fontFace,
                                  int fontStyle, int fontSize
                                  ) {
    aComboBox.setBorder(BorderFactory.createCompoundBorder());
    aComboBox.setBounds(new Rectangle(x, y, width, height));
    aComboBox.setOpaque(true);
    aComboBox.setBackground(new Color(Bred, Bgreen, Bblue));
    aComboBox.setForeground(new Color(Fred, Fgreen, Fblue));
    aComboBox.setFont(new java.awt.Font(fontFace, fontStyle, fontSize));
    aComboBox.setEditable(editable);
    if (selected == true) {
      aComboBox.setSelectedIndex(index);
    }
    return aComboBox;
  }

  public JScrollPane formatScrollPane(JScrollPane aScrollpane, int x, int y,
                                      int width,
                                      int height, int Bred, int Bgreen,
                                      int Bblue, int Fred, int Fgreen,
                                      int Fblue, String fontFace,
                                      int fontStyle, int fontSize
                                      ) {
    aScrollpane.setBorder(BorderFactory.createLoweredBevelBorder());
    aScrollpane.setBounds(new Rectangle(x, y, width, height));
    aScrollpane.setBackground(new Color(Bred, Bgreen, Bblue));
    aScrollpane.setForeground(new Color(Fred, Fgreen, Fblue));
    aScrollpane.setFont(new java.awt.Font(fontFace, fontStyle, fontSize));
    aScrollpane.setOpaque(true);

    return aScrollpane;
  }

  public JTable formatTable(JTable aTable, int x, int y,
                                    int width,
                                    int height, int Bred, int Bgreen,
                                    int Bblue, int Fred, int Fgreen,
                                    int Fblue, String fontFace,
                                    int fontStyle, int fontSize
                                    ) {
  aTable.setBorder(BorderFactory.createLoweredBevelBorder());
  aTable.setBounds(new Rectangle(x, y, width, height));
  aTable.setBackground(new Color(Bred, Bgreen, Bblue));
  aTable.setForeground(new Color(Fred, Fgreen, Fblue));
  aTable.setFont(new java.awt.Font(fontFace, fontStyle, fontSize));
  aTable.setOpaque(true);

  return aTable;
}


  public JTextArea formatTextArea(JTextArea aTextArea, String txt, int x, int y,
                                  int width, int height, int Bred, int Bgreen,
                                  int Bblue, int Fred, int Fgreen,
                                  int Fblue, String fontFace, int fontStyle,
                                  int fontSize, int border
                                  ) {
    aTextArea.setLineWrap(true);
    aTextArea.setWrapStyleWord(true);
    aTextArea.setEditable(true);
    aTextArea.setBounds(new Rectangle(x, y, width, height));
    aTextArea.setBackground(new Color(Bred, Bgreen, Bblue));
    aTextArea.setForeground(new Color(Fred, Fgreen, Fblue));
    aTextArea.setFont(new java.awt.Font(fontFace, fontStyle, fontSize));
    switch (border) {
     case 0:
       aTextArea.setBorder(BorderFactory.createLoweredBevelBorder());
       break;
     case 1:
       aTextArea.setBorder(BorderFactory.createEmptyBorder());
       break;
     case 2:
       aTextArea.setBorder(BorderFactory.createEtchedBorder());
       break;
     case 4:
       aTextArea.setBorder(BorderFactory.createRaisedBevelBorder());
       break;
   }
    return aTextArea;
  }

  public TextArea formatTextArea(TextArea aTextArea, String txt, int x, int y,
                                 int width, int height, int Bred, int Bgreen,
                                 int Bblue, int Fred, int Fgreen,
                                 int Fblue, String fontFace, int fontStyle,
                                 int fontSize
                                 ) {
   aTextArea.setEditable(true);
   aTextArea.setBounds(new Rectangle(x, y, width, height));
   aTextArea.setBackground(new Color(Bred, Bgreen, Bblue));
   aTextArea.setForeground(new Color(Fred, Fgreen, Fblue));
   aTextArea.setFont(new java.awt.Font(fontFace, fontStyle, fontSize));
   return aTextArea;
 }

 public JTextPane formatTextPane(JTextPane aTextPane, String txt, int x, int y,
                                 int width, int height, int Bred, int Bgreen,
                                 int Bblue, int Fred, int Fgreen,
                                 int Fblue, String fontFace, int fontStyle,
                                 int fontSize, int border
                                 ) {
   aTextPane.setEditable(true);
   aTextPane.setBounds(new Rectangle(x, y, width, height));
   aTextPane.setBackground(new Color(Bred, Bgreen, Bblue));
   aTextPane.setForeground(new Color(Fred, Fgreen, Fblue));
   aTextPane.setFont(new java.awt.Font(fontFace, fontStyle, fontSize));
   switch (border) {
    case 0:
      aTextPane.setBorder(BorderFactory.createLoweredBevelBorder());
      break;
    case 1:
      aTextPane.setBorder(BorderFactory.createEmptyBorder());
      break;
    case 2:
      aTextPane.setBorder(BorderFactory.createEtchedBorder());
      break;
    case 4:
      aTextPane.setBorder(BorderFactory.createRaisedBevelBorder());
      break;
  }
   return aTextPane;
 }



  public JButton formatButton(JButton aButton, String txt, int x, int y,
                              int width,
                              int height, int Bred, int Bgreen,
                              int Bblue, int Fred, int Fgreen, int Fblue,
                              String fontFace,
                              int fontStyle, int fontSize
                              ) {
    aButton.setOpaque(true);
    aButton.setText(txt);
    aButton.setBounds(new Rectangle(x, y, width, height));
    aButton.setBackground(new Color(Bred, Bgreen, Bblue));
    aButton.setForeground(new Color(Fred, Fgreen, Fblue));
    aButton.setFont(new java.awt.Font(fontFace, fontStyle, fontSize));

    return aButton;
  }

  public JButton formatButton(JButton aButton, String txt, int x, int y,
                              int width,
                              int height,  int Fred, int Fgreen, int Fblue,
                              String fontFace,
                              int fontStyle, int fontSize
                              ) {
    aButton.setOpaque(true);
    aButton.setText(txt);
    aButton.setBounds(new Rectangle(x, y, width, height));
    aButton.setForeground(new Color(Fred, Fgreen, Fblue));
    aButton.setFont(new java.awt.Font(fontFace, fontStyle, fontSize));

    return aButton;
  }


  public JCheckBox formatCheckBox(JCheckBox aButton, String txt, int x, int y,
                              int width,
                              int height, int Bred, int Bgreen,
                              int Bblue, int Fred, int Fgreen, int Fblue,
                              String fontFace,
                              int fontStyle, int fontSize
                              ) {
    aButton.setOpaque(true);
    aButton.setText(txt);
    aButton.setBounds(new Rectangle(x, y, width, height));
    aButton.setBackground(new Color(Bred, Bgreen, Bblue));
    aButton.setForeground(new Color(Fred, Fgreen, Fblue));
    aButton.setFont(new java.awt.Font(fontFace, fontStyle, fontSize));

    return aButton;
  }


  public JPanel formatPanel(JPanel aPanel, int border, Color lineColor,
                            int lineThick,
                            String borderTitle, int x, int y, int width,
                            int height, int Bred, int Bgreen, int Bblue,
                            int Fred, int Fgreen, int Fblue, String fontFace,
                            int fontStyle, int fontSize) {
    aPanel.setOpaque(true);
    aPanel.setBounds(new Rectangle(x, y, width, height));
    aPanel.setBackground(new Color(Bred, Bgreen, Bblue));
    aPanel.setForeground(new Color(Fred, Fgreen, Fblue));
    aPanel.setFont(new java.awt.Font(fontFace, fontStyle, fontSize));
    switch (border) {
      case 0:
        aPanel.setBorder(BorderFactory.createLoweredBevelBorder());
        break;
      case 1:
        aPanel.setBorder(BorderFactory.createEmptyBorder());
        break;
      case 2:
        aPanel.setBorder(BorderFactory.createEtchedBorder());
        break;
      case 3:
        aPanel.setBorder(BorderFactory.createLineBorder(lineColor, lineThick));
        break;
      case 4:
        aPanel.setBorder(BorderFactory.createRaisedBevelBorder());
        break;
      case 5:
        aPanel.setBorder(BorderFactory.createTitledBorder(borderTitle));
        break;
    }
    return aPanel;
  }

  public JPanel formatPanel(JPanel aPanel, int border, int x, int y, int width,
                           int height, int Bred, int Bgreen, int Bblue,
                           int Fred, int Fgreen, int Fblue, String fontFace,
                           int fontStyle, int fontSize) {
   aPanel.setOpaque(true);
   aPanel.setBounds(new Rectangle(x, y, width, height));
   aPanel.setBackground(new Color(Bred, Bgreen, Bblue));
   aPanel.setForeground(new Color(Fred, Fgreen, Fblue));
   aPanel.setFont(new java.awt.Font(fontFace, fontStyle, fontSize));
   switch (border) {
     case 0:
       aPanel.setBorder(BorderFactory.createLoweredBevelBorder());
       break;
     case 1:
       aPanel.setBorder(BorderFactory.createEmptyBorder());
       break;
     case 2:
       aPanel.setBorder(BorderFactory.createEtchedBorder());
       break;
     case 4:
       aPanel.setBorder(BorderFactory.createRaisedBevelBorder());
       break;
   }
   return aPanel;
 }


}


					