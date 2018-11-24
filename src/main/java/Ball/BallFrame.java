package Ball;

import javax.swing.*;
import java.awt.*;

public class BallFrame {
    public static void main(String[] arg){
        BallFrame bf = new BallFrame();
        bf.showUI();

    }

    private void showUI() {
        JFrame jf = new JFrame();
        jf.setName("多线程小球");
        jf.setSize(500,600);
        jf.setDefaultCloseOperation(3);
        jf.setLocationRelativeTo(null);

        JPanel jp_control = new JPanel();
        JPanel jp_ball = new JPanel();
        jp_control.setBackground(Color.lightGray);
        jp_ball.setBackground(Color.white);
        jf.add(jp_control,BorderLayout.NORTH);
        jf.add(jp_ball,BorderLayout.CENTER);

        JButton jb  = new JButton("开始游戏");
        jp_control.add(jb);

        jf.setVisible(true);

        Graphics g = jp_ball.getGraphics();
        ThreadListener threadListener = new ThreadListener(g,jp_ball);
        jp_ball.addMouseListener(threadListener);
        jb.addActionListener(threadListener);

    }

}
