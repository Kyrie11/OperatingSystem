package Lesson3;

import java.io.BufferedInputStream;
import java.util.*;

public class LRU {
    private int n;//内存储页框
    private int m;//访问次数
    private int F;//，没能直接找到的次数,F/m为缺页率
    private List<Integer> list = null;//访问地址走向
    private Map<Integer,Integer> map = null;

    public LRU(){
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

    //替换算法
    public void replace(){
        List<Integer> linkedList = new LinkedList<Integer>();
        int start = 0;
        for(int i=0;i<m;i++){
            int k=list.get(i);
            if(!map.containsKey(k)){
                F++;
                if(map.size()<n){
                    int temp = map.size();
                    map.put(k,temp);
                    linkedList.add(k);//添加位置
                }
                else{
                    int temp = linkedList.get(0);
                    int c = map.get(temp);
                    map.remove(temp);
                    map.put(k,c);
                    ((LinkedList<Integer>) linkedList).remove(0);
                    linkedList.add(k);
                }
            }
            else{
                int d = linkedList.indexOf(k);
                ((LinkedList<Integer>) linkedList).remove(d);
                linkedList.add(k);
            }
        }
        System.out.println("误码率为:"+F*1.0/m);
    }

    public static void main(String...args){
        LRU lru = new LRU();
        lru.replace();
    }
}
