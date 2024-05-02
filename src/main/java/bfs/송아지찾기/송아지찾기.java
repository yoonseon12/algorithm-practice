package bfs.송아지찾기;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 송아지찾기 {
    int[] dis = {1,-1,5};
    int[] ch;
    Queue<Integer> queue = new LinkedList<>();
    public int BFS(int s, int e) {
        ch = new int[10001]; // 문제에서 좌표가 10000 까지여서 10001로 설정
        ch[s] = 1; // 출발지점 체크
        queue.offer(s); // 체크하고 큐에 넣는다.
        int L = 0; // 노드 레벨
        while (!queue.isEmpty()) {
            int len = queue.size(); // 레벨에 있는 원소의 개수
            for (int i=0; i<len; i++) {
                int x = queue.poll();
                for (int j=0; j<3; j++) {
                    int nx = x+dis[j]; // x의 자식노드
                    if (nx == e) return L+1;
                    if (nx>=1 && nx<=10000 && ch[nx]==0) { // nx>=1 && nx<=10000 : 문제에서 나온 좌표범위
                                                           // ch[nx]==0 : 아직 방문하지 않은 곳
                        ch[nx]=1; // 방문처리
                        queue.offer(nx);
                    }

                }
            }
            L++;
        }
        return 0;
    }
    public static void main(String[] args) {
        송아지찾기 T = new 송아지찾기();
        Scanner kb = new Scanner(System.in);
        int s = kb.nextInt();
        int e = kb.nextInt();
        System.out.println(T.BFS(s, e));
    }
}
