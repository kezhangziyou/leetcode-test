package problem23;

/**
 * @author zhangke
 * @version 1.0
 * @className IsValidSudoku FROM LEETCOE
 * @description
 * @date 3/2/22 5:16 PM
 **/
public class IsValidSudoku {

	public static void main(String[] args) {
		
		char [][] board ={{'5','3','.','.','7','.','.','.','.'}
			,{'6','.','.','1','9','5','.','.','.'}
			,{'.','9','8','.','.','.','.','6','.'}
			,{'8','.','.','.','6','.','.','.','3'}
			,{'4','.','.','8','.','3','.','.','1'}
			,{'7','.','.','.','2','.','.','.','6'}
			,{'.','6','.','.','.','.','2','8','.'}
			,{'.','.','.','4','1','9','.','.','5'}
			,{'.','.','.','.','8','.','.','7','9'}};


		System.out.println(isValidSudoku(board));
		
	}
	public static   boolean isValidSudoku(char[][] board) {

		//定义数字行内出现的次数
		int[][] row = new int[9][9];
		//定义数字列内出现的次数
		int[][] column = new int[9][9];
		//定义数字九宫格内出现的次数最大为9次
		int[][][] jiugongge = new int[3][3][9];
		//遍历数组
		for (int i =0;i <9;i++){
			for(int j = 0;j<9;j++){
				char c = board[i][j];
				//只要存在数字
				if (c !='.'){
					//把数字-1化成索引下标,c是字符串要减去字符串，-1会报错。
					int index = c-'1';
					//这个时候++意思是第i行这个c值次数+1，默认row第二位就是{1-9}-1；每一行都有可能是1-9
					//例如现在是第一行第一列是9，就在row[1][8]号位置+1
					row[i][index]++;
					//列同理
					column[j][index]++;
					//并且九宫格内次数也要+1,例如也是第1行第一列，i/3 j/3会自动定位到所在的小宫格
					jiugongge[i/3][j/3][index]++;
					//次数大于1就不成立一个数独
					if (row[i][index]>1||column[j][index]>1||jiugongge[i/3][j/3][index]>1){
						return false;}
				}
			}
		}
		return true;
	}
}