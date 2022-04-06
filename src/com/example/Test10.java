package com.example;

import java.util.*;

/*
        给定两个字符串
        从字符串2中找出字符串1中的所有字符
        去重并按照ASCII码值从小到大排列
        输入字符串1长度不超过1024
        字符串2长度不超过100

        字符范围满足ASCII编码要求，按照ASCII由小到大排序

        输入描述：
         bach
         bbaaccddfg
         输出
          abc

          2
          输入
          fach
          bbaaccedfg
          输出
          acf

         */
public class Test10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        String messageStr = sc.nextLine();
        String[] split = word.split("");
        TreeSet<String> treeSet = new TreeSet<>();
        for (String s : split) {
            if (messageStr.contains(s)) {
                treeSet.add(s);
            }
        }
        treeSet.forEach(System.out::print);
    }
}
