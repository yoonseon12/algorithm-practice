package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class 등수구하기 {
    static int N, rank;
    static List<Integer> list, copyList;
    static Map<Integer, Integer> map;
    static StringBuilder answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = Arrays.stream(br.readLine().split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
        copyList = new ArrayList<>(list);
        Collections.sort(copyList);
        Collections.reverse(copyList);

        map = new HashMap<>();
        answer = new StringBuilder();
        rank = 1;
        for (int i : copyList) {
            if (!map.containsKey(i)) {
                map.put(i, rank);
            }
            rank++;
        }

        for (int i : list) {
            answer.append(map.get(i)+" ");
        }

        System.out.println(answer.toString());
    }
}
