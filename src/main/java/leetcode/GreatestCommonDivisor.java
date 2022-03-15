package leetcode;

/**
 * 如何求出最大公约数
 */
public class GreatestCommonDivisor {

	public static void main(String[] args) {
		System.out.println(gcd(25, 5));
		System.out.println(gcd(100, 80));
		System.out.println(gcd(27, 14));
	}

	/**
	 * 暴力枚举的方法，从较小整数的一半开始，试图 找到一个合适的整数i，看看这个整数能否被a和b同时整除。
	 * 时间复杂度是O(min(a, b))。
	 * @param a
	 * @param b
	 * @return
	 */
    public static int getGreatestCommonDivisor(int a, int b){
        int big = a>b ? a:b;
        int small = a<b ? a:b;
        if(big%small == 0){
            return small;
        }
        for(int i= small/2; i>1; i--){
            if(small%i==0 && big%i==0){
                return i;
            }
        }
        return  1;
    }

	/**
	 * 辗转相除法！求出两个正整数的最大公约数，
	 * ：两个正整数a和b（a>b），它们的最大公约数等于a除以b的余数c和b之间的最大公约数。
	 * 例如10和25，25除以10商2余5，那么10和25的最大公约数，等同于10和5的最大公约数。
	 * 时间复杂度O(log(max(a,b))) 但是取模运算性能较差。
	 * @param a
	 * @param b
	 * @return
	 */
	public static int getGreatestCommonDivisorV2(int a, int b){
        int big = a>b ? a:b;
        int small = a<b ? a:b;
        //直到两个数可以整除，或者其中一个数减小到1为止。
		//问题：当两个整数较大时，做a%b取模运算的性能会比较差。
        if(big%small == 0){
            return small;
        }
        return getGreatestCommonDivisorV2(big%small, small);
    }

	/**
	 * 更相减损术：两个正整数a和b（a>b），它们的最大公约数等于a-b的差 值c和较小数b的最大公约数。
	 * 例如10和25，25减10的差是15，那么10和25的最大公约数，等同于10和15的最大公约数。
	 * 最坏时间复杂度为 O(max(a, b))。
	 * @param a
	 * @param b
	 * @return
	 */
	public static int getGreatestCommonDivisorV3(int a, int b){
        if(a == b){
            return a;
        }
        int big = a>b ? a:b;
        int small = a<b ? a:b;
        return getGreatestCommonDivisorV3(big - small, small);
    }

	/**
	 * 把辗转相除法和更相减损术的优势结合起来，在更相减损术的基础上使用移位运算。
	 * 当a和b均为偶数时，gcd(a,b) = 2×gcd(a/2, b/2) = 2×gcd(a>>1,b>>1)。
	 * 当a为偶数，b为奇数时，gcd(a,b) = gcd(a/2,b) = gcd(a>>1,b)。
	 * 当a为奇数，b为偶数时，gcd(a,b) = gcd(a,b/2) = gcd(a,b>>1)。
	 * 当a和b均为奇数时，先利用更相减损术运算一次，gcd(a,b) = gcd(b,a-b)，此时a-b必然是偶数，然后又可以继续进行移位运算。
	 * 例如计算10和25的最大公约数的步骤如下。
	 * 1. 整数10通过移位，可以转换成求5和25的最大公约数。
	 * 2. 利用更相减损术，计算出25-5=20，转换成求5和20的最大公约数。
	 * 3. 整数20通过移位，可以转换成求5和10的最大公约数。
	 * 4. 整数10通过移位，可以转换成求5和5的最大公约数。
	 * 5. 利用更相减损术，因为两数相等，所以最大公约数是5。 这种方式在两数都比较小时，可能看不出计算次数的优势；
	 * 当两数越大时，计 算次数的减少就会越明显。
	 * 时间复杂度为O(log(max(a, b)))。
	 * @param a
	 * @param b
	 * @return
	 */
	public static int gcd(int a, int b){
        if(a == b){
            return a;
        }
        //让整数和1进行与运算，如果 (a&1)==0，则说明整数a是偶数，让整数和1进行与运算，如果 (a&1)==0，则说明整数a是偶数
        if((a&1)==0 && (b&1)==0){
            return gcd(a >> 1, b >> 1)<<1;
        } else if((a&1)==0 && (b&1)!=0){
            return gcd(a >> 1, b);
        } else if((a&1)!=0 && (b&1)==0){
            return gcd(a, b >> 1);
        } else {
            int big = a>b ? a:b;
            int small = a<b ? a:b;
            return gcd(big - small, small);
        }
    }


}
