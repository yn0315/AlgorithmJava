package day05;

public class PrimeNumber1 {
    //1000이하의 소수를 열거(버전1)
    public static void main(String[] args) {

        int counter = 0;//나눗셈의 횟수

        for(int n = 2; n <= 1000; n++) {
            int i;
            for(i = 2; i < n; i++) {
                counter++;
                if(n % i == 0) {//나누어떨어지면 소수가 아님
                    break;      //더이상 반복 불필요
                }
            }//end inner for
            if(n == i) {//마지막까지 나누어떨어지지않음
                System.out.println(n);
            }

        }//end outer for
        System.out.println("나눗셈을 수행한 횟수: " + counter);
    }

}
