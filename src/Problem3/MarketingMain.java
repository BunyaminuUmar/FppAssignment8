package Problem3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MarketingMain {
    public static void main(String[] args) {
        List<Marketing> marketingList = new ArrayList<>();

        // Adding objects to the Marketing
        marketingList.add(new Marketing("Umar", "ProductA", 1200.50));
        marketingList.add(new Marketing("Ayisha", "ProductB", 800.75));
        marketingList.add(new Marketing("Baba", "ProductC", 1500.20));

        // Removing an object from Marketing
        remove(marketingList, "Ayisha", "ProductB");

        // Printing the size of the list
        System.out.println("Size of the list: " + marketingList.size());

        // Displaying the contents of the list using toString()
        System.out.println("Contents of the list:");
        System.out.println(marketingList);

        // Sorting the list in natural order for the field salesAmount using comparator interface
        marketingList.sort(new Comparator<Marketing>() {
            @Override
            public int compare(Marketing m1, Marketing m2) {
                return Double.compare(m1.getSalesAmount(), m2.getSalesAmount());
            }
        });

        // Sorting the list in natural order using employeename with the criteria of salesAmount > 1000
        List<Marketing> result = listMoreThan1000(marketingList);
        result.sort(new Comparator<Marketing>() {
            @Override
            public int compare(Marketing m1, Marketing m2) {
                return m1.getEmployeeName().compareTo(m2.getEmployeeName());
            }
        });

        // Displaying the sorted result
        System.out.println("Sorted result of employees with salesAmount > 1000:");
        System.out.println(result);
    }

    // Removing an object from Marketing
    public static void remove(List<Marketing> list, String employeeName, String productName) {
        list.removeIf(marketing -> marketing.getEmployeeName().equals(employeeName)
                && marketing.getProductName().equals(productName));
    }

    // Retrieve the list of employees with salesAmount > 1000
    public static List<Marketing> listMoreThan1000(List<Marketing> list) {
        List<Marketing> result = new ArrayList<>();
        for (Marketing marketing : list) {
            if (marketing.getSalesAmount() > 1000) {
                result.add(marketing);
            }
        }
        return result;
    }
}
