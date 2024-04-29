import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class HuffmanTreeBuilder {

    public static List<BinaryTree> createAllTrees(Dictionary<Character, Integer> dictionary) {
        List<BinaryTree> treeList = new ArrayList<>();
        for (Character c : dictionary.keySet()) {
            Node n = new Node(c.toString(), dictionary.get(c), null, null);
            BinaryTree t = new BinaryTree(n);
            treeList.add(t);
        }
        treeList.sort(Comparator.comparingInt(t -> t.root.frequency));
        return treeList;
    }

    public static List<BinaryTree> includeNewTree(BinaryTree newTree, List<BinaryTree> list) {
        int freq = newTree.root.frequency;
        int insertIndex = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).root.frequency >= freq) {
                insertIndex = i;
                break;
            }
        }
        list.add(insertIndex, newTree);
        return list;
    }

    public static List<BinaryTree> createNewTree(BinaryTree t1, BinaryTree t2, List<BinaryTree> treeList) {
        int freq = t1.root.frequency + t2.root.frequency;
        String newLabel = t1.root.label + t2.root.label;
        Node newNode = new Node(newLabel, freq, t1.root, t2.root);
        BinaryTree newTree = new BinaryTree(newNode);
        treeList.remove(t1);
        treeList.remove(t2);
        return includeNewTree(newTree, treeList);
    }

    public static BinaryTree createHuffmanTree(List<BinaryTree> treeList) {
        while (treeList.size() > 1) {
            BinaryTree t1 = treeList.get(0);
            BinaryTree t2 = treeList.get(1);
            treeList = createNewTree(t1, t2, treeList);
        }
        return treeList.get(0);
    }
}
