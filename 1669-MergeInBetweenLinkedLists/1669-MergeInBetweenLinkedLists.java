// Last updated: 4/2/2025, 10:41:52 PM
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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int itr = 0;
        ListNode ptr = list1;

        while(itr != a-1) {
            itr++;
            ptr = ptr.next;
        }

        ListNode tempPtr = ptr;

        while(itr != b) {
            ptr = ptr.next;
            itr++;
        }

        ListNode tempPtr2 = ptr;

        tempPtr.next = list2;

        ptr = list2;

        while(ptr.next != null) {
            ptr = ptr.next;
        }

        ptr.next = tempPtr2.next;

        return list1;
    }
}