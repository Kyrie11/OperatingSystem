package Ball;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class BallThread extends Thread {

    private Graphics g;
    private JPanel jp_ball;
    private ArrayList<Ball> listBall;

    public BallThread(Graphics g,ArrayList<Ball> listBall,JPanel jp_ball){
        this.g = g;
        this.listBall = listBall;
        this.jp_ball = jp_ball;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i=0;i<listBall.size();i++){
                listBall.get(i).drawBall(g,jp_ball);
            }
        }

    }
}
