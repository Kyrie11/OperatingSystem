package File;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SaveDataToQueue implements  Runnable{
    private ConcurrentLinkedQueue<String> queue;
    private String data;

    public SaveDataToQueue(ConcurrentLinkedQueue<String> queue,String data){
        this.queue = queue;
        this.data = data;
    }


    public void run(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:hh:ss");
        data = format.format(new Date())+":"+data;
        System.out.println(data);
        queue.add(data);
    }

}
