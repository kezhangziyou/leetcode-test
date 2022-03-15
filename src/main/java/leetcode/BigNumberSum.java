package leetcode;

/**
 * Created by weimengshu on 2018/10/20.
 */
public class BigNumberSum {

	public static void main(String[] args) {
		System.out.println(bigNumberSumV1("426709752318", "95481253129"));
	}

    /**
     * 大整数求和
     * @param bigNumberA  大整数A
     * @param bigNumberB  大整数B
     */
    public static String bigNumberSumV1(String bigNumberA, String bigNumberB) {
		if (bigNumberA.equals("0") ) {
			return bigNumberB;
		}
		if (bigNumberB.equals("0") ) {
			return bigNumberA;
		}
        //1.把两个大整数用数组逆序存储，数组长度等于较大整数位数+1
        int maxLength = bigNumberA.length() > bigNumberB.length() ? bigNumberA.length() : bigNumberB.length();
        int[] arrayA = new int[maxLength+1];
        for(int i=0; i< bigNumberA.length(); i++){
            arrayA[i] = bigNumberA.charAt(bigNumberA.length()-1-i) - '0';
        }
        int[] arrayB = new int[maxLength+1];
        for(int i=0; i< bigNumberB.length(); i++){
            arrayB[i] = bigNumberB.charAt(bigNumberB.length()-1-i) - '0';
        }
        //2.构建result数组，数组长度等于较大整数位数+1
        int[] result = new int[maxLength+1];
        //3.遍历数组，按位相加
        for(int i=0; i<result.length; i++){
            int temp = result[i];
            temp += arrayA[i];
            temp += arrayB[i];
            //判断是否进位
            if(temp >= 10){
                temp = temp-10;
                result[i+1] = 1;
            }
            result[i] = temp;
        }
        //4.把result数组再次逆序并转成String
        StringBuilder sb = new StringBuilder();
        //是否找到大整数的最高有效位
        boolean findFirst = false;
        for (int i = result.length - 1; i >= 0; i--) {
            if(!findFirst){
                if(result[i] == 0){
                    continue;
                }
                findFirst = true;
            }
            sb.append(result[i]);
        }
        return sb.toString();
    }

	/**
	 * 大整数求和
	 * @param bigNumberA  大整数A
	 * @param bigNumberB  大整数B
	 */
	public static String bigNumberSumV2(String bigNumberA, String bigNumberB) {
		int i = bigNumberA.length() - 1, j = bigNumberB.length() - 1, add = 0;
		StringBuffer ans = new StringBuffer();
		//定义两个指针 i和 j分别指向 bigNumberA和bigNumberB的末尾，即最低位，
		// 同时定义一个变量 add 维护当前是否有进位，然后从末尾到开头逐位相加即可

		while (i >= 0 || j >= 0 || add != 0) {
			//指针当前下标处于负数的时候返回 00，等价于对位数较短的数字进行了补零操作，这样就可以除去两个数字位数不同情况的处理
			int x = i >= 0 ? bigNumberA.charAt(i) - '0' : 0;
			int y = j >= 0 ? bigNumberB.charAt(j) - '0' : 0;
			int result = x + y + add;
			ans.append(result % 10);
			add = result / 10;
			i--;
			j--;
		}
		ans.reverse();
		return ans.toString();
	}


}
