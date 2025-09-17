package ProducerConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
class Producer implements Runnable {
    BlockingQueue<String> queue;
    Thread t;
    String name;
    public Producer(BlockingQueue<String> queue,String name) {
        this.queue = queue;
        this.name = name;
        t = new Thread(this, name);
        t.start();
    }
    @Override
    public void run() {
        System.out.println(name + ": is starting...");
       int i=0;
       while(true) {
           if(queue.size()>=4){
               System.out.println(name+ ": queue is full..");
               try {
                   Thread.sleep(500);
               } catch (InterruptedException e) {
                   System.out.println(e.getMessage());
               }
           }
           try {
               queue.put("cake"+i);
               System.out.println("created cake "+(i+1));
               i++;
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               System.out.println(e.getMessage());
           }
       }
    }
}
class Consumer implements Runnable {
    Thread t;
    BlockingQueue<String> queue;
    String name;
    Consumer(BlockingQueue<String> queue,String name) {
        this.queue = queue;
        this.name = name;
        t = new Thread(this, name);
        t.start();
    }
    @Override
    public void run() {
        System.out.println(name + ": is starting...");
        while(true) {
            if(queue.size()==0){
                System.out.println(name+ ": queue is empty..");
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
            try {
                System.out.println(name + " Got "+ queue.take() );
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
public class Main {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(4);
       Producer p = new Producer(queue,"Producer1");
       Consumer c = new Consumer(queue,"Consumer1");
       Consumer c2 = new Consumer(queue,"Consumer2");


    }
}
