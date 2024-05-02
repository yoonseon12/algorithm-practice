package dfs;

public class 말단노드까지의거리 {
    /**
     * 최단거리 문제는 BFS로 푸는게 맞지만 연습으로 DFS로도 풀어본다.
     * DFS로 풀라면 항상 노드의 자식은 꽉 차있어야하는 제약사항이 있다.
     */

    public static void main(String[] args) {
        Node node = new Node(1);
        node.lt = new Node(2);
        node.rt = new Node(3);
        node.lt.lt = new Node(4);
        node.lt.rt = new Node(5);

        int level = DFS(0, node);

        System.out.println(level);
    }

    public static int DFS(int level, Node node) {
        if (node.lt == null && node.rt == null) {
            return level;
        }
        level++;
        return Math.min(DFS(level, node.lt), DFS(level, node.rt));
    }

    static class Node {
        public int value;
        private Node lt;
        private Node rt;

        public Node(int value) {
            this.value = value;
            lt = null;
            rt = null;
        }
    }
}
