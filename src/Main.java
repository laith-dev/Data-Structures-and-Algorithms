import structs.List;
import structs.SinglyLinkedList;

/**
 * Used for testing.
 */
public class Main {

    public static void main(String[] args) {

        List<String> names = new SinglyLinkedList<>();
        names.addFirst("Laith");
        names.addLast("Android");
        names.addLast("Developer");

        names.removeFirst();
        names.removeLast();
        names.removeLast();

        names.printList();
    }

}