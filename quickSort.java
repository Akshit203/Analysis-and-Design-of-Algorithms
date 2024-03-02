import java.util.Scanner;

public class quickSort {

    public static int partition(int[] arr, int low, int high) {

        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j) {

            while (i <= high && arr[i] <= pivot) {
                i++;
            }

            while (j >= low && arr[j] > pivot) {
                j--;
            }

            if (i < j) {
                swap(arr, i, j);
            }

        }

        swap(arr, low, j);
        return j;
    }

    public static void quickSort(int[] arr, int low, int high) {

        if (low < high) {

            int j = partition(arr, low, high);
            quickSort(arr, low, j);
            quickSort(arr, j + 1, high);

        }

    }

    public static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        
    }

    public static void main(String args[]) {

        Scanner scr = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scr.nextInt();

        int[] arr = new int[size];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            arr[i] = scr.nextInt();
        }

        quickSort(arr, 0, size - 1);

        System.out.println("Sorted Array :");

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
   
        }
    }
}
