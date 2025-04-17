package linkedlist;
// Definition for singly linked list node
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

// Class that contains the solution
class Solution {
    // Function to delete a node without having reference to the head pointer
    void deleteNode(Node node) {
        // Edge case: if node or node.next is null, we can't delete the node
        if (node == null || node.next == null) {
            return; // Cannot delete the last node with this method
        }

        // Copy the data from the next node into the current node
        node.data = node.next.data;

        // Update the current node's next pointer to skip the next node
        node.next = node.next.next;
    }
}

// Utility class to build and print the linked list
class LinkedList {
    Node head;

    // Function to insert a new node at the end of the linked list
    public void append(int newData) {
        Node newNode = new Node(newData);
        if (head == null) {
            head = newNode;
            return;
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
    }

    // Function to print the linked list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

// Driver code to test the solution
public class deletewithouthead {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Creating the linked list: 1 -> 2 -> 3 -> 4 -> 5
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);

        // Print the original list
        System.out.println("Original Linked List:");
        list.printList();

        // Assuming we want to delete node with data '3' (we don't have head reference, just the node)
        Node nodeToDelete = list.head.next.next; // Node with value 3

        // Call the deleteNode function
        Solution solution = new Solution();
        solution.deleteNode(nodeToDelete);

        // Print the modified list after deletion
        System.out.println("Linked List after deleting node with value 3:");
        list.printList();
    }
}
