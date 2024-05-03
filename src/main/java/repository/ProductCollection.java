package repository;

import model.Product;

import java.util.List;
import java.util.Vector;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.swing.JOptionPane;

public class ProductCollection
{
  private static List<Product> products;

  static
  {
    products = new Vector<>();

    Product iPhone = new Product();
    iPhone.setName("iPhone 14 Pro Max")
      .setDescription("Apple mobile phone")
      .setPrice(BigDecimal.valueOf(15000))
      .setCategory(CategoryCollection.getCategoryById(1L))
      .setRegistrationDate(LocalDateTime.now());

    save(iPhone);
  }

  public static List<Product> getAllProducts()
  {
    return products;
  }

  public static Product save(Product product)
  {
    if (!products.contains(product))
    {
      product.setId((long) products.size() + 1);
      products.add(product);
      return product;
    }

    JOptionPane.showMessageDialog(null, "Product already exists");
    return null;
  }

  public static Product getProductById(Long id)
  {
    return products.stream().filter(p->p.getId().equals(id)).findFirst().orElse(null);
  }

  public static List<Product> findByCategory(Category category)
  {
    return products.stream().filter(p->p.getCategory().equals(category)).toList();
  }
}