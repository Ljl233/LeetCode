package stack;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/*
20. 有效的括号
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true
 */
public class IsValid {
    public boolean isValid(String s) {
        if (s == null || s.equals("")) return true;
        char[] regex = {'(', '[', '{', ')', ']', '}'};
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            if (c == regex[3] || c == regex[4] || c == regex[5]) {
                if (stack.empty()) return false;

                switch (stack.peek()) {
                    case '(':
                        if (c == ')') stack.pop();
                        else return false;
                        break;
                    case '[':
                        if (c == ']') stack.pop();
                        else return false;
                        break;
                    case '{':
                        if (c == '}') stack.pop();
                        else return false;
                }
            }

        }
        return stack.size() == 0;
    }

    @Test
    void Test() {
        System.out.println(isValid("(){}[]"));
        System.out.println(isValid("(){(]}[]"));
    }
}
