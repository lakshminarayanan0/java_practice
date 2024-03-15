package com.shop;

public class TopSoldProductsThisMonth {
    private int product_id;
    private String name;
    private int total_sold;

    public int getProduct_id() {
        return product_id;
    }

    public String getName() {
        return name;
    }

    public int getTotal_sold() {
        return total_sold;
    }

    public TopSoldProductsThisMonth(int productId, String name, int totalSold) {
        this.product_id=productId;
        this.name=name;
        this.total_sold=totalSold;

    }
}
