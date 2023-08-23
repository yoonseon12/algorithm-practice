import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TwoPointersAndSlidingWindowTest {

    @Test
    @DisplayName("두배열합치기(two pointers algorithm)")
    void 두배열합치기() {
        int[] nArr = {1, 3, 5};
        int[] mArr = {2, 3, 6, 7, 9};
        String answer = 두배열합치기_solution1(3, nArr, 5, mArr);
        System.out.println("answer : " + answer);
    }

    private String 두배열합치기_solution1(int n, int[] nArr, int m, int[] mArr) {
        List<Integer> answer = new ArrayList<>();
        int p1=0, p2=0;
        while (p1<n && p2<m) { // p1이 n까지 또는 p2가 m까지 간다면(끝까지 간다면) 거짓이 된다.
                               // p1<n 조건이 거짓이 된다 -> p2 남아있다.
                               // p2<n 조건이 거짓이 된다 -> p1 남아있다.
            if (nArr[p1] < mArr[p2]) answer.add(nArr[p1++]); // nArr[p1]을 add 후 p1을 ++ 시킨다.(후위 증감 연산자)
            else answer.add(mArr[p2++]); // nArr[p1]을 add 후 p2을 ++ 시킨다. (후위 증감 연산자)
        }
        // p1, p2 중 어느 것이 남아있는지 모르기 때문에 둘다 비교 해줘야한다.
        while (p1<n) answer.add(nArr[p1++]);
        while (p2<m) answer.add(mArr[p2++]);

        return answer.stream()
                .map(i -> Integer.toString(i))
                .collect(Collectors.joining(" "));
    }

    @Test
    @DisplayName("공통원소구하기")
    void 공통원소구하기() {
        int[] nArr = {1, 3, 9, 5 ,2};
        int[] mArr = {3, 2, 5, 7, 8};
        String answer = 공통원소구하기_solution1(5, nArr, 5, mArr);
        System.out.println("answer : " + answer);
    }

    private String 공통원소구하기_solution1(int n, int[] nArr, int m, int[] mArr) {
        List<Integer> answer = new ArrayList<>();
        Arrays.sort(nArr); // 오름차순 정렬을 하고 시작
        Arrays.sort(mArr); // 오름차순 정렬을 하고 시작
        int p1=0, p2=0; // 포인터
        while (p1<n && p2<m) { // nArr 배열의 인덱스 : p1, nArr 배열 크기 : n
                               // mArr 배열의 인덱스 : p2, mArr 배열 크기 : m
            if (nArr[p1] == mArr[p2]) {
                answer.add(nArr[p1++]); // 각 배열의 p1, p2 인덱스 값이 같기 때문에 아무값고 넣고 넣은 값의 인덱스를 1 증가시킴
                p2++; // 나머지 인덱스도 1 증가시켜 다음 반복문부터 다음 인덱스를 비교도록함
            }
            else if (nArr[p1] < mArr[p2]) p1++; // mArr 배열의 p2 인덱스 값이 nArr 배열의 다음 인덱스에 존재할 가능성이 있기 때문에 nArr 배열의 p1 인덱스를 증가시킴
            else p2++; // nArr 배열의 p1 인덱스 값이 mArr 배열의 다음 인덱스에 존재할 가능성이 있기 때문에 mArr 배열의 p2 인덱스를 증가시킴
        }

        return answer.stream()
                .map(i -> Integer.toString(i))
                .collect(Collectors.joining(" "));
    }

    @Test
    @DisplayName("최대매출(Sliding window)")
    void 최대매출() {
        int[] arr = {12, 15, 11, 20, 25, 10, 20, 19, 13, 15};
        int answer = 최대매출_solution1(10, 3, arr);
        System.out.println("answer : " + answer);
    }

    private int 최대매출_solution1(int n, int k, int[] arr) {
        int answer = 0 ,sum = 0;
        for (int i=0; i<k; i++) {
            sum += arr[i];
        }
        answer = sum;
        for (int i=k; i<n; i++) {
            sum += (arr[i] - arr[i-k]);
            answer = Math.max(sum, answer);
        }
        return answer;
    }

    @Test
    @DisplayName("연속부분수열(복합적문제)")
    void 연속부분수열() {
        int[] arr = {1, 2, 1, 3, 1, 1, 1, 2};
        int answer = 연속부분수열_solution1(8, 6, arr);
        System.out.println("answer : " + answer);
    }

    private int 연속부분수열_solution1(int n, int m, int[] arr) {
        int answer = 0, sum = 0, lt = 0;

        for (int rt=0; rt<n; rt++) { // 증가하고
            sum+=arr[rt]; // sum부터 rt까지 합이 m인지 확인
            if (sum == m) answer++;
            while (sum >= m) {
                sum -= arr[lt++]; //빼고나서 lt가 증가한다음
                if (sum == m) answer++; // lt부터 rt까지의 합이 m인지 확인
            }
        }
        return answer;
    }

    @Test
    @DisplayName("연속된자연수의합(two pointers)")
    void 연속된자연수의합_twoPointers_twoPointers() {
        int answer = 연속된자연수의합_twoPointers_solution1(15);
        System.out.println("answer : " + answer);
    }
    private int 연속된자연수의합_twoPointers_solution1(int n) {
        int answer=0, lt=0, sum=0;
        int[] arr = new int[n/2+1];
        for (int i=0; i<arr.length; i++) {
            arr[i]=i+1;
        }
        for (int rt=0; rt<arr.length; rt++){
            sum += arr[rt];
            if (sum==n) answer++;
            while (sum>=n) {
                sum -= arr[lt++];
                if (sum==n) answer++;
            }
        }
        return answer;
    }

    @Test
    @DisplayName("연속된자연수의합(수학)")
    void 연속된자연수의합_수학_twoPointers() {
        int answer = 연속된자연수의합_수학_solution1(15);
        System.out.println("answer : " + answer);
    }
    private int 연속된자연수의합_수학_solution1(int n) {
        int answer=0, cnt=1; // cnt는 연속된 자연수의 개수
        n--;
        while (n>0) {
            cnt++;
            n=n-cnt; // n에서 1, 2를 뺏다고 가정
            if (n%cnt==0) answer++;
        }
        return answer;
    }

    @Test
    @DisplayName("최대 길이 연속부분수열(복합적 문제)")
    void 최대길이연속부분수열() {
        int[] arr = {1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1};
        int answer = 최대길이연속부분수열_solution(14, 2, arr);
        System.out.println("answer : " + answer);
    }
    private int 최대길이연속부분수열_solution(int n, int k, int[] arr) {
        int answer=0, lt=0;
        int cnt=0; // 0을 1로 변경한 횟수
        for (int rt=0; rt<n; rt++) {
            if (arr[rt] == 0) cnt++; // 0을 만나면 1로 바꾸었다고 가정하고 변경한 횟수를 cnt에 누적한다.
            while (cnt > k) { // 0을 1로 바꾼 횟수가 초과할 경우
                if (arr[lt] == 0) cnt--;// lt가 0을 1로 변경한 부분을 만나면 다시 0으로 바꾼다고 가정하고 cnt--
                lt++; // cnt--를 해주고 바로 lt를 증가시킨다. 따라서 arr[lt]는 한칸 씩 이동하게 된다.
            }
            answer = Math.max(answer, rt-lt+1); // 1로 이루어진 총 길이 저장
        }
        return answer;
    }

    @Test
    @DisplayName("예시입력 ,찍기")
    void 예시입력() {
        String s = "1 1 0 0 1 1 0 1 1 0 1 1 0 1";
        System.out.println(s.replaceAll(" ",", "));
    }

}
