package day13;

import java.util.Scanner;

public class Recur {
    //재귀함수
    static void recur(int n) {
        if(n > 0) {
            recur(n - 1);
//            System.out.println("=================================");
            System.out.println(n);
//            System.out.println("---------------------------------");
            recur(n - 2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 입력하세요: ");
        int x = sc.nextInt();

        recur(x);
    }
}
