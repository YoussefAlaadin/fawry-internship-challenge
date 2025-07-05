//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Products
        Product cheese = new Cheese("Cheese", 100, 5,  200,true);
        Product biscuits = new Biscuits("Biscuits", 150, 3, 700, false);
        Product tv = new TV("TV", 200, 5, 700);
        Product scratchCard = new ScratchCard("Scratch Card", 50, 10);

        // Customer
        Customer customer = new Customer("Youssef", 600);

        // Add Cart
        customer.getCart().add(cheese, 2);
        customer.getCart().add(biscuits, 1);
        customer.getCart().add(scratchCard, 1);

        // Checkout
        CheckoutService.checkout(customer);
    }
}