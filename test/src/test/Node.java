package test;

/**
 * ���
 * @author Davee
 */
public class Node implements Comparable<Node> {
    int weight;//Ȩֵ
    Node leftChild;//���ӽ��
    Node rightChild;//�Һ��ӽ��
    String huffCode;
    private boolean isLeaf;//�Ƿ���Ҷ��
    Character value;

    public Node(Character value, int weight) {
        this.value = value;
        this.weight = weight;
        this.isLeaf = true;
    }

    public Node(int weight, Node leftChild, Node rightChild) {
        this.weight = weight;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public void increaseWeight(int i) {
        weight += i;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}
