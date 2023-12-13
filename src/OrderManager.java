public class OrderManager {
    final String currencySymbol = "$";
    public void checkoutOrder(User user) {
        try {
            if (user.getCart().isEmpty()) {
                System.out.println("Your cart is empty. Please add items before checkout.");
                return;
            }

            Order order = new Order(user.getCart().getItems());
            System.out.println("\nOrder Placed Successfully!");
            System.out.println("Total Amount: " + currencySymbol + order.getTotalAmount());

            user.getCart().clearCart();
            user.getCart().displayCart();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
