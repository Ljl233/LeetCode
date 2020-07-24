package stack;

import org.junit.jupiter.api.Test;

import java.util.Stack;
    /*
    1021. 删除最外层的括号
    有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。

    如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。

    给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。

    对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。



    示例 1：

    输入："(()())(())"
    输出："()()()"
    解释：
    输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
    删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
    示例 2：

    输入："(()())(())(()(()))"
    输出："()()()()(())"
    解释：
    输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
    删除每个部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
    示例 3：

    输入："()()"
    输出：""
    解释：
    输入字符串为 "()()"，原语化分解得到 "()" + "()"，
    删除每个部分中的最外层括号后得到 "" + "" = ""。


    提示：

    S.length <= 10000
    S[i] 为 "(" 或 ")"
    S 是一个有效括号字符串
 */

public class RemoveOuterParentheses {
    public String removeOuterParentheses(String S) {
        if (S == null || S.equals("")) return "";

        Stack<Character> stack = new Stack<>();
        int start = 0, end = 0;
        char[] chars = S.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : chars) {
            end++;
            if (c == '(') {
                stack.push('(');
            } else {
                stack.pop();
                if (stack.size() == 0) {
                    stringBuilder.append(S, start + 1, end - 1);
                    start = end;
                }
            }
        }

        return stringBuilder.toString();
    }

    public String removeOuterParentheses2(String S) {
        char[] chars = S.toCharArray();
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
//            if (c == '(') {
//                if (count > 0) {
//                    sb.append(c);
//                }
//                count++;
//            } else {
//                count--;
//                if (count > 0) sb.append(c);
//            }
            if (c == ')')
                count--;
            if (count > 0)
                sb.append(c);
            if (c == '(')
                count++;
        }
        return sb.toString();
    }


    @Test
    void test() {
        String S = "()(())";
        System.out.println(S.substring(0, 6));
        System.out.println(removeOuterParentheses(S));
    }
}


