import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
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
        for (int i=1; i<n; i++) { // 배열의 첫 번째 요소는 이미 정렬된 상태로 간주하고 두 번째 요소부터 시작하여, 현재 요소를 적절한 위치에 삽입하면서 정렬을 진행합니다.
            int tmp = arr[i], j;
            for(j=i-1; j>=0; j--) {
                if (arr[j] > tmp) arr[j+1] = arr[j]; // 현재 요소를 이전 요소와 비교하여 이전 요소가 더 크다면 현재 요소를 한 칸 뒤로 이동시킵니다.
                else break;
            }
            arr[j+1] = tmp; // 이전 요소와 비교하며 적절한 위치를 찾으면, 현재 요소를 그 위치에 삽입합니다.
        }
        

        return Arrays.stream(arr).mapToObj(i -> i+"").collect(Collectors.joining(" "));
    }

    @Test
    @DisplayName("예시입력 ,찍기")
    void 예시입력() {
        String s = "11 7 5 6 10 9";
        System.out.println(s.replaceAll(" ",", "));
    }
}
