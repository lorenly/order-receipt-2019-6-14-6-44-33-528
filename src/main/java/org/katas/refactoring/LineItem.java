package org.katas.refactoring;

public class LineItem {
    private String description;
    private double price;
    private int qty;

    public LineItem(String desc, double price, int qty) {
        this.description = desc;
        this.price = price;
        this.qty = qty;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return qty;
    }

    double totalAmount() {
        return price * qty;
    }
}