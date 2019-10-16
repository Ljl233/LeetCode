package arraylist;

import java.util.Stack;

public class Trap {
    public int trap(int[] height) {

        int ans = 0;
        //每一个位置的储水量取决于左右两边最高的那个数中的最小值
        int len = height.length;
        for (int i = 0; i < len; i++) {
            int max_left = 0;
            int max_right = 0;
            for (int j = 0; j < i; j++) {
                max_left = Math.max(max_left, height[j]);
            }
            for (int k = i + 1; k < len; k++) {
                max_right = Math.max(max_right, height[k]);
            }
            if (Math.min(max_left, max_right) - height[i] > 0)
                ans += Math.min(max_left, max_right) - height[i];
        }
        return ans;
    }

    public int trap2(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        int current = 0;
        while (current < height.length) {
            while (!stack.empty() && height[current] > height[stack.peek()]) {
                int pop = stack.pop();
                if (stack.empty()) break;
                int distance = current - stack.peek() - 1;
                int high = Math.min(height[current], height[stack.peek()]) - height[pop];
                ans += distance * high;
            }
            stack.push(current++);
        }
        return ans;
    }
}
