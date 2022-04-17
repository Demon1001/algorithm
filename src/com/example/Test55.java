package com.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *          单词接龙的规则是
 *         可用于接龙的单词首字母必须要与前一个单词的尾字母相同
 *         当存在多个首字母相同的单词时
 *         取长度最长的单词
 *         如果长度也相等则取词典序最小的单词
 *         已经参与接龙的单词不能重复使用
 *         现给定一组全部由小写字母组成的单词数组
 *         并指定其中的一个单词为起始单词
 *         进行单词接龙
 *         请输出最长的单词串
 *         单词串是由单词拼接而成 中间没有空格
 *
 *         输入描述：
 *             输入的第一行为一个非负整数
 *             表示起始单词在数组中的索引k  0<=k<=n
 *             第二行输入的是一个非负整数表示单词的个数n
 *             接下来的n行分别表示单词数组中的单词
 *
 *         输出描述：
 *             输出一个字符串表示最终拼接的字符串
 *
 *         示例1：
 *         输入
 *           0
 *           6
 *           word
 *           dd
 *           da
 *           dc
 *           dword
 *           d
 *
 *         输出
 *           worddwordda
 *
 *         说明：
 *         先确定起始单词word
 *         再确定d开头长度最长的单词dword
 *         剩余以d开头且长度最长的由 da dd dc
 *         则取字典序最小的da
 *         所以最后输出worddwordda
 *
 *         示例二：
 *         输入：
 *             4
 *             6
 *             word
 *             dd
 *             da
 *             dc
 *             dword
 *             d
 *          输出：
 *          dwordda
 */
public class Test55 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = Integer.parseInt(sc.nextLine());
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            strings.add(sc.nextLine());
        }
        LinkedList<String> link = new LinkedList<>(strings);
        String first = link.get(k);
        String tail = first.substring(first.length() - 1);
        link.remove(k);
        StringBuilder sb = new StringBuilder();
        sb.append(first);
        for (int i = 0; i < strings.size(); i++) {
            String finalTail = tail;
            LinkedList<String> linkList = link.stream().filter(s -> s.startsWith(finalTail)).sorted((s1, s2) -> {
                if (s1.length() != s2.length()) {
                    return s2.length() - s1.length();
                }
                return s1.compareTo(s2);
            }).collect(Collectors.toCollection(LinkedList::new));
            if (linkList.size() == 0) {
                break;
            }
            String first1 = linkList.getFirst();
            sb.append(first1);
            tail = first1.substring(first1.length() - 1);
            link.remove(first1);
        }
        System.out.println(sb);
    }
}
