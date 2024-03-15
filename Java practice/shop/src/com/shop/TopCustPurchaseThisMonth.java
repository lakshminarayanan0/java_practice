package com.shop;

public class TopCustPurchaseThisMonth {
    private int customer_Id;
    private String first_name;
    private String last_name;
    private double total_amount;

    public int getCustomer_Id() {
        return customer_Id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public TopCustPurchaseThisMonth(int customer_Id, String first_name, String last_name, double total_amount) {
        this.customer_Id=customer_Id;
        this.first_name=first_name;
        this.last_name=last_name;
        this.total_amount=total_amount;
    }
}
