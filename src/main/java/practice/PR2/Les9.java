package practice.PR2;

import java.util.ArrayDeque;
import java.util.Deque;

public class Les9 {

    public static void main(String[] args) {

//        boolean res = isValid("(){}[]");

        String[] logs = new String[] {"d1/", "d2/", "../", "d21/", "./"};
        int res = minOperations(logs);

        
        System.out.println(res);
    }

    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else {
                if (stack.isEmpty() || stack.pop() != c) { // pop - повертає та знімає верхній елемент стеку
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static int minOperations(String[] logs) {

        Deque<String> stack = new ArrayDeque<>();
        for (String log: logs) {
            if ("../".equals(log)) {
                stack.pop();
            } else if ("./".equals(log)) {
            } else {
                stack.push(log);
            }
        }
        return stack.size();
    }

}
