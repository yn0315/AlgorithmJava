package day04;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ReverseCopyArray {


    //배열 b의 모든 요소를 배열 a에 역순으로 복사하는 메서드
    public static void copy(int[]a, int[]b) {
        int[] temp = new int[b.length];

        for (int i = 0; i < b.length; i++) {
            temp[i] = b[b.length - i - 1];
        }
        a = temp;
        temp= null;

        System.out.println("배열 b : " + Arrays.toString(b));
        System.out.println("배열 a : " + Arrays.toString(a));

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        System.out.println("배열 a에 b를 역순으로 복사합니다.");
        System.out.println("배열 b의 길이: ");
        int n = sc.nextInt();

        int[] b = new int[n];
        int[] a = new int[]{};

        for(int i = 0; i < b.length; i++) {
            b[i] = random.nextInt(100);
            System.out.print("배열 b[" + i + "]: " + b[i]);
            System.out.println();

        }

        copy(a,b);

        sc.close();
    }
}
