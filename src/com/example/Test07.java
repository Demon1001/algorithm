package com.example;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *          小明今年升学到了小学1年纪
 *          来到新班级后，发现其他小朋友身高参差不齐
 *          然后就想基于各小朋友和自己的身高差，对他们进行排序
 *          请帮他实现排序
 *          输入描述
 *           第一行为正整数 h和n
 *           0<h<200 为小明的身高
 *           0<n<50 为新班级其他小朋友个数
 *           第二行为n各正整数
 *            h1 ~ hn分别是其他小朋友的身高
 *          取值范围0<hi<200
 *          且n个正整数各不相同
 *
 *          输出描述
 *           输出排序结果，各正整数以空格分割
 *           和小明身高差绝对值最小的小朋友排在前面
 *           和小明身高差绝对值最大的小朋友排在后面
 *           如果两个小朋友和小明身高差一样
 *           则个子较小的小朋友排在前面
 *
 *           示例一
 *           输入
 *           100 10
 *           95 96 97 98 99 101 102 103 104 105
 *           输出
 *            99 101 98 102 97 103 96 104 95 105
 *
 *           说明  小明身高100
 *           班级学生10个  身高分别为
 */
public class Test07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line01 = sc.nextLine().split(" ");
        String[] line02 = sc.nextLine().split(" ");
        int h = Integer.parseInt(line01[0]);
        int n = Integer.parseInt(line01[1]);
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (String s : line02) {
            int k = Math.abs(Integer.parseInt(s) - h);
            Set<Integer> orDefault = map.getOrDefault(k, new TreeSet<>());
            orDefault.add(Integer.parseInt(s));
            map.put(k, orDefault);
        }
        map.keySet().stream().sorted().forEach(
                a->{
                    map.get(a).forEach(
                            v-> System.out.print(v + " ")
                    );
                }
        );
    }

}
