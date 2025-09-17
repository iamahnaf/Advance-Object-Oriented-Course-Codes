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
        new newThread(1);
        new newThread(2);
    }
}
