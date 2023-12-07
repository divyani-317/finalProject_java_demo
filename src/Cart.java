import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Pizza> items;
    final String currencySymbol = "$";

    public Cart() { this.items = new ArrayList<>(); }

    // Get method
    public List<Pizza> getItems() {
        return items;
    }

    // Set method
    public void addToCart(Pizza pizza) {
        items.add(pizza);
        System.out.println(pizza.getName() + " added to your cart.");
    }

    public void displayCart() {
        System.out.println("\nYour Cart:");
        for (Pizza pizza : items) {
            System.out.println(pizza.getName() + " - "+currencySymbol+"" + pizza.getPrice());
        }
        System.out.println("Total: "+currencySymbol+"" + calculateCartTotal());
    }

    public void clearCart() {
        items.clear();
    }

    public double calculateCartTotal() {
        double totalPrice = 0.0;
        for (Pizza pizza : items) {
            totalPrice += pizza.getPrice();
        }
        //return items.stream().mapToDouble(Pizza::getPrice).sum();
        return  totalPrice;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
