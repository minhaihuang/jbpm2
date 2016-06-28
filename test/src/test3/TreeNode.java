package test3;

public class TreeNode<Double> {
	public TreeNode leftNode;
	public TreeNode rightNode;
	public Double data;

	
	
	public TreeNode() {
		super();
	}

	public TreeNode getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(TreeNode leftNode) {
		this.leftNode = leftNode;
	}

	public TreeNode getRightNode() {
		return rightNode;
	}

	public void setRightNode(TreeNode rightNode) {
		this.rightNode = rightNode;
	}

	public Double getData() {
		return data;
	}

	public void setData(Double data) {
		this.data = data;
	}

	public TreeNode(Double data) {
		this.data = data;
	}
}