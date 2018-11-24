package Lesson1;

public class MultiThread {
    public static void main(String...args){
        for(int i=0;i<2;i++){
            Printer printer = new Printer(""+i);
            printer.start();
            Speaker speaker = new Speaker(i+"");
            speaker.start();
        }

    }
}
