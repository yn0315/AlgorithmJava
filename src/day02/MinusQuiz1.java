package day02;

import java.util.Scanner;

public class MinusQuiz1 {
    //a,b를 받고 b-a를 출력하는 프로그램 작성, b가 a 이하면 다시 입력받기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("뺄셈을 시작합니다. 값을 입력해주세요.");
        System.out.print("a:");
        int a = sc.nextInt();
        System.out.print("b:");
        int b = sc.nextInt();

        int minus = b - a;

        if(b <= a) {
            System.out.println("다시 입력해주세요.");
            System.out.print("b:");
            b = sc.nextInt();
            minus = b - a;
        }

        System.out.printf("%d - %d 의 값은 %d 입니다.", b, a, minus);
    }
}
