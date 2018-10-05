package com.example.gisilk.onlineorder2.com.functions.OrderLiquor;

public class Liquor {

    private String name;
    private String size;
    private float price;
    private boolean availability;
    private int thumbnail;

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public Liquor() {
    }

    public Liquor(String name, String size, float price, boolean availability) {
        this.name = name;
        this.size = size;
        this.price = price;
        this.availability = availability;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
