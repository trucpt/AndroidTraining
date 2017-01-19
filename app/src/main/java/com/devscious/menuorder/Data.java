package com.devscious.menuorder;

/**
 * Created by Khang.Dong on 2017-01-19.
 */

public class Data {
    private String title;
    private double price;
    private int quality;
    private Integer imageId;

    public Data(String title, double price, int quality, Integer imageId) {
        this.title = title;
        this.price = price;
        this.quality = quality;
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }
}
