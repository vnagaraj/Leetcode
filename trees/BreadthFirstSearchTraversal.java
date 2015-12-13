package trees;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * Created by VGN on 12/12/15.
 */
public class BreadthFirstSearchTraversal {

    /*
    Given a binary tree, return the level order traversal of its nodes' values.
    (ie, from left to right, level by level).
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> solution = new ArrayList<List<Integer>>();
        LinkListQueue<TreeNode> queue = new LinkListQueue<TreeNode>();
        if (root == null){
            return solution;
        }
        queue.enque(root);
        HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        map.put(root, 0);
        int prevDist = 0;
        int dist = 0;
        List<Integer> list = new ArrayList<Integer>();
        while (!queue.isEmpty()){
            TreeNode node = queue.deque();
            dist = map.get(node);
            //System.out.println("DIST " + dist);
            if (prevDist == dist){
                //System.out.println("NODE " + node.val);
                list.add(node.val);
            }
            else{
                //now add list to solution
                solution.add(list);
                prevDist = dist;
                list = new ArrayList<Integer>();
                list.add(node.val);

            }
            if (node.left != null){
                queue.enque(node.left);
                map.put(node.left, map.get(node)+1);
            }
            if (node.right != null){
                queue.enque(node.right);
                map.put(node.right, map.get(node) + 1);
            }
        }
        solution.add(list);
        return solution;
    }

    /*
    Given a binary tree, return the bottom-up level order traversal of its nodes' values.
    (ie, from left to right, level by level from leaf to root).
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root){
        List<List<Integer>> solution = new Stack<List<Integer>>();
        LinkListQueue<TreeNode> queue = new LinkListQueue<TreeNode>();
        if (root == null){
            return solution;
        }
        queue.enque(root);
        HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        map.put(root, 0);
        int prevDist = 0;
        int dist = 0;
        List<Integer> list = new ArrayList<Integer>();
        while (!queue.isEmpty()){
            TreeNode node = queue.deque();
            dist = map.get(node);
            //System.out.println("DIST " + dist);
            if (prevDist == dist){
                //System.out.println("NODE " + node.val);
                list.add(node.val);
            }
            else{
                //now add list to solution
                //System.out.println("NODE " + list.get(0));
                solution.add(0, list);
                prevDist = dist;
                list = new ArrayList<Integer>();
                list.add(node.val);

            }
            if (node.left != null){
                queue.enque(node.left);
                map.put(node.left, map.get(node)+1);
            }
            if (node.right != null){
                queue.enque(node.right);
                map.put(node.right, map.get(node) + 1);
            }
        }
        //System.out.println("NODEyyy " + list.get(0));
        solution.add(0, list);
        return solution;
    }

    /*
    Given a binary tree, return the zigzag level order traversal of its nodes' values.
    (ie, from left to right, then right to left for the next level and alternate between).
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> solution = new ArrayList<List<Integer>>();
        LinkListQueue<TreeNode> queue = new LinkListQueue<TreeNode>();
        if (root == null){
            return solution;
        }
        queue.enque(root);
        HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        map.put(root, 0);
        int prevDist = 0;
        int dist = 0;
        List<Integer> list = new ArrayList<Integer>();
        while (!queue.isEmpty()){
            TreeNode node = queue.deque();
            dist = map.get(node);
            //System.out.println("DIST " + dist);
            if (prevDist == dist){
                //System.out.println("NODE " + node.val);
                if (dist % 2 == 0){
                    list.add(node.val);
                }
                else{
                    list.add(0, node.val);
                }
            }
            else{
                //now add list to solution
                solution.add(list);
                prevDist = dist;
                list = new ArrayList<Integer>();
                if (dist % 2 == 0){
                    list.add(node.val);
                }
                else{
                    list.add(0, node.val);
                }

            }
            insertInChildren(node, queue, map);
        }
        solution.add(list);
        return solution;

    }

    private void insertInChildren(TreeNode node, LinkListQueue queue, HashMap<TreeNode, Integer> map){

        if (node.left != null){
            queue.enque(node.left);
            map.put(node.left, map.get(node)+1);
        }
        if (node.right != null){
            queue.enque(node.right);
            map.put(node.right, map.get(node) + 1);
        }
    }

    /*
    Given a binary tree, imagine yourself standing on the right side of it,
    return the values of the nodes you can see ordered from top to bottom.
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> solution = new ArrayList<Integer>();
        LinkListQueue<TreeNode> queue = new LinkListQueue<TreeNode>();
        if (root == null){
            return solution;
        }
        queue.enque(root);
        HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        map.put(root, 0);
        int prevDist = 0;
        int dist = 0;
        TreeNode prevNode = null;
        while (!queue.isEmpty()){
            TreeNode node = queue.deque();
            dist = map.get(node);
            if (prevDist == dist){
                prevNode = node;
            }
            else{
                //now add list to solution
                solution.add(prevNode.val);
                prevDist = dist;
                prevNode = node;
            }
            if (node.left != null){
                queue.enque(node.left);
                map.put(node.left, map.get(node)+1);
            }
            if (node.right != null){
                queue.enque(node.right);
                map.put(node.right, map.get(node) + 1);
            }
        }
        if (prevNode != null)
            solution.add(prevNode.val);
        return solution;
    }

    /*
    Given a binary tree, find its minimum depth.
    The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
     */
    public int minDepth(TreeNode root) {
        LinkListQueue<TreeNode> queue = new LinkListQueue<TreeNode>();
        if (root == null){
            return 0;
        }
        int dist = 1;
        queue.enque(root);
        HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        map.put(root, dist);
        while (true){
            TreeNode node = queue.deque();
            dist = map.get(node);
            if (node.left != null){
                queue.enque(node.left);
                map.put(node.left, map.get(node)+1);
            }
            if (node.right != null){
                queue.enque(node.right);
                map.put(node.right, map.get(node) + 1);
            }
            if (node.left == null && node.right == null){
                return dist;
            }
        }
    }
}

class LinkListQueue<Item>{

    private Node first,last;
    private int size;

    public void enque(Item item){
        //add item to back of queue
        size +=1;
        if (first == null){
            first = new Node(item);
            last = first;
            return;
        }
        Node oldLast = last;
        last = new Node(item);
        oldLast.next = last;
    }

    public Item deque(){
        if (first == null){
            throw new java.lang.RuntimeException("Cannot remove from empty queue");
        }
        Item item = first.item;
        first = first.next;
        if (first == null){
            last = first;
        }
        size -=1;
        return item;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int getSize(){
        return size;
    }

    private class Node {
        Item item;
        Node next;

        Node(Item item){
            this.item = item;
        }
    }
}
