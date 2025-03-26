import java.util.Random;
import java.util.Scanner;

public class DynamicSudoku {
    public static void main(String[] args) {
        int size = 4; 
        DynamicSudoku generator = new DynamicSudoku();
        generator.sudoku(size);
    }

    public void sudoku(int size) {
        if (size <= 0) {
            System.out.println("Input positive size");
            return;
        }

        int length = String.valueOf(size).length();
        String hyphen = "-".repeat(length + 2);

        int[][] grid = new int[size][size];
        fillGridWithoutDuplicates(grid, size);
        removeRandomCells(grid, size);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            printGrid(grid, size, length, hyphen);

            System.out.print("\nEnter row (1-" + size + ") or 0 to finish: ");
            int row = scanner.nextInt() - 1;
            if (row == -1) {
                System.out.println("\nFinished entering numbers.");
                break;
            }

            System.out.print("Enter column (1-" + size + "): ");
            int col = scanner.nextInt() - 1;
            if (row < 0 || row >= size || col < 0 || col >= size) {
                System.out.println("Invalid coordinates. Try again.");
                continue;
            }

            if (grid[row][col] != 0) {
                System.out.println("Cell already filled. Choose a different cell.");
                continue;
            }

            System.out.print("Enter a number (1-" + size + "): ");
            int num = scanner.nextInt();
            if (num < 1 || num > size) {
                System.out.println("Invalid number. Try again.");
                continue;
            }
            grid[row][col] = num;
        }

        System.out.println("\nValidating the solution...");
        if (isValidSolution(grid, size)) {
            System.out.println("Correct solution! Well done.");
        } else {
            System.out.println("Incorrect solution. Try again.");
        }
    }

    private void fillGridWithoutDuplicates(int[][] grid, int size) {
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            boolean[] used = new boolean[size + 1];
            for (int j = 0; j < size; j++) {
                int num;
                do {
                    num = rand.nextInt(size) + 1;
                } while (used[num] || isNumberInColumn(grid, j, num, i));
                grid[i][j] = num;
                used[num] = true;
            }
        }
    }

    private boolean isNumberInColumn(int[][] grid, int col, int num, int maxRow) {
        for (int i = 0; i < maxRow; i++) {
            if (grid[i][col] == num) {
                return true;
            }
        }
        return false;
    }

    private void removeRandomCells(int[][] grid, int size) {
        int numbersToRemove = (size * size) / 3;
        Random rand = new Random();
        while (numbersToRemove > 0) {
            int row = rand.nextInt(size);
            int col = rand.nextInt(size);
            if (grid[row][col] != 0) {
                grid[row][col] = 0;
                numbersToRemove--;
            }
        }
    }
    
 private void printGrid(int[][] grid, int size, int length, String hyphen) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("+" + hyphen);
            }
            System.out.println("+");

            for (int j = 0; j < size; j++) {
                if (grid[i][j] == 0) {
                    System.out.printf("| %" + length + "s ", " ");
                } else {
                    System.out.printf("| %" + length + "d ", grid[i][j]);
                }
            }
            System.out.println("|");
        }
        for (int j = 0; j < size; j++) {
            System.out.print("+" + hyphen);
        }
        System.out.println("+");
    }
 

    private boolean isValidSolution(int[][] grid, int size) {
        for (int i = 0; i < size; i++) {
            boolean[] rowCheck = new boolean[size + 1];
            boolean[] colCheck = new boolean[size + 1];
            for (int j = 0; j < size; j++) {
                int rowVal = grid[i][j];
                int colVal = grid[j][i];
                if (rowVal != 0 && rowCheck[rowVal]) return false;
                if (colVal != 0 && colCheck[colVal]) return false;
                rowCheck[rowVal] = true;
                colCheck[colVal] = true;
            }
        }
        return true;
    }
}

