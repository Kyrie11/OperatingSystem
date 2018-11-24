package Lesson1;

public class Printer extends Thread{
    private String name;
    public Printer(String name){
        this.name=name;
    }

    public void run(){
        while(true){
            try {
                System.out.println("打印机"+Thread.currentThread().getName()+"正在打印");
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
