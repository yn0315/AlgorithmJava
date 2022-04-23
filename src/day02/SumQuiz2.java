package day02;

import java.util.Scanner;

public class SumQuiz2 {

    //1부터 10 까지의 합은 (1+10)*5 같은 방법으로 구할 수 있다. 가우스의 덧셈을 이용하여
    //1부터 n 까지의 정수 합을 구하는 프로그램 작성
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("가우스의 덧셈을 활용하여 계산합니다.");
        System.out.print("n의 값:");
        int n = sc.nextInt();

        int sum = sum = (1 + n) * (n/2);

        if(n == 0) {
            System.out.println("프로그램을 종료합니다.");
        }else if(n % 2 != 0){//n이 홀수일 때
            sum = (1 + (n - 1)) * ((n -1)/2) + n;
        }

        System.out.printf("결과: %d", sum);

        sc.close();
    }
}
