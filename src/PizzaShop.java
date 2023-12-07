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
            System.out.print("Please make your choice: ");
            Scanner scanner = new Scanner(System.in);
            int userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1: case 2: case 3: case 4: case 5:
                    menu.processMenuChoice(userChoice, currentUser.getCart());
                    break;
                case 6:
                    currentUser.getCart().displayCart();
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
