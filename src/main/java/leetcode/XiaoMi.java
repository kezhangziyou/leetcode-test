package leetcode;

import java.util.*;

/**
 * @author zhangke
 * @version 1.0
 * @className main
 * @description
 * @date 2020-07-25 12:08
 **/
public class XiaoMi {
	public static void main(String[] args) {
		//新建一个 List 存储 A,B,C,D 四个项目
		List<String> listItem = new ArrayList<>();
		listItem.add("A");
		listItem.add("B");
		listItem.add("C");
		listItem.add("D");

		//新建一个 List 存储 A,B,C,D 四个项目的依赖个数
		Map<String, Integer> listItemCount = new HashMap<>();

		//新建一个list存储依赖关系，
		List<Obj> listRelation = new ArrayList<>();
		listRelation.add(new Obj("A","B"));
		listRelation.add(new Obj("A","C"));
		listRelation.add(new Obj("A","D"));
		listRelation.add(new Obj("B","C"));
		listRelation.add(new Obj("B","D"));
		listRelation.add(new Obj("C","D"));

		int count=0;

		int result = solve(listItem, listRelation, count);
		System.out.println(result);


	}

	/**
	 * 解法思路：
	 * 1、新建一个 List 存储 A,B,C,D 四个项目的依赖个数
	 * 2、对依赖关系遍历listRelation，对每个依赖关系加一，则此时listItem为<A,3>,<B,2>,<C,1>
	 * 3，遍历listItem,找到在listItemCount没有的key并且list 中不存在 key 的项目，即最先编译的项目
	 * 4，遍历listRelation，删除被依赖关系项目不在 List 中的项目(即已删除的项目)
	 * 5，递归这个过程，当 List 为空或者listRelation为空，循环结束
	 *
	 * @param listItem     存储 A,B,C,D 四个项目
	 * @param listRelation 依赖关系
	 * @param count        编译次数
	 */
	public static int solve(List<String> listItem, List<Obj> listRelation, int count) {
		if (listItem.size() == 0 || listRelation.size() == 0) {
			return count;
		}

		//新建一个 List 存储 A,B,C,D 四个项目的依赖个数
		Map<String, Integer> listItemCount = new HashMap<>();
		//遍历依赖关系，对每一个依赖关系加一，则此时listItem为<A,3>,<B,2>,<C,1>
		for (Obj obj : listRelation) {
				count++;
				if (!listItemCount.containsKey(obj.getX())) {
					listItemCount.put(obj.getX(), 1);
				} else {
					listItemCount.put(obj.getX(), new Integer(listItemCount.get(obj.getX()).intValue() + 1));
				}
		}

		//遍历listItem,找到在listItemCount没有的 key,则删除
		Iterator<String> it = listItem.iterator();
		while (it.hasNext()) {
			count++;
			String x = it.next();
			if (!listItemCount.containsKey(x)) {
				it.remove();
			}
		}

		//遍历listItem,找到在listItemCount没有的 key,则删除
		Iterator<Obj> hashMapIterator = listRelation.iterator();
		while (hashMapIterator.hasNext()) {
			count++;
			Obj next = hashMapIterator.next();
			if (!listItem.contains(next.getY())) {
				hashMapIterator.remove();
			}
		}
		 return solve(listItem,listRelation,count);
	}
}

 class Obj {
	String x;
	String y;

	public Obj(String x, String y) {
		this.x = x;
		this.y = y;
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}
}
