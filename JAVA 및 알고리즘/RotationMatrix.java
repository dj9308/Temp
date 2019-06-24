package answer;
public class RotationMatrix {
	
	/*
	 * 처음엔 평범한 이중포문 및 if 절로 싹다 정해서 하려 했으나 너무 많아져서 안됨

. 포문을 어떻게 조건을 둘지 고민하던중 행이 바뀔수록 뒷쪽 열까지 같이 줄어들어야 하는것을 알아 length-1-i를 생각하게 됨

. 위아래 왼오른쪽을 이중포문 한번에돌리려고 하니까 안됨 그래서 j포문을 유형마다 돌리기로 함

. 하지만 행을 거듭할수록 열의 범위 처리를 할 줄 몰라 중지.

느낀점 및 배운점 : 1. 포문조건식이 아닌 결과값 배열에서 length-i 형식으로 하면 포문 반대로 값을 넣을 수 있음
			2. 난이도가 조금만 높아져도 문제의 답안지를 보지 않으면 이해가 안되는 것 같다.
			난이도가 낮은 문제들을 따로 풀어봐서 배열의 원리 및 포인트를  잘 이해하고 안되면 외우기라도 해야할 것 같다.
	 */
	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] arr1 = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 } };
		int[][] arr2 = new int[10][10];
		int count = 1;
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				arr2[i][j] = count++;
			}
		}
		System.out.println(arr[0][1]);
		// rotateMatrix testCase
		printMatrix(arr);
		printMatrix(rotateMatrix(arr));
		printMatrix(arr1);
		printMatrix(rotateMatrix(arr1));
		printMatrix(arr2);
		printMatrix(rotateMatrix(arr2));

		// rotateMatrix1 testCase
		printMatrix(arr);
		printMatrix(rotateMatrix1(arr));
		printMatrix(arr1);
		printMatrix(rotateMatrix1(arr1));
		printMatrix(arr2);
		printMatrix(rotateMatrix1(arr2));

	}

	// 정사각형 배열을 시계방향으로 한칸씩 이동
	// 여기를 구현하세요 :)
	public static int[][] rotateMatrix(int[][] arr) {
		int[][] result = new int[arr.length][arr[0].length];
		int limitIndex = arr.length - 1;
		for (int i = 0; i < arr.length / 2; i++) {
			for (int j = i; j < limitIndex - i; j++) {
				if(j==i && i<arr.length-1) {
					result[i][j] =arr[i+1][j];
				}
				else if()
				
			}
		}
		return result;
	}

	// 정사각형 배열의 홀수번째 줄은 반시계방향, 짝수번째 줄은 시계방향으로 한칸씩 이동
	// 여기를 구현하세요 :)
	public static int[][] rotateMatrix1(int[][] arr) {
		int[][] result = new int[arr.length][arr[0].length];
		for(int i = 0;i<arr.length;i++) {
			for(int j =0;j<arr[i].length;j++) {
				if(i==j && i%2==1) {
					if(i==0) {
						result[i][j]=arr[i+1][0];
					}else if(j<=arr[i].length-1 && j!=0) {
						result[i][j]=arr[i][j-1];
					}
				}
				else if(i%2==0) {
					if(j<arr[i].length-1) {
						result[i][j]=arr[i][j+1];
					}else if(j<=arr[i].length-1) {
						result[i][j]=arr[i][0];
					}
				}
					
			}
		}
		return result;
	}

	public static void printMatrix(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (j > 0) {
					System.out.print(" ");
					if (arr[i][j] < 10)
						System.out.print(" ");
				} else if (j == 0 && arr[i][j] < 10)
					System.out.print(" ");
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}