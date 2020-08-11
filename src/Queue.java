public interface Queue<E> {

    int size();

    boolean isEmpty();

    E peek();

    void enqueue(E e);

    E dequeue();

    void printQueue();

}