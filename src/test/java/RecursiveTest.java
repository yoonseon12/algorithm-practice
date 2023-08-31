import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RecursiveTest {
    @Test
    @DisplayName("재귀함수(스택프레임)")
    void 재귀함수() {
        재귀함수_solution(3);
    }
    private void 재귀함수_solution(int n) {
        if (n==0) return;
        재귀함수_solution(n-1);
        System.out.print(n+" "); // 재귀함수는 스택프레임을 사용한다.
    }

    @Test
    @DisplayName("이진수출력(재귀)")
    void 이진수출력() {
        이진수출력_solution(11);
    }
    private void 이진수출력_solution(int n) {
        if (n==0) return;
        System.out.print(n%2+" ");
        이진수출력_solution(n/2);
    }

    @Test
    @DisplayName("팩토리얼")
    void 팩토리얼() {
        System.out.println(팩토리얼_solution(5));
    }
    private int 팩토리얼_solution(int n) {
        int answer = 1;
        if (n==0) return 1;
        answer = n * 팩토리얼_solution(n-1);
        return answer;
    }

    @Test
    @DisplayName("피보나치 재귀(메모이제이션)")
    void 피보나치재귀() {
        int n = 45;
        fibo = new int[n+1];
        피보나치재귀_solution1(n);
        for (int i: fibo) System.out.print(i+" ");
    }
    static int[] fibo;
    private int 피보나치재귀_solution1(int n) {
        if (fibo[n] > 0) return fibo[n];
        if (n==1) return fibo[n] = 1;
        else if (n==2) return fibo[n] = 1;
        else return fibo[n] = 피보나치재귀_solution1(n-2)+ 피보나치재귀_solution1(n-1);
    }
}
