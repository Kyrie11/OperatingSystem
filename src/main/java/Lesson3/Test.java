package Lesson3;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Test {
    public static void main(String...args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        String s = in.nextLine();
        String s1[] = s.split(" ");
        for(int i=0;i<s1.length;i++)
            System.out.println(s1[i]);
    }
}
