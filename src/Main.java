public class Main {
    public static void main(String[] args) {
        Worker worker1 = new Worker("worker_1", 100, 100, 13);
        Worker worker2 = new Worker("worker_2", 2300, 3000, 23);
        Worker worker3 = new Worker("worker_3", 1000, 2000, 36);
        Worker worker4 = new Worker("worker_4", 100, 5000, 49);

        worker1.addPeer(worker2);
        worker1.addPeer(worker3);
        worker1.addPeer(worker4);

        worker2.addPeer(worker1);
        worker2.addPeer(worker3);
        worker2.addPeer(worker4);

        worker3.addPeer(worker1);
        worker3.addPeer(worker2);
        worker3.addPeer(worker4);

        worker4.addPeer(worker1);
        worker4.addPeer(worker2);
        worker4.addPeer(worker3);

        new Thread(() -> {
            worker1.run();
        }).start();
        new Thread(() -> {
            worker2.run();
        }).start();

        new Thread(() -> {
            worker3.run();
        }).start();
        new Thread(() -> {
            worker4.run();
        }).start();
//        new Thread(() -> {
//            worker3.run();
//        }).start();
        //Worker worker4 = new Worker("worker_1", 500, 1000);

    }
}