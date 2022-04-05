package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 身高从低到高
 * 身高相同体重从轻到重
 * 体重相同维持原来顺序
 * 输入
 * 4
 * 100 100 120 130
 * 40 30 60 50
 * 输出：
 * 2 1 3 4
 * 输入
 * 3
 * 90 110 90
 * 45 60 45
 * 输出
 * 1 3 2
 */
public class Demo1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        String heightStr = in.nextLine();
        String weightStr = in.nextLine();
        String[] heightStrA = heightStr.split(" ");
        String[] weightStrA = weightStr.split(" ");
        int[][] ints = new int[N][3];
        for (int i = 0; i < N; i++) {
            ints[i][0] = i +1 ;
            ints[i][1] = Integer.parseInt(heightStrA[i]);
            ints[i][2] = Integer.parseInt(weightStrA[i]);
        }
        method02(N, heightStrA, weightStrA, ints);

//        method01(N, heightStrA, weightStrA);
    }

    private static void method02(int N, String[] heightStrA, String[] weightStrA, int[][] ints) {

        Arrays.sort(ints, new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                if (arr1[1] == arr2[1]) {
                    return arr1[2] - arr2[2];
                } else {
                    return arr1[1] - arr2[1];
                }
            }
        });
        for (int i = 0; i < N; i++) {
            System.out.print(ints[i][0]+ " ");
        }
    }

    private static void method01(int N, String[] heightStrA, String[] weightStrA) {
        ArrayList<Student> students = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            Student student = new Student(i + 1, Integer.parseInt(heightStrA[i]), Integer.parseInt(weightStrA[i]));
            students.add(student);
        }
        students.stream().sorted((s1, s2) -> {
            if (!s1.height.equals(s2.height)) {
                return s1.height - s2.height;
            }
            if (!s1.weight.equals(s2.weight)) {
                return s1.weight - s2.weight;
            }
            return 0;
        }).map(Student::getId).forEach(v -> System.out.print(v + " "));
    }

    static class Student {
        private Integer id;
        private Integer height;
        private Integer weight;


        public Student() {
        }

        public Student(Integer id, Integer height, Integer weight) {
            this.id = id;
            this.height = height;
            this.weight = weight;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Student student = (Student) o;

            if (id != null ? !id.equals(student.id) : student.id != null) return false;
            if (height != null ? !height.equals(student.height) : student.height != null) return false;
            return weight != null ? weight.equals(student.weight) : student.weight == null;
        }

        @Override
        public int hashCode() {
            int result = id != null ? id.hashCode() : 0;
            result = 31 * result + (height != null ? height.hashCode() : 0);
            result = 31 * result + (weight != null ? weight.hashCode() : 0);
            return result;
        }
    }
}
