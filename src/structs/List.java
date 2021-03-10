package structs;

public interface List<E> {

    void addFirst(E data);

    void addLast(E data);

    E removeFirst();

    E removeLast();

    int size();

    boolean isEmpty();

    void printList();

}
