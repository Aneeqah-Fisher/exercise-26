import java.util.Scanner;

public class App{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Read the first sorted list
        System.out.print("Enter the number of elements in the first list followed by the elements: ");
        int[] list1 = readList(input);

        // Read the second sorted list
        System.out.print("Enter the number of elements in the second list followed by the elements: ");
        int[] list2 = readList(input);

        // Merge the two sorted lists
        int[] mergedList = merge(list1, list2);

        // Display the merged list
        System.out.print("The merged list is: ");
        for (int num : mergedList) {
            System.out.print(num + " ");
        }

        input.close();
    }

    private static int[] readList(Scanner input) {
        int size = input.nextInt();
        int[] list = new int[size];
        for (int i = 0; i < size; i++) {
            list[i] = input.nextInt();
        }
        return list;
    }

    public static int[] merge(int[] list1, int[] list2) {
        int[] mergedList = new int[list1.length + list2.length];
        int i = 0, j = 0, k = 0;

        // Merge the two lists
        while (i < list1.length && j < list2.length) {
            mergedList[k++] = (list1[i] <= list2[j]) ? list1[i++] : list2[j++];
        }

        // Copy remaining elements from list1, if any
        while (i < list1.length) {
            mergedList[k++] = list1[i++];
        }

        // Copy remaining elements from list2, if any
        while (j < list2.length) {
            mergedList[k++] = list2[j++];
        }

        return mergedList;
    }
}
