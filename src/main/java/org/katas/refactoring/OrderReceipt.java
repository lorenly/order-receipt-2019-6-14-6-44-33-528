package org.katas.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    private Order order;
    private final String TAB = "\t";
    private final String NEWLINE = "\n";
    private final double tax = 0.1;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    private StringBuilder output = new StringBuilder();

    public String printReceipt() {
        output.append("======Printing Orders======\n");
        getCustomerInfo();

        double totSalesTx = 0d;
        double ttlAmount = 0d;

        for (LineItem lineItem : order.getLineItems()) {
            output.append(lineItem.getDescription()).append(TAB);
            output.append(lineItem.getPrice()).append(TAB);
            output.append(lineItem.getQuantity()).append(TAB);
            output.append(lineItem.totalAmount()).append(NEWLINE);

            double salesTax = lineItem.totalAmount() * tax;
            totSalesTx += salesTax;

            ttlAmount += lineItem.totalAmount() + salesTax;
        }
        outputSalesTax(totSalesTx);
        outputTotalAmmount(ttlAmount);

        return output.toString();
    }

    private void getCustomerInfo(){
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());
    }

    private void outputSalesTax(double totSalesTx){
        output.append("Sales Tax").append(TAB).append(totSalesTx);
    }

    private void outputTotalAmmount(double ttlAmount){
        output.append("Total Amount").append(TAB).append(ttlAmount);
    }
}