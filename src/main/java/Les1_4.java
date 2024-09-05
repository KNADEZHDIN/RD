import java.util.Arrays;

public class Les1_4 {

    public static void main(String[] args) {

        int[] nums = {8, 1, 2, 2, 3};
        int[] numsAnswer = smallerNumbersThanCurrent(nums);
        System.out.println(Arrays.toString(numsAnswer));

    }

    // Time: 0(n^2)
    // Memory: 0(n)
    public static int[] smallerNumbersThanCurrent(int[] nums) {//Скільки чисел менші за поточне число
        int[] answer = new  int[nums.length];
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    count++;
                }
            }
            answer[i] = count;
            count = 0;
        }
        return answer;
    }

}
