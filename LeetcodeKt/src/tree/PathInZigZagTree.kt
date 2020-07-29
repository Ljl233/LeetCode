package tree

/*
1104. 二叉树寻路
在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。

如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；

而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。



给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的。
 */

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