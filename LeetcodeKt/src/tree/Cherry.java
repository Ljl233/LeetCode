package tree;

import java.util.Scanner;
import java.util.HashSet;

public class Cherry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        Node[] nodes = new Node[m + 1];
        HashSet set = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            int id = scanner.nextInt();
            if (nodes[id] == null) {
                nodes[id] = new Node();
            }
            if (scanner.next().equals("left")) {
                nodes[id].left = scanner.nextInt();
            } else {
                nodes[id].right = scanner.nextInt();
            }
        }
        for (int i = 1; i < m + 1; i++) {
            if (nodes[i] == null) {
                set.add(i);
            }
        }
        int res = 0;
        for (int i = 1; i < m + 1; i++) {
            if (nodes[i] != null) {
                if (set.contains(nodes[i].left) && set.contains(nodes[i].right)) {
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}

class Node {
    int left;
    int right;
}