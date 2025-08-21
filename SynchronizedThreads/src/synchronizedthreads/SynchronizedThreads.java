package synchronizedthreads;

class Q {

    int n;
    boolean ready = false;

    synchronized void put(int n) {
        while (ready) {   // wait if data not yet consumed
            try {
                wait();
            } catch (Exception e) {
                System.out.println("Exception in put");
            }
        }
        this.n = n;
        System.out.println("Put: " + n);
        ready = true;
        notify();
    }

    synchronized void get() {
        while (!ready) {  // wait if no data yet
            try {
                wait();
            } catch (Exception e) {
                System.out.println("Exception in get");
            }
        }
        System.out.println("Got: " + n);
        ready = false;
        notify();
    }
}

class Producer extends Thread {

    Q q;

    Producer(Q q) {
        this.q = q;
        start();
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            q.put(i);
        }
    }
}

class Consumer extends Thread {

    Q q;

    Consumer(Q q) {
        this.q = q;
        start();
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            q.get();
        }
    }
}

public class SynchronizedThreads {

    public static void main(String[] args) {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);
    }
}
