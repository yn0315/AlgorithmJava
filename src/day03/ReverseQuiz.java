package day03;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseQuiz {

    //배열 역순으로 정렬하기
    public static void swap(int[] a, int idx1, int idx2) {
        //배열 요소 바꾸는 메서드

        System.out.printf("a[%d] 와 a[%d] 를 교환합니다.\n", idx1, idx2);
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;

        System.out.println(Arrays.toString(a));


    }//end swap

    private static void reverse(int[] a) {
        System.out.println(Arrays.toString(a));
        for (int i = 0; i < a.length / 2; i++) {//앞뒤로 교환하니까 범위가 반
            swap(a, i, a.length - i - 1);
        }
    }//end reverse

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("요솟수: ");
        int num = sc.nextInt();

        int[] x = new int[num];

        for (int i = 0; i < x.length; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = sc.nextInt();
        }

        reverse(x);

        System.out.println("역순정렬을 마쳤습니다.");

        System.out.println("요소를 역순으로 정렬했습니다.");
        for (int i = 0; i < x.length; i++) {
            System.out.print("x[" + i + "]: " + x[i]);
        }
    }

}
