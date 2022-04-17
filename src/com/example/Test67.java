package com.example;

import java.util.Scanner;

/**
 * 给定一个字符串S
 *
 *         变化规则:
 *          交换字符串中任意两个不同位置的字符
 *
 *         输入描述：
 *          一串小写字母组成的字符串
 *         输出描述：
 *          按照要求变换得到最小字符串
 *
 *         实例1：
 *          输入：、
 *          abcdef
 *         输出
 *          abcdef
 *
 *         实例2：
 *          输入
 *          bcdefa
 *          输出
 *          acdefb
 *
 *         s都是小写字符组成
 *         1<=s.length<=1000
 */
public class Test67 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] chars = sc.nextLine().toCharArray();
        char temp = chars[0];
        int pos = 0;
        for (int i = 1; i <chars.length; i++) {
            char cur = chars[i];
            if (cur <= temp) {
                temp = cur;
                pos = i;
            }
        }
        if (pos != 0) {
            chars[pos] =chars[0];
            chars[0] = temp;
        }
        System.out.println(new String(chars));
    }
}
