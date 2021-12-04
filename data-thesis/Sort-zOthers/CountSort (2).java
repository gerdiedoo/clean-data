package main;

/**
 * Created by abdullahodibat.
 */
public class CountSort {

    public static void main(String[] args) {
        int[] nums = new int[8];
        nums[0] = 8;
        nums[1] = 9;
        nums[2] = 3;
        nums[3] = 8;
        nums[4] = 2;
        nums[5] = 5;
        nums[6] = 9;
        nums[7] = 8;
        int[] result = countSort(nums);
        for (int num : result) {
            System.out.println(num);
        }
    }

    public static int[] countSort(int[] nums) {
        int[] countArr = new int[10];
        for (int i = 0; i < countArr.length; i++) {
            countArr[i] = 0;
        }
        for (int i = 0; i < nums.length; i++) {
            countArr[nums[i]] = countArr[nums[i]] + 1;
        }
        int sum = 0;
        for (int i = 0; i < countArr.length; i++) {
            sum += countArr[i];
            countArr[i] = sum;
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            countArr[nums[i]] = countArr[nums[i]] - 1;
            int index = countArr[nums[i]];
            result[index] = nums[i];

        }
        return result;
    }

}
