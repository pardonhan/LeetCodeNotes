public class SearchInsert {
    public static void main(String[] args) {
        int[] array = {1};
        System.out.println(searchInsert(array, 2));
    }
	// 我自己最初的答案，直接用了两个for循环..速度慢了很多
    public static int searchInsert(int[] nums, int target) {
        int index = -1;
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (nums[i] == target) {
                index = i;
            }
        }
        if (index < 0) {
            for (int i = 0; i < size; i++) {
                if (target < nums[i]) {
                    index = i;
                    i = size;
                }
            }
            if (index < 0 && target > nums[size - 1]) {
                index = size;
            }
        }
        return index;
     
    }
	// 其他人的答案，速度要快一倍多，采用的是二分法
	public static int searchInsert2(int[] A,int target){
		  int low = 0, high = A.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] == target) return mid;
            else if (A[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return low;
	}
}