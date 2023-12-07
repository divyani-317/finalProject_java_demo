import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Pizza> menuItems;

    public Menu() {
        this.menuItems = new ArrayList<>();
        initMenu();
    }

    private void initMenu() {
        try {
            menuItems.add(new MargheritaPizza());
            menuItems.add(new PepperoniPizza());
            menuItems.add(new VeggiePizza());
            menuItems.add(new HawaiianPizza());
            menuItems.add(new CustomPizza());
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void displayMenu() {
        try {
            System.out.println("\n Our Menu:");
            int index = 1;
            for (Pizza pizza : menuItems) {
                System.out.println(index + ". " + pizza.getName() + " - $" + pizza.getPrice());
                index++;
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void processMenuChoice(int choice, Cart cart) {
       try {
           Pizza pizza = menuItems.get(choice - 1);
           cart.addToCart(pizza);
       }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
