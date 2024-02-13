public class txt6312_RemoveDuplicates {
    public static int[] txt6312_removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        int j = 1; 
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j++] = nums[i];
            }
        }

        
        int[] result = new int[j];
        System.arraycopy(nums, 0, result, 0, j);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 4, 4, 4, 5, 5};
        int[] result = txt6312_removeDuplicates(nums);
        System.out.print("New Array[] : { ");
        for (int num : result) {
            System.out.print(num + ", ");
        }
        System.out.print("}");
    }
}
