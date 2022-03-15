import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangke
 * @version 1.0
 * @className Test
 * @description
 * @date 3/6/22 4:15 PM
 **/
public class Test {
	public static void main(String[] args) {
		String a = "A man, a plan, a canal: Panama";
		System.out.println(buildArray(new int []{1,3},3));

	}

	public static List<String> buildArray(int[] target, int n) {
		if(target==null){
			return null;
		}
		if(target.length==0){
			return null;
		}
		List<String> ans=new ArrayList<>();
		int index=1;
		int i=0;
		while(i<target.length){
			if(target[i]!=index){
				ans.add("Push");
				ans.add("Pop");
			} else{
				ans.add("Push");
				i++;
			}
			index++;

		}

		return ans;

	}
}