import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker implements Runnable{
    private final String workerID;
    private final List<Worker> peers;
    private final int jitters;
    private final int sleep;
    private boolean workerActive;
    private final int seed;
//    private int counter;

    public Worker(String workerID, int jitters, int sleep, int seed) {
        this.workerID = workerID;
        this.jitters = jitters;
        this.sleep = sleep;
        this.workerActive = true;
//        this.counter = 0;
        this.peers = new ArrayList<>();
        this.seed = seed;
    }

    @Override
    public void run() {
        Random rand = new Random();
        System.out.println("fsd");
        do {
            Worker worker = peers.get(rand.nextInt(peers.size()));
            try {
//                int current_counter = logger.counter++;
                logger.logMessage("Sending message from " + this.workerID + " to " + worker.getWorkerID());
                Thread.sleep(jitters);
                worker.handleMessage(String.valueOf(seed), workerID);
                Thread.sleep(sleep);
            }
            catch(InterruptedException e) {}
        } while(workerActive);
    }

    private void handleMessage(String message, String workerID) {
//        interrupt();
        logger.logMessage(this.workerID + " Received message from " + workerID + " counter values is " + message);
    }

    public void killWorker() {
        this.workerActive = false;
    }

    public String getWorkerID() {
        return this.workerID;
    }

    public void addPeer(Worker worker) {
        this.peers.add(worker);
    }
}
