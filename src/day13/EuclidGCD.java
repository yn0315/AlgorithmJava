package day13;

import java.util.Scanner;

public class EuclidGCD {

    //유클리드 호제법으로 최대공약수 구하기
    //정수 x,y의 최대공약수를 구하여 반환
    static int gcd(int x, int y) {

        if(y == 0) {//나머지가 0이므로
            return x;//x는 최대공약수가 됨
        }else {
            return gcd(y, x % y);//0이 아닐경우 반복
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("두 정수의 최대공약수를 구합니다.");

        System.out.print("정수를 입력하세요.: ");
        int x = sc.nextInt();
        System.out.print("정수를 입력하세요.: ");
        int y = sc.nextInt();

        System.out.println("최대공약수는 " + gcd(x, y) + "입니다.");
    }
}
