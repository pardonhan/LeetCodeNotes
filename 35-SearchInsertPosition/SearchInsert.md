## 35. Search Insert Position

Given a sorted array and a target value, return the index if the target is found. If not, return the
index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
``` 
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
```
####  My Solution 
代码如下，一开始直接for循环遍历所有数据去找target对应的值，如果找到了还行，只有一个for循环，但是如果
没找到就要再有一个for循环，如果还是没找到还要进行if判断，虽然思路很清晰，但是写法很low.

``` java
public class Solution {
    public int searchInsert(int[] nums, int target) {
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
}

```

#### Other's Solution 
下面的代码采用了二分查找法，在时间效率上要高很多

``` java
public static int searchInsert(int[] A,int target){
  	int low = 0, high = A.length - 1;
    while (low <= high) {
        int mid = (low + high) / 2;
        if (A[mid] == target) return mid;
        else if (A[mid] > target) high = mid - 1;
        else low = mid + 1;
    }
    return low;
}
```