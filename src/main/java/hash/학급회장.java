package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 학급회장 {
    static int N;
    static String arr;
    static Character answer;
    static Map<Character, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = br.readLine();

        map = new HashMap<>();
        for (char c : arr.toCharArray()) {
            map.put(c, map.getOrDefault(c,0)+1);
        }

        int max = 0;
        for (Map.Entry<Character, Integer> m : map.entrySet()) {
            if (max < m.getValue()) {
                answer = m.getKey();
                max = m.getValue();
            }
        }

        System.out.println(answer);
    }
}
