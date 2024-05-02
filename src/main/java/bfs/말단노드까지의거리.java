package bfs;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class 말단노드까지의거리 {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.lt = new Node(2);
        node.rt = new Node(3);
        node.lt.lt = new Node(4);
        node.lt.rt = new Node(5);

        int level = BFS(node);

        System.out.println(level);
    }

    private static int BFS(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        int level = 0;

        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i=0; i<size; i++) {
                Node currentNode = queue.poll();
                if (currentNode.rt == null && currentNode.lt == null) {
                    return level;
                }
                offerChildNode(queue, currentNode);
            }
        }
        return 0;
    }

    private static void offerChildNode(Queue<Node> queue, Node parentNode) {
        Optional.ofNullable(parentNode.lt)
            .map(lt -> queue.offer(lt));
        Optional.ofNullable(parentNode.rt)
            .map(rt -> queue.offer(rt));
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
