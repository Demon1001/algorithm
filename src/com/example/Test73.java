package com.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 给出一个只包含字母的字符串,
 *     不包含空格,统计字符串中各个子字母(区分大小写)出现的次数,
 *     并按照字母出现次数从大到小的顺序输出各个字母及其出现次数
 *     如果次数相同,按照自然顺序排序,且小写字母在大写字母之前
 *
 *     输入描述:
 *       输入一行仅包含字母的字符串
 *
 *     输出描述:
 *       按照字母出现次数从大到小的顺序输出各个字母和字母次数,
 *       用英文分号分割,
 *       注意末尾的分号
 *       字母和次数中间用英文冒号分隔
 *
 *     示例:
 *         输入: xyxyXX
 *         输出:x:2;y:2;X:2;
 *     说明:每个字符出现的次数为2 故x排在y之前
 *     而小写字母x在大写X之前
 *
 *     示例2:
 *         输入:
 *          abababb
 *         输出:
 *             b:4;a:3
 *         说明:b的出现个数比a多 故排在a前
 */
public class Test73 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] chars = sc.nextLine().toCharArray();
        HashMap<Character, Integer> res = new HashMap<>();
        for (char aChar : chars) {
            Integer v = res.getOrDefault(aChar, 0);
            res.put(aChar, v + 1);
        }
        StringBuilder sb = new StringBuilder();
        res.keySet().stream().sorted((k1, k2) -> {
            int v1 = res.get(k1);
            int v2 = res.get(k2);
            if (v2 != v1) {
                return v2 - v1;
            }
            if (Character.isLowerCase(k1) && !Character.isLowerCase(k2)) {
                return -1;
            }
            if (Character.isLowerCase(k2) && !Character.isLowerCase(k1)) {
                return 1;
            }
            return k1.compareTo(k2);
        }).forEach(k -> sb.append(k).append(":").append(res.get(k)).append(";"));
        System.out.println(sb.substring(0, sb.length() - 1));
    }
}
