package practice.PR2;

import java.util.ArrayDeque;
import java.util.Deque;
import static java.lang.Math.max;

public class Les9 {

    public static void main(String[] args) {

//        boolean res = isValid("(){}[]");

//        String[] logs = new String[] {"d1/", "d2/", "../", "d21/", "./"};
//        int res = minOperations2(logs);
//        System.out.println(res);


//        ListNode node = new ListNode(1);
//        node.next = new ListNode(2);
//        node.next.next = new ListNode(3);
//        node.next.next.next = new ListNode(4);
//        node.next.next.next.next = new ListNode(5);
//        // 1 -> 2 -> 3 -> 4 -> 5
//        System.out.println(findMiddleElement(node).val);


//        ListNode node = new ListNode(1);
//        node.next = new ListNode(2);
//        node.next.next = new ListNode(3);
//        node.next.next.next = new ListNode(4);
//        node.next.next.next.next = new ListNode(5);
//
//        int countElement = 0;
//        ListNode current = node;
//        while (current != null) {
//            countElement ++;
//            System.out.println(current.val);
//            current = current.next;
//        }
//        System.out.println(countElement);


        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        ListNode current = node;
        Deque<Integer> stack = new ArrayDeque<>();
        while (current != null) {
            stack.push(current.val);
            current = current.next;
        }

        ListNode nodeReverse = new ListNode(0);
        ListNode dummy = nodeReverse;
        while (!stack.isEmpty()) {
            nodeReverse.next = new ListNode(stack.pop());
            nodeReverse = nodeReverse.next;
            //System.out.println(stack.pop());
        }

        ListNode curr = dummy.next;
        while (curr != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }



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

    public static int minOperations2(String[] logs) {
        int counter = 0;
        for (String log: logs) {
            if ("../".equals(log)) {
                counter = max(counter-1, 0);
            } else if ("./".equals(log)) {
            } else {
                counter++;
            }
        }
        return counter;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode findMiddleElement(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }



}
