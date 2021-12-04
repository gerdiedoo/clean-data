package main;

/**
 * Created by abdullahodibat.
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] nums = new int[8];
        nums[0] = 5;
        nums[1] = 7;
        nums[2] = 3;
        nums[3] = 2;
        nums[4] = 0;
        nums[5] = 1;
        nums[6] = 9;
        nums[7] = 8;
        int max = getMax(nums);
        for (int exp = 1; max / exp > 0; exp *= 10)
            countSort(nums, exp);

        for (int num : nums) {
            System.out.println(num);
        }
    }

    static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > max)
                max = arr[i];
        return max;
    }

    public static void countSort(int[] nums, int exp) {
        int[] countArr = new int[10];
        for (int i = 0; i < countArr.length; i++) {
            countArr[i] = 0;
        }
        for (int i = 0; i < nums.length; i++) {
            countArr[(nums[i] / exp) % 10]++;
        }
        int sum = 0;
        for (int i = 0; i < countArr.length; i++) {
            sum += countArr[i];
            countArr[i] = sum;
        }
        int[] result = new int[nums.length];
        for (int i = result.length - 1; i >= 0; i--) {
            result[countArr[(nums[i] / exp) % 10] - 1] = nums[i];
            countArr[(nums[i] / exp) % 10]--;

        }
        for (int i = 0; i < result.length; i++) {
            nums[i] = result[i];
        }
    }

}
