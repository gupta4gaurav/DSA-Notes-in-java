public class Assignment {
    // This method merges two sub-arrays and counts the number of inversions between them.
    // It returns the total number of inversions found in the two sub-arrays
    public static int merge(int[] arr, int left, int mid, int right) {
        int i = left, j = mid, k = 0;
        int invCount = 0;
        int[] temp = new int[(right - left + 1)];

        // Merge the two sub-arrays into a temporary array, while counting the number of
        // inversions
        while ((i < mid) && (j <= right)) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                k++;
                i++;
            } else {
                temp[k] = arr[j];
                invCount += (mid - i); // Increment the inversion count by the number of remaining elements in the left
                                       // sub-array
                k++;
                j++;
            }
        }
        // Copy the remaining elements from the left sub-array to the temporary array
        while (i < mid) {
            temp[k] = arr[i];
            k++;
            i++;
        }
        // Copy the remaining elements from the right sub-array to the temporary array
        while (j <= right) {
            temp[k] = arr[j];
            k++;
            j++;
        }

        // Copy the sorted sub-array from the temporary array back to the original array
        for (i = left, k = 0; i <= right; i++, k++) {
            arr[i] = temp[k];
        }
        return invCount;
    }

    // This method recursively divides the array into two sub-arrays, sorts them,
    // and merges them
    // It returns the total number of inversions found in the array
    private static int mergeSort(int[] arr, int left, int right) {
        int invCount = 0;

        if (right > left) {
            int mid = (right + left) / 2;
            // Recursively divide and sort the left sub-array
            invCount = mergeSort(arr, left, mid);
            // Recursively divide and sort the right sub-array
            invCount += mergeSort(arr, mid + 1, right);
            // Merge the sorted left and right sub-arrays and count the number of inversions
            // between them
            invCount += merge(arr, left, mid + 1, right);
        }
        return invCount;
    }

    // This method calls the mergeSort method to count the number of inversions in
    // an array
    // It returns the total number of inversions found in the array
    public static int getInversions(int arr[]) {
        int n = arr.length;
        return mergeSort(arr, 0, n - 1);
    }

    // This method tests the getInversions method by creating an array and printing
    // the number of inversions found in it
    public static void main(String[] args) {
        int[] arr = { 1, 20, 6, 4, 5 };
        System.out.println("Inversion Count = " + getInversions(arr));
    }

}
