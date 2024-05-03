package view;

import javax.swing.JOptionPane;

public class ViewOption
{
  public static Option select()
  {
    Option ret = (Option) JOptionPane.showInputDialog(null, "Enter an option", "Menu", 
      JOptionPane.QUESTION_MESSAGE, null, 
      Option.values(), Option.NEW_PRODUCT
    );

    return ret != null ? ret : Option.EXIT;
  }
}