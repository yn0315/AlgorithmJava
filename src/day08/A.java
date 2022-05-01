package day08;

public class A {
    private int f1;     //비공개 필드
    protected int f2;   //한정 공개 필드
    public int f3;      //공개 필드

    static final int S1 = 0; //정적 상수 필드
    public A() {
        f1 = f2 = f3 = 0; //생성자
    }

    public A(int f1, int f2, int f3) {//생성자
        this.f1 = f1;
        this.f2 = f2;
        this.f3 = f3;
    }

    public void setF1(int f) {
        f1 = f;                 //메서드 F1의 setter
    }

    public int getF1() {
        return f1;              //메서드 F1의 getter
    }


}
