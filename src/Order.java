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
        double totalPrice = 0.0;
        try {
            for (Pizza pizza : pizzas) {
                totalPrice += pizza.getPrice();
            }
        }
         catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return  totalPrice;
    }
}
