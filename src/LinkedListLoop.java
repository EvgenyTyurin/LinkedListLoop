/**
 * Detect loop in linked list
 * 0. Prepare two pointers at the head of the list
 * 1. Move fast (by 2 steps) and slow (by 1 step) pointers till collision
 * 2. Move one pointer back to head
 * 3. Move pointer slow till collision.
 * 4. PROFIT: The point of looping found
 */

public class LinkedListLoop {

    public static void main(String[] args) {
        // Create cycled list 1 -> 2 -> 3 -> 4 -> 5 -> 2
        MyLinkedList.Node<Integer> node1 = new MyLinkedList.Node<>(1);
        MyLinkedList.Node<Integer> node2 = new MyLinkedList.Node<>(2);
        MyLinkedList.Node<Integer> node3 = new MyLinkedList.Node<>(3);
        MyLinkedList.Node<Integer> node4 = new MyLinkedList.Node<>(4);
        MyLinkedList.Node<Integer> node5 = new MyLinkedList.Node<>(5);
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(node1);
        linkedList.add(node2);
        linkedList.add(node3);
        linkedList.add(node4);
        linkedList.add(node5);
        node5.setNext(node2);
        // Fast and slow car race till collision
        MyLinkedList.Node fast = linkedList.head;
        MyLinkedList.Node slow = linkedList.head;
        do {
            slow = slow.next();
            fast = fast.next();
            if (fast != null)
                fast = fast.next();
        } while (fast != null && slow != null && fast != slow);
        if (fast != null) {
            System.out.println("Collision point: " + fast.getData()); // 5
        } else {
            System.out.println("No loop detected");
            return;
        }
        // Return one pointer to head and proceed with slow speed till collision
        slow = linkedList.head;
        while (slow != fast) {
            slow = slow.next();
            fast = fast.next();
        }
        System.out.println("Loop at: " + slow.getData()); // 2
    }

}
