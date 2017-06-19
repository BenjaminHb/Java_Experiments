import static java.lang.Thread.sleep;

/**
 * Created by benjaminzhang on 11/06/2017.
 * Copyright © benjaminzhang 2017.
 */

class DelayThread_Runnable implements Runnable {
    private Thread thread = null;
    private static int count = 0;
    private int no;
    private int delay;

    protected DelayThread_Runnable() {
        count++;
        no = count;
    }

    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                delay = (int) (Math.random() * 5000);
                sleep(delay);
                System.out.println("Thread " + no + " with a delay " + delay);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void start(){
        thread = new Thread(this);
        thread.start();
    }
}

public class MyThread_Runnable{
    public static void main(String args[]){
        DelayThread_Runnable thread1 = new DelayThread_Runnable();
        DelayThread_Runnable thread2 = new DelayThread_Runnable();
        thread1.start();
        thread2.start();
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread wrong!");
    }
}
