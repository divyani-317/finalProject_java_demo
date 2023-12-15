import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PizzaShop {
    private Menu menu;
    private OrderManager orderManager;
    private User currentUser;

    public PizzaShop() {
       try {
           this.menu = new Menu();
           this.orderManager = new OrderManager();
           this.currentUser = new User();
       }
       catch(Exception ex){
           System.out.println(ex.getMessage());
       }
    }

    public void run() {
       try {
           System.out.println("Welcome to the Pizza Management System - PMS!");
           menu.displayMenu();
           System.out.println("6. View Cart");
           System.out.println("7. Checkout");
           System.out.println("8. Exit");

           while (true) {
               mainMenuHandler();
           }
       }
         catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    private void mainMenuHandler() {
        try {
            System.out.print("Please add any pizza to cart: ");
            Scanner scanner = new Scanner(System.in);
            int userChoice = scanner.nextInt();
            boolean selctionCompleted = false;

            switch (userChoice) {
                case 1: case 2: case 3: case 4:
                    menu.processMenuChoice(userChoice, currentUser.getCart());
                    break;
                case 5:
                    CustomPizza customPizza = new CustomPizza();
                    while(true) {
                        System.out.println("Select Toppings:");
                        System.out.println("1. Add Veggies");
                        System.out.println("2. Add Sauces");
                        System.out.println("3. Add Cheese");
                        System.out.println("4. Exit");
                        Scanner _scanner = new Scanner(System.in);
                        int toppingSelected = _scanner.nextInt();

                        switch (toppingSelected) {
                            case 1:
                                customPizza.addTopping(new Vegetables("Tomatoes"));
                                customPizza.addTopping(new Vegetables("Mushrooms"));
                                System.out.println("Veggies added.");
                                break;
                            case 2:
                                customPizza.addTopping(new Sauces("Mayo"));
                                customPizza.addTopping(new Sauces("Chipotle"));
                                System.out.println("Sauces added.");
                                break;
                            case 3:
                                customPizza.addTopping(new Cheese("Mozzarella"));
                                customPizza.addTopping(new Cheese("Processed"));
                                System.out.println("Cheese added.");
                                break;
                            case 4:
                                menu.UpdateCustomPiza(customPizza);
                                menu.processMenuChoice(5, currentUser.getCart());
                                selctionCompleted = true;
                        }
                        if (selctionCompleted)
                        {
                            System.out.println("Toppings added - " + customPizza.getToppings());
                            break;
                        }
                    }

                    break;
                case 6:
                    currentUser.getCart().displayCart();
                    System.out.println("Would you like to remove any pizza? Y/N");
                    Scanner _scanner = new Scanner(System.in);
                    char changeRequired = _scanner.nextLine().charAt(0);
                    if(Character.toUpperCase(changeRequired) == 'Y') {
                        System.out.println("Select any pizza to remove:");
                        int selectedPizza = _scanner.nextInt();
                        menu.RemoveSelectedPizza(selectedPizza, currentUser.getCart());
                    }
                    break;
                case 7:
                    orderManager.checkoutOrder(currentUser);
                    break;
                case 8:
                    System.out.println("Thank you for visiting. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again!");
                    break;
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
