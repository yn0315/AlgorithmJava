package day03;

import java.util.Arrays;
import java.util.Scanner;

public class SumArrayQuiz {

    //배열 요소 합계구하기
    public static int sumOf(int[] a) {
        int sum = 0;
        for(int i = 0; i < a.length; i++) {
            sum += a[i];

        }
        return sum;

    }//end sumOf


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("요솟수: ");
        int num = sc.nextInt();

        int[] x = new int[num];

        for (int i = 0; i < x.length; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = sc.nextInt();
        }

        System.out.println("요소의 합계를 구했습니다.");
        System.out.printf("요소의 합: %d", sumOf(x));

    }
}
