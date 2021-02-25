package model;

public class ProductView {
    private int id;
    private String name;
    private int price;
    private int quantity;
    private String color;
    private String description;
    private String categoryName;


    public ProductView(int id, String name, int price, int quantity, String color, String description, String categoryName) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.description = description;
        this.categoryName = categoryName;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getColor() {
        return color;
    }

    public String getDescription() {
        return description;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
