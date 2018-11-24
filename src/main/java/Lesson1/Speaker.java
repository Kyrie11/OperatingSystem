package Lesson1;

public class Speaker extends Thread {
    String name;

    public Speaker(String name){
        this.name = name;
    }

    public void run(){
        while(true)
            try{
                System.out.println("音响"+Thread.currentThread().getName()+"正在播放音乐");
                sleep(5000);
            }catch (Exception e){e.printStackTrace();}
    }
}
