package com.example;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *         游戏规则：输入一个只包含英文字母的字符串，
 *         字符串中的俩个字母如果相邻且相同，就可以消除。
 *         在字符串上反复执行消除的动作，
 *         直到无法继续消除为止，
 *         此时游戏结束。
 *         输出最终得到的字符串长度。
 *
 *         输出：原始字符串str只能包含大小写英文字母，字母的大小写敏感，长度不超过100，
 *         输出游戏结束后字符串的长度
 *
 *         备注：输入中包含非大小写英文字母是均为异常输入，直接返回0。
 *
 *         事例：mMbccbc输出为3
 */
public class Test69 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String s = str.replaceAll("[a-z]", "").replaceAll("[A-Z]", "");
        if (s.length() > 1) {
            System.out.println("0");
        }
        char[] chars = str.toCharArray();
        LinkedList<Character> list = new LinkedList<>();
        for (Character s1 : chars) {
            list.add(s1);
        }
        for (int i = 0; i < list.size()-1; ) {
            if (list.get(i) == list.get(i + 1)) {
                list.remove(i);
                list.remove(i);
                i--;
            } else {
                i++;
            }
        }
        System.out.println(list.size());

    }

}
