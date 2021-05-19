package sort;

import java.util.Arrays;

public class SortUtil {
    public static void main(String[] args) {
        int[] exampleArray = new int[]{22, 151, 14, 7, 3, 135, 2, 29, 0};
        heapSort(exampleArray);
        System.out.println(Arrays.toString(exampleArray));
    }



    /*
        1. 冒泡排序
        从左到右（从右到左）依次两两比较交换，使得值较大的数往后面移动，
        一次遍历之后，【0，len）中最大的值会移动到len-1的位置。
        遍历的长度在每次遍历之后--

        时间复杂度：O(n^2)
            最好情况：O(n)   ——已经排序好的
            最坏情况：O(n^2) ——倒序
        空间复杂度：O(1)
     */
    public static void bubbleSort(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            boolean flag = true;
            for (int j = 0; j < length - i - 1; j++) {
                if (compare(nums, j, j + 1) > 0) {
                    swap(nums, j, j + 1);
                    flag = false;
                }
            }
            if (flag) break;
        }
    }

    /*
        2. 选择排序
        遍历【i,len), 选择这个区间最小的一个数与nums[i]进行交换，i依次取值【0，len）

        时间复杂度：O(n^2)
            最好情况：O(n^2) ——任何情况
            最坏情况：O(n^2) ——任何情况
        空间复杂度：O(1)
     */
    public static void selectionSort(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int minIndex = i;
            for (int j = i; j < length; j++) {
                if (compare(nums, minIndex, j) > 0) {
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
    }

    /*
        3. 插入排序
        在数组前面维护一个有序子序列，通过插入数值来扩展子序列

        时间复杂度：O(n^2)
            最好情况：O(n)      ——已经排序
            最坏情况：O(n^2)    ——倒序
        空间复杂度：O(1)
     */
    public static void insertSort(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            insert(nums, i);
        }
    }

    private static void insert(int[] nums, int targetIndexAndEnd) {
        if (targetIndexAndEnd >= nums.length
                || targetIndexAndEnd <= 0
                || nums[targetIndexAndEnd] > nums[targetIndexAndEnd - 1]
        ) return;

        int target = nums[targetIndexAndEnd];

        for (int i = targetIndexAndEnd - 1; i >= 0; i--) {
            if (target < nums[i]) {
                nums[i + 1] = nums[i];
            } else {
                nums[i + 1] = target;
                return;
            }
        }
        nums[0] = target;
    }

    /*
        4. 希尔排序
        对于插入排序的优化，插入排序在基本有序的情况下效率较高。
        按照间隔对数据进行排序，间隔为gap=2^n，依次减小，
        以gap为间隔形成gap个子序列，依次对其进行插入排序，
        当间隔较大时，序列长度较小，
        当间隔增大时，从左到右，基本有序，插入排序效率高。

        时间复杂度：O(n log n)
            最好：O(n)
            最坏：O(n log^2 n)
        空间复杂度：O(1)
     */
    public static void shellSort(int[] nums) {
        int length = nums.length;
        for (int step = length / 2; step > 0; step /= 2) {
            for (int i = step; i < length; i++) {
                int j = i - step;
                int temp = nums[i];

                while (j >= 0 && nums[j] > temp) {
                    nums[j + step] = nums[j];
                    j -= step;
                }

                nums[j + step] = temp;
            }
        }
    }

    /*
        5. 归并排序
        递归分组+合并
        先对左右进行排序，再将左右合并

        时间复杂度：O(n log n)
            最好：O(n log n) ——任何情况
            最坏：O(n log n) ——任何情况
        空间复杂度：O(n)
     */
    public static void mergeSort(int[] nums) {
        int[] result = new int[nums.length];
        mergeSort(nums, result, 0, nums.length);
    }

    private static void mergeSort(int[] nums, int[] result, int left, int right) {
        if (right - left < 2) return;
        int mid = (right - left) / 2 + left;

        mergeSort(nums, result, left, mid);
        mergeSort(nums, result, mid, right);

        int i = left;
        int j = mid;
        int k = left;

        while (i < mid && j < right)
            result[k++] = nums[i] < nums[j] ? nums[i++] : nums[j++];

        while (i < mid)
            result[k++] = nums[i++];

        while (j < right)
            result[k++] = nums[j++];

        System.arraycopy(result, left, nums, left, right - left);
    }

    /*
        6. 快速排序
        双指针+递归
        快指针进行遍历，慢指针指向小于pivot的下一个位置，如果快指针对应的值小于pivot则和慢指针进行交换，使得小于pivot的值都在前半部分

        5 3 1 7 1 2 1

        时间复杂度：O(n log n)
            最好：O(n log n)
            最坏：O(n^2)
        空间复杂度：O(log n)
     */
    public static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int div = partition(nums, left, right);
        quickSort(nums, left, div - 1);
        quickSort(nums, div + 1, right);
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = left;
        int index = left + 1;
        for (int i = index; i <= right; i++) {
            if (nums[i] < nums[pivot]) {
                swap(nums, i, index);
                index++;
            }
        }
        swap(nums, pivot, index - 1);
        return index - 1;
    }

    /*
        7. 堆排序
        构造一个父节点都大于子节点的堆，取出根节点放在数组尾部，维护堆的特性

        时间复杂度：O(n log n)
            最好：O(n log n)
            最坏：O(n log n)
        空间复杂度：O(1)
     */
    public static void heapSort(int[] nums) {
        int len = nums.length;

        //build heap
        for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
            heapify(nums, i, len);
        }

        for (int i = len - 1; i > 0; i--) {
            swap(nums, 0, i);
            heapify(nums, 0, i);
        }
    }

    private static void heapify(int[] nums, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < len && nums[left] > nums[largest]) {
            largest = left;
        }
        if (right < len && nums[right] > nums[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(nums, largest, i);
            heapify(nums, largest, len);
        }
    }

    /*
        8. 计数算法
        构造一个桶，类似于Map，index为数值，对应的值为index在nums中出现的次数

        时间复杂度：O(n+k)
            最好：O(n+k)
            最坏：O(n+k)
        空间复杂度：O(k)
     */
    public static void countingSort(int[] nums) {
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        for (int num : nums) {
            if (maxValue < num) maxValue = num;
            if (minValue > num) minValue = num;
        }

        int[] bucket = new int[maxValue - minValue + 1];
        for (int num : nums) {
            bucket[num - minValue]++;
        }

        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                nums[index++] = i + minValue;
            }
        }
    }

    /*
        9. 桶排序
        将数组按值进行分区，在区内进行插入排序

        时间复杂度：O(n+k)
            最好：O(n+k)
            最坏：O(n^2)
        空间复杂度：O(n+k)
     */
    public static void bucketSort(int[] nums) {
        int bucketSize = 5;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num < min) {
                min = num;
            } else if (num > max) {
                max = num;
            }
        }

        int bucketCount = (max - min) / bucketSize + 1;
        int[][] buckets = new int[bucketCount][0];

        for (int value : nums) {
            int index = (value - min) / bucketSize;
            buckets[index] = arrayAppendAndSort(buckets[index], value);
        }

        int index = 0;
        for (int[] bucket : buckets) {
            if (bucket.length <= 0) continue;
            for (int value : bucket) {
                nums[index++] = value;
            }
        }
    }

    private static int[] arrayAppendAndSort(int[] bucket, int value) {
        int len = bucket.length + 1;
        int[] copy = Arrays.copyOf(bucket, len);
        int i = len - 1;
        while (i > 0 && bucket[i - 1] > value) {
            bucket[i] = bucket[i - 1];
        }
        bucket[i] = value;
        return copy;
    }

    /*
        10. 基数排序
        分别对个十百千万位进行排序

        时间复杂度：O(n*k)
            最好：O(n*k)
            最坏：O(n*k)
        空间复杂度：O(n+k)
     */
    public static void radixSort(int[] nums) {
        int len = nums.length;
        int maxLen = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        while (max != 0) {
            maxLen++;
            max = max / 10;
        }

        int mod = 10;
        int dev = 1;
        for (int i = 0; i < maxLen; i++, mod *= 10, dev *= 10) {
            int[][] counter = new int[20][0];

            for (int j = 0; j < len; j++) {
                int bucket = nums[j] % mod / dev;
                counter[bucket] = arrayAppend(counter[bucket], nums[j]);
            }
            int pos = 0;
            for (int[] bucket : counter) {
                for (int num : bucket) {
                    nums[pos++] = num;
                }
            }
        }
    }

    private static int[] arrayAppend(int[] bucket, int num) {
        int len = bucket.length;
        int[] copy = Arrays.copyOf(bucket, len + 1);
        copy[len] = num;
        return copy;
    }

    private static int compare(int[] nums, int first, int second) {
        return nums[first] - nums[second];
    }

    private static void swap(int[] nums, int first, int second) {
        if (first == second) return;

        nums[first] = nums[first] ^ nums[second];
        nums[second] = nums[first] ^ nums[second];
        nums[first] = nums[first] ^ nums[second];
    }
}
