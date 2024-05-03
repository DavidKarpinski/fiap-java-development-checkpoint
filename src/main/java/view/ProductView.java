package view;

import model.*;
import repository.ProductCollection;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.swing.JOptionPane;

public class ProductView
{
  public static Product form(Product product)
  {
    Category category;
    
    do
    {
      category = CategoryView.select(product.getCategory());
    } while (category == null);  

    String name = "";

    do
    {
      name = JOptionPane.showInputDialog(null, "Enter a product name", product.getName());
    } while (name.equals(""));

    String description = "";

    do
    {
      description = JOptionPane.showInputDialog(null, "Enter a product description", product.getDescription());
    } while (description.equals(""));

    double price = 0;

    do
    {
      try
      {
        price = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter a product price"));
      }
      catch (Exception e)
      {
        price = 0;
      }
    } while (price == 0);
    
    Product ret = product;
    ret.setName(name)
      .setCategory(category)
      .setDescription(description)
      .setPrice(BigDecimal.valueOf(price))
      .setRegistrationDate(LocalDateTime.now());
    
    return ret;
  }

  public static void success()
  {
    JOptionPane.showMessageDialog(null, "Product saved succesfully");
  }

  public static void success(Product product)
  {
    JOptionPane.showMessageDialog(null, "Product " + product.getName() + " saved successfully");
  }

  public static Product select(Product product)
  {
    Product ret = (Product) JOptionPane.showInputDialog(null, 
      "Enter a product", "Menu",
      JOptionPane.QUESTION_MESSAGE, null,
      ProductCollection.getAllProducts().toArray(),
      product == null ? 1 : product
    );
    return ret;
  }

  public static void editProduct(Product product)
  {
    form(product);
    success(product);
    show(product);
  }

  public static void show(Product product)
  {
    System.out.println(product);
    String formattedText = String.format("Product: " + product.getName() + System.lineSeparator() + "Description: " + product.getDescription() + System.lineSeparator() + "Price: %,.2f", product.getPrice());
    JOptionPane.showMessageDialog(null, formattedText);
  }
}