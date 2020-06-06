public class Main {

    public static void main(String[] args) {

        Queue<Integer> test = new CircularArrayQueue<>(5);

        test.enqueue(5);
        test.enqueue(4);
        test.enqueue(3);
        test.enqueue(2);
        test.enqueue(1);

        test.dequeue();
        test.dequeue();
        test.dequeue();
        test.dequeue();

        test.enqueue(2);
        test.enqueue(3);
        test.enqueue(4);

        test.dequeue();
        test.dequeue();

        test.enqueue(5);
        test.enqueue(5);
        test.enqueue(5);

        test.printQueue();


    }

}
