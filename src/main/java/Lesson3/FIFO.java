package Lesson3;

import java.io.BufferedInputStream;
import java.util.*;

public class FIFO {
    private int n;//内存储页框
    private int m;//访问次数
    private int F;//，没能直接找到的次数,F/m为缺页率
    private List<Integer> list = null;//访问地址走向
    private Map<Integer,Integer> map = null;
    
    public FIFO(){
        F=0;
        map = new HashMap<Integer, Integer>();//存储每个内储页框所存的内容
        list = new ArrayList<Integer>();
        Scanner cin = new Scanner(new BufferedInputStream(System.in));
        System.out.println("请输入用户访问页地址走向:");
        String s = cin.nextLine();
        String []s1 = s.split(" ");
        m = s1.length;
        for(int i = 0;i<m;i++)
            list.add(Integer.valueOf(s1[i]));
        System.out.println("请输入内储叶框数量");
        n = cin.nextInt();
    }

    public void replace(){
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0;i<m;i++){
            int k = list.get(i);//待处理元素
            if(!map.containsValue(k)){
                F++;//不能直接找到次数加1
                if(map.size()<n){//如果没有装满
                    int temp = map.size();
                    map.put(temp,k);
                    q.offer(temp);
                }else{
                    int temp = q.poll();//排除的元素位置
                    map.remove(temp);
                    map.put(temp,k);
                    q.offer(temp);
                }
            }
        }
        System.out.println("误码率为:"+F*1.0/m);
    }

    public static void main(String...args){
        FIFO fifo = new FIFO();
        fifo.replace();
    }
}
