package org.example.model;

import org.example.config.AppConfig;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final String customerName;
    private final List<OrderItem> items;
    private OrderStatus status;
    private Discount discount = new NoDiscount();
    private Fee fee = amount -> 0;

    public Order(Builder builder) {
        this.customerName = builder.customerName;
        this.items = builder.items;
        this.status = OrderStatus.NEW;
    }

    public void applyFee(Fee fee) {
        if (fee != null) {
            this.fee = fee;
        }
    }

    public void addItem(OrderItem item){

        if (this.getStatus() != OrderStatus.NEW)  throw new IllegalStateException("The order is already paid");
        items.add(item);
        // TODO: prevent adding items if order is already paid
    }

    public double calculateTotal(){
        double sum = 0;
        for (OrderItem item : items){
           sum += item.calculateTotal();
        }
        // TODO: calculate total from all order items (including discounts)
        //double discountedSum = discount.apply(sum);
        return discount.apply(sum) + fee.applyFee(discount.apply(sum));
    }

    public void markAsPaid(){

        // TODO: validate order is not empty
        if (items.isEmpty()) throw new IllegalStateException("Your order is empty!");
        this.status = OrderStatus.PAID;
    }

    public void applyDiscount(Discount discount){
        this.discount = discount;
    }

    public boolean isPaid(){
        return this.status == OrderStatus.PAID;
    }

    public List<OrderItem> getItems() {
        return items;
    }
    public String getCustomerName() {
        return customerName;
    }
    public OrderStatus getStatus() {
        return status;
    }
    public static Builder builder(){
        return new Builder();
    }
    public static class Builder{
        private String customerName;
        private List<OrderItem> items = new ArrayList<>();
        private String currency = "EUR";
        public Builder customerName(String customerName){
            this.customerName = customerName;
            return this;
        }
        public Builder addItem(OrderItem item){
            this.items.add(item);
            return this;
        }
        public Builder currency(String currency) {
            this.currency = currency;
            return this;
        }
        public Order build(){
            if (customerName == null || customerName.trim().isEmpty()) throw new IllegalArgumentException("Customer name cannot be null or blank");
            // TODO: validate customerName
            if (!AppConfig.getInstance().isCurrencySupported(this.currency)) {
                throw new IllegalArgumentException("Unsupported currency: " + this.currency);
            }
            return new Order(this);
        }
    }
}
