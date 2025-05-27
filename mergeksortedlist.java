package linkedlist;
import java.util.PriorityQueue;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class mergeksortedlist {
    // Solution method to merge k sorted linked lists
    public ListNode mergeKLists(ListNode[] lists) {
        // Min-heap to store the nodes in ascending order
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.val, b.val)
        );

        // Add the head of each list to the heap
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }

        // Dummy node to simplify the result list creation
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // While the heap is not empty
        while (!minHeap.isEmpty()) {
            // Get the smallest node
            ListNode smallest = minHeap.poll();
            tail.next = smallest;
            tail = tail.next;

            // If the smallest node has a next, add it to the heap
            if (smallest.next != null) {
                minHeap.offer(smallest.next);
            }
        }

        return dummy.next;
    }
}