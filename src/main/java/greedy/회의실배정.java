package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 회의실배정 {
    /**
     * 1. 회의가 끝나는 시간순으로 오름차순 정렬
     * 2. 회의가 빨리 끝나는 것부터 회의 진행 -> 회의가 빨리 끝나는 것 부터 먼저한다.-> 빨리 끝나는 것부터 계속 선택해나가면 최상의 결과가 나온다.
     * 3. 같을때도 비교하도록 구현하는 부분 주의하기
     */
    static int N;
    static List<Room> rooms;
    static int count, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        rooms = new ArrayList<>();
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            rooms.add(new Room(start, end));
        }

        Collections.sort(rooms);
        count = 0;
        end = 0;
        for (int i=0; i<N; i++) {
            if (rooms.get(i).start >= end) {
                count++;
                end = rooms.get(i).end;
            }
        }
        System.out.println(count);
    }

    static class Room implements Comparable<Room>{
        public int start;
        public int end;

        public Room(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Room o) {
            if (this.end == o.end) {
                return Integer.compare(this.start, o.start);
            }
            return Integer.compare(this.end, o.end);
        }
    }
}
