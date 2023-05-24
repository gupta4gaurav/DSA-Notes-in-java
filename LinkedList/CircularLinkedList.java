public class CircularLinkedList {
    static class Node {
        int data;
        Node next;
    };

    // Add a node to an empty list
    static Node addToEmpty(Node last, int data) {
        if (last != null)
            return last;

        Node newNode = new Node();
        newNode.data = data;
        last = newNode;
        newNode.next = last;

        return last;
    }

    // Add a node to the front of the list
    static Node addFront(Node last, int data) {
        if (last == null)
            return addToEmpty(last, data);

        Node newNode = new Node();
        newNode.data = data;
        newNode.next = last.next;
        last.next = newNode;

        return last;
    }

    // Add a node to the end of the list
    static Node addEnd(Node last, int data) {
        if (last == null)
            return addToEmpty(last, data);

        Node newNode = new Node();
        newNode.data = data;
        newNode.next = last.next;
        last.next = newNode;
        last = newNode;

        return last;
    }

    // Add a node after a given node
    static Node addAfter(Node last, int data, int item) {
        if (last == null)
            return null;

        Node newNode, p;
        p = last.next;
        do {
            if (p.data == item) {
                newNode = new Node();
                newNode.data = data;
                newNode.next = p.next;
                p.next = newNode;
                if (p == last)
                    last = newNode;
                return last;
            }
            p = p.next;
        } while (p != last.next);

        System.out.println(item + "The given node is not present in the list");
        return last;
    }

    // Delete a node with a given key
    static Node deleteNode(Node last, int key) {
        if (last == null)
            return null;

        if (last.data == key && last.next == last) {
            last = null;
            return last;
        }

        Node temp = last, d = new Node();
        if (last.data == key) {
            while (temp.next != last) {
                temp = temp.next;
            }
            temp.next = last.next;
            last = temp.next;
        }

        while (temp.next != last && temp.next.data != key) {
            temp = temp.next;
        }

        if (temp.next.data == key) {
            d = temp.next;
            temp.next = d.next;
        }

        return last;
    }

    // Traverse/print the list
    static void traverse(Node last) {
        Node p;
        if (last == null) {
            System.out.println("List is empty.");
            return;
        }
        p = last.next;
        do {
            System.out.print(p.data + " ");
            p = p.next;
        } while (p != last.next);
    }

    
    public static void main(String[] args) {
        Node last = null;
        last = addToEmpty(last, 6);
        last = addEnd(last, 8);
        last = addFront(last, 2);
        last = addAfter(last, 10, 2);
        traverse(last);
        deleteNode(last, 8);
        traverse(last);
    }

}
