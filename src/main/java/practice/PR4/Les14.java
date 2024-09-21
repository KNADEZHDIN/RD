package practice.PR4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Les14 {

    public static void main(String[] args) {

//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);

        // лінійний пошук по елементам
//        if (list.contains(5)) {
//            System.out.println(1);
//        } else {
//            System.out.println("no data found");
//        }

        //System.out.println(list.indexOf(1)); // повертає індекс по значенню елементу


        int[] arrSorted = new int[]{0, 1, 5, 6, 8, 9, 11, 23, 24, 77, 82, 95, 102, 923};
        int searchVal = 2;
//        String out = "[%s] search for value %d. Index: %d \n";
//        System.out.printf(out, "binary recursive", searchVal, binarySearchRecursive(arrSorted, searchVal));

        System.out.println(Math.abs(Arrays.binarySearch(arrSorted, searchVal)));
    }

    public static int binarySearch(int[] arr, int elementToSearch) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            // if middle is search value - return it right away
            if (arr[mid] == elementToSearch) {
                return mid;

            } else if (arr[mid] < elementToSearch) {
                // if middle is LESS
                // move to the RIGHT part of array
                left = mid + 1;

            } else if (arr[mid] > elementToSearch) {
                // if middle is BIGGER
                // move to the LEFT part of array
                right = mid - 1;
            }

        }

        return -1;
    }

    public static int binarySearchRecursive(int[] arr, int elementToSearch) {
        return binarySearchRecursive(arr, 0, arr.length, elementToSearch);
    }

    public static int binarySearchRecursive(int[] arr, int left, int right, int elementToSearch) {
        // termination check
        if (right >= left) {
            int mid = left + (right - left) / 2;

            // if middle is what we need - return index
            if (arr[mid] == elementToSearch) {
                return mid;
            }

            // if middle is BIGGER
            // call search recursively from LEFT part of array
            if (arr[mid] > elementToSearch) {
                return binarySearchRecursive(arr, left, mid - 1, elementToSearch);
            }

            // if middle is LESS
            // call search recursively from RIGHT part of array
            return binarySearchRecursive(arr, mid + 1, right, elementToSearch);
        }

        return -1;
    }

}
