public class Search_Insert_Position {

    public static void main(String[] args) {
        int index = searchInsert(new int[]{1, 3, 5, 6}, 0);

        System.out.println(index);
    }

    public static int searchInsert(int[] nums, int target) {

        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (; i < nums.length; i++) {
            if (target <= nums[i]) {
                return i;
            }
        }

        return i;
    }
}
