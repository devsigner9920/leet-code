/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        Map<ListNode, Integer> map = new HashMap<>();
        while (head.next != null) {
            var count = map.getOrDefault(head, 0);

            if (count > 1) {
                return true;
            }

            map.put(head, count + 1);
            head = head.next;
        }

        return false;
    }
}