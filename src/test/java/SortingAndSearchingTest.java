import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class SortingAndSearchingTest {

    @Test
    @DisplayName("선택정렬")
    void 선택정렬() {
        int[] arr = {13, 5, 11, 7, 23, 15};
        System.out.println(선택정렬_solution(6, arr));
    }
    private String 선택정렬_solution(int n, int[] arr) {
        for (int i=0; i<n-1; i++) {
            int idx = i;
            for (int j=i+1; j<n; j++) {
                if (arr[j] < arr[idx]) {
                    idx = j;
                }
            }
            int tmp = arr[idx];
            arr[idx] = arr[i];
            arr[i] = tmp;
        }
        return Arrays.stream(arr).mapToObj(i -> i+"").collect(Collectors.joining(" "));
    }

    @Test
    @DisplayName("버블정렬")
    void 버블정렬() {
        int[] arr = {13, 5, 11, 7, 23, 15};
        System.out.println(버블정렬_solution(6, arr));
    }
    private String 버블정렬_solution(int n, int[] arr) {
        for (int i=0; i<n-1; i++) {
            for(int j=0; j<n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        return Arrays.stream(arr).mapToObj(i -> i+"").collect(Collectors.joining(" "));
    }

    @Test
    @DisplayName("삽입정렬")
    void 삽입정렬() {
        int[] arr = {11, 7, 5, 6, 10, 9};
        System.out.println(삽입정렬_solution(6, arr));
    }
    private String 삽입정렬_solution(int n, int[] arr) {
        for (int i=1; i<n; i++) { // 배열의 첫 번째 요소는 이미 정렬된 상태로 간주하고 두 번째 요소부터 시작하여, 현재 요소를 적절한 위치에 삽입하면서 정렬을 진행한다.
            int tmp = arr[i], j;
            for (j=i-1; j>=0; j--) {
                if (arr[j] > tmp)
                    arr[j+1] = arr[j]; // 현재 요소를 이전 요소와 비교하여 이전 요소가 더 크다면 현재 요소를 한 칸 뒤로 이동시킨다.
                else break;
            }
            arr[j+1] = tmp; // 이전 요소와 비교하며 적절한 위치를 찾으면, 현재 요소를 그 위치에 삽입한다.
        }
        return Arrays.stream(arr).mapToObj(i -> i+"").collect(Collectors.joining(" "));
    }

    @Test
    @DisplayName("Least Recently Used")
    void LRU() {
        int[] arr = {1, 2, 3, 2, 6, 2, 3, 5, 7};
        System.out.println(LRU_solution(5, 9, arr));
    }
    private String LRU_solution(int s, int n, int[] arr) {
        int[] cache = new int[s];
        for (int x : arr) {
            int pos = -1; // 인덱스번호
            for (int i=0; i<s; i++) {
                if (x == cache[i]) pos = i; // hit된 지점의 인덱스를 저장
            }
            if (pos == -1) { // miss 일 경우
                for (int i=s-1; i>=1; i--) {
                    cache[i] = cache[i-1]; // 배열을 다음칸씩 이동시킨다.
                }
                cache[0] = x;
            }
            else { // hit 일 경우
                for (int i=pos; i>=1; i--) {
                    cache[i] = cache[i-1]; // 배열을 다음칸씩 이동시킨다.
                }
                cache[0] = x;
            }
        }
        return Arrays.stream(cache).mapToObj(i -> i+"").collect(Collectors.joining(" "));
    }

    @Test
    @DisplayName("중복확인")
    void 중복확인() {
        int[] arr = {20, 25, 52, 30, 39, 33, 43, 33};
        System.out.println(중복확인_solution(8, arr));
    }
    private String 중복확인_solution(int n, int[] arr) {
        String answer = "U";
        Arrays.sort(arr);
        for (int i=0; i<n-1; i++) {
            if(arr[i]==arr[i+1]) return "D";
        }
        return answer;
    }

    @Test
    @DisplayName("장난꾸러기")
    void 장난꾸러기() {
        int[] arr = {120, 125, 152, 130, 135, 135, 143, 127, 160};
        System.out.println(장난꾸러기_solution2(9, arr));
    }
    private String 장난꾸러기_solution2(int n, int[] arr) {
        String answer = "";
        int[] temp = arr.clone();
        Arrays.sort(temp);
        for (int i=0; i<n; i++) {
            if (arr[i] != temp[i]) answer += (i+1)+" ";
        }
        return answer.trim();
    }

    @Test
    @DisplayName("좌표정렬")
    void 좌표정렬() {
        ArrayList<Point> list = new ArrayList<>();
        list.add(new Point(2, 7));
        list.add(new Point(1, 3));
        list.add(new Point(1, 2));
        list.add(new Point(2, 5));
        list.add(new Point(3, 6));
        System.out.println(좌표정렬_solution(5, list));
    }
    private String 좌표정렬_solution(int n, ArrayList<Point> list) {
        Collections.sort(list);
        for (Point p : list) {
            System.out.println(p.x+" "+p.y);
        }
        return "";
    }
    public class Point implements Comparable<Point> {
        public int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Point o) {
            if (this.x == o.x) return this.y - o.y; // 오름차순이기 때문에 this가 음수가 되도록설정
            return this.x - o.x;
//            if (this.x == o.x) return o.y- this.y; // 내림차순이기 때문에 Object가 음수가 되도록설정
//            return o.x- this.x;
        }
    }

    @Test
    @DisplayName("이분검색")
    void 이분검색() {
        int[] arr = {23, 87, 65, 12, 57, 32, 99, 81};
        System.out.println(이분검색_solution(8, 32, arr));
    }
    private int  이분검색_solution(int n, int m, int[] arr) {
        int answer = 0;
        Arrays.sort(arr); // 이진 검색은 정렬된 배열에서 수행되어야 한다.
        int lt = 0; // 검색 범위의 왼쪽 끝 인덱스 초기화
        int rt = n-1; // 검색 범위의 오른쪽 끝 인덱스 초기화
        while(lt <= rt) {
            int mid = (lt+rt)/2; // 검색 범위의 중간 인덱스 계산
            if (arr[mid] == m) return mid+1; // 찾은 경우: 해당 값의 인덱스를 반환 (인덱스는 1부터 시작)
            if (arr[mid] > m) rt = mid-1; // 중간 값이 찾으려는 값보다 큰 경우: 오른쪽 범위를 좁힘
            if (arr[mid] < m) lt = mid+1; // 중간 값이 찾으려는 값보다 작은 경우: 왼쪽 범위를 좁힘
        }
        return answer;
    }

    @Test
    @DisplayName("뮤직비디오(결정알고리즘)")
    void 뮤직비디오() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(뮤직비디오_solution(9, 3, arr));
    }
    private int 뮤직비디오_solution(int n, int m, int[] arr) {
        int answer = 0; // DVD 용량의 최솟값을 저장할 변수
        int lt = Arrays.stream(arr).max().getAsInt(); // 가능한 DVD 용량의 최솟값 초기화 (가장 큰 노래 길이)
        int rt = Arrays.stream(arr).sum(); // 가능한 DVD 용량의 최댓값 초기화 (모든 노래 길이 합)
        while (lt <= rt) {
            int mid = (lt + rt) / 2; // 가능한 DVD 용량의 중간값을 계산
            if (뮤직비디오_count(arr, mid) <= m) { // 현재 DVD 용량으로 노래를 저장했을 때, 필요한 DVD 개수가 m 이하인지 확인한다.
                answer = mid; // DVD 용량의 최솟값 갱신
                rt = mid - 1; // 더 작은 DVD 용량을 탐색
            } else {
                lt = mid + 1; // 더 큰 DVD 용량을 탐색
            }
        }
        return answer; // 최적의 DVD 용량 반환
    }

    // 주어진 DVD 용량으로 노래를 저장했을 때 필요한 DVD 개수를 반환하는 함수
    public int 뮤직비디오_count(int[] arr, int capacity) {
        int cnt = 1; // DVD의 개수 초기화
        int sum = 0; // 현재 DVD에 담아진 노래 길이의 합 초기화
        for (int x : arr) {
            if (sum + x > capacity) {
                cnt++; // 새로운 DVD에 노래를 저장
                sum = x; // 현재 DVD에 첫 번째 노래를 담아 초기화
            } else {
                sum += x; // 현재 DVD에 노래를 추가
            }
        }
        return cnt; // 필요한 DVD 개수 반환
    }

    @Test
    @DisplayName("마굿간정하기(결정알고리즘)")
    void 마굿간정하기() {
        int[] arr = {1, 2, 8, 4, 9};
        System.out.println(마굿간정하기_solution(5, 3, arr));
    }
    private int 마굿간정하기_solution(int n, int m, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int lt=1, rt=arr[n-1];
        // 가장 가까운 말의 거리를 mid라고 해놓고 3마리가 배치가 되는지 보는거다.
        while (lt<=rt) {
            int mid = (lt+rt)/2;
            if (마굿간정하기_count(arr, mid) >= m) {
                // 유효한 경우
                answer = mid;
                lt = mid +1;
            }
            else rt = mid -1;
        }
        return answer;
    }
    public int 마굿간정하기_count(int[] arr, int dist) {
        int cnt = 1;
        int ep = arr[0];
        for (int i=0; i<arr.length; i++) {
            if (arr[i]-ep >= dist) {
                cnt++;
                ep=arr[i];
            }
        }
        return cnt;
    }

    @Test
    @DisplayName("예시입력 ,찍기")
    void 예시입력() {
        String s = "1 2 8 4 9";
        System.out.println(s.replaceAll(" ",", "));
    }
}
