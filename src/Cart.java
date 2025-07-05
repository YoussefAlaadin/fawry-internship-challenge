import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void add(Product product, int quantity){
        if(!product.isAvailable(quantity)){
            System.out.println("Not Enough quantity available for: "+ product.getName());
            return;
        }
        if(product.isExpired()){
            System.out.println("Sorry product "+product.getName() +" is expired");
            return;
        }
        items.add(new CartItem(product, quantity));
        product.reduceQuantity(quantity); // Reduce the quantity in stock
    }

    public List<CartItem> getItems() {
        return items;
    }
    public boolean isEmpty(){
        return items.isEmpty();
    }
    public double getSubTotal(){
        return items.stream().mapToDouble(CartItem::getTotalPrice).sum();
    }
}
