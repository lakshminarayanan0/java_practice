package com.shop;

public class revenueByElectronicsProductsThisMonth {
    private int product_id;
    private String name;

    public int getProduct_id() {
        return product_id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal_sold() {
        return total_sold;
    }

    private int quantity;
    private double total_sold;
    public revenueByElectronicsProductsThisMonth(int productId, String name, int quantity, double totalSold) {
        this.product_id=productId;
        this.name=name;
        this.quantity=quantity;
        this.total_sold=totalSold;
    }
}
