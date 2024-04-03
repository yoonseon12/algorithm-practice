package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 아나그램 {
    static Map<Character, Integer> map1, map2;
    static String str1, str2, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str1 = br.readLine();
        str2 = br.readLine();

        map1 = new HashMap<>();
        for (char c : str1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c,0)+1);
        }
        map2 = new HashMap<>();
        for (char c : str2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c,0)+1);
        }

        answer = "YES";
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            if (!entry.getValue().equals(map2.get(entry.getKey()))) {
                answer = "NO";
            }
        }

        System.out.println(answer);
    }
}
