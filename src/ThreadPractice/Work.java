package ThreadPractice;

public class Work extends Thread {
    Task t1=null;
   public Work(Task t1){
        this.t1=t1;
    }

    @Override
    public void run() {
        for(int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName()+" i=>"+t1.increase());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
