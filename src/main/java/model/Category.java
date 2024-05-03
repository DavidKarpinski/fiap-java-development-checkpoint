package model;

import java.util.Objects;

public class Category
{
  Long id;
  String name;

  public Category()
  {
    
  }

  public Category(String name)
  {
    this.name = name;
  }

  public Category(Long id, String name)
  {
    this.id = id;
    this.name = name;
  }

  public Long getId()
  {
    return id;
  }

  public Category setId(Long id)
  {
    this.id = id;
    return this;
  }

  public String getName()
  {
    return name;
  }

  public Category setName(String name)
  {
    this.name = name;
    return this;
  }

  @Override
  public boolean equals(Object o)
  {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Category category = (Category) o;
    return name.equals(category.name);
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