import java.util.InputMismatchException;
import java.util.Scanner;
public class Bdemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no Of Queens: ");
        int n;
        try {
            n = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid integer.");
            sc.close();
            return;
        }
        if (n <= 0) {
            System.out.println("Please enter number greater than 0");
            sc.close();
            return;
        }
        Operation op = new Operation(n);
        op.queen(1, n);

        if (op.getCount() == 0) {
            System.out.println("\nNo solution exists for N = " + n);
        } else {
            System.out.println("\nTotal Solutions: " + op.getCount());
        }
        sc.close();
    }
}
class Operation {
    private final int[] x;
    private int count = 0;

    Operation(int n) {
        x = new int[n + 1];
    }
    public boolean place(int row, int column) {
        for (int i = 1; i < row; i++) {
            if (x[i] == column || Math.abs(x[i] - column) == Math.abs(i - row))
                return false;
        }
        return true;
    }
    public void queen(int row, int n) {
        for (int column = 1; column <= n; column++) {
            if (place(row, column)) {
                x[row] = column;
                if (row == n) {
                    printBoard(n);
                } else {
                    queen(row + 1, n);
                }
            }
        }
    }
    public void printBoard(int n) {
        count++;
        System.out.println("\n\nSolution : " + count);
        System.out.print("   ");
        for (int i = 1; i <= n; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 1; i <= n; i++) {
            System.out.print(" " + i + " ");
            for (int j = 1; j <= n; j++) {
                System.out.print(x[i] == j ? " Q" : " -");
            }
            System.out.println();
        }
    }
    public int getCount() {
        return count;
    }
}