package File;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.concurrent.ConcurrentLinkedQueue;

public class WriteFileFromQueue {
    public static void main(String...args){
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File(System.getProperty("user.dir") + File.separator+"text.txt");
            if (!file.exists()) {
                //file.mkdirs();

            }
            fileWriter = new FileWriter(file,true);
            bufferedWriter = new BufferedWriter(fileWriter);
        }catch (Exception e){
            e.printStackTrace();
        }

        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<String>();

        for(int i=0;i<10;i++){
            new Thread(new SaveDataToQueue(queue,"写入数据为："+i)).start();
        }

        new Thread(new PutDataToFile(queue,bufferedWriter)).start();
    }
}
