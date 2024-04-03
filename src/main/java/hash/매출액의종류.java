package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 매출액의종류 {
    static int N, K;
    static String[] arr;
    static Map<String, Integer> map, map2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = br.readLine().split(" ");

        StringBuilder sb = new StringBuilder();
        map = new HashMap<>();
        for (int i=0; i<K-1; i++) {
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }

        int lt=0, rt=K-1;
        while (rt<N) {
            map.put(arr[rt], map.getOrDefault(arr[rt],0)+1);
            sb.append(map.size()).append(" ");
            if (map.get(arr[lt]) == 1) {
                map.remove(arr[lt]);
            } else {
                map.put(arr[lt], map.get(arr[lt])-1);
            }
            lt++;
            rt++;
        }

        System.out.println(sb.toString().trim());
    }
}
