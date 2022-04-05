package com.example;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *         如果三个正整数A B C ,A²+B²=C²则为勾股数
 *          如果ABC之间两两互质，即A与B A与C B与C均互质没有公约数，
 *          则称其为勾股数元组。
 *         请求出给定n m 范围内所有的勾股数元组
 *         输入描述
 *           起始范围 1<n<10000    n<m<10000
 *         输出描述
 *            abc 保证a<b<c输出格式  a b c
 *            多组勾股数元组 按照a升序b升序 c升序的排序方式输出。
 *        给定范围内，找不到勾股数元组时，输出  Na
 *
 *         案例
 *          输入
 *           1
 *           20
 *          输出
 *           3 4 5
 *           5 12 13
 *           8 15 17
 *
 *          输入
 *            5
 *            10
 *          输出
 *            Na
 */
public class Test01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int m = Integer.parseInt(sc.nextLine());
        ArrayList<String> resultStr = new ArrayList<>();
        for (int i = n; i < m; i++) {
            for (int j = i; j < m; j++) {
                for (int k = j; k < m; k++) {
                    if ((i * i + j * j == k * k)
                            && huzhi(i,j) == 1
                            && huzhi(i,k) == 1
                            && huzhi(k,j) == 1
                    ) {
                        resultStr.add(i + " " + j + " " + k);
                    }
                }
            }

        }
        if (resultStr.size() == 0) {
            System.out.println("Na");
        } else {
            for (String result : resultStr) {
                System.out.println(result);
            }
        }
    }

    /**
     * 互质判定
     * @param a
     * @param b
     * @return
     */
    private static int huzhi(int a, int b) {
        if (a == 0 || b == 0 ||a == b) {
            return 1;
        }
        if (a % b == 0) {
            return b ;
        } else {
            return huzhi(b, a % b) ;
        }
    }
}
