public class SearchInsert {
    public static void main(String[] args) {
        int[] array = {1};
        System.out.println(searchInsert(array, 2));
    }
	// ���Լ�����Ĵ𰸣�ֱ����������forѭ��..�ٶ����˺ܶ�
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
	// �����˵Ĵ𰸣��ٶ�Ҫ��һ���࣬���õ��Ƕ��ַ�
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