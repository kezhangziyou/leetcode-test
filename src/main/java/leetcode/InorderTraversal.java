package leetcode;

import base.data.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangke
 * @version 1.0
 * @className InorderTraversal
 * @description
 * @date 3/12/22 3:46 PM
 **/
public class InorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> ans =new ArrayList<>();
		if (root == null) {
			return ans;
		}
		inorder(root,ans);
		return ans;
	}
	public void inorder(TreeNode root , List<Integer> ans) {
		if (root == null) {
			return;
		}
		//中序，左中右
		inorder(root.left,ans);
		ans.add(root.val);
		inorder(root.right,ans);
	}
}