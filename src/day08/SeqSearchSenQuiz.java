package day08;

import java.util.Arrays;
import java.util.Scanner;

public class SeqSearchSenQuiz {
    //선형검색(보초법) : 검색할 값을 마지막 인덱스에 넣어버림, 종료조건 중 한 가지를 줄일 수 있음
    //종료조건 1. 검색할 값을 발견하지 못 하고 배열의 끝을 지나간 경우 ->이걸 줄일 수 있게 됨
    //종료조건 2. 검색할 값과 같은 요소를 발견한 경우

    //길이가 n인 배열 a에서 key와 같은 요소를 보초법으로 선형검색합니다.
    static int seqSearchSen(int[] a, int n, int key) {
        int i = 0;

        a[n] = key; //보초를 추가;
//        while (true) {
//            if(a[i] == key) {
//                break;//일치하는 값 찾았으면 빠져나와라
//            }
//            i++;
//        }
//        return i == n ? -1: i;//값을 찾으면 i값 반환,
        // i가 n과 같다는 것은 배열 안에 값이 없고 찾은 값이 보초이므로 검색실패를 나타내는 -1반환

        //for문으로 바꿔 작성하기
        for (i = 0; a[i] != key; i++)//찾으면 바로 끝내버리니까 효율적.....
            ;
        return i == n ? -1 : i;
    }//end seqSearchSen method

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("길이: ");
        int num = sc.nextInt();
        int[] x = new int[num + 1]; //마지막 인덱스에 검색할 값을 넣어야 해서 1개 늘려줌

        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = sc.nextInt();
        }

        System.out.print("검색할 값: "); //키값을 입력
        int ky = sc.nextInt();

        int idx = seqSearchSen(x, num, ky);//배열 x에서 값이 ky인 요소를 검색

        if(idx == 1) {
            System.out.println("그 값의 요소가 없습니다.");
        }else {
            System.out.println(ky + "은(는) x[" + idx + "]에 있습니다.");
        }



    }
}
