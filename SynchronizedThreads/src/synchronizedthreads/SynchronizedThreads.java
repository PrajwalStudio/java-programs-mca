package synchronizedthreads;

// Shared resource
class Q {
    int n;
    boolean valueSet = false;

    synchronized int get() {
        while (!valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted in get");
            }
        }
        System.out.println("Got: " + n);
        valueSet = false;
        notify();
        return n;
    }

    synchronized void put(int n) {
        while (valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted in put");
            }
        }
        this.n = n;
        System.out.println("Put: " + n);
        valueSet = true;
        notify();
    }
}

// Producer Thread
class Producer implements Runnable {
    Q q;

    Producer(Q q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }

    public void run() {
        for (int i = 0; i <= 5; i++) {
            q.put(i);
        }
    }
}

// Consumer Thread
class Consumer implements Runnable {
    Q q;

    Consumer(Q q) {
        this.q = q;
        new Thread(this, "Consumer").start();
    }

    public void run() {
        for (int i = 0; i <= 5; i++) {
            q.get();
        }
    }
}

// Main class
public class SynchronizedThreads {
    public static void main(String[] args) {
        Q q = new Q();
        System.out.println("Press Ctrl+C to stop...");
        new Producer(q);
        new Consumer(q);
    }
}
