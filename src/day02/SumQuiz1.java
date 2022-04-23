package day02;

import java.util.Scanner;

public class SumQuiz1 {
    //n이 3이면 1 + 2 + 3 = 6 으로 출력하는 프로그램을 작성
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1부터 n까지의 합을 구합니다.");
        System.out.print("n의 값:");
        int n = sc.nextInt();

        int i = 1;
        int sum = 0;
        String result = "";

        while (i <=n) {

            sum += i;

            if(i == n) {
                result += i;
            } else {
                result += i + " + ";
            }//end if

            i++;

        }//end while

        System.out.printf("%s = %d", result, sum);

        sc.close();
    }
}
