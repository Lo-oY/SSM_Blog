/**
 * Created by cilu on 2017/12/2.
 */
public class TestInterrupt {

    public static void main(String args[]) throws InterruptedException {

        Thread thread = new Thread(new Task());
        thread.start();
        thread.interrupt();
        Thread.sleep(100);
        System.out.println(thread.isInterrupted());

    }

    static class Task implements Runnable {

        private int i = 0;
        @Override
        public void run() {

            while (true) {
                try {
                    System.out.println(i++);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().isInterrupted());
                    System.out.println("interrupt");
                    Thread.currentThread().interrupt();
                    System.out.println(Thread.currentThread().isInterrupted());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e1) {
                        System.out.println("interrupt2");
                    }
                    return;
//                e.printStackTrace();
                }
            }
        }
    }


}


