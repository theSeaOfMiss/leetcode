package dir;

import dir.lib.solution_2.*;

import java.util.Stack;

import static dir.solution_2.Solution.*;
import static dir.solution_5.Solution.*;
import static dir.solution_7.Solution.*;
import static dir.solution_8.Solution.*;

public class Main {

    private static void printIntArray(int[] data) {
        for (int d:data) {
            System.out.print(d+",");
        }
    }

    //java是引用参数
    public static int[] test(int[] t) {
        t[0] = 100;
        System.out.println("函数内t[0]:"+t[0]);
        return t;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("9128347239"));
       int res = 9;
       int max = Integer.MAX_VALUE;
       res += Math.pow(10, 10);
       System.out.println(res);

    }
}
