import java.util.ArrayList;
import java.util.List;

public class CustomPizza extends Pizza{
    private static final double basePrice = 10.00;
    private double price;
    public CustomPizza() {
        super("Custom Pizza", basePrice);
        price = basePrice;
    }
    @Override
    public void setPrice(double price) {
        super.setPrice(price + this.price);
    }
}
