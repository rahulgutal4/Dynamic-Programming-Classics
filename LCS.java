package dp;

public class LCS {

	private static void lcs(String str1, String str2){
		
		int len1 = str1.length();
		int len2 = str2.length();
		
		int[][] lcs = new int[len1+1][len2+1];
		String[][] track = new String[len1+1][len2+1];
		
		for(int i=0;i<=len1;i++){
			lcs[i][0] = 0;
			track[i][0] = "0";
		}
		
		for(int i=0;i<=len2;i++){
			lcs[0][i] = 0;
			track[0][i] = "0";
		}
		
		for(int i=1;i<=len1;i++){
			for(int j=1;j<=len2;j++){
				
				if(str1.charAt(i-1) == str2.charAt(j-1)){
					lcs[i][j] = lcs[i-1][j-1] + 1;
					track[i][j] = "diagonal";
				}else{
					
					lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
					if(lcs[i][j] == lcs[i-1][j]){
						track[i][j] = "top";
					}else{
						track[i][j] = "left";
					}
					
				}
				
			}
		}
		
		String answer = "";
		String tracker = track[len1][len2];
		int row = len1;
		int col = len2;
		while(tracker != "0"){
			
			if(tracker.equals("diagonal")){
				answer = str1.charAt(row-1) + answer;
				row--;
				col--;
			}else if(tracker.equals("left")){
				col--;
			}else{
				row--;
			}
			
			tracker = track[row][col];
		}
		
		System.out.println("LCS Length: " + lcs[len1][len2]);
		System.out.println("LCS: " + answer);
		
	}
	
	public static void main(String[] args) {
		
		String A = "rahul";
		String B = "rahabababl";
		
		lcs(A, B);
		
	}

}
