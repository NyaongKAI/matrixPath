package matrixPath;

class MathMatrixPath{
	int n1, n2, n3;
	int max;
	
	int k, n;
	int[][] c;
	
	public int max(int n1, int n2, int n3) {
		this.n1 = n1;
		this.n2 = n2;
		this.n3 = n3;
		
		if (n1 >= n2 && n1 >= n3) {
            max = n1;
        } else if (n2 >= n1 && n2 >= n3) {
            max = n2;
        } else {
            max = n3;
        }
		
		return max;
	}
	
	public void matrixPath(int k, int n) {
		this.k = k;
		this.n = n;
		
		for(int i = 1; i < k; i++) {
			c[i][0] = c[i-1][0] + c[i][0];
		}
		for(int j = 1; j < n; j++) {
			c[0][j] = c[0][j-1] + c[0][j];
		}
		for(int i = 1; i < k; i++) {
			for(int j =1; j < n; j++) {
				c[i][j] = c[i][j] + max(c[i-1][j], c[i][j-1], c[i-1][j-1]);
			}
		}
	}
}

public class MatrixPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] d = {{6, 7, 12, 5}, {5, 3, -11, 18}, {7, -7, 3, 3}, {2, 10, 14, 19}};
		
		MathMatrixPath m = new MathMatrixPath();
		m.c = d;
		m.matrixPath(4, 4);
		
		System.out.println(m.c[3][3]);
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				System.out.print(m.c[i][j] + " ");
			}
			System.out.println();
		}

	}

}