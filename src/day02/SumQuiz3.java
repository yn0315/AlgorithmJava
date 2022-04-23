package day02;

import java.util.Scanner;

public class SumQuiz3 {
    //정수 a,b 사이의 모든 정수의 합을 구하여 반환하는 메서드를 작성

    static int sumOf(int a, int b) {

        int sum = 0;

        for(int i = a; i <=b; i++) {
            sum += i;
        }

        return sum;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("a의 값:");
        int a = sc.nextInt();
        System.out.print("b의 값:");
        int b = sc.nextInt();
        int result = sumOf(a,b);

        System.out.printf("%d 부터 %d 까지의 합은 %d 입니다.", a, b, result);

        sc.close();

    }
}
