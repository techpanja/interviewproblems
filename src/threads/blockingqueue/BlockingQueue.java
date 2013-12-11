package threads.blockingqueue;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement a blocking queue.
 * User: rpanjrath
 * Date: 10/14/13
 * Time: 2:07 PM
 */
public class BlockingQueue {

    private final Queue<Integer> queue = new LinkedList<Integer>();
    private int limit = 10;

    public BlockingQueue(int size) {
        this.limit = size;
    }

    public void enqueue(int input) throws InterruptedException {
        synchronized (queue) {
            // keep on waiting until its full
            while (queue.size() == limit) {
                wait();
            }
            // if empty then notifyAll
            if (queue.size() == 0) {
                notifyAll();
            }
            queue.add(input);
            //notifyAll();
        }
    }

    public int dequeue() throws InterruptedException {
        synchronized (queue) {
            while (queue.size() == 0) {
                wait();
            }
            if (queue.size() == limit) {
                notifyAll();
            }
            return queue.remove();
            //notifyAll();
        }
    }
}
