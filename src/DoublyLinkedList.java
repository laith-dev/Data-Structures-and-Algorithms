public class DoublyLinkedList<E> implements List<E> {

    /* In a DLL, the head doesn't contain any data
     * The peek node is head's next. head's prev is not needed therefore is never assigned
     */
    private final Node head;
    // size incremental in Node constructor
    private static int size;

    public DoublyLinkedList() {
        head = new Node(null, null, null);
        size = 0;
    }

    private class Node {

        E data;
        private Node prev;
        private Node next;

        public Node(E data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;

            size++;
        }

        public E getData() {
            return data;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    } // end class Node

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public void addFirst(E data) {

        if (isEmpty()) {
            /*
             * 1- Create a new Node and let it point (as prev) to the head
             * 2- Let the head point (as next) to the new Node
             */

            Node newNode = new Node(data, head, null);
            head.setNext(newNode);
            return;
        }

        /*
         * 1- Create a new Node
         * 2- Let it point (as next) to the peek node (head's next)
         * 3- Let it point (as prev) to the head
         * 4- Let the peek Node point (as prev) to the new Node
         * 5- Let the head point (as next) to the new Node
         * */

        Node newNode = new Node(data, head, head.getNext());

        head.getNext().setPrev(newNode);
        head.setNext(newNode);

    }

    @Override
    public void addLast(E data) {

        if (isEmpty()) {
            /*
             * 1- Create a new Node and let it point (as prev) to the head
             * 2- Let the head point (as next) to the new Node
             */

            Node newNode = new Node(data, head, null);
            head.setNext(newNode);
            return;
        }

        /*
         * 1- Create a new Node
         * 2- Find the last node and let it point (as next) to the new Node
         * 3- Let the new Node point (as prev) to the last Node
         * */

        Node newNode = new Node(data, null, null);

        // Find the last Node
        Node temp = head.getNext();
        while (temp.getNext() != null)
            temp = temp.getNext();

        // temp now is the last Node

        temp.setNext(newNode);
        newNode.setPrev(temp);

    }

    @Override
    public E removeFirst() {

        if (isEmpty()) {
            return null;
        }

        // Store the peek Node's data to return it
        E answer = head.getNext().getData();

        // Let the head point (as next) to the second Node
        head.setNext(head.getNext().getNext());
        size--;

        return answer;

    }

    @Override
    public E removeLast() {

        if (isEmpty()) {
            return null;
        }

        if (size == 1) {
            E answer = head.getNext().getData();

            head.setNext(null);
            size--;

            return answer;
        }

        // We have at least 2 Nodes

        // Find the Node right before the last one and let it point (as next) to null
        Node temp = head.getNext();
        while (temp.getNext().getNext() != null)
            temp = temp.getNext();

        // temp now is the node right before the last one
        E answer = temp.getNext().getData();

        temp.setNext(null);
        size--;

        return answer;

    }

    @Override
    public void printList() {

        if (isEmpty()) {
            return;
        }

        System.out.print("List -> ");

        // Keep moving until you are on a node whose next is null
        Node temp = head.getNext();
        while (temp != null) {
            System.out.print(temp.data + "  ");
            temp = temp.getNext();
        }

    }

}
