package Ball;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class ThreadListener extends MouseAdapter implements ActionListener {

    private int x,y;
    //JPanel：用于获取画笔的长和宽
    private JPanel jp_ball;
    //队列：存储球的对象，不用定义初始长度
    private ArrayList<Ball> listBall = new ArrayList<Ball>();
    //线程：线程中循环绘制listBall中的所有ball
    private BallThread ballThread;

    public ThreadListener(Graphics g,JPanel jp_ball) {
        this.jp_ball = jp_ball;
        //构造函数只使用1次，在此处创建线程，则线程一定只有一个——实现一个线程绘制多个小球
        //创建线程对象，构造方法将画笔和画布和队列listBall传入
        if(ballThread==null){
            System.out.println("线程创建");
            ballThread = new BallThread(g,listBall,jp_ball);
            ballThread.start();
        }
    }


    public void actionPerformed(ActionEvent e) {
        System.out.println("run");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // 1.获取x和y
        x = e.getX();
        y = e.getY();
        // 2.判断点击是否超出界面，超出则把其设置为边界x和y
        if (x + 20 >= jp_ball.getWidth()){
            x = jp_ball.getWidth() - 30;
        }
        if (y + 20 >= jp_ball.getHeight()){
            y = jp_ball.getHeight() - 30;
        }
        // 3.点击时，创建小球对象，
        Ball ball = new Ball(x,y);
        // 4.将小球对象存入小球队列listBall中
        listBall.add(ball);
    }
}