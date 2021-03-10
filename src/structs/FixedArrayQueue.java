package structs;

public class FixedArrayQueue<E> implements Queue<E> {

    private E[] data;   // general-type array for storing elements
    private int front;  // index of the first element, initially -1
    private int rear;   // index of the last element, initially -1
    private int size;   // number of filled cells in the array

    public FixedArrayQueue(int capacity) {
        front = -1;
        rear = -1;
        size = 0;
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    // Note how 'isFull' differs between Fixed and Circular structs.Queue
    public boolean isFull() {
        return (rear + 1 == data.length);
    }

    @Override
    public E peek() {

        if (isEmpty()) {
            return null;
        }

        return data[front];
    }

    /**
     * Adds a new element at the rear of the queue.
     *
     * @param e is the element to be added.
     */
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

        // Move the rear one step forward
        rear++;
        data[rear] = e;
        // Can be simplified to: data[++rear] = e;

        size++;

    }

    /**
     * Removes the first element of the queue and returns it.
     *
     * @return the deleted element.
     */
    @Override
    public E dequeue() {

        if (isEmpty()) {
            return null;
        }

        // Store front's data to return it
        E answer = data[front];

        // Move every element one step forward
        for (int i = 0; i < size - 1; i++) // size-1 because no need to reach the last element
            data[i] = data[i + 1];

        size--;

        // Move the rear one step backward
        rear--;

        return answer;
    }

    @Override
    public void printQueue() {

        if (isEmpty()) {
            return;
        }

        System.out.print("structs.Queue -> ");
        // Always start from 0, because the front is always 0 -> structs.FixedArrayQueue
        for (int i = 0; i < size; i++)
            System.out.print(data[i] + " ");

    }

}
