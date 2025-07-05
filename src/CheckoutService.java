import java.util.ArrayList;
import java.util.List;
public class CheckoutService {
    public static final double SHIPPING_FEE_PER_KG = 15.0;

    public static void checkout(Customer customer){
        Cart cart = customer.getCart();
        if(cart.isEmpty()){
            System.out.println("Cart is empty!");
        return;
        }

        List<CartItem> items = cart.getItems();  // Items from the cart of the specified customer
        double subtotal = cart.getSubTotal(); // Items' price in the cart

        List<Shippable> itemsToShip = new ArrayList<>();
        double totalWeight = 0;

        for(CartItem item : items){
            Product product = item.getProduct();
            int quantity = item.getQuantity();

            if(product instanceof Shippable) { // Checks if the product is shippable
                Shippable shippable = (Shippable) product;
                itemsToShip.add(shippable);
                totalWeight += shippable.getWeight() * quantity;
            }
        }
        double shippingFees = totalWeight > 0 ? SHIPPING_FEE_PER_KG : 0;
        double total =subtotal +shippingFees;

        if(customer.getBalance()<total){
            System.out.println("Sorry insufficient balance!");
            return;
        }
        customer.reduceBalance(total);

        /****************PRINTING RECIEPTS*************/

        if(!itemsToShip.isEmpty()){
            System.out.println("** Shipment Notice **");
            for (CartItem item :items){
                if(item.getProduct() instanceof Shippable){
                    double itemWeight = ((Shippable) item.getProduct()).getWeight();
                    System.out.println(item.getQuantity() + "x " + item.getProduct().getName() + "     "+ item.getQuantity()*itemWeight);

                }
            }
            System.out.println("Total package weight " + (totalWeight / 1000.0) + "kg\n");
        }
        System.out.println("** Checkout receipt **");
        for (CartItem item : items) {
            System.out.println(item.getQuantity() + "x " + item.getProduct().getName() + "     " + item.getTotalPrice());
        }
        System.out.println("----------------------");
        System.out.println("Subtotal     " + subtotal);
        System.out.println("Shipping     " + shippingFees);
        System.out.println("Amount       " + total);
        System.out.println("Balance left " + customer.getBalance());
    }
}
