package structs;

public class CircularArrayQueue<E> implements Queue<E> {

    private final E[] data;     // generic array used for storage
    private int front;          // index of the front element
    private int rear;           // index of the last element
    private static int size;    // number of filled cells in the array

    public CircularArrayQueue(int capacity) {
        front = -1;
        rear = -1;
        size = 0;
        data = (E[]) new Object[capacity];
    }

    /**
     * Keep track of elements count in the queue.
     * @return the size of the queue.
     */
    @Override
    public int size() {
        return size;
    }


    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    public boolean isFull() {
        return (size == data.length);
    }

    @Override
    public E peek() {

        if (isEmpty()) {
            return null;
        }

        return data[front];
    }

    @Override
    public void enqueue(E e) {

        if (isFull()) {
            return;
        }

        if (isEmpty()) {
            front = rear = 0;
            data[rear] = e;
            size++;

            return;
        }

        /* Adding in queue done at the rear, so find the rear */
        rear = (front + size) % data.length;
        data[rear] = e;
        size++;

    }

    @Override
    public E dequeue() {

        if (isEmpty()) {
            return null;
        }
        // Store front to return it
        E answer = data[front];

        // Dereference to help garbage collection
        data[front] = null;

        // Move front one step forward
        front = (front + 1) % data.length;
        size--;

        return answer;

    }

    @Override
    public void printQueue() {

        if (isEmpty()) {
            return;
        }

        /* To traverse the queue:
         * 1- Start from the front
         * 2- Move 'size' times
         * - modulus used because queue is circular
         */
        System.out.print("structs.Queue -> ");
        for (int i = 0; i < size; i++)
            System.out.print(data[(front + i) % data.length] + " ");

    }

}
