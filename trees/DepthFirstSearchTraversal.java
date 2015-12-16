package trees;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
/**
 * Created by VGN on 12/13/15.
 */
public class DepthFirstSearchTraversal {

    /*
    Given a binary tree, return the preorder traversal of its nodes' values.
    */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> solution = new ArrayList<Integer>();
        recursivePreOrderTraversal(root, solution);
        return solution;
    }

    private void recursivePreOrderTraversal(TreeNode root, List<Integer> solution){
        if (root == null){
            return;
        }
        solution.add(root.val);
        recursivePreOrderTraversal(root.left, solution);
        recursivePreOrderTraversal(root.right, solution);
    }

    /*
    Given a binary tree, return the postorder traversal of its nodes' values.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> solution = new ArrayList<Integer>();
        recursivePostOrderTraversal(root, solution);
        return solution;
    }

    private void recursivePostOrderTraversal(TreeNode root, List<Integer> solution){
        if (root == null){
            return;
        }
        recursivePostOrderTraversal(root.left, solution);
        recursivePostOrderTraversal(root.right, solution);
        solution.add(root.val);
    }
    /*
    Given a binary tree, determine if it is a valid binary search tree (BST).
    */
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        boolean isValid =  recurseTree(root.left, root.val, true) && recurseTree(root.right, root.val, false);
        if (!isValid)
            return false;
        return isValidBST(root.left) && isValidBST(root.right);
    }

    private boolean recurseTree(TreeNode node, int value, boolean less){
        if (node == null)
            return true;
        if (less){
            if (node.val >= value){
                return false;
            }
        }
        else{
            if (node.val <= value){
                return false;
            }
        }
        return recurseTree(node.left, value, less) && recurseTree(node.right, value, less);
    }

    /*
    non recursive version of preOrder traversal
     */
    private List<Integer> nonRecursivePreOrderTraversal(TreeNode root){
        List<Integer> solution = new ArrayList<Integer>();
        if (root == null){
            return solution;
        }
        LinkListStack<TreeNode> linkListStack = new LinkListStack<TreeNode>();
        linkListStack.push(root);
        while (!linkListStack.isEmpty()){
            TreeNode node = linkListStack.pop();
            solution.add(node.val);
            if (node.right != null){
                linkListStack.push(node.right);
            }
            if (node.left != null){
                linkListStack.push(node.left);
            }
        }
        return solution;
    }

    /*
        non recursive version of postOrder traversal
    */
    private List<Integer> nonRecursivePostOrderTraversal(TreeNode root){
        List<Integer> solution = new ArrayList<Integer>();
        if (root == null){
            return solution;
        }
        LinkListStack<TreeNode> linkListStack = new LinkListStack<TreeNode>();
        linkListStack.push(root);
        //symbol table to keep track of visited nodes, nodes that have been visited are added to solution
        Set<TreeNode> set = new HashSet<TreeNode>();
        while (!linkListStack.isEmpty()){
            TreeNode node = linkListStack.pop();
            if (!set.contains(node)) {
                set.add(node);
                linkListStack.push(node);
                if (node.right != null) {
                    linkListStack.push(node.right);
                }
                if (node.left != null) {
                    linkListStack.push(node.left);
                }
            }
            else {
                solution.add(node.val);
            }
        }
        return solution;
    }
}

class LinkListStack<Item>{
    private Node first;
    private int size;

    public void push(Item item){
       if (item == null){
           throw new RuntimeException("Cannot insert null item in stack");
       }
       size += 1;
       if (first == null){
           first = new Node(item);
           return;
       }
       Node oldFirst = first;
       first = new Node(item);
       first.next = oldFirst;
    }

    public Item pop(){
       if (first == null){
           throw new RuntimeException("Cannot pop on an empty stack");
       }
       size -= 1;
       Item item = first.item;
       first = first.next;
       return item;
    }

    public Item peek(){
        if (first == null){
            throw new RuntimeException("Cannot pop on an empty stack");
        }
        return first.item;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int getSize(){
        return size;
    }
    private class Node{
        Item item;
        Node next;
        Node(Item item){
            this.item = item;
        }
    }
}
