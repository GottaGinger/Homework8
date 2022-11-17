import java.util.*;

public class Main {
    public static Scanner sncr;
    private static Map<String, Double> items = new TreeMap<>();
    private static List<String> orderNames = new ArrayList<>();
    private static List<Double> orderPrices = new ArrayList<>();


    public static void main(String[] args) {
        // loop start?
        String answerOrderContinue = "y";
        do {
            sncr = new Scanner(System.in);
            fillItemsMap();

            printMenu();
            System.out.println("What would you like to order?");
            String itemName = sncr.nextLine();

            if (itemExist(itemName)) {
                Double itemPrice = items.get(itemName);
                System.out.println("Adding " + itemName + " to cart as $" + itemPrice);
                // storing items/ prices chosen
                orderNames.add(itemName);
                orderPrices.add(itemPrice);
                System.out.println("Would you like to order anything else (y/n)");
                answerOrderContinue = sncr.nextLine();

            }
        } while (orderMoreCont(answerOrderContinue));
        checkOut();
    }

    private static void fillItemsMap() { // map of arrays
        items.put("apple", .99);
        items.put("banana", .59);
        items.put("cauliflower", 1.59);
        items.put("dragonfruit", 2.19);
        items.put("elderberry", 1.79);
        items.put("figs", 2.09);
        items.put("grapefruit", 1.99);
        items.put("honeydew", 3.49);
    }

    private static void printMenu() {
        System.out.println("Item\tPrice"); // prints out the menu

        for (Map.Entry<String, Double> entry : items.entrySet()) {
            System.out.println(entry.getKey() + "\t"
                    + entry.getValue());

        }
    }

    private static boolean itemExist(String itemName) { // checks if user entered correct items
        if (items.get(itemName) == null) {
            System.out.println("Sorry, we don't have those. Please try again.");
            return false;
        } else {
            return true;
        }
    }

    private static boolean orderMoreCont(String answerOrderContinue) {
        return answerOrderContinue.equals("y");

    }

    // loop ends here
    private static void checkOut() {
        System.out.println("Thanks for your order!");
        System.out.println("Here's what you got:");
        printOrder();
        averageCost();
        highestCost();
        lowestCost();

    }

    private static void printOrder() {
        System.out.println("Item\tPrice"); // prints out the menu

        for (int i = 0; i < orderNames.size(); i++) {
            System.out.println(orderNames.get(i) + "\t" + (orderPrices.get(i)));
        }

    }

    private static void averageCost() {  //average cost of all ordered items
        double averageValue = 0;
        double sum = 0;
        for (int i = 0; i < orderPrices.size(); i++) {
            sum += orderPrices.get(i);
            averageValue = sum / orderPrices.size();
        }
        System.out.println("Average price per item in order was " + averageValue);
    }

    private static void highestCost() { //looking for highest priced item in arraylist
        double highestCost = orderPrices.get(0);
        for (int i = 1; i < orderPrices.size(); i++) {
            double curValue = orderPrices.get(i);
            if (curValue > highestCost) {
                highestCost = curValue;
            }
        }
        System.out.println("Your highest cost item is " + highestCost);
    }
    private static void lowestCost(){
        double lowestCost = orderPrices.get(0);
        for (int i = 1; i < orderPrices.size(); i++) {
            double curValue = orderPrices.get(i);
            if (curValue < lowestCost) {
                lowestCost = curValue;
            }
        }
        System.out.println("Your lowest cost item is " + lowestCost);
    }
}





//method for average cost of items

//method for highest cost

//method for lowest cost

// can make a number system - to have them choose a number for the items
//a third ArrayList for quantities of items ordered and allow the user to order more than one at a time.
//Extended: If they order an item already in their cart, increase the quantity rather than adding another entry.
