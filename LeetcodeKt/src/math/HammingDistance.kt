package math

/*
461. 汉明距离
 */
class HammingDistance {
    fun hammingDistance(x: Int, y: Int): Int {
        var xor = x xor y
        var distance = 0

        while (xor != 0) {
            distance += 1;
            // remove the rightmost bit of '1'
            xor = xor and (xor - 1);
        }
        return distance;
    }
}