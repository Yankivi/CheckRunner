import Date.DataBase;
import Date.Good;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CheckRunner {

    public static void main(String[] args) throws IOException {
        System.out.println("CheckRunner is running");
        DataBase dataBase = new DataBase();
        String[] data = args;
        if (args.length == 0 )
        {
            FileReader fr = new FileReader("CheckInputFile.txt");
            Scanner scan = new Scanner(fr);
            String fileData = scan.nextLine();
            fr.close();
            data = fileData.split(" ");
        }
        // получаем все товары в виде массива
        // где [0] - id товара
        // [1] - количество товаров
        var goodsItems = getGoods(data);
        // получаем номер карты если она есть, в ином случае пустая строка
        var cardNumber = getDiscondCardNumber(data);
        dataScanner(goodsItems, cardNumber);
    }

    public static List<String[]> getGoods(String[] items)
    {
        List<String[]> result = new ArrayList<>();

        for (String item : items) {
            var temp = item.split("-");
            if (!temp[0].equals("card"))
            {
                result.add(temp);
            }
        }
        return result;
    }

    public static String getDiscondCardNumber(String[] items)
    {
        for (String item : items) {
            var temp = item.split("-");
            if (temp[0].equals("card"))
            {
                return temp[1];
            }
        }
        return "";
    }

    public static double getGoodPrice(Good good, Integer count)
    {
        return good.getPrice() * count;
    }

    public static void writeInFile (List<String> line) throws IOException {

        FileWriter writer = new FileWriter("CheckRunner.txt",false);
        for (var item: line)
        {
            writer.write(item);
        }
        writer.flush();
        writer.close();
    }

    public static void dataScanner(List<String[]> inputData, String cardNumber) throws IOException {
        DataBase dataBase = new DataBase();
        double totalPrice = 0;
        List<String> linesForPrint = new ArrayList<>();
        String lineForPrint = new String();
        lineForPrint = String.format("%-5s %-15s %-9s %-10s \n", "QTY", "Description", "Price", "Total");
        System.out.print(lineForPrint);
        linesForPrint.add(lineForPrint);
        lineForPrint = String.format("-".repeat(39) + "\n");
        System.out.print(lineForPrint);
        linesForPrint.add(lineForPrint);
        for (var item : inputData)
        {
            int searchKey = Integer.parseInt(item[0]);
            int count = Integer.parseInt(item[1]);
            Good searchedGood = dataBase.getGoodOnId(searchKey);
            double goodPrice = getGoodPrice(searchedGood, count);
            lineForPrint = String.format("%-5d %-15s %-10s", count, searchedGood.getName(),
                    String.format("%.2f", goodPrice) + "$");
            linesForPrint.add(lineForPrint);
            System.out.printf(lineForPrint);
            double productDiscont = 1;
            if (searchedGood.isSale() && count > 5)
            {
                productDiscont = 0.9;
            }
            double goodsPriceWithDiscount = goodPrice * productDiscont;
            totalPrice += goodsPriceWithDiscount;
            lineForPrint = String.format("%-10s \n", String.format("%.2f", goodsPriceWithDiscount) + "$");
            System.out.printf(lineForPrint);
            linesForPrint.add(lineForPrint);
        }
        var discont = dataBase.getDiscountOfCard(cardNumber);
        lineForPrint = String.format("-".repeat(39) + "\n");
        System.out.print(lineForPrint);
        linesForPrint.add(lineForPrint);

        System.out.printf("TOTAL PRICE: %-7s", String.format("%.2f", totalPrice) + "$ \n");
        linesForPrint.add(String.format("TOTAL PRICE: %-7s", String.format("%.2f", totalPrice) + "$ \n"));
        if (discont != 0)
        {
            System.out.printf("CARD DISCOUNT:  %-3s", String.format("%.2f", discont * 100) + "% \n");
            linesForPrint.add(String.format("CARD DISCOUNT:  %-3s", String.format("%.2f", discont * 100) + "% \n"));
            System.out.printf("TOTAL PRICE WITH DISCOUNT: %-7s", String.format("%.2f", totalPrice - totalPrice * discont) + "$");
            linesForPrint.add(String.format("TOTAL PRICE WITH DISCOUNT: %-7s", String.format("%.2f", totalPrice - totalPrice * discont) + "$ \n"));
        }
        writeInFile(linesForPrint);
    }
}
