package leetcode;

import base.data.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangke
 * @version 1.0
 * @className PreorderTraversal
 * @description
 * @date 3/12/22 3:42 PM
 **/
public class PreorderTraversal {

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> ans =new ArrayList<>();
		if (root == null) {
			return ans;
		}
		preorder(root,ans);
		return ans;

	}

	public void preorder(TreeNode root ,List<Integer> ans) {
		if (root == null) {
			return;
		}
		ans.add(root.val);
		preorder(root.left,ans);
		preorder(root.right,ans);
	}
}