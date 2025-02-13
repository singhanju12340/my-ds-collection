package com.tekion.aec.cp.imsjobs.controller.arrays;

/**
 * @author anju
 * @created on 22/08/24 and 1:18 PM
 */
public class DuplicateInArray {
    static void printRepeating(int arr[], int n)
    {
        // First check all the values that are
        // present in an array then go to that
        // values as indexes and increment by
        // the size of array
        for (int i = 0; i < n; i++)
        {
            int index = arr[i] % n;
            arr[index] += n;
        }

        // Now check which value exists more
        // than once by dividing with the size
        // of array
        for (int i = 0; i < n; i++)
        {
            if ((arr[i] / n) >= 2)
                System.out.print(i + " ");
        }
    }

    // Driver code
    public static void main(String args[])
    {
        int arr[] = { 1, 2, 3, 1, 3, 6, 6 };
        int arr_size = arr.length;

        System.out.println("The repeating elements are: ");

        // Function call
        printRepeating(arr, arr_size);
    }
}
