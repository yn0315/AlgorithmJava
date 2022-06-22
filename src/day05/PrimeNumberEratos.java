package day05;

public class PrimeNumberEratos {
    public static void primeNumber(int numbers) {
        //숫자를 지울 배열
        boolean [] arr = new boolean[numbers + 1];

        arr[0] = true;
        arr[1] = true;

        //2부터 특정 숫자의 배수에 해당하는 수를 지움
        for (int i = 2; i<= numbers; i++) {
            if(arr[i]) continue;//이미 지워진 수라면 건너뜀

            for (int j = 2 * i; j <= numbers; j += i) {//지워진 숫자가 아니라면, 해당 숫자의 배수를 true로
                arr[j] = true;

            }
        }

        //남은 수 출력
        for (int i = 2; i <= numbers; i++) {
            if(!arr[i])//false 프린트
                System.out.printf("%d  ", i);
        }

    }

    public static void main(String[] args) {
        primeNumber(100);
    }
}
