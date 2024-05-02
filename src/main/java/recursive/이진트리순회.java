package recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이진트리순회 {

    static int N;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        sb = new StringBuilder();
        Node node = new Node(1);
        initNode(node);

        recursive(node);

        System.out.println(sb.toString().trim());
    }

    private static void recursive(Node node) {
        if (node == null) return;
        else {
            // sb.append(node.root+" "); // 전위 - 중 왼 오
            recursive(node.lt);
            sb.append(node.root+" "); // 중위 - 왼 중 오
            recursive(node.rt);
            // sb.append(node.root+" "); // 후위 - 왼 오 중
        }
    }

    private static void initNode(Node node) {
        node.lt = new Node(2);
        node.rt = new Node(3);
        node.lt.lt = new Node(4);
        node.lt.rt = new Node(5);
        node.rt.lt = new Node(6);
        node.rt.rt = new Node(7);
    }

    static class Node {
        public int root;
        public Node lt;
        public Node rt;

        public Node(int data) {
            this.root = data;
            this.lt = null;
            this.rt = null;
        }
    }
}

