package day02;

import java.util.Scanner;

public class TriangleLB {
    //왼쪽 아래가 직각인 이등변삼각형 출력하기
    private static void triangleLB(int n) {
        for (int i = 1; i <= n; i++) {//0부터 시작하고 미만으로 작성하면 밑에 반복문 한번 안돌아서 1단 안 나옴
            for(int j = 1; j <= i; j++) {//하나씩 늘어나야 하므로 범위가 i까지
                System.out.print("*");
            }
            System.out.println();
        }
    }//end LBmethod

    //왼쪽 위가 직각인 이등변삼각형
    private static void triangleLU(int n) {
        for (int i = n; i >= 1; i--) {
            for(int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }//end LU

    //어렵다......오른쪽 위 직각
    private static void triangleRU(int n){
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for(int j = 0; j < n - i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }//end RU

    //오른쪽 아래가 직각
    private static void triangleRB(int n) {
        for (int i = n; i >= 0; i--) {
            for (int j = i; j > 0; j--) {
                System.out.print(" ");
            }
            for(int j = 0; j < n - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }//end RB



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        System.out.println("이등변 삼각형을 출력합니다.");
        do{
            System.out.println("몇 단 삼각형입니까?");
            System.out.println(">>");
            n = sc.nextInt();
        }while (n <= 0);

        triangleLB(n);
        triangleLU(n);
        triangleRU(n);
        triangleRB(n);
    }

}
