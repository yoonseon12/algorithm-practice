import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class RecursiveTest {
    @Test
    @DisplayName("재귀함수(스택프레임)")
    void 재귀함수() {
        재귀함수_solution(3);
    }
    private void 재귀함수_solution(int n) {
        if (n==0) return;
        재귀함수_solution(n-1);
        System.out.print(n+" "); // 재귀함수는 스택프레임을 사용한다.
    }

    @Test
    @DisplayName("이진수출력(재귀)")
    void 이진수출력() {
        이진수출력_solution(11);
    }
    private void 이진수출력_solution(int n) {
        if (n==0) return;
        System.out.print(n%2+" ");
        이진수출력_solution(n/2);
    }

    @Test
    @DisplayName("팩토리얼")
    void 팩토리얼() {
        System.out.println(팩토리얼_solution(5));
    }
    private int 팩토리얼_solution(int n) {
        int answer = 1;
        if (n==0) return 1;
        answer = n * 팩토리얼_solution(n-1);
        return answer;
    }

    @Test
    @DisplayName("피보나치 재귀(메모이제이션)")
    void 피보나치재귀() {
        int n = 45;
        fibo = new int[n+1];
        피보나치재귀_solution1(n);
        for (int i: fibo) System.out.print(i+" ");
    }
    int[] fibo;
    private int 피보나치재귀_solution1(int n) {
        if (fibo[n] > 0) return fibo[n];
        if (n==1) return fibo[n] = 1;
        else if (n==2) return fibo[n] = 1;
        else return fibo[n] = 피보나치재귀_solution1(n-1)+ 피보나치재귀_solution1(n-2);
    }

    @Test
    @DisplayName("이진트리순회(DFS : Depth-First Search)")
    void 이진트리순회() {
        Node root;
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        이진트리순회_solution(root);
    }
    private void 이진트리순회_solution(Node root) {
        if (root == null) return;
        else {
//            System.out.print(root.data + " "); // 전위순회 (1 2 4 5 3 6 7)
            이진트리순회_solution(root.lt);
//            System.out.print(root.data + " "); // 중위순회 (4 2 5 1 6 3 7)
            이진트리순회_solution(root.rt);
            System.out.print(root.data + " "); // 후위순회 (4 5 2 6 7 3 1)

        }
    }
    class Node {
        int data;
        Node lt, rt;
        public Node(int val) {
            data=val;
            lt=rt=null;
        }
    }

    @Test
    @DisplayName("부분집합구하기(DFS)")
    void 부분집합구하기() {
        n = 3; // 부분집합의 개수
        ch = new int[n+1];
        부분집합구하기_solution(1);
    }
    int n;
    int[] ch;
    private void 부분집합구하기_solution(int L) {
        if (L == n+1) { // 현재 단계 L이 부분집합의 크기 n+1에 도달하면
            String tmp = "";
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) tmp += (i + " "); // ch 배열에 1로 표시된 인덱스를 tmp 문자열에 추가
            }
            if (tmp.length() > 0) {
                System.out.println(tmp); // 만들어진 부분집합을 출력
            }
        }
        else {
            ch[L] = 1; // L 번째 원소를 부분집합에 포함시키는 경우 (왼쪽으로 뻗는 경우)
            부분집합구하기_solution(L+1);
            ch[L] = 0; // L 번째 원소를 부분집합에 포함시키지 않는 경우 (오른쪽으로 뻗는 경우)
            부분집합구하기_solution(L+1);
        }
    }

    @Test
    @DisplayName("이진트리레벨탐색(BFS : Breadth-First Search)")
    void 이진트리레벨탐색() {
        Node root;
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        이진트리레벨탐색_solution(root);
    }
    private void 이진트리레벨탐색_solution(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root); // 루트 노드를 큐에 추가
        int L = 0; // 탐색할 노드 레벨
        while(!queue.isEmpty()) { // 큐가 비어있을 때까지 반복(모든 노드가 탐색될 때까지 실행된다)
            int len = queue.size();
            System.out.print(L + "레벨 : ");
            for (int i=0; i<len; i++) {
                Node current = queue.poll(); // 큐에서 노드를 하나 꺼내와서
                System.out.print(current.data+" ");
                if (current.lt != null) queue.offer(current.lt); // 왼쪽 자식 노드가 있으면 큐에 추가
                if (current.rt != null) queue.offer(current.rt); // 오른쪽 자식 노드가 있으면 큐에 추가
            }
            L++; // 다음 레벨로 이동
            System.out.println();
        }
    }
}
