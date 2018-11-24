package File;

import java.io.BufferedWriter;
import java.util.concurrent.ConcurrentLinkedQueue;

public class PutDataToFile implements Runnable{
    private ConcurrentLinkedQueue<String> queue;
    private BufferedWriter buff;

    public PutDataToFile(ConcurrentLinkedQueue<String> queue,BufferedWriter buff){
        super();
        this.queue = queue;
        this.buff = buff;
    }

    public void run(){
        while(true){
            if(!queue.isEmpty()){
                try{
                    buff.write(queue.poll());
                    buff.newLine();
                    buff.flush();
                }catch (Exception e){e.printStackTrace();}
            }
        }
    }
}
