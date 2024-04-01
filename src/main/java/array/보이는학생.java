package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 보이는학생 {
    static int N, max;
    static String[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = br.readLine().split(" ");
        max = 0;
        int count = 0;
        for (String s : arr) {
            int toInt = Integer.parseInt(s);
            if (max < toInt) {
                max = toInt;
                count++;
            }
        }

        System.out.println(count);
    }
}
