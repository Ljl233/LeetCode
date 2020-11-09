package dac

import java.util.*

/*
#973. 最接近原点的 K 个点
使用PriorityQueue
注意语法：
1. sam的参数不用加括号
2. 方法引用放在后面{}里
 */
class KClosest {
    fun kClosest(points: Array<IntArray>, K: Int): Array<IntArray> {
        val queue = PriorityQueue<IntArray>(K) { o1, o2 ->
            (o1[0] * o1[0] + o1[1] * o1[1]) - (o2[0] * o2[0] + o2[1] * o2[1])
        }
        points.forEach { point ->
            queue.add(point)
            if (queue.size > K){
                queue.poll()
            }
        }

        return Array(K){
            queue.poll()
        }
    }
}