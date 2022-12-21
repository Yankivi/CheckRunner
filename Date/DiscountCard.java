package Date;

public class DiscountCard {

    private int cardNumber;
    private int discountValue;

    public DiscountCard (int cardNumber, int discountValue) {
        this.cardNumber = cardNumber;
        this.discountValue = discountValue;
    }

    public void printCards () {
        System.out.println(this.cardNumber + " " + this.discountValue + "%");
    }
}
