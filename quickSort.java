public class quickSort {
    public static void main (String args[]){




    }

    public static void split_Array (int low, int high){

        int pivot ;
    }

    public static void quickSort_function (int low, int high){

        if (low < high){

            j = split_Array (low, high);

            quickSort_function(low, high);
            quickSort_function(j + 1, high);
        }
    }
}
