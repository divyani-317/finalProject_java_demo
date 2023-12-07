public class User {
    private Cart cart;

    public User() {
        this.cart = new Cart();
    }

    public Cart getCart() {
        return cart;
    }
}
