import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private double price;
    private List<Topping> toppings;
    public Pizza(String name, double price) {
        this.name = name;
        this.price = price;
        this.toppings = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        double toppingPrice = toppings.stream().mapToDouble(Topping::getPrice).sum();
        return price + toppingPrice;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public void addTopping(Topping topping) {
        toppings.add(topping);
    }
    public List<Topping> getToppings() {
        return toppings;
    }
}
