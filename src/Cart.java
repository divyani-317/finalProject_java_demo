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
       try {
           items.add(pizza);
           System.out.println(pizza.getName() + " added to your cart.");
       }
       catch(Exception ex){
           System.out.println(ex.getMessage());
       }
    }

    public void removeFromCart(int choice) {
        try {
            int index = choice - 1;
            if (index >= 0 && index < items.size()) {
                Pizza removedPizza = items.remove(index);
                System.out.println(removedPizza.getName() + " removed from your cart.");
            }
            else {
                System.out.println("Invalid index. Pizza not removed from the cart.");
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void displayCart() {
        try {
            System.out.println("\nYour Cart:");
            int index = 1;
            for (Pizza pizza : items) {
                System.out.println(index + ". " + pizza.getName() + " - "+currencySymbol+"" + pizza.getPrice());
                index++;
            }
            System.out.println("Total: "+currencySymbol+"" + calculateCartTotal());
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void clearCart() {
        items.clear();
    }

    public double calculateCartTotal() {
        double totalPrice = 0.0;
        try {
            for (Pizza pizza : items) {
                totalPrice += pizza.getPrice();
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return  totalPrice;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
