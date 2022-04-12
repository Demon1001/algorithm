package com.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 *   运维工程师采集到某产品线网运行一天产生的日志n条
 *   现需根据日志时间先后顺序对日志进行排序
 *   日志时间格式为H:M:S.N
 *   H表示小时(0~23)
 *   M表示分钟(0~59)
 *   S表示秒(0~59)
 *   N表示毫秒(0~999)
 *   时间可能并没有补全
 *   也就是说
 *   01:01:01.001也可能表示为1:1:1.1
 *
 *   输入描述
 *      第一行输入一个整数n表示日志条数
 *      1<=n<=100000
 *      接下来n行输入n个时间
 *
 *    输出描述
 *      按时间升序排序之后的时间
 *      如果有两个时间表示的时间相同
 *      则保持输入顺序
 *
 *    示例：
 *      输入：
 *       2
 *       01:41:8.9
 *       1:1:09.211
 *      输出
 *        1:1:09.211
 *        01:41:8.9
 *    示例
 *       输入
 *        3
 *        23:41:08.023
 *        1:1:09.211
 *        08:01:22.0
 *       输出
 *         1:1:09.211
 *         08:01:22.0
 *         23:41:08.023
 *
 *     示例
 *       输入
 *         2
 *         22:41:08.023
 *         22:41:08.23
 *       输出
 *         22:41:08.023
 *         22:41:08.23
 *       时间相同保持输入顺序
 */
public class Test78 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            list.add(line);
        }
        list.stream().sorted((o1, o2) -> {
            String[] arr1 = o1.split(":");
            String[] arr2 = o2.split(":");
            int h1 = Integer.parseInt(arr1[0]);
            int h2 = Integer.parseInt(arr2[0]);
            int m1 = Integer.parseInt(arr1[1]);
            int m2 = Integer.parseInt(arr2[1]);
            String[] split1 = arr1[2].split("\\.");
            String[] split2 = arr2[2].split("\\.");
            int s1 = Integer.parseInt(split1[0]);
            int s2 = Integer.parseInt(split2[0]);
            int ms1 = Integer.parseInt(split1[1]);
            int ms2 = Integer.parseInt(split2[1]);
            if (h1 != h2) {
                return h1 - h2;
            }
            if (m1 != m2) {
                return m1 - m2;
            }
            if (s1 != s2) {
                return s1 - s2;
            }
            if (ms1 != ms2) {
                return ms1 - ms2;
            }
            return 0;
        }).forEach(System.out::println);
    }
}
