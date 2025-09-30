package Threads;

public class ThreadLocking {

    public static void main(String[] args) {
        ThreadLocking threadLocking = new ThreadLocking();

        Thread thread1 = new Thread(threadLocking:: printOdd);
        Thread thread2 = new Thread(threadLocking:: printEven);

        thread1.start();
        thread2.start();

    }

    volatile boolean numberTurn = true;

    public synchronized void printEven()  {
        for (int i = 2; i < 10 ; i +=2) {
            while (!numberTurn){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(i +" ");
            numberTurn =false;
            this.notifyAll();
        }
    }
    public synchronized void printOdd() {

        for (int i= 1; i < 10; i +=2){
            while (numberTurn){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(i+ " ");
            numberTurn = true;
            this.notifyAll();
        }

    }

}
