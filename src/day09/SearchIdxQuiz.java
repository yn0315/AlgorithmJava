package day09;

import java.util.Arrays;
import java.util.Scanner;

public class SearchIdxQuiz {
    //길이가 n인 배열 a에서 key와 일치하는 모든 요소의 인덱스를 배열idx의 맨 앞부터 순서대로 저장,
    //일치하는 요솟수를 반환하는 메서드 작성
    //ex) 길이가 8인 배열 a가 {1,9,2,9,4,6,7,9}이고 key가 9이면 배열 idx에 {1,3,7}을 저장, 3을 반환

    static int searchIdx(int[] a, int n, int key, int[] idx) {

        int count = 0;
        for (int i = 0; i < n; i++) {
            if(a[i] == key) {
                idx[count++] = i;//저장되어있는 위치를 알아내야 하니까 i를 넣음
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("요솟수: ");
        int num = sc.nextInt();

        int[] a = new int[num]; //길이가 num인 배열
        int[] idx = new int[num];

        System.out.println("값을 입력하세요.");
        for (int i = 0; i < a.length; i++) {
            System.out.print("a[" + i + "]: ");
            a[i] = sc.nextInt();
        }
        System.out.print("찾는 값: ");
        int key = sc.nextInt();

//        System.out.printf("%d는 %d 개 있습니다.", key, searchIdx(a,num, key, idx));

        int count = searchIdx(a, num, key, idx);

        if(count == 0) {
            System.out.println("그런 값은 없습니다.");
        }
        for (int i = 0; i < count; i++) {
            System.out.println("찾는 값은 idx["+ idx[i] + "]에 있습니다.");
        }

        sc.close();
    }
}
