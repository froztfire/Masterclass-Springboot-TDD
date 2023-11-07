package practice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductCostCalcuTest {

    private ProductCostCalcu productCostCalcu;

    @BeforeEach
    void setup(){
        productCostCalcu = new ProductCostCalcu();
    }

    @Test
    void shouldCalculateTotalPriceFor3Apples(){
        Order order = new Order("Apple", 3);
        double actual = productCostCalcu.calculate(order);
        assertEquals(6, actual);
    }
    @Test
    void shouldCalculateTotalPriceFor3Mangoes(){
        Order order = new Order("Mango", 3);
        double actual = productCostCalcu.calculate(order);
        assertEquals(9, actual);
    }
    @Test
    void shouldReturnPriceNotFoundException(){
        Order order = new Order("Tomato", 3);
        assertThrows(PriceNotFoundException.class, () -> productCostCalcu.calculate(order));
    }
    @Test
    void shouldReturnAValidDiscountCodeForApple(){
        Order order = new Order("Apple", 3, "Apple20");
        double actual = productCostCalcu.calculate(order);
        assertEquals(4.800000000000001, actual);
    }

    @Test
    void shouldReturnAValidDiscountCodeForMango(){
        Order order = new Order("Mango", 3, "Mango15");
        double actual = productCostCalcu.calculate(order);
        assertEquals(7.6499999999999995, actual);
    }

    @Test
    void shouldReturnAInvalidDiscountCodeForApple(){
        Order order = new Order("Apple", 3, "Apple21");
        assertThrows(PriceNotFoundException.class, () -> productCostCalcu.calculate(order));
    }

    @Test
    void shouldReturnAInvalidDiscountCodeForMango(){
        Order order = new Order("Mango", 3, "Mango16");
        assertThrows(PriceNotFoundException.class, () -> productCostCalcu.calculate(order));
    }
}
