import repository.*;
import model.*;
import view.*;

import java.util.List;

import javax.swing.JOptionPane;

public class Main 
{
  public static void main(String[] args) 
  {
    Option option = null;

    do
    {
      option = ViewOption.select();
      switch (option)
      {
        case NEW_CATEGORY -> newCategory();
        case NEW_PRODUCT -> newProduct();
        case EDIT_PRODUCT -> editProduct();
        case SEARCH_PRODUCT_BY_ID -> searchProductById();
        case SEARCH_PRODUCT_BY_CATEGORY -> searchProductByCategory(); 
      }
    } while (option != Option.EXIT);
  }

  private static void newCategory()
  {
    CategoryView view = new CategoryView();
    Category category = view.form(new Category());
    CategoryCollection.save(category);
    view.success(category);
  }

  private static void newProduct()
  {
    Product product = ProductView.form(new Product());
    ProductCollection.save(product);
    ProductView.success(product);
  }

  private static void editProduct()
  {
    Product product = ProductView.select(null);
    ProductView.editProduct(product);
  }

  private static void searchProductById()
  {
    Long productId = Long.parseLong(JOptionPane.showInputDialog("Enter product ID:"));
    Product product = ProductCollection.getProductById(productId);

    if (product != null) ProductView.show(product);
    else JOptionPane.showMessageDialog(null, "Product not found");
  }

  private static void searchProductByCategory()
  {
    Category category = CategoryView.select(null);
    List<Product> products = ProductCollection.findByCategory(category);

    if (products.size() == 0)
      JOptionPane.showMessageDialog(null, "No products of category " + category.getName() +" found");
    else
    {
      products.forEach(ProductView::show);
      products.forEach(System.out::println);
    }
  }
}