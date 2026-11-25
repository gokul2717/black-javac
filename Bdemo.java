
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter no of Queens:");
        int n = s.nextInt();

        if (n <= 0) {
            System.out.println("Enter number > 0");
            s.close();
            return;
        }

        Opr op = new Opr(n);
        op.queen(1, n);

        if (op.Gc() == 0) {
            System.out.println("No solution exists for n=" + n);
        } else {
            System.out.println("Total solutions: " + op.Gc());
        }

        s.close();
    }
}

class Opr{
    int[] x;
    int count = 0;

    Opr(int n) {
        x = new int[n + 1];
    }


    public boolean place(int r, int c) {
        for (int i = 1; i < r; i++) {
            if (x[i] == c) {
                return false;
            }

            if (Math.abs(x[i] - c) == Math.abs(i - r)) {
                return false;
            }
        }
        return true;
    }

    public void queen(int r, int n) {
        for (int c = 1; c <= n; c++) {
            if (place(r, c)) {
                x[r] = c;
                if (r == n) {
                    pboard(n);
                } else {
                    queen(r + 1, n);
                }
            }
        }
    }

    public void pboard(int n) {
    count++;

    System.out.println("Solution :" + count);
    for (int i = 1; i <= n; i++)
        System.out.print(i + " ");
    System.out.println();

    for (int i = 1; i <= n; i++) {
        System.out.print(i + " ");
        for (int j = 1; j <= n; j++) {
            if (x[i] == j) {
                System.out.print("Q ");
            } else {
                System.out.print("- ");
            }
        }
        System.out.println();
    }
}
    public int Gc() {
        return count;
    }
}

