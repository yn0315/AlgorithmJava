package day02;

import java.util.Scanner;

public class SumForPos {
    //양수만 입력받기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        System.out.println("1부터 n 까지의 합을 구합니다.");

        do{
            System.out.print("n의 값:");
            n = sc.nextInt();
        }while (n <=0);//0이나 음수값을 입력받으면 다시 반복하는 구조

        int sum = 0;

        for (int i = 1; i <=n; i++) {
            sum += i;
        }

        System.out.printf("1 부터 %d 까지의 합은 %d 입니다.", n, sum);
    }
}
