package com.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


/**
 * 定义当一个字符串只有元音字母(a,e,i,o,u,A,E,I,O,U)组成,
 *     称为元音字符串，现给定一个字符串，请找出其中最长的元音字符串，
 *     并返回其长度，如果找不到请返回0，
 *     字符串中任意一个连续字符组成的子序列称为该字符串的子串
 *
 *     输入描述：
 *       一个字符串其长度 0<length ,字符串仅由字符a-z或A-Z组成
 *     输出描述：
 *       一个整数，表示最长的元音字符子串的长度
 *
 *     示例1：
 *       输入
 *         asdbuiodevauufgh
 *       输出
 *         3
 *       说明：
 *         最长的元音字符子串为uio和auu长度都为3，因此输出3
 */
public class Test66 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] chars = str.toCharArray();
        ArrayList<String> strings = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            if (checkChar(chars[i])) {
                int len = 1;
                for (int j = i + 1; j < chars.length; j++) {
                    if (checkChar(chars[j])) {
                        len++;
                    } else {
                        break;
                    }
                }
                max = Math.max(len, max);
            }
        }
        System.out.println(max);
    }

    private static boolean checkChar(char aChar) {
        List<Character> list = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        return list.contains(aChar);
    }

}
