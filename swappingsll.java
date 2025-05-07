package linkedlist;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    // Function to swap the values of k-th node from start and k-th node from end
    public ListNode swapNodes(ListNode head, int k) {
        // Step 1: Find the k-th node from the beginning
        ListNode first = head;
        for (int i = 1; i < k; i++) {
            first = first.next;
        }
        
        // Step 2: Find the k-th node from the end using two-pointer technique
        ListNode second = head;
        ListNode temp = first;
        while (temp.next != null) {
            second = second.next;
            temp = temp.next;
        }
        
        // Step 3: Swap the values of the two nodes
        int swap = first.val;
        first.val = second.val;
        second.val = swap;
        
        // Return the modified list
        return head;
    }
}

// Driver code to test the function
public class swappingsll {
    // Helper function to create a linked list from an array
    public static ListNode createLinkedList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    // Helper function to print a linked list
    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test case
        int[] arr = {1, 2, 3, 4, 5};
        int k = 2;

        // Create the linked list
        ListNode head = createLinkedList(arr);

        // Print original list
        System.out.print("Original list: ");
        printLinkedList(head);

        // Swap nodes
        Solution solution = new Solution();
        head = solution.swapNodes(head, k);

        // Print modified list
        System.out.print("Modified list after swapping: ");
        printLinkedList(head);
    }
}

