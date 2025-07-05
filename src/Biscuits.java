public class Biscuits extends Product implements Shippable{
    private boolean expired;
    private double weight;

    public Biscuits(String name, double price, int quantity,double weight, boolean expired) {
        super(name, price, quantity);
        this.expired = expired;
        this.weight = weight;

    }

    @Override
    public boolean isExpired() {
        return expired;
    }
    @Override
    public double getWeight() {
        return weight;
    }
}
