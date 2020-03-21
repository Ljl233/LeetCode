package athority;

/**
 * #365
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 * <p>
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 * <p>
 * 你允许：
 * <p>
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 * 示例 1: (From the famous "Die Hard" example)
 * <p>
 * 输入: x = 3, y = 5, z = 4
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: x = 2, y = 6, z = 5
 * 输出: False
 */
public class CanMeasureWater {
    public static boolean canMeasureWater(int x, int y, int z) {
        if (z > x + y) return false;
        if (x == 0 || y == 0) return z == 0 || z == x + y;

        if (x > y) {
            x = x ^ y;
            y = x ^ y;
            x = x ^ y;
        }
        int a = y % x;
        while (a != 0) {
            y = x;
            x = a;
            a = y % x;
        }
        return z % x == 0;
    }

    public static void main(String[] args) {
        canMeasureWater(3, 5, 4);
    }
}
