import java.util.LinkedList;
public class MergeSortLL {

    public Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow; // Mid Node
    }

    public Node mergeSort(Node head) {
        //Corner Case
        if(head == null || head.next == null){
            return head;
        }

        //Find Mid
        Node mid = getMid(head);

        // Left & Right MS
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        // Merge 
        return merge(newLeft, newRight);

    }

    public Node Merge(Node head1, Node head2){
        Node mergeLL = new Node(-1);
        Node temp = mergeLL;
        
        while (head1 != null && head2 != null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }

            while(head1 != null){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }

            while(head2 != null){
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }

            return mergeLL.next;
        }
    }
    public static void main(String[] args) {
        LinkedList<Integer> ll == new LinkedList<>();
    }
    
}
