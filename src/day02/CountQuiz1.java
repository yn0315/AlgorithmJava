package day02;

import java.util.Scanner;

public class CountQuiz1 {
    //자릿수 세기, 123 을 입력받으면 '그 수는 3자리입니다.'출력
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("숫자를 입력하세요.");
        System.out.print(">>");
        int n = sc.nextInt();

        int result = (int)Math.log10(n) + 1;//함수사용하는 방법

        System.out.printf("그 수는 %d 자리입니다.", result);

    }
}
