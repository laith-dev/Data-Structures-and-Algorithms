package algorithms;

import java.util.ArrayList;

public class Search {

    public static final String ASC = "ASC";
    public static final String DESC = "DESC";
    public static final String UNSORTED = "UNSORTED";

    public static boolean search(int[] arr, int key, String sortOrder) {
        for (int i : arr) {
            if (sortOrder.equals(ASC) && i > key ||
                    sortOrder.equals(DESC) && i < key) {
                return false;
            } else if (i == key) {
                return true;
            }
        }
        return false;
    }

    public static void countOccurrences(int[] mainArray, int[] subArray) {
        for (int i : subArray) {
            System.out.println("Occurrences of " + i + ": " + countOccurrences(mainArray, i));
            System.out.println();
        }
    }

    public static int searchSubArray(int[] arr, int from, int to, int key) {
        if (from >= to || to > arr.length) {
            return -1;
        }

        for (int i = from; i < to; i++) {
            if (arr[i] == key) {
                return i;
            }
        }

        return -1;
    }

    public static ArrayList<Integer> searchOccurrences(int[] arr, int key) {
        ArrayList<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                indexes.add(i);
            }
        }
        return indexes;
    }

    public static int countOccurrences(int[] arr, int key) {
        int occurrences = 0;
        for (int i : arr) {
            if (i == key) {
                occurrences++;
            }
        }
        return occurrences;
    }
    // Returns the index of the last occurrence of key in arr, otherwise -1.

    public static int lastOccurrence(int[] arr, int key) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                index = i;
            }
        }
        return index;
    }
    // Returns the index of the first occurrence of key in arr, otherwise -1.

    public static int firstOccurrence(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static boolean binarySearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;

        int mid;
        while (low <= high) {
            mid = (low + high) / 2;

            if (key > arr[mid])
                low = mid + 1;
            else if (key < arr[mid])
                high = mid - 1;
            else
                return true;
        }

        return false;
    }

    public static boolean binarySearch(String[] arr, String key, boolean ignoreCase) {
        int low = 0, high = arr.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (ignoreCase) {
                if (key.compareToIgnoreCase(arr[mid]) > 0)
                    low = mid + 1;
                else if (key.compareToIgnoreCase(arr[mid]) < 0)
                    high = mid - 1;
                else
                    return true;
            } else {
                if (key.compareTo(arr[mid]) > 0)
                    low = mid + 1;
                else if (key.compareTo(arr[mid]) < 0)
                    high = mid - 1;
                else
                    return true;
            }
        }

        return false;
    }
}