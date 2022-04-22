package day01;

import java.util.Scanner;

public class JudgeSign {
    public static void main(String[] args) {
        //조건판단과 분기
        Scanner sc = new Scanner(System.in);

        System.out.println("정수를 입력하세요.");
        int i = sc.nextInt();

        if(i > 0) {
            System.out.printf("%d는 양수입니다.", i);
        } else if(i < 0) {
            System.out.printf("%d는 음수입니다.", i);
        }else {
            System.out.println("이 수는 0입니다.");
        }//end if



    }//end main

}//end class
