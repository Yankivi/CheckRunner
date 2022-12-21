package Date;

import java.util.HashMap;

public class DataBase {
    private HashMap<Integer, Good> products = new HashMap<>();
    {
        products.put(1, new Good("Banana", 1, false, 2.45));
        products.put(2, new Good("Pineapple", 2, false, 3.20));
        products.put(3, new Good("Orange", 3, true, 2.90));
        products.put(4, new Good("Watermelon", 4, false, 4.50));
        products.put(5, new Good("Cherry", 5, false, 6.30));
        products.put(6, new Good("Grapefruit", 6, false, 3.00));
        products.put(7, new Good("Strawberry", 7, true, 7.12));
        products.put(8, new Good("Lemon", 8, true, 2.80));
        products.put(9, new Good("Peach", 9, false, 5.61));
        products.put(10, new Good("Pear", 10, true, 1.99));

    }
    private HashMap<String, Double> cardDiscont = new HashMap<>();
    {
        cardDiscont.put("1000", 0.12);
        cardDiscont.put("1111", 0.05);
        cardDiscont.put("1221", 0.0);
        cardDiscont.put("1311", 0.50);
        cardDiscont.put("1467", 0.03);
        cardDiscont.put("1581", 0.00);
        cardDiscont.put("1670", 0.03);
        cardDiscont.put("1739", 0.20);
        cardDiscont.put("1888", 0.00);
        cardDiscont.put("1956", 0.14);
    }

    public Good getGoodOnId(int id)
    {
        return  products.get(id); // возвращает Good по номеру ключа
    }

    public double getDiscountOfCard (String cardNumber)
    {
        if (cardDiscont.containsKey(cardNumber))
        {
            return cardDiscont.get(cardNumber); //возвращает скидку по карте, если такая катра существует
        }
        return 0;
    }
}
