package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *   公司用一个字符串来标识员工的出勤信息
 *
 *   absent:    缺勤
 *   late:      迟到
 *   leaveearly:早退
 *   present:   正常上班
 *
 *   现需根据员工出勤信息,判断本次是否能获得出勤奖,
 *   能获得出勤奖的条件如下：
 *       1.缺勤不超过1次
 *       2.没有连续的迟到/早退
 *       3.任意连续7次考勤 缺勤/迟到/早退 不超过3次
 *
 *    输入描述：
 *     用户的考勤数据字符串记录条数  >=1
 *     输入字符串长度 <10000 ;
 *     不存在非法输入
 *     如：
 *      2
 *      present
 *      present absent present present leaveearly present absent
 *
 *     输出描述：
 *     根据考勤数据字符串
 *     如果能得到考勤奖输出true否则输出false
 *     对于输出示例的结果应为
 *      true false
 *
 *     示例一：
 *      输入：
 *       2
 *       present
 *       present present
 *
 *      输出：
 *       true true
 *
 *     示例二
 *      输入：
 *       2
 *       present
 *       present absent present present leaveearly present absent
 *      输出：
 *       true false
 */
public class Test59 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<List<String>> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] split = sc.nextLine().split(" ");
            ArrayList<String> list = Arrays.stream(split).collect(Collectors.toCollection(ArrayList::new));
            lists.add(list);
        }
        StringBuilder sb = new StringBuilder();
        for (List<String> list : lists) {
            boolean res = checkPresent(list);
            sb.append(res).append(" ");
        }

        System.out.println(sb);
    }

    private static boolean checkPresent(List<String> list) {
        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        boolean flag = true;
        String str = "late leaveearly";
        String str2 = "late leaveearly absent";
        if (list.size() <= 7) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals("absent")) {
                    cnt1++;
                }
                if (i != list.size() - 1 && str.contains(list.get(i)) && str.contains(list.get(i + 1))) {
                    cnt2++;
                }
            }
            if (cnt1 > 1 || cnt2 > 0) {
                flag = false;
            }
        }else {
            for (int i = 0; i < list.size(); i++) {
                List<String> strings = list.subList(i, 7);
                for (String s : strings) {
                    if (str2.contains(s)) {
                        cnt3++;
                    }
                }
                if (cnt3 > 3) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
}
