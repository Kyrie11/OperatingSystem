package Bank;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class moneyMan extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel jContentPane = null;

    private JPanel jPanel = null;

    private JLabel jLabel = null;

    private JLabel jLabel1 = null;

    JTextField time = null;

    private JLabel jLabel2 = null;

    JTextField total = null;

    private JLabel jLabel3 = null;

    JTextField out = null;

    private JLabel jLabel4 = null;

    JTextField a = null;

    private JLabel jLabel5 = null;

    JTextField b = null;

    private JLabel jLabel6 = null;

    JTextField c = null;

    private JLabel jLabel7 = null;

    JTextField d = null;

    JScrollPane showScroll = null;

    private JLabel jLabel8 = null;

    JTextArea jTextArea = null;

    private JButton sure = null;

    private JButton clear = null;

    private JButton save = null;

    /**
     * This method initializes jPanel
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJPanel() {
        if (jPanel == null) {
            jLabel8 = new JLabel();
            jLabel8.setBounds(new Rectangle(224, 77, 285, 27));
            jLabel8.setText("财务状况显示区：");
            jLabel7 = new JLabel();
            jLabel7.setBounds(new Rectangle(34, 277, 115, 30));
            jLabel7.setText("20号后支出：");
            jLabel6 = new JLabel();
            jLabel6.setBounds(new Rectangle(35, 246, 114, 26));
            jLabel6.setText("13号~19号支出：");
            jLabel5 = new JLabel();
            jLabel5.setBounds(new Rectangle(35, 212, 106, 29));
            jLabel5.setText("7号~12号支出：");
            jLabel4 = new JLabel();
            jLabel4.setBounds(new Rectangle(37, 180, 105, 28));
            jLabel4.setText("1号~6号支出：");
            jLabel3 = new JLabel();
            jLabel3.setBounds(new Rectangle(37, 148, 68, 27));
            jLabel3.setText("总支出：");
            jLabel2 = new JLabel();
            jLabel2.setBounds(new Rectangle(36, 119, 69, 27));
            jLabel2.setText("总收入：");
            jLabel1 = new JLabel();
            jLabel1.setBounds(new Rectangle(35, 87, 70, 28));
            jLabel1.setText("财务时间：");
            jLabel = new JLabel();
            jLabel.setBounds(new Rectangle(196, 2, 168, 69));
            jLabel.setText("        财务管理系统");
            jPanel = new JPanel();
            jPanel.setLayout(null);
            jPanel.setBounds(new Rectangle(4, 5, 588, 387));
            jPanel.add(jLabel, null);
            jPanel.add(jLabel1, null);
            jPanel.add(getTime(), null);
            jPanel.add(jLabel2, null);
            jPanel.add(getTotal(), null);
            jPanel.add(jLabel3, null);
            jPanel.add(getOut(), null);
            jPanel.add(jLabel4, null);
            jPanel.add(getA(), null);
            jPanel.add(jLabel5, null);
            jPanel.add(getB(), null);
            jPanel.add(jLabel6, null);
            jPanel.add(getC(), null);
            jPanel.add(jLabel7, null);
            jPanel.add(getD(), null);
            jPanel.add(getShowScroll(), null);
            jPanel.add(jLabel8, null);
            jPanel.add(getSure(), null);
            jPanel.add(getClear(), null);
            jPanel.add(getSave(), null);
        }
        return jPanel;
    }

    /**
     * This method initializes time
     *
     * @return javax.swing.JTextField
     */
    private JTextField getTime() {
        if (time == null) {
            time = new JTextField();
            time.setBounds(new Rectangle(107, 89, 103, 27));
        }
        return time;
    }

    /**
     * This method initializes total
     *
     * @return javax.swing.JTextField
     */
    private JTextField getTotal() {
        if (total == null) {
            total = new JTextField();
            total.setBounds(new Rectangle(109, 118, 100, 27));
        }
        return total;
    }

    /**
     * This method initializes out
     *
     * @return javax.swing.JTextField
     */
    private JTextField getOut() {
        if (out == null) {
            out = new JTextField();
            out.setBounds(new Rectangle(106, 148, 103, 26));
        }
        return out;
    }

    /**
     * This method initializes a
     *
     * @return javax.swing.JTextField
     */
    private JTextField getA() {
        if (a == null) {
            a = new JTextField();
            a.setBounds(new Rectangle(143, 181, 70, 26));
        }
        return a;
    }

    /**
     * This method initializes b
     *
     * @return javax.swing.JTextField
     */
    private JTextField getB() {
        if (b == null) {
            b = new JTextField();
            b.setBounds(new Rectangle(145, 213, 67, 26));
        }
        return b;
    }

    /**
     * This method initializes c
     *
     * @return javax.swing.JTextField
     */
    private JTextField getC() {
        if (c == null) {
            c = new JTextField();
            c.setBounds(new Rectangle(155, 247, 58, 25));
        }
        return c;
    }

    /**
     * This method initializes d
     *
     * @return javax.swing.JTextField
     */
    private JTextField getD() {
        if (d == null) {
            d = new JTextField();
            d.setBounds(new Rectangle(155, 278, 58, 26));
        }
        return d;
    }

    /**
     * This method initializes showScroll
     *
     * @return javax.swing.JScrollPane
     */
    private JScrollPane getShowScroll() {
        if (showScroll == null) {
            showScroll = new JScrollPane();
            showScroll.setBounds(new Rectangle(224, 107, 356, 198));
            showScroll.setViewportView(getJTextArea());
        }
        return showScroll;
    }

    /**
     * This method initializes jTextArea
     *
     * @return javax.swing.JTextArea
     */
    private JTextArea getJTextArea() {
        if (jTextArea == null) {
            jTextArea = new JTextArea();
        }
        return jTextArea;
    }

    /**
     * This method initializes sure
     *
     * @return javax.swing.JButton
     */
    private JButton getSure() {
        if (sure == null) {
            sure = new JButton();
            sure.setBounds(new Rectangle(36, 325, 99, 43));
            sure.setText("确定计算");
            sure.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {

                }
            });
            sure.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e)
                {



                    TestThread testThread = new TestThread();//新生成一个处理事务线程
                    testThread.start();//启动事务线程


                }
            });
        }
        return sure;
    }

    /**
     * This method initializes clear
     *
     * @return javax.swing.JButton
     */
    private JButton getClear() {
        if (clear == null) {
            clear = new JButton();
            clear.setBounds(new Rectangle(160, 327, 94, 40));
            clear.setText("清空");
            clear.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
                }
            });
        }
        return clear;
    }

    /**
     * This method initializes save
     *
     * @return javax.swing.JButton
     */
    private JButton getSave() {
        if (save == null) {
            save = new JButton();
            save.setBounds(new Rectangle(291, 324, 89, 41));
            save.setText("历史财务");
            save.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    jTextArea.setText("");
                    String record = null;
                    try {
                        FileReader fr = new FileReader("money.txt");
                        BufferedReader br = new BufferedReader(fr);
                        record = new String();
                        while ((record = br.readLine()) != null) {
                            String value = record+'\n';
                            jTextArea.insert(value,jTextArea.getDocument().getLength());

                        }
                        br.close();
                        fr.close();
                    } catch (IOException ee) {
                        System.out.println( "Read file error! ");
                        ee.printStackTrace();
                    }


                }
            });
        }
        return save;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {




        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                moneyMan thisClass = new moneyMan();
                thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                thisClass.setVisible(true);
            }
        });
    }

    /**
     * This is the default constructor
     */
    public moneyMan() {
        super();
        initialize();
    }

    /**
     * This method initializes this
     *
     * @return void
     */
    private void initialize() {
        this.setSize(591, 425);
        this.setContentPane(getJContentPane());
        this.setTitle("JFrame");
    }

    /**
     * This method initializes jContentPane
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJContentPane() {
        if (jContentPane == null) {
            jContentPane = new JPanel();
            jContentPane.setLayout(null);
            jContentPane.add(getJPanel(), null);
        }
        return jContentPane;
    }


    class TestThread extends Thread
    {


        public void run()
        {


            System.out.println("线程工作了");

            String shijian = time.getText();


            String zong = total.getText();
            int z = Integer.parseInt(zong);

            String zhi = out.getText();

            int o = Integer.parseInt(zhi);

            int z_o = o / z;
            String zo = Integer.toString(z_o); //收支比例


            String A = a.getText();
            int aa = Integer.parseInt(A);
            int A_a = aa / z;
            String Aa = Integer.toString(A_a);//第一星期收支比例

            String B = b.getText();
            int bb = Integer.parseInt(B);
            int B_b = bb / z;
            String Bb = Integer.toString(B_b);//第二星期收支比例


            String C = c.getText();
            int cc = Integer.parseInt(C);
            int C_c = cc / z;
            String Cc = Integer.toString(C_c);//第三星期收支比例

            String D = d.getText();
            int dd = Integer.parseInt(D);
            int D_d = dd / z;
            String Dc = Integer.toString(D_d);//第四星期收支比例


            String value = "总收入:" + zong + '\n' + "总支出:" + zhi + '\n' + "总收支比例:" + zo + "%" + '\n' + "第一星期收支比例:" + Aa + "%" + '\n' + "第二星期收支比例:" + Bb + "%" + '\n' + "第三星期收支比例:" + Cc + "%" + '\n' + "第四星期收支比例:" + Dc + '\n' + "财务结算时间：" + shijian + '\n';

            jTextArea.insert(value,jTextArea.getDocument().getLength());


            File f = new File("money.txt");
            try
            {
                FileWriter out = new FileWriter(f);
                out.write(value);
                out.close();
            }
            catch (Exception a)
            {
                System.out.println(a);
            }
        }

    }

}