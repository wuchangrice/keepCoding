package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oukinsei on 2020/1/19.
 */
public class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
        this.neighbors = new ArrayList<>();
    }
}
