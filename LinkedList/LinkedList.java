public class LinkedList {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        // Step - 1 -> To create Node
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        
        // Step - 2 -> To create new node node's next = Head
        newNode.next = head; // Linking

        // Step - 3 -> To create Head = New Node
        head = newNode;
    }
    public void addLast (int data){
        // Step - 1 
        Node newNode = new Node(data);
        size++;
        if(head == null){ // Corner Case
            head = tail = newNode;
        }

        // Step - 2
        tail.next = newNode;

        // Step - 3
        tail = newNode;
    }
    
    //Print a linked list
    public void print(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Add in the middle
    public void add(int idx, int data){
        if(idx == 0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while(i < idx - 1){
            temp = temp.next;
            i++;
        }
        // i = idx - 1 ; temp -> prev
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst(){
        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        else if (size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }
    public int removeLast(){
        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        else if (size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        // Previous : i = size - 2
        Node prev = head;
        for(int i = 0; i < size - 2; i++){
            prev = prev.next;
        }
        int val = prev.next.data; // tail.data
        prev.next = null;
        size--;
        return val;
    }

    public int itrSearch (int key){
        Node temp = head; 
        int i = 0;

        while ( temp != null ){
            if(temp.data == key){ // Key found 
                return i; 
            }
            temp = temp.next;
            i++;
        }
        
        // Key not found
        return -1;
    }

    public int helper(Node head, int key) {
        // If the linked list is empty, return -1 to indicate that the key is not found
        if (head == null) {
            return -1;
        }

        // If the current node contains the key, return 0 to indicate that the key is
        // found at the head
        if (head.data == key) {
            return 0;
        }

        // Recursively search for the key in the remaining nodes of the linked list
        int idx = helper(head.next, key);

        // If the key is not found in the remaining nodes, return -1 to indicate that
        // the key is not found
        if (idx == -1) {
            return -1;
        }

        // If the key is found in the remaining nodes, add 1 to the index and return it
        return idx + 1;
    }
    
    public int recurSearch(int key) {
        // Call the helper method with the head node to start the recursive search
        return helper(head, key);
    }


    /**
     * Method to reverse a singly linked list in place.
     * The head and tail pointers of the linked list are updated to reflect the
     * reversed order of nodes.
     */
    public void reverse() {
        // Initialize pointers to track the previous, current, and next nodes in the
        // linked list
        Node prev = null;
        Node curr = tail = head;
        Node next;

        // Traverse the linked list, reversing the direction of each node's next pointer
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Update the head pointer to point to the new first node of the reversed linked
        // list
        head = prev;
    }


    /**
     * Method to delete the nth node from the end of a singly linked list.
     * If n is greater than the size of the linked list, the first node is removed.
     * 
     * @param n the index (1-based) of the node to delete from the end of the linked
     *          list
     */
    public void deleteNthfromEnd(int n) {
        // Calculate the size of the linked list by iterating through it
        int size = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }

        // If n is equal to the size of the linked list, remove the first node and
        // return
        if (n == size) {
            head = head.next;
            return;
        }

        // Calculate the index of the node to delete from the start of the linked list
        int i = 1;
        int idxToFind = size - n;

        // Traverse the linked list to find the node to delete
        Node prev = head;
        while (i < idxToFind) {
            prev = prev.next;
            i++;
        }

        // Remove the node by updating the next pointer of the previous node to skip the
        // deleted node
        prev.next = prev.next.next;
    }

    // Helper method to find the middle node of the linked list
    public Node findMidNode(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // Slow is my midnode.
    }

    // Method to check if the linked list is a palindrome
    public boolean checkPalindrome() {
        // Corner Case
        if (head == null || head.next == null) {
            return true;
        }
        // Step - 1 Find Mid
        Node mid = findMidNode(head);

        // Step - 2 Reverse 2nd half of the Linked List
        Node prev = null;
        Node curr = mid.next;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev; // Right Half head
        Node left = head; // Left Half head

        // Step - 3 Check Left half == Right half
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    // public static boolean isCycle() { // Floyd's Cycle Detecting Algorithm
    //     Node slow = head; // Initialize slow pointer to head
    //     Node fast = head; // Initialize fast pointer to head

    //     // Traverse linked list using slow and fast pointers
    //     while (fast != null && fast.next != null) {
    //         slow = slow.next; // Move slow pointer one node ahead
    //         fast = fast.next.next; // Move fast pointer two nodes ahead

    //         // Check if slow and fast pointers meet at same node
    //         if (slow == fast) {
    //             return true; // Cycle exists in linked list
    //         }
    //     }

    //     return false; // Cycle does not exist in linked list
    // }


    // public static void removeCycle() {
    //     // Detect Cycle

    //     // Initialize two pointers, slow and fast, to the head of the linked list
    //     Node slow = head;
    //     Node fast = head;
    //     boolean cycle = false;

    //     // Traverse the linked list using the fast pointer
    //     while (fast != null && fast.next != null) {
    //         slow = slow.next;
    //         fast = fast.next.next;

    //         // If there is a cycle, the fast pointer will eventually catch up with the slow
    //         // pointer
    //         if (fast == slow) {
    //             cycle = true;
    //             break;
    //         }
    //     }

    //     // Return if cycle not found
    //     if (cycle == false) {
    //         return;
    //     }

    //     // find meeting point

    //     // Reset the slow pointer to the head of the linked list
    //     slow = head;

    //     // Initialize a pointer called prev to null
    //     Node prev = null;

    //     // Traverse the linked list again using both slow and fast pointers
    //     while (slow != fast) {
    //         // Store the current node pointed by fast as the previous node
    //         prev = fast;

    //         // Move both pointers one step at a time
    //         slow = slow.next;
    //         fast = fast.next;
    //     }

    //     // Remove Cycle -> last.next = null

    //     // Set the next pointer of the last node (pointed by prev) to null
    //     prev.next = null;
    // }

    
    public Node getMid(Node head) {
        // Initialize two pointers, slow and fast, both pointing to the head of the
        // linked list
        Node slow = head;
        Node fast = head.next;

        // Traverse the linked list until fast reaches the end (null) or the second to
        // last node
        while (fast != null && fast.next != null) {
            // Move slow pointer by one node
            slow = slow.next;
            // Move fast pointer by two nodes
            fast = fast.next.next;
        }

        // Return the mid node (slow pointer points to it)
        return slow;
    }

    public Node mergeSort(Node head) {
        // Base case: If the linked list is empty or has only one node, return it as it
        // is already sorted
        if (head == null || head.next == null) {
            return head;
        }

        // Find the mid node of the linked list using the getMid() function
        Node mid = getMid(head);

        // Split the linked list into two halves at the mid node
        Node rightHead = mid.next; // Head of right half of linked list
        mid.next = null; // Terminate the left half of the linked list

        // Recursively call mergeSort() on the left and right halves of the linked list
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        // Merge the two sorted linked lists using the merge() function and return the
        // sorted linked list
        return merge(newLeft, newRight);
    }

    public Node merge(Node head1, Node head2) {
        // Create a dummy node to hold the merged linked list
        Node mergeLL = new Node(-1);
        Node temp = mergeLL; // Initialize a temporary node to point to the dummy node

        // Traverse both linked lists and compare their values
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) { // If the value in the first linked list is smaller
                // Append the node with the smaller value to the merged linked list and move the
                // pointer to the next node
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else { // If the value in the second linked list is smaller
                // Append the node with the smaller value to the merged linked list and move the
                // pointer to the next node
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        // If there are any remaining nodes in the first linked list, append them to the
        // merged linked list
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        // If there are any remaining nodes in the second linked list, append them to
        // the merged linked list
        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        // Return the merged linked list (the dummy node points to the actual head of
        // the merged linked list)
        return mergeLL.next;
    }

    public void zigzag() {
        // Step 1: Find the middle node of the linked list using slow and fast pointers
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        // Step 2: Reverse the second half of the linked list
        Node curr = mid.next;
        mid.next = null; // Break the linked list at the middle node
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node left = head;
        Node right = prev;

        // Step 3: Merge the first and second halves of the linked list in zigzag
        // fashion
        Node nextLeft, nextRight;

        while (left != null && right != null) {
            // Alternate merging nodes from the left half and the reversed right half
            nextLeft = left.next;
            left.next = right;
            nextRight = right.next;
            right.next = nextLeft;

            // Move the left and right pointers to the next nodes
            left = nextLeft;
            right = nextRight;
        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.print();
        ll.zigzag();
        ll.print();
    }
}