class Sudoku {
    public static void main(String[] args) {
        int size = 9 ; // Grid size
        Sudoku generator = new Sudoku();
        generator.sudoku(size);
    }

    public void sudoku(int size) {
        if (size <= 0) {
            System.out.println("Input positive size");
            return;
        }
        int length = String.valueOf(size).length();
        String hyphen = "-".repeat(length + 2);

        // Initialize the Sudoku-like grid
        int[][] array = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                array[i][j] = (i + j) % size + 1;
            }
        }

        // Remove one-third of the numbers using System.nanoTime()
        int numbersToRemove = (size * size) / 3;
        long rmv = System.nanoTime(); // Use nanotime as a rmv
        while (numbersToRemove > 0) {
            rmv ^= (rmv << 21); // Bitwise shift for randomness
            rmv ^= (rmv >>> 35);
            rmv ^= (rmv << 4);
            int index = (int) (Math.abs(rmv) % (size * size)); // Generate a valid index to ensure generated index is non-negative

            int row = index / size;
            int col = index % size;

            if (array[row][col] != 0) {
                array[row][col] = 0;
                numbersToRemove--;
            }
        }

        // Print the Sudoku-like grid
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("+" + hyphen);
            }
            System.out.println("+");

            for (int j = 0; j < size; j++) {
                if (array[i][j] == 0) {
                    System.out.printf("| %" + length + "s ", " ");
                } else {
                    System.out.printf("| %" + length + "d ", array[i][j]);
                }
            }
            System.out.println("|");
        }

        // Print last horizontal line
        for (int j = 0; j < size; j++) {
            System.out.print("+" + hyphen);
        }
        System.out.println("+");
    }
}
