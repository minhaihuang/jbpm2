package test3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TestTree {
	/*
	 * 设S={A,B,C,D,E,F},W={2,3,5,7,9,12}
	 */
	static HashMap map;

	public TestTree() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Character[] character = { 'a', 'd', '+', 'c', '1', 'x','=','k','i' };
		double[] weight = { 0.2, 0.1, 0.1, 0.2, 0.09, 0.05,0.12,0.05,0.09 };// 有序或者无序都一样
		map = new HashMap();
		
		List<TreeNode<Double>> nodes = new ArrayList<TreeNode<Double>>();
		for (int i = 0; i < weight.length; i++) {
			nodes.add(new TreeNode(weight[i]));
			map.put(weight[i], character[i]);
		}
		while (true) {
			if (nodes.size() <= 1)
				break;
			// 找两个最小的
			TreeNode minNode = nodes.get(0);
			TreeNode sminNode = nodes.get(1);
			for (int i = 1; i < nodes.size(); i++) {

				TreeNode tempNode = nodes.get(i);

				double a = (Double) minNode.getData();
				double b = (Double) sminNode.getData();
				double t = (Double) tempNode.getData();

				if (a >= b) {
					sminNode = minNode;
					minNode = tempNode;
				}
			}
			nodes.remove(minNode);
			nodes.remove(sminNode);
			TreeNode newNode = new TreeNode((Double) minNode.getData()
					+ (Double) sminNode.getData());
			newNode.leftNode = minNode;
			newNode.rightNode = sminNode;
			nodes.add(newNode);
		}
		TreeNode hafmanTreeNode = nodes.get(0);
		getHalmanCode(hafmanTreeNode, " ");

	}

	public static void getHalmanCode(TreeNode hafmanTreeNode, String blank) {
		if (hafmanTreeNode == null)
			return;
		if (hafmanTreeNode.leftNode == null && hafmanTreeNode.rightNode == null) {
			System.out.println("->" + getCharacter(hafmanTreeNode.data));
		} else {
			System.out.print("0");
			getHalmanCode(hafmanTreeNode.leftNode, blank + " ");
			System.out.print(blank + "1");
			getHalmanCode(hafmanTreeNode.rightNode, blank + " ");
		}
	}

	// 得到某一个字符的编码
	public static void getHalmanCode(TreeNode hafmanTreeNode,
			Character character) {
		if (hafmanTreeNode == null)
			return;
		if (hafmanTreeNode.leftNode == null && hafmanTreeNode.rightNode == null) {
			if (getCharacter(hafmanTreeNode.data) == character) {
				System.out.print("");
			}
		}
	}

	// 得到权值对应的字符
	public static Character getCharacter(Object data) {
		Set set = map.entrySet();
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry entry = (Entry) iterator.next();
			if ((Double)entry.getValue() == data) {
				map.remove(entry.getKey());
				return (Character) entry.getKey();
			}
		}
		return null;
	}
	
	

}