---
layout: default
title: Array
nav_order: 2
---

---

<br/>

## 27: Remove Element

Given an integer array `nums` and an integer `val`, remove all occurrences of `val` in `nums` [**in-place**](https://en.wikipedia.org/wiki/In-place_algorithm). The order of the elements may be changed. Then return *the number of elements in *`nums`_ which are not equal to _`val`.

Consider the number of elements in `nums` which are not equal to `val` be `k`, to get accepted, you need to do the following things:

- Change the array `nums` such that the first `k` elements of `nums` contain the elements which are not equal to `val`. The remaining elements of `nums` are not important as well as the size of `nums`.
- Return `k`.

![Example](/Leetcode/assets/27.png)

**Solution:**

### 1. Two pointers

Use two pointers: `slow` and `fast`

`slow`: looking for index of updated number in the arr

`fast`: looing for index that is not the target

![Example](/Leetcode/assets/27gif.gif)

```java

class Solution {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for(int fast = 0; fast < nums.length; fast++) {
            if(nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}

```

### 2.

```java
class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length-1;

        while(left<=right) {
            //find the val from left
            while(left <= right && num[left] != val)
                left++;
            //find element that is not == val from right
            while(left <= right && nums[right] == val)
                right--;

            if(left < right) {
                nums[left] = nums[right];
                left++;
                right--;
            }
        }
        return left;
    }
}
```

---

<br/>
<br/>
<br/>

# 34: Find First and Last Position of Element in Sorted Array

Given an array of integers `nums` sorted in non-decreasing order, find the starting and ending position of a given `target` value.

If `target` is not found in the array, return `[-1, -1]`.

You must write an algorithm with `O(log n)` runtime complexity.

![Example](/Leetcode/assets/34.png)

**Solution:**

### 1.

Using Binary Search method to find the first and last target respectively

```java

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = findFirst(nums, target);
        ans[1] = findLast(nums, target);
        return ans;
    }
    private int findFirst(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;
        while(left <= right) {

            int mid = left + (right - left) / 2;
            //keep searching the left part of the arr
            if(nums[mid] >= target)
                right = mid - 1;
            else
                left = mid + 1;
            if(nums[mid] == target) {
                result = mid;
            }
        }
        return result;
    }

    private int findLast(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = - 1;
        while(left <= right) {

            int mid = left + (right - left) / 2;

            if(nums[mid] > target)
                right = mid - 1;
            //keep searching the right part of the arr
            else
                left = mid + 1;
            if (nums[mid] == target)
                result = mid;
        }
        return result;
    }
}
```

---

<br/>
<br/>
<br/>

# 35: Search Insert Position

Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with `O(log n)` runtime complexity.

![Example](/Leetcode/assets/35.png)

**Solution:**

### 1.

Use Binary Search to find the `target`, if doesn't find any. then `left` is the index that target should be inserted.

```java

class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] > target)
                right = mid - 1;
            else if(nums[mid] < target)
                left = mid + 1;
            else
                return mid;
        }
        return left;
    }
}
```

### 2. [left,right)

```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while(left < right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] > target)
                right = mid;
            else if(nums[mid] < target)
                left = mid + 1;
            else
                return mid;
        }
        return left;
    }
}
```

---

<br/>
<br/>
<br/>

# 704: Binary Search

Given an array of integers `nums` which is sorted in ascending order, and an integer `target`, write a function to search `target` in `nums`. If `target` exists, then return its index. Otherwise, return `-1`.

You must write an algorithm with `O(log n)` runtime complexity.
![Example](/Leetcode/assets/704.png)

**Solution:**

### 1. Left close and right close [right, left]

- Using two pointers: `left` and `right` to define the section of the arr.
- while `left <= right`
- Find the mid element of the arr, if this element larger than `target`, let `right = mid - 1`. if this element is smaller than `target`, let `left = mid + 1`
- If `arr[mid] == target` return `mid`

![img](/Leetcode/assets/704-1.jpg)

```java
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left <= right) {
            int mid = left + (right-left) / 2;
            if(nums[mid] < target)
                left = mid + 1;
            else if(nums[mid] > target)
                right = mid - 1;
            else
                return mid;
        }
        return -1;
    }
}
```

### 2. Left close and right open [left, right)

There are two points that different from [right, left]:

1. `while (left < right)`
2. `if(nums[mid] > target) right = mid`.

![img](/Leetcode/assets/704-2.jpg)

```java
class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length;
        while(left < right) {
            int mid = left + (right-left) / 2;
            if(nums[mid] < target)
                left = mid + 1;
            else if(nums[mid] > target)
                right = mid;
            else
                return mid;
        }
        return -1;
    }
}
```

---

# 59. Spiral Matrix II

Given a positive integer `n`, generate an `n x n` `matrix` filled with elements from `1` to `n2` in spiral order.

![Example](/Leetcode/assets/59.png)

**Solution:**

### 1.

- Define the boundary of top, bottom, left and right.
- Using count to record the number insert into the matrix.
- When `count <= n * n` filling the matrix with numbers with each round squize the boundary

![Example](/Leetcode/assets/59-1.png)

```java

class Solution {
    public int[][] generateMatrix(int n) {
       int[][] ans = new int[n][n];
       int count = 1;
       int top = 0;
       int bottom = n-1;
       int left = 0;
       int right = n-1;

       while(count <= n*n) {
           for(int i = left; i <= right; i++) {
               ans[top][i] = count++;
           }
           top++;
           for(int i = top; i <= bottom; i++) {
               ans[i][right] = count++;
           }
           right--;
           for(int i = right; i >= left; i--) {
               ans[bottom][i] = count++;
           }
           bottom--;
           for(int i = bottom; i >= top; i--){
               ans[i][left] = count++;
           }
           left++;
       }
       return ans;
    }
}

```

---

<br/>
<br/>
<br/>

# 209. Minimum Size Subarray Sum

Given an array of positive integers `nums` and a positive integer `target`, return *the **minimal length** of a *_subarray_* whose sum is greater than or equal to* `target`. If there is no such subarray, return `0` instead.

![Example](/Leetcode/assets/209.png)

**Solution:**

### 1. Brute Force

- using two for loops

```java

    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            int sum = 0;
            for(int j = i; j < nums.length; j++) {
                sum += nums[j];
                if(sum >= target){
                    min = Math.min(min, j-i+1);
                    break;
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

```

### 2. Two Pointers

- Using `left` and `right` to define the window between `nums`
- use `sum` to record the current sum
- when the `sum` is larger or equal than the `target`, store the `min` length of the subarray then remove the left number from the sum and `left`++

```java

    public int minSubArrayLen(int target, int[] nums) {
        if(nums.length == 0) return 0;
        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        while(right < nums.length) {
            sum += nums[right];
            while(sum >= target) {
                min = Math.min(min, right - left + 1);
                sum -= nums[left];
                left++;
            }
                right++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

```

### 3. Binary Search

- use `sum[i] `to store the sum of` nums[0...i]`
- in this case, `sums[k]-sum[j] >= target`, then the length would be` k-j`. but this is not nessessary the shortest one. Therefore, we need to loop over the arr
- we can use `sum[j]+tartget <= sums[k]`;

```java

    public int minSubArrayLen(int target, int[] nums) {
        if(nums.length == 0) return 0;
        int min = Integer.MAX_VALUE;
        int[] sums = new int[nums.length+1];

        for(int i = 1; i <= nums.length; i++) {
            sums[i] = sums[i-1] + nums[i-1];

        }
        for(int i = 0; i <= nums.length; i++) {
            int _target = target + sums[i];
            int index = Arrays.binarySearch(sums, _target);
            if(index < 0)
                index = -index;
            if(index <= nums.length) {
                min = Math.min(min, index - i);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;

    }

```

---

<br/>
<br/>
<br/>

# 977. Squares of a Sorted Array

Given an integer array `nums` sorted in **non-decreasing** order, return *an array of **the squares of each number** sorted in non-decreasing order*.

![Example](/Leetcode/assets/977.png)

**Solution:**

### 1. Sort

- do the power 2 operation for each numbers in the arr
- do Sort the arry.

```java

class Solution {
    public int[] sortedSquares(int[] nums) {

    for(int i = 0; i < nums.length; i++)
        nums[i] = nums[i] * nums[i];

    Arrays.sort(nums);
    return nums;
    }
}

```

### 2. O(n)

- According to the question, we know that the absolute of the number is either at the first index or last index
- in this case, we can create a new arr of nums' length
- with a loop we compare number from first index and last index, picking the number power of two with larger absolute value to the right of the array.

```java

class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length -1;
        int[] ans = new int[nums.length];
        for(int i = ans.length-1; i >= 0 ; i--) {
            if(Math.abs(nums[left]) > Math.abs(nums[right])) {
                ans[i] = nums[left] * nums[left];
                left++;
            } else {
                ans[i] = nums[right] * nums[right];
                right--;
            }
        }
        return ans;
    }
}

```

---
