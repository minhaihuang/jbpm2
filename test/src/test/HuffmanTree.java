package test;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HuffmanTree {
    private boolean debug = false;

    private HashMap<Character, Node> nodeMap;
    private ArrayList<Node> nodeList;

    public HuffmanTree() {
        nodeMap = new HashMap<Character, Node>();
        nodeList = new ArrayList<Node>();
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public String decode(Map<String, Character> codeTable, String binary) {
        int begin = 0, end = 1, count = binary.length();
        StringBuffer sb = new StringBuffer();
        while (end <= count) {
            String key = binary.substring(begin, end);
            if (codeTable.containsKey(key)) {
                sb.append(codeTable.get(key));
                begin = end;
            } else {
            }
            end++;
        }
        return sb.toString();
    }

    public String encode(String originText) {
        if (originText == null) return null;

        calculateWeight(originText);

//        if (debug) printNodes(nodeList);

        Node root = generateHuffmanTree(nodeList);

        generateHuffmanCode(root, "");

        if (debug) printNodes(root);

        StringBuffer sb = new StringBuffer();
        for (Character key : originText.toCharArray()) {
            sb.append(nodeMap.get(key).huffCode);
        }
        if (debug) System.out.println("二进制："+sb.toString());

        return sb.toString();
    }

    /**
     * 计算叶子权值
     * @param text
     */
    private void calculateWeight(String text) {
        for (Character c : text.toCharArray()) {
            if (nodeMap.containsKey(c)) {
                nodeMap.get(c).increaseWeight(1);//权值加1
            } else {
                Node leafNode = new Node(c, 1);
                nodeList.add(leafNode);
                nodeMap.put(c, leafNode);
            }
        }
    }

    /**
     * 生成哈夫曼树
     * @param nodes
     */
    private Node generateHuffmanTree(ArrayList<Node> nodes) {
        Collections.sort(nodes);
        while(nodes.size() > 1) {
            Node ln = nodes.remove(0);
            Node rn = nodes.remove(0);
            insertSort(nodes, new Node(ln.weight + rn.weight, ln, rn));
        }
        Node root = nodes.remove(0);
        nodes = null;
        return root;
    }

    /**
     * 插入排序
     * @param sortedNodes
     * @param node
     */
    private void insertSort(ArrayList<Node> sortedNodes, Node node) {
        if (sortedNodes == null) return;

        int weight = node.weight;
        int min = 0, max = sortedNodes.size();
        int index;
        if (sortedNodes.size() == 0) {
            index = 0;
        } else if (weight < sortedNodes.get(min).weight) {
            index = min;//插入到第一个
        } else if (weight >= sortedNodes.get(max-1).weight) {
            index = max;//插入到最后
        } else {
            index = max/2;
            for (int i=0, count=max/2; i<=count; i++) {
                if (weight >= sortedNodes.get(index-1).weight && weight < sortedNodes.get(index).weight) {
                    break;
                } else if (weight < sortedNodes.get(index).weight) {
                    max = index;
                } else {
                    min = index;
                }
                index = (max + min)/2;
            }
        }
        sortedNodes.add(index, node);
    }

    private void generateHuffmanCode(Node node, String code) {
        if (node.isLeaf()) node.huffCode = code;
        else {
            generateHuffmanCode(node.leftChild, code + "0");
            generateHuffmanCode(node.rightChild, code + "1");
        }
    }

    /**
     * 生成码表
     * @return
     */
    public Map<String, Character> getCodeTable() {
        Map<String, Character> map = new HashMap<String, Character>();
        for (Node node : nodeMap.values()) {
            map.put(node.huffCode, node.value);
        }
        return map;
    }

    /**
     * 打印节点信息
     * @param root
     */
    private void printNodes(Node root) {
        System.out.println("字符　　权值　　哈夫码");
        printTree(root);
    }

    private void printTree(Node root) {
        if (root.isLeaf()) System.out.println((root.value == null ? "   " : root.value)+"　　　　"+root.weight+"　　　　"+(root.huffCode == null ? "" : root.huffCode));
        if (root.leftChild != null) printTree(root.leftChild);
        if (root.rightChild != null) printTree(root.rightChild);
    }

    /**
     * 打印节点信息
     * @param nodes
     */
    private void printNodes(ArrayList<Node> nodes) {
        System.out.println("字符　　权值　　哈夫码");
        for (Node node : nodes) {
            System.out.println(node.value+"　　　　"+node.weight+"　　　　"+node.huffCode);
        }
    }
}
