package leetcode;

/**
 删去k个数字后的最小值，假设给出一个整数1593212，删去3个数字，新整数最小的情况是1212。

 */
public class RemoveKDigits {

    /**
     * 把原整数的所有数字从左到右进行比较， 如果发现某一位数字大于它右面的数字，
	 * 那么在删除该数字后，必然会使该数位的值降低，因为右面比它小的数字顶替了它的位置。
     * @param num  原整数
     * @param k  删除数量
     */
    public static String removeKDigits(String num, int k) {
        for(int i=0; i<k; i++){
            boolean hasCut = false;
            //从左向右遍历，找到比自己右侧数字大的数字并删除
            for(int j=0; j<num.length()-1;j++){
                if(num.charAt(j) > num.charAt(j+1)){
                    num = num.substring(0, j) + num.substring(j+1,num.length());
                    hasCut = true;
                    break;
                }
            }
            //如果没有找到要删除的数字，则删除最后一个数字
            if(!hasCut){
                num = num.substring(0, num.length()-1);
            }
        }
        //清除整数左侧的数字0
        int start = 0;
        for(int j=0; j<num.length()-1; j++){
            if(num.charAt(j) != '0'){
                break;
            }
            start++;
        }
        num = num.substring(start, num.length()) ;
        //如果整数的所有数字都被删除了，直接返回0
        if(num.length() == 0){
            return "0";
        }
        return num;
    }

    /**
     * 以目前的代码逻辑，下一轮循环时，还要从头开始遍历，再次重复遍历大部分 数字，一直遍历到数字3，发现3>2，从而删除3。 事实上，我们应该停留在上一次删除的位置继续进行比较，而不是再次从头开始遍历。
     * @param num  原整数
     * @param k  删除数量
     */
    public static String removeKDigitsV2(String num, int k) {
        //新整数的最终长度 = 原整数长度 - k
        int newLength = num.length() - k;
        //创建一个栈，用于接收所有的数字
        char[] stack = new char[num.length()];
        int top = 0;
        for (int i = 0; i < num.length(); ++i) {
            //遍历当前数字
            char c = num.charAt(i);
            //当栈顶数字大于遍历到的当前数字，栈顶数字出栈（相当于删除数字）
            while (top > 0 && stack[top-1] > c && k > 0) {
                top -= 1;
                k -= 1;
            }
            //如果遇到数字0，且栈为空，0不入栈
            if('0' == c && top == 0){
                newLength--;
                if(newLength <= 0){
                    return "0";
                }
                continue;
            }
            //遍历到的当前数字入栈
            stack[top++] = c;
        }
        // 用栈构建新的整数字符串
        return newLength<=0 ? "0" : new String(stack, 0, newLength);
    }

    public static void main(String[] args) {
        System.out.println(removeKDigits("1593212", 3));
        System.out.println(removeKDigits("30200", 1));
        System.out.println(removeKDigits("10", 2));
        System.out.println(removeKDigits("541270936", 3));
        System.out.println(removeKDigits("1593212", 4));
        System.out.println(removeKDigits("1000020000000010", 2));
    }
}
