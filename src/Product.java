public abstract class Product {
    protected String name;
    protected double price;
    protected int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void reduceQuantity(int amount) {
        if (amount > quantity) {    // Checks if stock has enough quantity
            throw new IllegalArgumentException("Not enough quantity in stock!");
        }
        quantity -= amount;

    }

    public abstract boolean isExpired(); // Checks if the product is expirable

    public  boolean isAvailable(int requestedQty){ // Checks if the product is available in stock
        return quantity >= requestedQty;
    }

}

