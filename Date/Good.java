package Date;

public class Good {

    private String name;
    private int idItem;
    private boolean sale;

    public Good() {

    }

    public String getName() {
        return name;
    }
    public boolean isSale() {
        return sale;
    }

    public double getPrice() {
        return price;
    }

    private double price;

    public Good (String name, int idItem, boolean sale, double price) {
        this.name = name;
        this.idItem = idItem;
        this.sale = sale;
        this.price = price;

    }

    public void printGood () {
        System.out.println(this.name + " " + this.idItem + " " + this.price + " " + this.sale);
    }
}

