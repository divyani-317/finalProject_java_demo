import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Pizza> menuItems;

    public Menu() {
        this.menuItems = new ArrayList<>();
        initMenu();
    }

    private void initMenu() {
        menuItems.add(new MargheritaPizza());
        menuItems.add(new PepperoniPizza());
        menuItems.add(new VeggiePizza());
        menuItems.add(new HawaiianPizza());
        menuItems.add(new CustomPizza());
    }

    public void displayMenu() {
        System.out.println("\n Our Menu:");
        int index = 1;
        for (Pizza pizza : menuItems) {
            System.out.println(index + ". " + pizza.getName() + " - $" + pizza.getPrice());
            index++;
        }
    }

    public void processMenuChoice(int choice, Cart cart) {
        Pizza pizza = menuItems.get(choice - 1);
        cart.addToCart(pizza);
    }
}
