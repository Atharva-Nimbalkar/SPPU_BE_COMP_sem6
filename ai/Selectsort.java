package atharva.com.TwoDarray;


import java.util.Scanner;

public class Selectsort {
    void sort(int arr[]) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        Selectsort ob = new Selectsort();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of elements in the array:");
        int size = scanner.nextInt();

        int arr[] = new int[size];

        System.out.println("Enter the elements of the array:");

        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        ob.sort(arr);

        System.out.println("Sorted array:");
        ob.printArray(arr);

        // Close the scanner to avoid resource leak
        scanner.close();
    }
}
