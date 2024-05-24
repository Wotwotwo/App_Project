package com.example.cafeteria;

import android.graphics.drawable.Drawable;

public class Menu {

    private String name;
    private double price;
    private int ImageURL;

    public Menu(String name, double price, int imageURL) {
        this.name = name;
        this.price = price;
        this.ImageURL = imageURL;
    }


    @Override
    public String toString() {
        return "Menu{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", ImageURL='" + ImageURL + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getImageURL() {
        return ImageURL;
    }

    public void setImageURL(int imageURL) {
        ImageURL = imageURL;
    }
}
