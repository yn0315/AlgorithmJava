package day03;

import java.util.Random;
import java.util.Scanner;

public class MaxOfArrayRand {

    //배열의 최댓값 구하기
    public static int maxOf(int[] a) {
        int max = a[0];
        for(int i = 1; i < a.length; i++) {
            if(a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }//end maxOf

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random(); //난수생성

        System.out.println("키의 최댓값을 구합니다.");
        System.out.print("사람 수: ");
        int num = sc.nextInt();

        int[] height = new int[num];

        System.out.println("키 값은 아래와 같습니다.");
        for(int i = 0; i < height.length; i++) {
            height[i] = 100 + rand.nextInt(90);
            System.out.println("height[" + i + "]: " + height[i]);

        }

        System.out.printf("최댓값은 %d 입니다.", maxOf(height));
    }

}
