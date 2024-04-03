package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class K번째큰수 {
    static int N, K, answer = -1;
    static Integer[] arr;
    static TreeSet<Integer> treeSet;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = Arrays.stream(br.readLine().split(" "))
            .map(Integer::valueOf)
            .toArray(Integer[]::new);

        treeSet = new TreeSet<>(Collections.reverseOrder());
        for (int i=0; i<N; i++) {
            for (int j=i+1; j<N; j++) {
                for (int k=j+1; k<N; k++) {
                    int sum = arr[i] + arr[j] + arr[k];
                    treeSet.add(sum);
                }
            }
        }

        int count = 1;
        for (Integer i : treeSet) {
            if (count == K) {
                answer = i;
            }
            count++;
        }

        System.out.println(answer);
    }
}
