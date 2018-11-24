package Snake;


import javax.swing.*;
import java.awt.*;


public class four3 extends JFrame {
    // 全局变量
    static int positionA = 50, positionB = 50, distanceAll = 1600;
    static int RecWidth = 50, RecHeight = 50;
    static char winner;
    static long sleeptime = 300;
    static boolean waitA = true, waitB = true, gaming = true, unrepaint = true;


    private int x=10;
    private static String str = "刘婷的线程小游戏";

    //构造函数
    public four3() {
        setTitle("多线程：方块赛跑");
        setBackground(Color.WHITE);
        setSize(1600, 500);
        setLocation(0, 200);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }



    //绘图函数
    public void paint(Graphics g) {
        // TODO Auto-generated method stub
        g.clearRect(0, 0, 1600, 900);
        g.setColor(Color.RED);
        g.fillRect(positionA - 50, 100, RecWidth, RecHeight);
        g.setColor(Color.BLUE);
        g.fillRect(positionB - 50, 300, RecWidth, RecHeight);
        g.setColor(Color.CYAN);
        Font font = new Font("\\u5fae\\u8f6f\\u96c5\\u9ed1",Font.PLAIN,30);
        g.setFont(font);
        FontMetrics fontMetrics = g.getFontMetrics();
        int strWidth = fontMetrics.stringWidth(str);
        g.drawString(str,x+700,80);

        if (!gaming) {
            g.setFont(new Font("宋体", Font.BOLD, 50));
            if (winner == 'A') {
                g.setColor(Color.RED);
                g.drawString(new String("Winner Is The Red One!"), 550, 250);
            } else if (winner == 'B') {
                g.setColor(Color.BLUE);
                g.drawString(new String("Winner Is The Blue One!"), 550, 250);
            }
        }
    }

    public static void main(String[] args) {
        waitA = false;
        waitB = true;
        unrepaint = false;

        threadframe tf = new threadframe();
        threadA tA = new threadA();
        threadB tB = new threadB();

        tf.start();
        tA.start();
        tB.start();

        try {
            tf.join();
            tA.join();
            tB.join();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return;
    }


    //红色方块线程
    public static class threadA extends Thread {

        public void run() {
            while (gaming) {

                while (waitA) {
                    if (!gaming)return;
                    System.out.print("");
                }

                try {
                    sleep(sleeptime);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                int distance = (int) (Math.random() * 100000) % 100;
                positionA += distance;
                if (positionA >= distanceAll) {
                    positionA = distanceAll;
                    unrepaint = false;
                    gaming = false;
                    winner = 'A';
                }
                unrepaint = false;
                waitA = true;
                waitB = false;
            }
        }
    }

    //蓝色方块线程
    public static class threadB extends Thread {

        public void run() {
            while (gaming) {

                while (waitB) {
                    if (!gaming)return;
                    System.out.print("");
                }

                try {
                    sleep(sleeptime);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                int distance = (int) (Math.random() * 100000) % 100;
                positionB += distance;

                if (positionB >= distanceAll) {
                    positionB = distanceAll;
                    unrepaint = false;
                    gaming = false;
                    winner = 'B';
                }
                unrepaint = false;
                waitB = true;
                waitA = false;
            }
        }
    }

    //框架刷新线程
    public static class threadframe extends Thread {
        four3 jiemian = new four3();

        public void run() {
            while (gaming) {
                while (unrepaint) {
                    if (!gaming)return;
                    System.out.print("");
                }
                jiemian.repaint();
                unrepaint = true;
            }
        }
    }

}






