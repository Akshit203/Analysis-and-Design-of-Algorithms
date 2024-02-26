// MERGE SORT ALGORITHM
import java.util.*;
import java.util.Scanner;

public class mergeSort {

    public static void main (String args[]){

        Scanner scr = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scr.nextInt();
        int[] arr = new int[size];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            arr[i] = scr.nextInt();
        }

        mergeSort_function(arr, 0 , arr.length - 1);

        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

    }

    public static void mergeSort_function (int[] arr, int low, int high) {

        if (low < high) {

            int mid = (low + high) / 2;

            mergeSort_function(arr, low, mid);
            mergeSort_function(arr, mid + 1, high);


            merge(arr, low, mid, high);
        }

    }

    public static void merge(int[] arr, int low, int mid, int high) {

        int m = mid - low + 1;
        int n = high - mid;

        int [] leftArray = new int[m];
        int [] rightArray = new int[n];

        for (int i = 0; i < m; ++i) {
            leftArray [i] = arr [low + i];
        }

        for (int j = 0; j < n; ++j) {
            rightArray [j] = arr [mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = low;

        while (i < m && j < n) {

            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } 
            
            else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < m) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

}