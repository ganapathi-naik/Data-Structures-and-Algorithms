package leetcode.array._287;

/**
 * Problem link: <a href="https://leetcode.com/problems/find-the-duplicate-number/">287. Find The Duplicate Number</a><br/>
 * Author: <a href="https://github.com/ganapathi-naik">Ganapathi Naik</a><br/>
 * GitHub repo link: <a href="https://github.com/ganapathi-naik/Data-Structures-and-Algorithms">Data-Structures-and-Algorithms</a><br/>
 * Date: 2022-07-03<br/>
 */

public class FindTheDuplicateNumber {

    /**
     * Using Floyd’s Algorithm for Cycle Detection
     * Part 1: https://www.youtube.com/watch?v=iAe0GgyFrg4
     * Part 2: https://www.youtube.com/watch?v=SyfdOzZttXA
     */
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);

        int ptr1 = nums[0];
        int ptr2 = fast;

        while(ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }
        return ptr1;
    }

    private int withModificationOfInputArray(int[] inputArray) {
        for(int num : inputArray) {
            num = Math.abs(num);
            if(inputArray[num] < 0) {
                return num;
            }
            inputArray[num] *= -1;
        }
        return -1;
    }

    private int withoutModificationOfInputArray(int[] inputArray) {
        int slow = inputArray[0];
        int fast = inputArray[0];

        do {
            slow = inputArray[slow];
            fast = inputArray[inputArray[fast]];
        } while(slow != fast);

        int ptr1 = inputArray[0];
        int ptr2 = fast;

        while(ptr1 != ptr2) {
            ptr1 = inputArray[ptr1];
            ptr2 = inputArray[ptr2];
        }
        return ptr1;
    }

	public static void main(String[] args) {
        FindTheDuplicateNumber duplicateNumber = new FindTheDuplicateNumber();
        int output = duplicateNumber.findDuplicate(new int[] {1,3,4,2,2});
        System.out.println("Duplicate number with given array modification: " + duplicateNumber.withModificationOfInputArray(new int[] {1, 3, 2, 1, 4}));
        System.out.println("Duplicate number without the given array modification: " + duplicateNumber.withoutModificationOfInputArray(new int[] {1, 3, 2, 1, 4}));
        System.out.println("Find The Duplicate Number: " + output);
	}

}
