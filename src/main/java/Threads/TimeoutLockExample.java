import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;

public class TimeoutLockExample {
    private final Lock lock = new ReentrantLock();

    public void doWork() {
        boolean acquired = false;
        try {
            // Try to get lock within 2 seconds
            acquired = lock.tryLock(2, TimeUnit.SECONDS);
            if (acquired) {
                System.out.println(Thread.currentThread().getName() + " acquired lock!");
                Thread.sleep(3000); // simulate work
            } else {
                System.out.println(Thread.currentThread().getName() + " could not acquire lock, timed out.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            if (acquired) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        TimeoutLockExample example = new TimeoutLockExample();

        Runnable task = example::doWork;
        new Thread(task, "Thread-1").start();
        new Thread(task, "Thread-2").start();
    }
}
