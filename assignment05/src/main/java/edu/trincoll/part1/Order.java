package edu.trincoll.part1;

public class Order implements Comparable<Order> {
    private int quantity;
    private String customerName;
    private int priority;
    
    public Order(int quantity, String customerName, int priority) {
        this.quantity = quantity;
        this.customerName = customerName;
        this.priority = priority;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public String getCustomerName() {
        return customerName;
    }
    
    public int getPriority() {
        return priority;
    }
    
    @Override
    public int compareTo(Order other) {
        // Lower priority value means higher priority
        return Integer.compare(this.priority, other.priority);
    }
    
    @Override
    public String toString() {
        return "Customer: " + customerName + ", Quantity: " + quantity + ", Priority: " + priority;
    }
    
    public void print() {
        System.out.println(toString());
    }
}
