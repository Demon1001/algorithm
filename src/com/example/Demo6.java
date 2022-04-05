package com.example;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 主管期望你来实现英文输入法单词联想功能
 *          需求如下
 *          依据用户输入的单词前缀
 *          从已输入的英文语句中联想出用户想输入的单词
 *          按字典序输出联想到的单词序列
 *          如果联想不到
 *          请输出用户输入的单词前缀
 *          注意
 *          英文单词联想时区分大小写
 *          缩略形式如
 *          "don't" 判定为两个单词 "don"和 "t"
 *          输出的单词序列不能有重复单词
 *          且只能是英文单词，不能有标点符号
 *
 *          输入描述
 *          输入两行
 *          首行输入一段由英文单词word和标点构成的语句str
 *
 *          接下来一行为一个英文单词前缀pre
 *          0 < word.length() <= 20
 *          0 < str.length <= 10000
 *          0 < pre <=20
 *
 *          输出描述
 *          输出符合要求的单词序列或单词前缀
 *          存在多个时，单词之间以单个空格分割
 *
 *          示例一
 *          输入
 *            I love you
 *            He
 *
 *           输出
 *             He
 *
 *           说明
 *             用户已输入单词语句"I love you",
 *             中提炼出"I","love","you"三个单词
 *             接下来用户输入"He" ，
 *             从已经输入信息中无法联想到符合要求的单词
 *             所以输出用户输入的单词前缀
 *
 *             示例二
 *             输入
 *             The furthest distance in the world,Is not between life and death,But when I stand in front or you,Yet you don't know that I love you.
 *             f
 *
 *             输出
 *             front furthest
 */
public class Demo6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] messageStr = sc.nextLine().split(" ");
        String word = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for (String s : messageStr) {
            if (s.startsWith(word)) {
                sb.append(s).append(" ");
            }
        }
        if (sb.toString().length() == 0) {
            System.out.println(word);
        } else {
            System.out.println(sb);
        }
    }
}