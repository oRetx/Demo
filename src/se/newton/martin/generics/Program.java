package se.newton.martin.generics;


public class Program {


    /**
     * Javadoc comment. This is a generic method that can take any reference as input.
     * Type is decided at compiletime.
     *
     * @param arg
     * @param <T>
     */
     public static <T> void genericMethod(T arg) {
        System.out.println(arg);
    }

    public static void main(String[] args) {
        Queue<String> q = new Queue();
        Thread producer = new Thread(new Producer(q));
        producer.start();

        Thread consumer1 = new Thread(new Runnable() {
                @Override
            public void run() {
                while (true) {
                    System.out.println("Consumer1 says:" + q.deQueue());
                }
            }
        });
        consumer1.start();

        Thread consumer2 = new Thread( () -> {
                while (true) {
                    System.out.println("Consumer2 says:" + q.deQueue());
                }
        });
        consumer2.start();

//        q.enQueue(1);
//        System.out.println(q.deQueue());
//
//        q.enQueue(1);
//        q.enQueue(2);
//        System.out.println(q.deQueue());
//        System.out.println(q.deQueue());


//        StorageBin<Integer> placeToStoreThings = new StorageBin<>();
//        placeToStoreThings.setStorage(10);
//        placeToStoreThings.add(20);

    }
}
