import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayTest {
    @Test
    @DisplayName("큰수출력하기")
    void 큰수출력하기() {
        int[] arr = {7, 3, 9, 5, 6, 12};
        String answer = 큰수출력하기_solution2(6, arr);
        System.out.println("answer : " + answer);
    }

    private String 큰수출력하기_solution1(int n, int[] arr) {
        return IntStream.range(0, n)
                .filter(i -> i==0 || arr[i-1] < arr[i])
                .mapToObj(i ->  String.valueOf(arr[i]))
                .collect(Collectors.joining(" "));
    }
    private String 큰수출력하기_solution2(int n, int[] arr) {
        StringBuilder answer = new StringBuilder();
        answer.append(arr[0]);
        for (int i=1; i<n; i++) {
            if (arr[i-1] < arr[i]) answer.append(" "+arr[i]);
        }

        return answer.toString();
    }

    @Test
    @DisplayName("보이는학생")
    void 보이는학생() {
        int[] arr = {130, 135, 148, 140, 145, 150, 150, 153};
        int answer = 보이는학생_solution1(8, arr);
        System.out.println("answer : " + answer);
    }
    private int 보이는학생_solution1(int n, int[] arr) {
        int height = arr[0];
        List<Integer> students = new ArrayList<>();
        students.add(arr[0]);
        for (int i=1; i<n; i++) {
            if (arr[i] > height) {
                students.add(arr[i]);
                height = arr[i];
            }
        }
        return students.size();
    }

    @Test
    @DisplayName("가위바위보")
    void 가위바위보() {
        int[] a = {1, 2, 1, 2, 1, 3, 3, 2, 3, 1};
        int[] b = {3, 3, 3, 2, 3, 3, 2, 3, 2, 3};
        String[] answer = 가위바위보_solution1(10, a, b);
        for (String s : answer) {
            System.out.println(s);
        }
    }
    private String[] 가위바위보_solution1(int n, int[] a, int[] b) {
        String[] answer = new String[n];
        for (int i=0; i<n; i++) {
            answer[i] = a[i] == b[i] ? "D" : (a[i] - b[i] == 1 || a[i] - b[i] == -2 ? "A" : "B");
        }
        return answer;
    }

    @Test
    @DisplayName("피보나치수열")
    void 피보나치수열() {
        String answer = 피보나치수열_solution2(10);
        System.out.println("answer : "+answer);
    }
    private String 피보나치수열_solution1(int n) {
        int[] answer = new int[n];
        answer[0] = 1;
        answer[1] = 1;
        for (int i=2; i<n; i++) {
            answer[i] = answer[i-1] + answer[i-2];
        }
        return Arrays.stream(answer)
                .mapToObj(i -> i+"")
                .collect(Collectors.joining(" "));
    }
    private String 피보나치수열_solution2(int n) {
        int a = 1, b = 1, c;
        System.out.print(a+" "+b+" ");
        for (int i = 2; i < n; i++) {
            c = a+b;
            System.out.print(c+" ");
            b = c;
            a = b;
        }
        return "";
    }

    @Test
    @DisplayName("소수(에라토스테네스 체)")
    void 소수_에라토스테네스체() {
        int answer = 소수_에라토스테네스체_solution1(200000);
        System.out.println("answer : "+answer);
    }
    private int 소수_에라토스테네스체_solution1(int n) {
        int answer = 0;
        int[] ch = new int[n+1];
        for (int i=2; i<=n; i++) {
            if (ch[i] == 0) {
                answer++;
                for (int j=i; j<=n; j=j+i) {
                    ch[j] = 1;
                }
            }
        }
        return answer;
    }

    @Test
    @DisplayName("뒤집은소수")
    void 뒤집은소수() {
        int[] arr = {32, 55, 62, 20, 250, 370, 200, 30, 100};
        String answer = 뒤집은소수_solution2(9, arr);
        System.out.println("answer : "+answer);
    }
    private String 뒤집은소수_solution1(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] ints = Arrays.stream(arr)
                .filter(i -> 1 != Integer.parseInt(new StringBuilder(String.valueOf(i)).reverse().toString()))
                .map(i -> Integer.parseInt(new StringBuilder(String.valueOf(i)).reverse().toString()))
                .toArray();
        for (int num : ints) {
            boolean isPrime = true;
            for(int i=2; i<num; i++){
                if(num % i == 0) isPrime = false;
            }
            if (isPrime) answer.add(num);
        }
        return answer.stream()
                .map(i -> i+"")
                .collect(Collectors.joining(" "));
    }
    private String 뒤집은소수_solution2(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int tmp = arr[i];
            int res = 0;
            while (tmp > 0) {
                int t = tmp%10;
                res = res * 10 + t;
                tmp = tmp/10;
            }
            if (isPrime(res)) answer.add(res);
        }
        return answer.stream()
                .map(i -> i+"")
                .collect(Collectors.joining(" "));
    }
    private boolean isPrime(int num) {
        if (num == 1) return false;
        for(int i=2; i<num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }

    @Test
    @DisplayName("점수계산")
    void 점수계산() {
        int[] arr = {1, 0, 1, 1, 1, 0, 0, 1, 1, 0};
        int answer = 점수계산_solution1(10, arr);
        System.out.println("answer : "+answer);
    }
    private int 점수계산_solution1(int n, int[] arr) {
        int answer = 0;
        int score = 0;
        for (int i : arr) {
            if (i == 1) score++;
            else score = 0;
            answer = answer + score;
        }
        return answer;
    }

    @Test
    @DisplayName("등수구하기")
    void 등수구하기() {
        int[] arr = {87, 89, 92, 100, 76};
        String answer = 등수구하기_solution1(5, arr);
        System.out.println("answer : "+answer);
    }
    private String 등수구하기_solution1(int n, int[] arr) {
        int[] ranks = new int[n];
        for (int i=0; i<n; i++) {
            int rank = 1;
            for (int j=0; j<n; j++) {
                if (arr[i] < arr[j]) rank++;
            }
            ranks[i] = rank;
        }
        return Arrays.stream(ranks)
                .mapToObj(i -> i+"")
                .collect(Collectors.joining(" "));
    }

    @Test
    @DisplayName("격자판최대합")
    void 격자판최대합() {
        int[][] arr = {{10 ,13 ,10 ,12 ,15}
                      ,{12 ,39 ,30 ,23 ,11}
                      ,{11 ,25 ,50 ,53 ,15}
                      ,{19 ,27 ,29 ,37 ,27}
                      ,{19 ,13 ,30 ,13 ,19}};
        int answer = 격자판최대합_solution2(5, arr);
        System.out.println("answer : "+answer);
    }
    private int 격자판최대합_solution1(int n, int[][] arr) {
        int answer = 0;
        int leftCrossSum = 0, rightCrossSum = 0, maxRowSum = 0, maxColSum = 0;
        for (int i=0; i<n; i++) {
            int rowSum = 0, colSum = 0;
            for (int j=0; j<n; j++) {
                if (i==j) rightCrossSum += arr[i][j];
                if (i+j==n-1) leftCrossSum += arr[i][j];
                rowSum += arr[i][j];
                colSum += arr[j][i];
            }
            if (rowSum > maxRowSum) maxRowSum = rowSum;
            if (colSum > maxColSum) maxColSum = colSum;
        }
        return Math.max(Math.max(maxRowSum, maxColSum), Math.max(leftCrossSum, rightCrossSum));
    }
    private int 격자판최대합_solution2(int n, int[][] arr) {
        int answer = Integer.MIN_VALUE;
        int sum1, sum2;
        for (int i=0; i<n; i++) {
            sum1 = sum2 = 0;
            for (int j=0; j<n; j++) {
                sum1+=arr[i][j];
                sum2+=arr[j][i];
            }
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
        }
        sum1 = sum2 = 0;
        for (int i=0; i<n; i++) {
            sum1 += arr[i][i];
            sum2 += arr[i][n-i-1];
        }
        answer = Math.max(answer, sum1);
        answer = Math.max(answer, sum2);
        return answer;
    }
}
