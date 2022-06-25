package ThreadPractice;

public class Task {
    int val=0;
    public  synchronized  int increase(){

            this.val += 1;
            return this.val;

    }
}
