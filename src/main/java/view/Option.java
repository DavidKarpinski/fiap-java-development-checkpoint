package view;

public enum Option
{
  NEW_CATEGORY(1, "New Category"),
  NEW_PRODUCT(2, "New Product"),
  EDIT_PRODUCT(3, "Edit Product"),
  SEARCH_PRODUCT_BY_ID(4, "Search Product by ID"),
  SEARCH_PRODUCT_BY_CATEGORY(5, "Search Product by Category"),
  EXIT(6, "Exit");

  int id;
  String name;

  Option(int id, String name)
  {
    this.id = id;
    this.name = name;
  }

  public int getId()
  {
    return id;
  }

  public Option setId(int id)
  {
    this.id = id;
    return this;
  }

  public String getName()
  {
    return name;
  }

  public Option setName(String name)
  {
    this.name = name;
    return this;
  }

  @Override
  public String toString()
  {
    return name.toUpperCase();
  }
}