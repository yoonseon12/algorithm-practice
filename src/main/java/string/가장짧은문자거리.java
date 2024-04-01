package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class 가장짧은문자거리 {
    static String str;
    static char target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        str = st.nextToken();
        target = st.nextToken().charAt(0);

        int[] arr = new int[str.length()];

        int count = 101;
        // 앞부터 순회
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == target) {
                count = 0;
                arr[i] = count;
            } else {
                count++;
                arr[i] = count;
            }
        }
        // 뒤부터 순회
        for (int i=str.length()-1; i>=0; i--) {
            if (str.charAt(i) == target) {
                count = 0;
            } else {
                count++;
                arr[i] = Math.min(count, arr[i]);
            }
        }

        String answer = Arrays.stream(arr)
            .mapToObj(String::valueOf)
            .collect(Collectors.joining(" "));
        System.out.println(answer);
    }
}
