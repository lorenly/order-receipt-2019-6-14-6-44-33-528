package org.katas.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    private StringBuilder output = new StringBuilder();

    public String printReceipt() {
        output.append("======Printing Orders======\n");
        getCustomerInfo();

        // prints lineItems
        double totSalesTx = 0d;
        double ttlAmount = 0d;

        for (LineItem lineItem : order.getLineItems()) {
            output.append(lineItem.getDescription());
            output.append('\t');
            output.append(lineItem.getPrice());
            output.append('\t');
            output.append(lineItem.getQuantity());
            output.append('\t');
            output.append(lineItem.totalAmount());
            output.append('\n');

            // calculate sales tax @ rate of 10%
            double salesTax = lineItem.totalAmount() * .10;
            totSalesTx += salesTax;

            // calculate total amount of lineItem = price * quantity + 10 % sales tax
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
        output.append("Sales Tax").append('\t').append(totSalesTx);
    }

    private void outputTotalAmmount(double ttlAmount){
        output.append("Total Amount").append('\t').append(ttlAmount);
    }
}