package avaliacao;

public class questao7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] A = {{1, 2},{3,4}};
		
		/*
		 * [1][2]
		 * [3][4]
		 */
		if(A[0].length==A.length) {
		int digonal1 = A[0][0]+A[1][1];
		int digonal2 = A[0][1]+A[1][0];
		int determinate = digonal1-digonal2;
		
		System.out.println(determinate);
		}else {
			System.out.println("matriz incorreta");
		}
		
	}

}
