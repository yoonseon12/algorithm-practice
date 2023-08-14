import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class StringTest {
    @Test
    @DisplayName("배열만들기2")
    void 배열만들기2() {
        int[] ints = 배열만들기2_solution(10, 20);
        Arrays.stream(ints).forEach(System.out::println);
    }
    private int[] 배열만들기2_solution(int l, int r) {
        int[] ints = IntStream.rangeClosed(l, r)
                .filter(idx -> {
                    while (idx > 0) {
                        if (idx % 5 != 0)
                            return false;
                        idx /= 10;
                    }
                    return true;
                })
                .toArray();

        return ints.length == 0 ? new int[]{-1} : ints;
    }

    @Test
    @DisplayName("문자찾기")
    void 문자찾기() {
        int count = 문자찾기_solution3("Computercooler", 'C');
        System.out.println("count : " + count);
    }
    private int 문자찾기_solution1(String str, char c) {
        char lowerChar = Character.toLowerCase(c);
        String lowerString = str.toLowerCase();

        return lowerString.length() - lowerString.replace(String.valueOf(lowerChar), "").length();
    }
    private int 문자찾기_solution2(String str, char c) {
        char lowerChar = Character.toLowerCase(c);
        String lowerString = str.toLowerCase();
        long count = lowerString.chars()
                .filter(idx -> idx == lowerChar)
                .count();
        return Math.toIntExact(count); // Long -> int casting 시 오버플로우 예외처리
    }
    private int 문자찾기_solution3(String str, char c) {
        int answer = 0;
        c = Character.toLowerCase(c);
        str = str.toLowerCase();
        for (char x : str.toCharArray()) {
            if (x == c) answer++;
        }
        return answer;
    }

    @Test
    @DisplayName("대소문자변환")
    void 대소문자변환() {
        String result = 대소문자변환_solution2("StuDY");
        System.out.println("result : " + result);
    }
    private String 대소문자변환_solution1(String str) {
        return str.chars()
                .map(c -> Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c))
                .mapToObj(c -> Character.toString((char)c))
                .collect(Collectors.joining());
    }
    private String 대소문자변환_solution2(String str) {
        String result = "";
        for(char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result += Character.toLowerCase(c);
            } else {
                result += Character.toUpperCase(c);
            }
        }
        return result;
    }

    @Test
    @DisplayName("문장 속 단어(indexOf(), substring())")
    void 문장속단어() {
        String result = 문장속단어_solution3("it is time to study");
        System.out.println("result : " + result);
    }
    private String 문장속단어_solution1(String str) {
        // 문자 배열 중 가장 긴 문자의 길이 출력
        int longestLength = Arrays.stream(str.split(" "))
                .mapToInt(String::length)
                .max()
                .orElse(0);
        System.out.println(longestLength);

        // 문자 배열 중 가장 긴 문자 출력
        String longestString = Arrays.stream(str.split(" "))
                .max((s1, s2) -> Integer.compare(s1.length(), s2.length()))
                .orElse("");
        System.out.println(longestString);

        // 문자 배열 중 가장 긴 문자 출력(가장 길이가 긴 단어가 여러개일 경우 문장속에서 가장 앞쪽에 위치한 문자 출력)
        return Arrays.stream(str.split(" "))
                .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : "")
                .orElse("");
    }
    private String 문장속단어_solution2(String str) {
        String result = "";
        for (String s : str.split( " ")) {
            if (s.length() > result.length()) {
                result = s;
            }
        }
        return result;
    }
    private String 문장속단어_solution3(String str) {
        String answer = "";
        int m = Integer.MIN_VALUE, pos;
        while ((pos = str.indexOf(" ")) != -1) {
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            if (len > m) {
                m = len                                                                                                                        ;
                answer = tmp;
            }
            str = str.substring(pos + 1);
            System.out.println(answer);
        }
        if(str.length() > str.indexOf(" ")) {
            answer = str;
        }
        return answer;
    }

    @Test
    @DisplayName("문자열뒤집기")
    void 문자열뒤집기() {
        String[] str = new String[]{"good", "Time", "Big"};
        ArrayList<String> result = 문자열뒤집기_solution3(3, str);
        for (String s : result) {
            System.out.println(s);
        }
    }
    private ArrayList<String> 문자열뒤집기_solution1(int n, String[] str) {
        ArrayList<String> answer = new ArrayList<>();
        for (int i =0; i < str.length; i++) {
            if (i < n) {
                StringBuilder sb = new StringBuilder(str[i]);
                answer.add(String.valueOf(sb.reverse()));
            } else {
                answer.add(str[i]);
            }
        }
        return answer;
    }
    private ArrayList<String> 문자열뒤집기_solution2(int n, String[] str) {
        return Arrays.stream(str)
                .map(s -> String.valueOf(new StringBuilder(s).reverse()))
                .collect(Collectors.toCollection(ArrayList::new));
    }
    private ArrayList<String> 문자열뒤집기_solution3(int n, String[] str) {
        ArrayList<String> answer = new ArrayList<>();
        for (String x : str) {
            char[] s = x.toCharArray();
            int lt = 0, rt = x.length()-1;
            while (lt < rt) {
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
            answer.add(String.valueOf(s));
        }
        return answer;
    }

    @Test
    @DisplayName("특정문자뒤집기")
    void 특정문자뒤집기() {
        String result = 특정문자뒤집기_solution1("a#b!GE*T@S");
        System.out.println("result : " + result);
    }
    private String 특정문자뒤집기_solution1(String str) {
        char[] chars = str.toCharArray();
        int lt = 0, rt = str.length()-1;

        while(lt < rt) {
            if (!Character.isAlphabetic(chars[lt])) lt++;
            else if (!Character.isAlphabetic((chars[rt]))) rt--;
            else {
                char tmp = chars[lt];
                chars[lt] = chars[rt];
                chars[rt] = tmp;
                lt++;
                rt--;
            }
        }
        return String.valueOf(chars);
    }

    @Test
    @DisplayName("중복문자제거")
    void 중복문자제거() {
        String result = 중복문자제거_solution2("ksekkset");
        System.out.println("result : " + result);
    }
    private String 중복문자제거_solution1(String str) {
        return Arrays.stream(str.split(""))
                .distinct()
                .collect(Collectors.joining());
    }
    private String 중복문자제거_solution2(String str) {
        String answer = "";

        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i)+" "+i+" "+ str.indexOf(str.charAt(i)));
            if (i == str.indexOf(str.charAt(i))) {
                answer+=str.charAt(i);
            }
        }

        return answer;
    }

    @Test
    @DisplayName("회문문자열") // 회문문자열 : 앞에서 읽으나 뒤에서 읽으나 동일한 문자열
    void 회문문자열() {
        String result = 회문문자열_solution3("go2oG");
        System.out.println("result : " + result);
    }
    private String 회문문자열_solution1(String str) {
        str = str.toLowerCase();
        char[] chars = str.toCharArray();
        int lt = 0, rt = str.length()-1;
        while (lt < rt) {
            if (chars[lt] == chars[rt]) {
              lt++;
              rt--;
            } else {
                return "NO";
            }
        }
        return "YES";
    }
    private String 회문문자열_solution2(String str) {
        String answer = "YES";
        str = str.toLowerCase();
        for (int i = 0; i < str.length()/2; i++) {
            if (str.charAt(i) != str.charAt(str.length()-1-i)) {
                return "NO";
            }
        }
        return answer;
    }
    private String 회문문자열_solution3(String str) {
        StringBuilder sb = new StringBuilder(str);
        String reverseStr = sb.reverse().toString();

        return str.equalsIgnoreCase(reverseStr) ? "YES" : "NO";
    }
}