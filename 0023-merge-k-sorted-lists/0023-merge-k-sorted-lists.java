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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        var sortedList = new ArrayList<Integer>();
        for (ListNode node: lists) {
            while (node != null) {
                sortedList.add(node.val);
                node = node.next;
            }
        }

        if (sortedList.isEmpty()) return null;

        sortedList.sort(Integer::compareTo);
        var node = new ListNode();
        var temp = node;
        for (int i = 0; i < sortedList.size(); i++) {
            temp.val = sortedList.get(i);
            if (i != sortedList.size() - 1) {
                temp.next = new ListNode();
                temp = temp.next;
            }
        }

        return node;
    }
}