/**
 * Created by eishkinina on 14.03.17.
 */
public class StatusOfThreads {
static boolean start ;
    static boolean wait = true;
    static Object lock = new Object();
    public static void main(String[] args) throws Exception {
        Thread T1 = new Thread(new Runnable() {
            @Override
            public void run() {

                while(!start){

                }
                synchronized (lock) {

                    while(wait) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        System.out.println(T1.getState());
        T1.start();
        System.out.println(T1.getState());
        start = true;
        Thread.sleep(1000);
//        System.out.println(T1.getState());
        synchronized (lock){//  чтобы статус был ваитинг гарантировано
            System.out.println(T1.getState());
            wait = false;
            lock.notifyAll();
            System.out.println(T1.getState());
        }
        Thread.sleep(5000); // аналогично
        System.out.println(T1.getState());
    }
}
