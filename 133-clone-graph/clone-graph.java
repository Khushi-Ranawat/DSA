/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

import java.util.*;

class Solution {
    private Node dfs(Node node, Map<Node, Node> map) {
        Node clone = new Node(node.val);
        map.put(node, clone);
        for (Node nei : node.neighbors) {
            if (!map.containsKey(nei)) {
                clone.neighbors.add(dfs(nei, map));
            } else {
                clone.neighbors.add(map.get(nei));
            }
        }
        return clone;
    }
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        return dfs(node, new HashMap<>());
    }
}