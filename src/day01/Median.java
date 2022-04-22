package day01;

import java.util.Scanner;

public class Median {

    //중앙값 구하기
    static int med3(int a, int b, int c) {
        if(a >= b) {
            if (b >= c) {
                return b;

            }else if(a <= c){
                return a;

            }else {
                return c;

            }//end inner if
        }else if(a > c) {
            return a;

        }else if(b > c) {
            return c;

        }else {
            return b;

        }//end outer if
    }//end med3

    //비교연산자를 이용한 메소드, 효율 떨어짐
    static int median3(int a, int b, int c) {
        if((b >= a && c <= a) || (b <=a && c >=a)) {
            return a;
        }else if((a > b && c < b) || (a < b && c > b)) {
            return b;
        }else {
            return c;
        }
    }//end median3

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("세 정수의 중앙값을 구합니다.");
        System.out.print("a의 값: ");
        int a = sc.nextInt();
        System.out.print("b의 값: ");
        int b = sc.nextInt();
        System.out.print("c의 값: ");
        int c = sc.nextInt();

        System.out.printf("중앙값은 %d 입니다.", med3(a,b,c));

        sc.close();
    }//end main

}//end class
