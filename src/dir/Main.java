package dir;

import dir.lib.solution_2.*;
import static dir.solution_2.Solution.*;

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
	// write your code here
        int[] test1 = {1,2,3,4,5,6,7,8};
        int[] test2 = {2,3,4};
        int[] test3;
        test3 = test1;
        test3[0] = 200;
        printIntArray(test1);

    }
}
