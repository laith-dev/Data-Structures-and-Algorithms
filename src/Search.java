public class Search {

    public static int linearSearch(int[] ints, int key) {
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static int linearSearch(String[] strings, String key) {
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals(key)) {
                return i;
            }
        }

        return -1;
    }

    /*
     * -Time Complexity:
     *   - Successful:
     *       Best:    O(1)
     *       Average: O(log n)
     *       Worst:   O(log n)
     *
     *   - Unsuccessful:
     *      O(log n) best, average & worst cases
     *
     */
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

    /*
        Procedure depthFirstSearch ( graph G , start vertex , end vertex )
        // visited (1 : n) ,Boolean array initiated to false
        // every vertex i had been visited visited [i] = true.
        Found = false;
        Stack . push(start vertex)
        Do
        Stack . pop(vertex)
        If (vertex = = end vertex) Found = true;
        else {
        if (visited(vertex) = = false)
        { visited(vertex) = true
        push all adjacent vertices to ‘vertex’ that have
        } //end if
        } //end else
        while ( ! stack . Is Empty( ) && ! found )
        if (found) print “path exist”
        else print “ path not found”
        End procedure
    */

}



















































