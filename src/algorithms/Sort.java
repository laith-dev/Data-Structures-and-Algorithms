package algorithms;

public class Sort {

    public static void selectionSort(int[] arr) {

        /*
         * Find the smallest number and put it in its correct place
         */

        for (int i = 0; i < arr.length - 1; i++) {

            // Find the smallest integer from i -> n-1
            int min = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[min])
                    min = j;

            // Swap arr[i] & arr[min]
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }

    }

    public static void insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {

            // The value to be sorted
            int temp = arr[i];

            // Move all values that's bigger than 'temp' one step forward
            int j = i - 1;
            while ((j >= 0) && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Place temp in its correct place, which is arr[j++]
            arr[++j] = temp;

        }

    }

    public static void quickSort(int[] arr, int low, int high) {

        /* There must be at least 2 elements to be sorted:
        *  - if (low = high) -> there is only one element, no need to sort
        *  - if (low > high) -> invalid input
        * */
        if (low < high) {

            // After this call, pivot is at the correct place in the array
            int pivotIndex = partition(arr, low, high);

            // Repeat for the sub-arrays

            // For elements that are smaller than pivot
            quickSort(arr, low, pivotIndex - 1);

            // For elements that are greater than pivot
            quickSort(arr, pivotIndex + 1, high);
        }

    }

    private static int partition(int[] arr, int low, int high) {

        // The last element is considered as the pivot
        int pivot = arr[high];

        // index of smaller element
        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {

            if (arr[j] < pivot) {
                i++;

                // Swap arr[i], arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

        }

        i++;
        // now, i is the index that the pivot must be at

        // Swap arr[i], pivot (arr[high])
        int temp = arr[high];
        arr[high] = arr[i];
        arr[i] = temp;

        /* now, i is the index of pivot where all elements that are smaller than pivot are
         on the left, and all elements that are greater than the pivot are on the right */
        return i;

    }

} // end class algorithms.Sort

























