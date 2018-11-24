import java.util.ArrayList;
import java.util.List;

public class MyThread implements Runnable {
  private String name;
  private List<String> list = new ArrayList<String>();
  private final int size = 10;

  public void produce(int num) throws Exception {
    while (true) {
      synchronized (list) {
        while (list.size() + num > size) {
          System.out.println(Thread.currentThread().getName()+"������ʣ���ȴ�����");
          list.wait();
        }
        System.out.println(Thread.currentThread().getName()+"��������");
        for (int i = 0; i < num; i++) {
          list.add("hello, world");
          System.out.println("��Ʒ����:"+list.size());
        }
        list.notify();
      }
      Thread.sleep(1000);
    }
  }
  public void consume() throws Exception {
    while (true) {
      synchronized (list) {
        while (list.size() == 0) {
          System.out.println(Thread.currentThread().getName()+"���޲�Ʒ�����ѣ��ȴ�����");
          list.wait();
        }
        System.out.println(Thread.currentThread().getName()+"��������");
        list.remove(0);
        System.out.println("��Ʒ����:"+list.size());
        list.notify();
      }
      Thread.sleep(1000);
    }
  }
  public void setName(String name) {
    this.name = name;
  }

  public void run() {
    try {
      if ("producer".equals(name)) {
        produce(1);
      }
      else {
        consume();
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
  public static void main(String[] args) {
    try {
      MyThread myThread = new MyThread();
      myThread.setName("producer");
      Thread t1 = new Thread(myThread);
      Thread t4 = new Thread(myThread);
      t1.start();
      t4.start(); 
      Thread.sleep(1);
      myThread.setName("consumer");
      Thread t2 = new Thread(myThread);
      Thread t3 = new Thread(myThread);
      t2.start();
      t3.start();
    }
    catch (Exception e) {

    }
  }
}