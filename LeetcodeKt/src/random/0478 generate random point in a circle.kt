package random

import java.util.Random

class Solution(val radius: Double, val x_center: Double, val y_center: Double) {

    fun randPoint(): DoubleArray {
        var x: Double
        var y: Double

        do {
            x = x_center - radius + Math.random() * radius * 2
            y = y_center - radius + Math.random() * radius * 2
        } while (Math.pow(x - x_center, 2.0) + Math.pow(y - y_center, 2.0) > Math.pow(radius, 2.0))
        return doubleArrayOf(x, y)
    }

    fun randPoint2(): DoubleArray {
        val random = Random()
        val d = Math.sqrt(random.nextDouble()) * radius
        //in radians
        val theta = random.nextDouble() * 2 * Math.PI

        return doubleArrayOf(x_center + d * Math.cos(theta), y_center + d * Math.sin(theta))
    }

}

fun main() {
    val obj = Solution(5.0, 0.0, 0.0)
    val param_1 = obj.randPoint()
    println(param_1.contentToString())
}