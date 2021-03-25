package array

/*
#136. 只出现一次的数字
https://leetcode-cn.com/problems/single-number/
 */
class SingleNumber {
    fun singleNumber(nums: IntArray): Int {
        var res = 0
        nums.forEach { num ->
            res = res xor num
        }
        return res
    }
}

/*
> 给定一个非空整数数组，除了某个元素只出现1次以外，其余每一个元素都出现2次，找出那个只出现一次的元素。
异或运算有三个性质：
1. 任何数与0做异或运算，结果仍然为原来那个数，即 a^0 = a
2. 任何数与其自身做异或运算，结果为0，即 a^a = 0
3. 异或运算满足交换律和结合律，即 a^b^a=b^a^a=b^(a^a)=b^0=b
假设数组有2m+1个元素，其中m个数出现两次，一个数出现一次，令a1,a2...am为出现两次的m个数，a_m+1为出现一次的数，根据性质3，数组中全部元素的异或运算结果总是可以写成如下格式
（a1^a1）^(a2^a2)^...^a_m+1
根据性质1和性质2，上式可以简化和运算得到如下结果：0^a_m+1
因此，数组中全部异或运算结果即为数组中只出现1次的数字。
 */