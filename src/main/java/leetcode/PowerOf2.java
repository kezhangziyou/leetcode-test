package leetcode;

/**
 * 如何判断一个数是否为2的整数次 幂
 */
public class PowerOf2 {

	/**
	 * 依次乘以 2 判断
	 * @param num
	 * @return
	 */
    public static boolean isPowerOf2(int num) {
        int temp = 1;
        while(temp<=num){
            if(temp == num){
                return true;
            }
            temp = temp*2;
        }
        return false;
    }

	/**
	 * 位移运算代替乘法
	 * @param num
	 * @return
	 */
	public static boolean isPowerOf2V2(int num) {
        int temp = 1;
        while(temp<=num){
            if(temp == num){
                return true;
            }
            temp = temp<<1;
        }
        return false;
    }

	/**
	 * 与运算是按照位运算的
	 * @param num
	 * @return
	 */
	public static boolean isPowerOf2V3(int num) {
        return (num&num-1) == 0;
    }

    public static void main(String[] args) {

    	int a=3;
		int b=8;
    	System.out.println("左移："+(a<<1));
		System.out.println("右移："+(a>>1));
		System.out.println("与："+(a&b));
		System.out.println("或："+(a|b));
		System.out.println("或移："+(a^b));

        System.out.println(isPowerOf2V3(32));
        System.out.println(isPowerOf2V3(19));
    }
}
