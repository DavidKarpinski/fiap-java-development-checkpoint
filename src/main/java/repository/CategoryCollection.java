package repository;

import model.Category;
import model.Product;

import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

public class CategoryCollection
{
  private static List<Category> categories;

  static 
  {
    categories = new Vector<>();
    Category electronics = new Category(1L, "Electronics");
    Category mugs = new Category(2L, "Mugs");
    Category books = new Category(3L, "Books");

    categories.add(electronics);
    categories.add(mugs);
    categories.add(books);
  }

  public static List<Category> getAllCategories()
  {
    return categories;
  }

  public static Category getCategoryById(Long id)
  {
    return categories.stream().filter(c -> c.getId()
      .equals(id))
      .findFirst()
      .orElse(null);
  }

  public static List<Category> getCategoryByName(String name)
  {
    return categories.stream().filter(c -> c.getName()
      .equalsIgnoreCase(name))
      .toList();
  }

  public static Category save(Category category)
  {
    if (!categories.contains(category))
    {
      category.setId((long) categories.size() + 1);
      categories.add(category);
      return category;
    }
    JOptionPane.showMessageDialog(null, "Category already exists");
    return null;
  }
}