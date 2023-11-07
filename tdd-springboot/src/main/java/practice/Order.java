package practice;

public class Order {
    String product;
    int quantity;
    String discCode;

    public Order(String product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Order(String product, int quantity, String discCode) {
        this.product = product;
        this.quantity = quantity;
        this.discCode = discCode;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDiscCode() {
        return discCode;
    }
}
