public class Les1_1 {

    public static int countDuplicatePairs(int[] arr) {
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    counter++;
                }
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 6, 2, 3, 6, 6, 2, 1, 9, 12, 42, 2, 63, 33, 8193, 123, 62, 56, 7 };
        int count = countDuplicatePairs(arr);
        System.out.printf("Found %d same pairs\n", count);
        int size = arr.length;
        int numOfChecks = (size * (size - 1)) / 2;
        System.out.printf(
                "For array with %d elements, number of checks performed: %d\n",
                size,
                numOfChecks
        );
    }

}
