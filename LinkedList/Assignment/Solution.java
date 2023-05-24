package Assignment;
import java.util.*;

public class Solution {
    // Define the Node class with integer data and a next pointer
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Define a function to get the intersection node of two linked lists
    public Node getIntersectionNode(Node head1, Node head2) {
        // Traverse the second linked list
        while (head2 != null) {
            // Traverse the first linked list for each node in the second linked list
            Node temp = head1;
            while (temp != null) {
                // Check if the current node in the first linked list is the same as the current
                // node in the second linked list
                if (temp == head2) {
                    // If they are the same, then we have found the intersection point
                    return head2;
                }
                // Move to the next node in the first linked list
                temp = temp.next;
            }
            // Move to the next node in the second linked list
            head2 = head2.next;
        }
        // If we have traversed the entire second linked list and not found an
        // intersection point, return null
        return null;
    }

    public static void main(String[] args) {
        // Create two linked lists
        Solution list = new Solution();
        Node head1, head2;
        head1 = new Node(10);
        head2 = new Node(3);

        // Add nodes to the second linked list to create an intersection with the first
        // linked list
        Node newNode = new Node(6);
        head2.next = newNode;
        newNode = new Node(9);
        head2.next.next = newNode;
        newNode = new Node(15);
        head1.next = newNode;
        head2.next.next.next = newNode;
        newNode = new Node(30);
        head1.next.next = newNode;
        head1.next.next.next = null;

        // Find the intersection point and print the result
        Node intersectionPoint = list.getIntersectionNode(head1, head2);
        if (intersectionPoint == null) {
            System.out.print(" No Intersection Point \n");
        } else {
            System.out.print("Intersection Point: " + intersectionPoint.data);
        }
        System.out.println();
    }
}