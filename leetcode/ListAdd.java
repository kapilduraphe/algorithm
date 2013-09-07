/**
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 * 
 * Solution:
 * Iterate through the two lists, and add their val to get each digit
 * for the number of sum. Since the input is in reverse order, going
 * from first node to last node represent smallest to largest digit,
 * so the carry is always applied to the sum of val for the next nodes.
 * Meanwhile, put each digit into a ListNode.
 * 
 */

import java.util.LinkedList;
import java.util.ArrayList;

public class ListAdd {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode output = null;
        ListNode generator = null;
        int carry = 0;
        // when carry != 0, there will be one extra didit
        // to add to the output list
        while (p1 != null || p2 != null || carry != 0) {
            int digit = 0;
            if (p1 != null) {
                digit = digit + p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                digit = digit + p2.val;
                p2 = p2.next;
            }
            digit = digit + carry;
            // carry will be used in the next iteration
            carry = digit / 10;
            digit = digit % 10;
            // output generation
            if (output != null) {
                generator.next = new ListNode(digit);
                generator = generator.next;
            } else {
                output = new ListNode(digit);
                generator = output;
            }
        }
        return output;
    }
    
    public static void main() {
        // 2 -> 4 -> 3
        ListNode ln1 = new ListNode(2);
        ln1.next = new ListNode(4);
        ln1.next.next = new ListNode(3); 
        // 5 -> 6 -> 4
        ListNode ln2 = new ListNode(5);
        ln2.next = new ListNode(6);
        ln2.next.next = new ListNode(4);
        
        ListNode result = addTwoNumbers(ln1, ln2);
        System.out.print("\nResult: ");
        while (result != null) {
            System.out.printf("%d", result.val);
            result = result.next;
        }
    }
    
}