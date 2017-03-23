/**
 * Created by eishkinina on 14.03.17.
 */
public class DeadLockExample {
   static Object R1 = new Object();
    static Object R2 = new Object();

    public static void main(String[] args) {

        Thread T1 = new Thread(new Runnable(){
            @Override
            public void run() {
                synchronized (R1) {
                    System.out.println("I'm in R1; " + Thread.currentThread());
                }
                synchronized (R2){
                        System.out.println("I'm in R2; " + Thread.currentThread());
                    }
                }

        });

        Thread T2 = new Thread(new Runnable(){
            @Override
            public void run() {
                synchronized (R2){
                    System.out.println("I'm in R2; " + Thread.currentThread());
                }
                synchronized (R1){
                    System.out.println("I'm in R1; " + Thread.currentThread());
                }

            }
        });

        T1.start();
        T2.start();



    }


}
