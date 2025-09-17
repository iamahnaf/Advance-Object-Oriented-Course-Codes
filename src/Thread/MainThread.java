package Thread;

public class MainThread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = Thread.currentThread();
        System.out.println("Current Thread: " + thread);
        // change thread name
        thread.setName("Main Thread");
        System.out.println("Current Thread: " + thread);

        //printing
        for(int i=1;i<=5;i++){
            System.out.println(i);
            Thread.sleep(100);
        }

    }
}
