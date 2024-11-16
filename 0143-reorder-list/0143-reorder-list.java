/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        var temp = head;
        // 루프를 돌며 head 의 끝까지 갔다가 점진적으로 돌아오기?
        while (temp.next != null) {
            if (temp.next.next == null) {
                break;
            }
            // 처음엔 2
            var nextElement = temp.next;
            // 2의 다음이 3 이니까 한번은 돌거고
            // 3의 4
            while (nextElement.next != null) {
                var cur = nextElement;
                nextElement = nextElement.next;
                if (nextElement.next == null) {
                    cur.next = null;
                }
            }
            nextElement.next = temp.next;
            temp.next = nextElement;

            temp = temp.next.next;
        }

        System.out.println(head);
    }
}