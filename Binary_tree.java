public class BinaryTree {

    Node root;

    /**
     * Constructs a binary tree with a given root.
     * 
     * @param root The root node of the binary tree.
     */
    public BinaryTree(Node root) {
        this.root = root;
    }

    /**
     * Represents the binary tree as a string.
     * 
     * @return A string representation of the binary tree.
     */
    @Override
    public String toString() {
        return root.label + " : " + root.frequency;
    }

    /**
     * Node class to represent the structure of each element in the binary tree.
     */
    static class Node {
        char label;
        int frequency;
        Node left;
        Node right;

        /**
         * Constructs a node with label, frequency, left child, and right child.
         * 
         * @param label The character label of the node.
         * @param frequency The frequency of occurrence of the node's label.
         * @param left The left child of the node.
         * @param right The right child of the node.
         */
        Node(char label, int frequency, Node left, Node right) {
            this.label = label;
            this.frequency = frequency;
            this.left = left;
            this.right = right;
        }
    }
}
