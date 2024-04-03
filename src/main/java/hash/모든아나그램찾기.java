package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 모든아나그램찾기 {
    static int answer;
    static String str, target;
    static char[] strArr;
    static Map<Character, Integer> map, targetMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        target = br.readLine();

        targetMap = new HashMap<>();
        for (char c : target.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0)+1);
        }

        strArr = str.toCharArray();
        map = new HashMap<>();
        for (int i=0; i<target.length()-1; i++) {
            map.put(strArr[i], map.getOrDefault(strArr[i], 0)+1);
        }

        int lt=0, rt=target.length()-1;
        while (rt < str.length()) {
            map.put(strArr[rt], map.getOrDefault(strArr[rt], 0)+1);

            if (map.equals(targetMap)) {
                answer++;
            }

            if (map.get(strArr[lt]) == 1) {
                map.remove(strArr[lt]);
            } else {
                map.put(strArr[lt], map.get(strArr[lt])-1);
            }
            lt++;
            rt++;
        }

        System.out.println(answer);
    }
}
