package base.data.structure.tree;

/**
 * @author zhangke
 * @version 1.0
 * @className TreeNode
 * @description 二叉树
 * @date 3/12/22 3:24 PM
 **/
public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}