package Ball;

import javax.swing.*;
import java.awt.*;

public class Ball {
    private int x, y;
    private int radius = 30;
    private int vx = 3, vy = 3;

    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void drawBall(Graphics g, JPanel jp_ball) {
        //1.判断是否为边界
        if (x <= 0 || x + radius >= jp_ball.getWidth()) {
            vx = -vx;
        }
        if (y <= 0 || y + radius >= jp_ball.getHeight()) {
            vy = -vy;
        }
        //2.绘制一个背景色小球，覆盖于上次绘制的小球上
        g.setColor(Color.white);
        g.fillOval(x, y, radius, radius);
        //3.获取本次的x和y
        x += vx;
        y += vy;
        //4.绘制本次小球
        g.setColor(Color.orange);
        g.fillOval(x, y, radius, radius);
    }
}
