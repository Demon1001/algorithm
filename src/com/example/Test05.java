package com.example;

import java.util.Scanner;

/**
 *           一天一只顽猴想要从山脚爬到山顶
 *           途中经过一个有n个台阶的阶梯，但是这个猴子有个习惯，每一次只跳1步或3步
 *           试问？猴子通过这个阶梯有多少种不同的跳跃方式
 *
 *           输入描述：
 *             输入只有一个这个数n    0<n<50
 *             此阶梯有多个台阶
 *           输出描述：
 *             有多少种跳跃方式
 *
 *           实例:
 *            输入
 *              50
 *            输出
 *               122106097
 *
 *            输入
 *               3
 *            输出
 *               2
 */
public class Test05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int f1 = 1;
        int f2 = 1;
        int f3 = 2;
        int f4 = n == 1 || n == 2 ? 1 : 2;
        for (int i = 4; i <= n; i++) {
            f4 = f3 + f1;
            f1 = f2;
            f2 = f3;
            f3 = f4;
        }

        System.out.println(f4);

        sc.close();
    }
}
