package day02;

import java.util.Scanner;

public class CountQuiz2 {

    //자릿수 세기, 123 을 입력받으면 '그 수는 3자리입니다.'출력
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("숫자를 입력하세요.");
        System.out.print(">>");
        int n = sc.nextInt();

        //형변환 후 길이 세는 방법
       String num = String.valueOf(n);

        int result = num.length();

        System.out.printf("그 수는 %d 자리입니다.", result);

    }
}
