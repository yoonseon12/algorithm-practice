package recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 부분집합구하기 {

    static int N;
    static boolean[] isChecked;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());
            isChecked = new boolean[N];

            DFS(0);
        }
    }

    private static void DFS(int num) {
        if (num == N) {
            String tmp ="";
            for (int i=0; i<N; i++) {
                if (isChecked[i]) {
                    tmp += (i+1+" ");
                }
            }
            if (tmp.length() > 0) {
                System.out.println(tmp.trim());
            }
        } else {
            isChecked[num] = true;
            DFS(num+1);
            isChecked[num] = false;
            DFS(num+1);
        }
    }
}
