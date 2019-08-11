package pl.piomin.microservices.order.model;

public class Order {

    private int id;
    private Customer customer;
    private double price;

    public Order(int id, double price) {
        this.id = id;
        this.price = price;
    }

    public Order(int id, Customer customer, double price) {
        this.id = id;
        this.customer = customer;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
