public class SinglyLinkedListStack<E> implements Stack<E> {

    /*
     * In SLLS, each node points (has a reference) to the previous node (the node below it).
     * */
    
    private class Node {

        private E data;
        private Node prev;

        public Node(E data) {
            this.data = data;

            // Increase the size each time a node is created.
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
    }

    private int size;
    private Node top;

    public SinglyLinkedListStack() {
        top = null;
        size = 0;
    }

    @Override
    public void push(E data) {

        if (isEmpty()) {
            top = new Node(data);
            return;
        }

        /*
         * To add a node to a none-empty stack:
         * 1- Create a node node.
         * 2- Let it point to top.
         * 3- Move top to the new Node.
         * */

        Node newNode = new Node(data);
        newNode.setPrev(top);

        // Move top to the newNode
        top = newNode;

    }

    @Override
    public E pop() {

        if (isEmpty()) {
            return null;
        }

        // Store top's data to return it
        E answer = top.getData();

        // Make top point to the previous Node
        top = top.getPrev();

        size--;

        return answer;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public void printStack() {

        if (isEmpty()) {
            return;
        }

        System.out.println("Stack ->");
        Node temp = top;
        while (temp != null) {
            System.out.println("\t\t" + temp.getData());
            temp = temp.getPrev();
        }
    }
}
