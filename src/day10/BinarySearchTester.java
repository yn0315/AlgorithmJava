package day10;

import java.util.Arrays;
import java.util.Scanner;
//Arrays.binarySearch로 이진검색
public class BinarySearchTester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("요솟수: ");
        int num = sc.nextInt();
        int[] x = new int[num];

        System.out.println("오름차순으로 입력하세요.");

        System.out.print("x[0]: "); //배열의 첫 요소를 먼저 입력
        x[0] = sc.nextInt();

        for (int i = 1; i < num; i++) {
            do{
                System.out.print("x[" + i + "]: ");
                x[i] = sc.nextInt();

            }while (x[i] < x[i - 1]); //바로 앞 요소보다 작으면 다시 입력
        }//end for

        System.out.print("검색할 값: ");
        int key = sc.nextInt();

        int idx = Arrays.binarySearch(x, key); //배열 x에서 키값이 key인 요소를 검색

        if(idx < 0) {
            System.out.println("그 값의 요소가 없습니다.");
        }else {
            System.out.println(key + "은(는) x[" + idx + "]에 있습니다.");
        }
    }
}
