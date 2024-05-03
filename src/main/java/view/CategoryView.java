package view;

import model.Category;
import repository.CategoryCollection;

import javax.swing.JOptionPane;

public class CategoryView
{
  static CategoryCollection repo;

  public static Category select(Category category)
  {
    Category ret = (Category) JOptionPane.showInputDialog(null, "Enter a category", "Menu", 
      JOptionPane.QUESTION_MESSAGE, null, 
      repo.getAllCategories().toArray(), 
      category == null ? 1 : category
    );

    return ret;
  }

  public void success()
  {
    JOptionPane.showMessageDialog(null, "Category saved successfully");
  }

  public void success(Category category)
  {
    JOptionPane.showMessageDialog(null, "Category " + category.getName() + " updated successfully");
  }

  public static Category form(Category category)
  {
    String name = JOptionPane.showInputDialog(null, "Enter a category name", category != null ? category.getName() : "");
    return new Category(name);
  }
}