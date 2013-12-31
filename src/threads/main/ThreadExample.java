package threads.main;

/**
 * Created with IntelliJ IDEA.
 * User: rpanjrath
 * Date: 8/29/13
 * Time: 2:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class ThreadExample {

    public static void main(String[] args){
//        System.out.println(Thread.currentThread().getName());
//        for(int i=0; i<10; i++){
//            new Thread("" + i){
//                public void run(){
//                    System.out.println("Thread: " + getName() + " running");
//                }
//            }.start();
//        }

        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {

                }
                System.out.println("inner thread: " + Thread.currentThread().getName());
            }
        }, "myThread1");
        myThread.run(); // calling run will have the original thread i.e. main here execute without spawning a new thread.
        myThread.start(); // calling start will have the new thread .. myThread1 ... execute parallely.
    }
}
