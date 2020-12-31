public class EightQueens
{
    public char[][] board;
    public int n;

    public EightQueens(int n) {
        this.n = n;
        board = new char[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = '*';
            }
        }
    }

    public boolean solveNQueens(char board[][], int column) {
        if(column >= n) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
	// write your code here
    }
}
