package Thread;
class newThread implements Runnable {
    Thread t; int name;
    newThread(int name) {
        t = new Thread(this,"runnable thread ");
        this.name = name;
        t.start();
    }

    @Override
    public void run() {
        //printing
        for(int i=1;i<=5;i++){
            System.out.println(name+"child thread"+i);
        }

    }
}
public class RunnableThread  {
    public static void main(String[] args) {
        System.out.println("main thread started....");
       newThread obj1= new newThread(1);
       newThread obj2= new newThread(2);
        System.out.println("Thread 1 is alive: "+obj1.t.isAlive());
        System.out.println("Thread 2 is alive: "+obj2.t.isAlive());

        try {
            obj1.t.join(); // wait for obj1 thread untill it finish
            obj2.t.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
