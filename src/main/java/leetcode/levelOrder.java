package leetcode;

import base.data.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zhangke
 * @version 1.0
 * @className levelOrder
 * @description
 * @date 3/12/22 4:34 PM
 **/
public class levelOrder {
	public int[] levelOrder(TreeNode root) {
		List<Integer> ans =new ArrayList<>();
		if(null == root){
			return  new int[0];
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			ans.add(node.val);
			if(node.left != null){
				queue.offer(node.left);
			}
			if(root.right != null){
				queue.offer(node.right);
			}
		}
		int[] ints = new int[ans.size()];
		for(int i = 0; i < ans.size(); i++)
			ints[i] = ans.get(i);
		return ints;
	}
}