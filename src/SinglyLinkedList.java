public class SinglyLinkedList<E> implements List<E> {

    private Node head;
    private static int size;

    private class Node {
        E data;
        Node next;

        Node(E data) {
            this.data = data;
            this.next = null;

            size++;
        }

    } // end class Node

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public void addFirst(E data) {

        if (isEmpty()) {
            head = new Node(data);
            return;
        }

        Node newNode = new Node(data);

        // Let the newNode point to the head then move head to the newNode
        newNode.next = head;
        head = newNode;

    }

    @Override
    public void addLast(E data) {

        if (isEmpty()) {
            head = new Node(data);
            return;
        }

        Node newNode = new Node(data);

        // Find the tail and let it point to the newNode
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;

        // temp now is the tail

        temp.next = newNode;

    }

    @Override
    public E removeFirst() {

        if (isEmpty()) {
            System.out.println("Nothing to remove. List is empty!");
            return null;
        }

        // Store head's data to return it
        E answer = head.data;

        // Move head one step forward
        head = head.next;

        size--;

        return answer;

    }

    @Override
    public E removeLast() {

        if (isEmpty()) {
            System.out.println("Nothing to remove. List is empty!");
            return null;
        }

        if (size == 1) {
            head = null;
            size--;

            return null;
        }

        // There is at least 2 nodes

        // Find the node right before the tail
        Node temp = head;
        while (temp.next.next != null)
            temp = temp.next;

        // temp now is the node right before the tail

        // Store tail's data to return it
        E answer = temp.next.data;

        temp.next = null;

        size--;

        return answer;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printList() {

        if (isEmpty()) {
            System.out.println("Nothing to print. List is empty!");
            return;
        }

        System.out.print("List ->  ");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "  ");
            temp = temp.next;
        }

    }

}


