package com.lab;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    static Minesweeper initMineField() {
        Minesweeper game = new Minesweeper(9, 9);
        game.setMineCell(0, 1);
        game.setMineCell(1, 5);
        game.setMineCell(1, 8);
        game.setMineCell(2, 4);
        game.setMineCell(3, 6);
        game.setMineCell(4, 2);
        game.setMineCell(5, 4);
        game.setMineCell(6, 2);
        game.setMineCell(7, 2);
        game.setMineCell(8, 6);
        return game;
    }

    static Minesweeper initMineFieldFromFile(String minefieldFile) {
        return new Minesweeper(minefieldFile);
    }
    
    static Minesweeper initCustomMineField() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter board size (rows cols): ");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        Minesweeper game = new Minesweeper(rows, cols);

        System.out.println("Enter minefield row by row (use '.' for empty and 'x' for mines):");
        for (int i = 0; i < rows; i++) {
            String line = scanner.next();
            for (int j = 0; j < cols; j++) {
                if (line.charAt(j) == 'x') {
                    game.setMineCell(i, j);
                }
            }
        }
        return game;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        Minesweeper customGame = null;

        System.out.println("1 for table1");
        System.out.println("2 for table2");
        System.out.println("3 for table3");
        System.out.println("4 for custom minefield");
        System.out.println("5 to display custom minefield");
        System.out.println("6 for escape");

        while (true) {
            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                
                if (choice == 1) {
                    Minesweeper game = initMineField();
                    game.displayField();
                } else if (choice == 2) {
                    Minesweeper game = initMineFieldFromFile("minefield/minefield01.txt");
                    game.displayField();
                } else if (choice == 3) {
                    Minesweeper game = initMineFieldFromFile("minefield/minefield02.txt");
                    game.displayField();
                } else if (choice == 4) {
                    customGame = initCustomMineField();
                } else if (choice == 5) {
                    if (customGame != null) {
                        customGame.displayField();
                    } else {
                        System.out.println("No custom minefield available. Please create one first.");
                    }
                } else if (choice == 6) {
                    System.out.println("END PROGRAM");
                    break;
                } else {
                    System.out.println("Error!! Please enter 1, 2, 3, 4, 5, or 6.");
                }
            } else {
                System.out.println("Wrong!! please enter an integer.");
                scanner.next(); 
            }
        }
        scanner.close();
    }
}
