## 303 Range Sum Query - Immutable

#### Question Describe

 [Range Sum Query - Immutable](https://leetcode.com/problems/range-sum-query-immutable/)
 
 数组指定区间内和，数组不可改变。

 Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

给定一个int类型的数组 nums ,找到指定区间i到j（i<=j）直接所有元素的和。

```
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
```
#### Note:
	1.You may assume that the array does not change.
	2.There are many calls to sumRange function.
	
	// Your NumArray object will be instantiated and called as such:
	// NumArray numArray = new NumArray(nums);
	// numArray.sumRange(0, 1);
	// numArray.sumRange(1, 2);

#### My Solution

我的解题方法时直接对所给区间进行遍历，将所有元素进行相加，当只调用一次的时候效率是还可以，但是当数据量较大，调用次数比较频繁的时候就会导致大量的加法操作，从而影响效率。


```java
public class NumArray {
    int[] array;
    
    public NumArray(int[] nums) {
        this.array = nums;
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        for(int a=i;a<=j;a++){
            sum = sum + array[a];
        }
        return sum;
    }
}
```
#### Other Solution

下面这个解题方法有效的避免了在调用次数较多和数据量较大情况下的效率问题。

首先是循环整个数组，将当前元素的值变为他前面所有数据的和，要获取指定区间的元素的和的时候可以用处理后的
数组的对应位置的元素相减的到结果，那么在频繁调用下，每次都是只计算一次的减法，有效的提高了效率。

``` java
public class NumArray{
	
	int[] nums;
	
	public NumArray(int[] nums){
		for(int i = 1; i < nums.length; i++)
        	nums[i] += nums[i - 1];
    
		this.nums = nums;
	}

	public int sumRange(int i, int j) {
		if(i == 0)
			return nums[j];
		
		return nums[j] - nums[i - 1];
	}
}

```
