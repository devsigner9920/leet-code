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
    public ListNode reverseList(ListNode head) {
        // 스위칭을 하기 위한 node
        ListNode prev = null;
        // iterate 하며 다음 노드에 가기 위해 세팅한 노드
        var current = head;

        while (current != null) {
            // 다음 노드를 임시저장 한다.
            var next = current.next;
            // current 노드의 다음을 prev로 설정한다. -> 처음엔 null
            // 2번째 iter에서는 val = 1, next = null을 가진 노드를 저장
            current.next = prev;
            // 1번째 iter
            // prev 노드에 current 노드를 저장한다.
            // prev: val = 1, next = null 상태

            // 2번째 iter
            // prev: val = 2, next = (val = 1, next = null)
            prev = current;
            // 1번째 iter
            // current 노드에 임시저장한 next(val = 2, next = 3)을 저장한다.
            // 2번째 iter
            // current 노드에 임시저장한 next(val = 3, next = 4)을 저장한다.
            current = next;
        }

        return prev;
    }
}