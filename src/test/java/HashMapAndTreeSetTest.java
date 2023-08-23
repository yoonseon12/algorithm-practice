import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class HashMapAndTreeSetTest {

    @Test
    @DisplayName("학급회장")
    void 학급회장() {
        String str ="BACBACCACCBDEDE";
        System.out.println(학급회장_solution(5, str));
    }
    private char 학급회장_solution(int n, String str) {
        char answer = ' ';
        int maxValue = Integer.MIN_VALUE;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char ch : str.toCharArray()) {
            hashMap.put(ch, hashMap.getOrDefault(ch,0)+1);
        }
        for (char key : hashMap.keySet()) {
            Integer value = hashMap.get(key);
            if (value > maxValue) {
                maxValue = value;
                answer = key;
            }
        }
        return answer;
    }

    @Test
    @DisplayName("아나그램")
    void 아나그램() { // Anagram이란 두 문자열이 알파벳의 나열 순서를 다르지만 그 구성이 일치하면 두 단어이다.
                    // 예를 들면 AbaAeCe 와 baeeACA 는 알파벳을 나열 순서는 다르지만 그 구성을 살펴보면
                    // A(2), a(1), b(1), C(1), e(2)로 알파벳과 그 개수가 모두 일치한다.
        String str1 ="AbaAeCe";
        String str2 ="baeeACA";
        System.out.println(아나그램_solution2(str1, str2));
    }
    private String 아나그램_solution1(String str1, String str2) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (char c : str1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0)+1);
        }
        for (char c : str2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0)+1);
        }
        if (map1.size() != map2.size()) return "NO";
        for (char key : map1.keySet()) {
            if (map1.get(key) != map2.get(key)) return "NO";
        }
        return "YES";
    }
    private String 아나그램_solution2(String str1, String str2) {
        String answer = "YES";
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : str1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for (char c : str2.toCharArray()) {
            if (!map.containsKey(c) && map.get(c) == 0) return "NO";
            map.put(c, map.get(c)-1);
        }
        return "YES";
    }

    @Test
    @DisplayName("매출액의종류")
    void 매출액의종류() {
        int[] arr = {20, 12, 20, 10, 23, 17, 10};
        System.out.println(매출액의종류_solution1(7, 4, arr));
    }
    private String 매출액의종류_solution1(int n, int k, int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        // 초기 슬라이딩 윈도우를 설정
        for (int i=0; i<k-1; i++) {
            map.put(arr[i],map.getOrDefault(arr[i], 0)+1);
        }
        int rt=k-1,lt=0;
        while(rt<n) {
            // 슬라이딩 윈도우를 오른쪽으로 이동
            map.put(arr[rt], map.getOrDefault(arr[rt], 0)+1);
            list.add(map.size()); // 매출액 종류 개수를 저장
            map.put(arr[lt], map.get(arr[lt])-1); // 왼쪽 끝 요소를 제거
            if (map.get(arr[lt]) == 0) map.remove(arr[lt]);
            // 다음 슬라이딩 윈도우로 이동
            lt++;
            rt++;
        }
        return list.stream().map(i -> i+"").collect(Collectors.joining(" "));
    }

    @Test
    @DisplayName("예시입력 ,찍기")
    void 예시입력() {
        String s = "20 12 20 10 23 17 10";
        System.out.println(s.replaceAll(" ",", "));
    }
}
