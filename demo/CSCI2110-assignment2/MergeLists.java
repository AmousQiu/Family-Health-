import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MergeLists {
    public static <T extends Comparable<T>> OrderedList merge(OrderedList<T> list1, OrderedList<T> list2) {
        OrderedList<T> list3 = new OrderedList<>();
        int f1 = 0;//start of f1
        int f2 = 0;//start of f2
        while (f1 < list1.size() && f2 < list2.size()) {
            if (list1.get(f1).compareTo(list2.get(f2)) < 0) {//if item at f1 < item at f2
                list3.add(list1.get(f1));//append item at f1 to l3(add to end)
                f1++;//move f1
            } else if (list1.get(f1).compareTo(list2.get(f2)) > 0) {
                list3.add(list2.get(f2));
                f2++;
            } else {
                list3.add(list1.get(f1));
                f1++;
                f2++;
            }
        }
        //append remaining items in l2 to l3
        if (f1 == list1.size()) {
            while (f2 < list2.size()) {
                list3.add(list2.get(f2));
                f2++;
            }
        }
        //append remaining items in l1 to l3
        if (f2 == list2.size()) {
            while (f1 < list1.size()) {
                list3.add(list1.get(f1));
                f1++;
            }
        }
        return list3;
    }

    public static void main(String[] args) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        //create a list from the first file
        System.out.println("Enter the first filename to read from:");
        String filename1 = keyboard.nextLine();
        File file1 = new File(filename1);
        Scanner inputFile1 = new Scanner(file1);
        Scanner input = new Scanner(System.in);
        OrderedList<String> nList1 = new OrderedList();
        while (inputFile1.hasNext()) {
            String name = inputFile1.nextLine();
            nList1.insert(name);
        }
        inputFile1.close();
        //System.out.println(nList1.size()); it's used for test
        nList1.enumerate();//display list1

        //create a lis from the second list
        System.out.println("Enter the second filename to read from:");
        String filename2 = keyboard.nextLine();
        File file2 = new File(filename2);
        Scanner inputFile2 = new Scanner(file2);
        OrderedList<String> nList2 = new OrderedList();
        while (inputFile2.hasNext()) {
            String name = inputFile2.nextLine();
            nList2.insert(name);
        }
        inputFile2.close();
        //System.out.println(nList2.size());
        nList2.enumerate();
        merge(nList1, nList2).enumerate();

    }

}
