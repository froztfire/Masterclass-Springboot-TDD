package practice;

public class PriceService {

    DiscountService discountService = new DiscountService();
    public double getPrice(Order order) {

        if ("Apple".equals(order.product)) {
            if ("Apple20".equals(order.discCode)){
                return (2 - discountService.getAppleDiscount());
            } else
            return 2;
        }

        else if ("Mango".equals(order.product)) {
            if ("Mango15".equals(order.discCode)) {
                return (3 - discountService.getMangoDiscount());
            }
            return 3;
        }


//        if ("Apple".equals(order.product) && "Apple20".equals(order.discCode)){
//            return (2 - discountService.getAppleDiscount());
//        } else if else if ("Apple".equals(order.product) && !"Apple20".equals(order.discCode)) {
//            throw new PriceNotFoundException("Invalid Discount Code for Apple");
//        } else if ("Mango".equals(order.product) && !"Mango15".equals(order.discCode)) {
//            throw new PriceNotFoundException("Invalid Discount Code for Mango");
//        }
//        else  else
//            throw new PriceNotFoundException("No Price");
//    }
        throw new PriceNotFoundException("Price Not Found");
    }
}