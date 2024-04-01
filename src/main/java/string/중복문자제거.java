package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class 중복문자제거 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String answer = Arrays.stream(str.split(""))
            .distinct()
            .map(String::valueOf)
            .collect(Collectors.joining(""));

        System.out.println(answer);
    }
}
