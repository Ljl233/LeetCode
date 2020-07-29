package tree

import kotlin.math.ln
import kotlin.math.log2
import kotlin.math.pow

class PathInZigZagTree {
    fun pathInZigZagTree(label: Int): List<Int> {
        val path = mutableListOf<Int>()
        var depth: Int = (Math.log(label.toDouble()) / Math.log(2.0) + 1).toInt()
        var curLabel = label
        while (curLabel > 1) {
            path.add(curLabel)
            depth--
            curLabel = (3 * Math.pow(2.0, (depth - 1).toDouble()) - 1 - curLabel / 2).toInt()
        }
        path.add(1)
        return path.reversed()
    }
}

fun main() {
    val path = PathInZigZagTree().pathInZigZagTree(10)
    println(path)
}