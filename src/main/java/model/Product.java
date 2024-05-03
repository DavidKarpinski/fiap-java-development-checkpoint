package model;

import java.util.Objects;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Product 
{
  Long id;
  String name;
  String description;
  BigDecimal price;
  LocalDateTime registrationDate;
  Category category;

  public Product() 
  {
    
  }

  public Product(String name, String description, BigDecimal price, LocalDateTime registrationDate, Category category)
  {
    this.name = name;
    this.description = description;
    this.price = price;
    this.registrationDate = registrationDate;
    this.category = category;
  }

  public Product(Long id, String name, String description, BigDecimal price, LocalDateTime registrationDate, Category category)
  {
    this.id = id;
    this.name = name;
    this.description = description;
    this.price = price;
    this.registrationDate = registrationDate;
    this.category = category;
  }

  public Long getId()
  {
    return id;
  }

  public Product setId(Long id)
  {
    this.id = id;
    return this;
  }

  public String getName()
  {
    return name;
  }

  public Product setName(String name)
  {
    this.name = name;
    return this;
  }

  public String getDescription()
  {
    return description;
  }

  public Product setDescription(String description)
  {
    this.description = description;
    return this;
  }

  public BigDecimal getPrice()
  {
    return price;
  }
  
  public Product setPrice(BigDecimal price)
  {
    this.price = price;
    return this;
  }

  public LocalDateTime getRegistrationDate()
  {
    return registrationDate;
  }

  public Product setRegistrationDate(LocalDateTime registrationDate)
  {
    this.registrationDate = registrationDate;
    return this;
  }

  public Category getCategory()
  {
    return category;
  }

  public Product setCategory(Category category)
  {
    this.category = category;
    return this;
  }

  @Override
  public boolean equals(Object o)
  {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Product product = (Product) o;
    return name.equals(product.name);
  }

  @Override
  public int hashCode()
  {
    return Objects.hash(name);
  }

  @Override
  public String toString()
  {
    return name.toUpperCase();
  }
}