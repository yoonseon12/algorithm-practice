import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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

}
