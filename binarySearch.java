import java.util.*;

public class binarySearch {

    static int binary_search(int arr[], int target){

        int start = 0, end = arr.length - 1;
        int mid;

        while (start <= end) {
             mid = start + (end - start) / 2;

            // if target is present at mid
            if (arr[mid] == target)
                return mid;

            if (arr[mid] < target)
                start = mid + 1;

            else
                end = mid - 1;
        }

        // If target is not found
        return -1;
    }

    public static void main(String args[]){

        Scanner scr =  new Scanner(System.in);

        System.out.println("Enter Length of an Array : ");
        int arr_len = scr.nextInt();

        int arr[] =  new int[arr_len];

        System.out.println ("Enter Array elements in sorted order : ");

        for(int i = 0; i < arr_len; i++){
            arr[i] = scr.nextInt();
        }

        System.out.print("Enter the target element to search: ");
        int target = scr.nextInt();
        
        int target_index = binary_search (arr, target);

        if(target_index == -1) {
            System.out.println("Element not present in array");
        }
            
        else {
            System.out.println("Element found at index " + target_index);
        }
            
    }
}