package day04;

import java.util.Scanner;

public class ArrayEqual {

    //두 배열이 같은지 판단
    public static boolean equals(int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("배열 a의 길이: ");
        int na = sc.nextInt();

        int[] a = new int[na];

        for (int i = 0; i < a.length; i++) {
            System.out.print("a[" + i + "]: ");
            a[i] = sc.nextInt();
        }

        System.out.println("배열 b의 길이: ");
        int nb = sc.nextInt();

        int[] b = new int[nb];

        for (int i = 0; i < b.length; i++) {
            System.out.print("b[" + i + "]: ");
            b[i] = sc.nextInt();
        }

        System.out.println("배열 a 와 b 는 " + (equals(a,b)? "같습니다.":"같지 않습니다."));

        sc.close();
    }
}
