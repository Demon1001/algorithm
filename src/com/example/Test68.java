package com.example;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 定一个随机的整数数组(可能存在正整数和负整数)nums,
 * 请你在该数组中找出两个数，其和的绝对值(|nums[x]+nums[y]|)为最小值
 * 并返回这两个数(按从小到大返回)以及绝对值。
 * 每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 输入描述：
 * 一个通过空格空格分割的有序整数序列字符串，最多1000个整数，
 * 且整数数值范围是[-65535,65535]
 * <p>
 * 输出描述：
 * 两个数和两数之和绝对值
 * <p>
 * 示例一：
 * 输入
 * -1 -3 7 5 11 15
 * 输出
 * -3 5 2
 * <p>
 * 说明：
 * 因为|nums[0]+nums[2]|=|-3+5|=2最小，
 * 所以返回-3 5 2
 */
public class Test68 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] sp = sc.nextLine().split(" ");
        HashMap<Integer, TreeSet<Integer>> mp = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < sp.length; i++) {
            for (int j = i + 1; j < sp.length; j++) {
                int sum = 0;
                TreeSet<Integer> treeSet = new TreeSet<>();
                int m = Integer.parseInt(sp[i]);
                int n = Integer.parseInt(sp[j]);
                sum = Math.abs(m + n);
                treeSet.add(m);
                treeSet.add(n);
                mp.put(sum, treeSet);
                min = Math.min(min, sum);
            }
        }
        System.out.println(mp.get(min).first() + " " + mp.get(min).last() + " " + min);
    }

}
