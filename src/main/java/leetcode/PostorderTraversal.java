package leetcode;

import base.data.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangke
 * @version 1.0
 * @className PostorderTraversal
 * @description
 * @date 3/12/22 3:47 PM
 **/
public class PostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> ans =new ArrayList<>();
		if (root == null) {
			return ans;
		}
		postorder(root,ans);
		return ans;
	}
	public void postorder(TreeNode root ,List<Integer> ans) {
		if (root == null) {
			return;
		}
		//后序，左右中
		postorder(root.left,ans);
		postorder(root.right,ans);
		ans.add(root.val);
	}
}