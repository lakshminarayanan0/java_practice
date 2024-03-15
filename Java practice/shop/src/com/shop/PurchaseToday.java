package com.shop;

public class PurchaseToday {
    private int transaction_id;
    private int customer_id;
    private String first_name;
    private String last_name;
    private double total_amount;

    public int getTransaction_id() {
        return transaction_id;
    }

    public int getCustomer_id() {
        return customer_id;
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

    public PurchaseToday(int transaction_Id, int customer_Id, String first_name, String last_name, double total_amount) {
        this.transaction_id=transaction_Id;
        this.customer_id=customer_Id;
        this.first_name=first_name;
        this.last_name=last_name;
        this.total_amount=total_amount;
    }
}
