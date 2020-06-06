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

    // Note how 'isFull' differs between Fixed and Circular Queue
    public boolean isFull() {
        return (rear + 1 == data.length);
    }

    @Override
    public E peek() {

        if (isEmpty()) {
            System.out.println("Nothing to peek. Queue is empty!");
            return null;
        }

        return data[front];
    }

    /* Adding in a queue happens at the rear of the array */
    @Override
    public void enqueue(E e) {

        if (isFull()) {
            System.out.println("Cannot add " + e + ". Queue is full!");
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

    /* Deletion in a queue happens at the front of the array */
    @Override
    public E dequeue() {

        if (isEmpty()) {
            System.out.println("Nothing to remove. Queue is empty!");
            return null;
        }

        // Store front's data to return it
        E answer = data[front];

        // Move every element one step backward
        for (int i = 0; i < size - 1; i++) // size-1: no need to reach the last element
            data[i] = data[i + 1];

        size--;

        // Move the rear one step backward
        rear--;

        return answer;
    }

    @Override
    public void printQueue() {

        if (isEmpty()) {
            System.out.println("Nothing to print. Queue is empty!");
            return;
        }

        System.out.print("Queue -> ");
        // Always start from 0, because the front is always 0 -> FixedArrayQueue
        for (int i = 0; i < size; i++)
            System.out.print(data[i] + " ");

    }

}
