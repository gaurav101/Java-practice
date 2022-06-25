package ThreadPractice;

public class Thread1 extends  Thread {

    String Name;
    public Thread1(String name){
        super.setName(name);
        this.Name=name;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println(this.Name+"==>"+i);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
