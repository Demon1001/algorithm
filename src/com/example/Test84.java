package com.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 *    小组中每位都有一张卡片
 *   卡片是6位以内的正整数
 *   将卡片连起来可以组成多种数字
 *   计算组成的最大数字
 *
 *   输入描述：
 *     ","分割的多个正整数字符串
 *     不需要考虑非数字异常情况
 *     小组种最多25个人
 *
 *    输出描述：
 *      最大数字字符串
 *
 *    示例一
 *      输入
 *       22,221
 *      输出
 *       22221
 *
 *     示例二
 *       输入
 *         4589,101,41425,9999
 *       输出
 *         9999458941425101
 */
public class Test84 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(",");
        StringBuilder sb = new StringBuilder();
        Arrays.sort(split, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] split1 = o1.split("");
                String[] split2 = o2.split("");
                int len1 = split1.length;
                int len2 = split2.length;
                if (split1.length == split2.length) {
                    return Integer.parseInt(o2) - Integer.parseInt(o1);
                }
                int min = Math.min(len1, len2);
                for (int i = 0; i < min; i++) {
                    String s1 = split1[i];
                    String s2 = split2[i];
                    if (!s1.equals(s2)) {
                        return Integer.parseInt(s2) - Integer.parseInt(s1);
                    }
                }

                if (len1 > len2) {
                    return Integer.parseInt(split1[0]) - Integer.parseInt(split1[split2.length]);
                } else {
                    return Integer.parseInt(split2[0]) - Integer.parseInt(split2[split1.length]);
                }

            }
        });
        for (String s : split) {
            sb.append(s);
        }
        System.out.println(sb);
    }
}
