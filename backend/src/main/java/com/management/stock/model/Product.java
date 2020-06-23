package com.management.stock.model;

public class Product {
    private long id;
    private String name;
    private String category;
    private String gender;
    private int stock;
    private int price;
    private String codeScan;
    private String image;

    public Product(long id, String name, String category, String gender, int price, int stock, String codeScan,String image) {
        this.id = id;
        this.category = category;
        this.codeScan = codeScan;
        this.gender = gender;
        this.price = price;
        this.stock = stock;
        this.name = name;
        this.image = image;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public String getCategory() {
        return category;
    }

    public String getCodeScan() {
        return codeScan;
    }

    public String getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", gender='" + gender + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                ", codeScan='" + codeScan + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}

