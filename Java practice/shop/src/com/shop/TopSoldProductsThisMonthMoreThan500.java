package com.shop;

public class TopSoldProductsThisMonthMoreThan500 {
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

    public int getSold_quantity() {
        return sold_quantity;
    }

    private int sold_quantity;

    public TopSoldProductsThisMonthMoreThan500(int productId, String name, String category, int soldQuantity) {
        this.product_id=productId;
        this.name=name;
        this.sold_quantity=soldQuantity;
        this.category=category;
    }
}
