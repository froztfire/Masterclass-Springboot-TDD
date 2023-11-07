package practice;

public class ProductCostCalcu {

    public double calculate(Order order){
        PriceService priceService = new PriceService();
        double price = priceService.getPrice(order);
        return price * order.quantity;
    }
}




