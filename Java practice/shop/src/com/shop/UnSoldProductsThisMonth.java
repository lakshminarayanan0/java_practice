package com.shop;

public class UnSoldProductsThisMonth {
    private int product_id;
    private String name;
    private String category;

    public int getProduct_id() {
        return product_id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public UnSoldProductsThisMonth(int productId, String name, String category) {
        this.product_id=productId;
        this.name=name;
        this.category=category;
    }
}
