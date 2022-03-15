package base.data.structure.tree;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by weimengshu on 2018/9/22.
 */
public class BinaryTreeTraversal {


	public static void main(String[] args) {
		LinkedList<Integer> inputList = new LinkedList<Integer>(Arrays.asList(new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4,}));
		TreeNode treeNode = createBinaryTree(inputList);
		System.out.println("前序遍历：");
		preOrderTraversal(treeNode);
		System.out.println("中序遍历：");
		inOrderTraversal(treeNode);
		System.out.println("后序遍历：");
		postOrderTraversal(treeNode);
	}

	/**
	 * 构建二叉树
	 *
	 * @param inputList 输入序列
	 */
	public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
		TreeNode node = null;
		if (inputList == null || inputList.isEmpty()) {
			return null;
		}
		Integer data = inputList.removeFirst();
		//这里的判空很关键。如果元素是空，说明该节点不存在，跳出这一层递归；如果元素非空，继续递归构建该节点的左右孩子。
		if (data != null) {
			node = new TreeNode(data);
			node.left = createBinaryTree(inputList);
			node.right = createBinaryTree(inputList);
		}
		return node;
	}

	/**
	 * 二叉树前序遍历
	 *
	 * @param node 二叉树节点
	 */
	public static void preOrderTraversal(TreeNode node) {
		if (node == null) {
			return;
		}
		System.out.println(node.val);
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
	}

	/**
	 * 二叉树中序遍历
	 *
	 * @param node 二叉树节点
	 */
	public static void inOrderTraversal(TreeNode node) {
		if (node == null) {
			return;
		}
		inOrderTraversal(node.left);
		System.out.println(node.val);
		inOrderTraversal(node.right);
	}


	/**
	 * 二叉树后序遍历
	 *
	 * @param node 二叉树节点
	 */
	public static void postOrderTraversal(TreeNode node) {
		if (node == null) {
			return;
		}
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		System.out.println(node.val);
	}

}
