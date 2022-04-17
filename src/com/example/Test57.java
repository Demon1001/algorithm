package com.example;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *     给定一个字符串
 *     只包含大写字母
 *     求在包含同一字母的子串中
 *     长度第K长的子串
 *     相同字母只取最长的子串
 *
 *     输入
 *      第一行 一个子串 1<len<=100
 *      只包含大写字母
 *      第二行为k的值
 *
 *      输出
 *      输出连续出现次数第k多的字母的次数
 *
 *      例子：
 *      输入
 *              AABAAA
 *              2
 *      输出
 *              1
 *        同一字母连续出现最多的A 3次
 *        第二多2次  但A出现连续3次
 *
 *     输入
 *
 *     AAAAHHHBBCDHHHH
 *     3
 *
 *     输出
 *     2
 *
 * //如果子串中只包含同一字母的子串数小于k
 *
 * 则输出-1
 */
public class Test57 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] chars = sc.nextLine().toCharArray();
        int k = Integer.parseInt(sc.nextLine());
        HashMap<Character, Integer> resMap= new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            int cnt = 1;
            for (int j = i+1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    cnt++;
                }
            }
            Integer v = resMap.getOrDefault(chars[i], 0);
            resMap.put(chars[i], Math.max(v, cnt));
        }
        List<Integer> res = resMap.values().stream().sorted(Integer::compareTo).collect(Collectors.toList());
        if (res.size() < k) {
            System.out.println("-1");
        } else {
            int r = res.get(res.size() - k);
            System.out.println(r);
        }
    }

}
