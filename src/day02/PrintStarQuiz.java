package day02;

import java.util.Scanner;

public class PrintStarQuiz {
    //입력한 수를 한 변으로 하는 정사각형을 *기호로 출력하기
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("사각형을 출력합니다.");
        System.out.print("단수:");
        int n = sc.nextInt();

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
