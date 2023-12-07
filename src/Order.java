import java.util.List;

public class Order {
    private static int orderCount = 0;
    private int orderNumber;
    private List<Pizza> pizzas;

    public Order(List<Pizza> pizzas) {
        this.pizzas = pizzas;
        this.orderNumber = ++orderCount;
    }

    public double getTotalAmount() {
        return pizzas.stream().mapToDouble(Pizza::getPrice).sum();
    }
}
