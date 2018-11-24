package Lesson5;

import java.io.*;
import java.nio.Buffer;
import java.util.Scanner;

public class FileManager {

    private static File file;

    //打开文件
    public static void open(){
        file = new File("test.txt");
        if(file.exists()){
            System.out.println("文件已经存在");
        }
        else{
            System.out.println("文件不存在");
            try{
                file.createNewFile();
                System.out.println("文件已被创建");
            }catch (Exception e){System.out.println("文件无法创建");}
        }
    }

    //读文件
    public static void read(){
        try{
            FileInputStream stream = new FileInputStream(file);//文件输入流，是字节流
            InputStreamReader reader = new InputStreamReader(stream,"UTF-8");//InputStreamReader是字符流,字节流向字符流转换时需要指定编码方式，不然会乱码
            BufferedReader buffer = new BufferedReader(reader);//字符缓冲区

            System.out.println("\n打印内容:");
            String line;
            while((line=buffer.readLine())!=null){//如果缓冲区非空就读出来打印
                System.out.println(line);
            }
            buffer.close();
            reader.close();
            stream.close();
        }catch (Exception e){e.printStackTrace();}
    }

    public static void write(){
        try{
            FileOutputStream fos = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);//写入缓冲区

            String line ="加入的内容";

            osw.append(line);
            osw.flush();
//            bw.append(line);
//            bw.flush();

            bw.close();
            osw.close();
            fos.close();
        }catch (Exception e){e.printStackTrace();}
    }

    public static void main(String...args){
        open();
        read();
        write();
        read();
    }

}
