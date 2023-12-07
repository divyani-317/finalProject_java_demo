
public class Main {
    public static void main(String[] args) {
        try{
            PizzaShop pizzaShop = new PizzaShop();
            pizzaShop.run();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
