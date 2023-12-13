import java.util.List;

public class Topping {
   private String name;
   private  double price;
   final String currencySymbol = "$";
   public Topping(String _name, double _price) {
    this.name = _name;
    this.price = _price;
   }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return name + " (" + currencySymbol + price + ")";
    }
}
