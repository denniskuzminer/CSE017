import java.util.Scanner;

public class EightQueensOneSoln
{

    // I know that everything could be package private but im different :)

    public boolean[][] board;
    public boolean[] upDiagEmpty;
    public boolean[] downDiagEmpty;
    public boolean[] colEmpty;
    public int n;

    public EightQueensOneSoln(int n) {
        this.n = n;
        this.board = new boolean[n][n];
        this.colEmpty = new boolean[n];
        this.upDiagEmpty = new boolean[n * 2 - 1];
        this.downDiagEmpty = new boolean[n * 2 - 1];
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("What size board would you like? ");
        int n = scnr.nextInt();

        EightQueensOneSoln query = new EightQueensOneSoln(n);
        boolean solnExists = query.findSolution(0);
        if(!solnExists) {
            System.out.println("No solution exists for n = " + n);
        }
        else {
            query.printSolution();
        }
    }

    public boolean findSolution(int row) {
        if(row == n) {
            printSolution();
            return true;
        }
        //boolean res = false;
        for(int col = 0; col < n; col++) {
            if(isSafe(row, col)) {
                placeQueen(row, col);
                findSolution(row + 1);
                //res = res || findSolution(row + 1);
                removeQueen(row, col);
            }
        }
        return false;
    }

    public boolean isSafe(int row, int col) {
        //return colEmpty[col] && upDiagEmpty[row + col] && downDiagEmpty[n - 1 + row - col];

//        for(int i = 0; i < row; i++) {
//            if(board[i][col]) {
//                return false;
//            }
//        }
/*for(int i = row; i < n; i++) {
            for(int j = col; j < n; j++) {
                if(board[i][j]) {
                    return false;
                }
            }
        }*//*

        */
/*for(int i = row; i >= 0; i--) {
            for(int j = col; j < n; j++) {
                if(board[i][j]) {
                    return false;
                }
            }
        }*/

        /*for(int i = row; i >= 0; i--) {
            for(int j = col; j >= 0; j--) {
                if(board[i][j]) {
                    return false;
                }
            }
        }
        for(int i = row; i < n; i++) {
            for(int j = col; j >= 0; j--) {
                if(board[i][j]) {
                    return false;
                }
            }
        }*/
        //return true;


       /* int i, j;

*//* Check this row on left side *//*

        for (i = 0; i < row; i++)
            if (board[i][col])
                return false;*/



 /*Check upper diagonal on left side */

       /* for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j])
                return false;*/


/* Check lower diagonal on left side */

        /*(for (i = row, j = col; j >= 0 && i < n; i++, j--)
            if (board[i][j])
                return false;

        for(int i = row; i < n; i++) {
            for(int j = col; j >= 0; j--) {
                if(board[i][j]) {
                    return false;
                }
            }
        }*/

        for(int i = 0; i < row; i++) {
            if(board[i][col]) {
                return false;
            }
        }

        int j = col;
        for(int i = row; i < n; i++){
            if (board[i][j]) {
                return false;
            }
            if(j != 0) {
                j--;
            }
        }

        j = col;
        for(int i = row; i >= 0; i--) {
            if(board[i][j]) {
                return false;
            }
            if(j != 0) {
                j--;
            }
        }

        j = col;
        for(int i = row; i >= 0; i--) {
            if(j == n) {
                break;
            }
            if(board[i][j]) {
                return false;
            }
            if(j != n) {
                j++;
            }
        }

        j = col;
        for(int i = row; i < n; i++) {
            if(j == n) {
                break;
            }
            if(board[i][j]) {
                return false;
            }
            if(j != n) {
                j++;
            }
        }
        return true;


    }

    public void placeQueen(int row,int col) {
        if(isSafe(row, col)){
            board[row][col] = true;
            colEmpty[col] = true;
            upDiagEmpty[row + col] = false;
            downDiagEmpty[n - 1 + row - col] = false;
        }
    }

    public void removeQueen(int row, int col) {
        board[row][col] = false;
        colEmpty[col] = false;
        upDiagEmpty[row + col] = true;
        downDiagEmpty[n - 1 + row - col] = true;
    }

    public void printSolution() {
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j]) {
                    System.out.print("Q  ");
                }
                else {
                    System.out.print("*  ");
                }
            }
            System.out.println("");
        }
        System.out.println("");
        /*
        // This is not right but ill figure it out later
        if(isSafe(row, col)) {
            System.out.print(" Q ");
        }
        else {
            System.out.print(" * ");
        }
        // This is not right but ill figure it out later
        if() {
            System.out.println("");
        }*/
    }
}
