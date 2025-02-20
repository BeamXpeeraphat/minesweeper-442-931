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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("1 for table1");
        System.out.println("2 for table2");
        System.out.println("3 for escape");

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
                    System.out.println("END PROGRAM");
                    break; // ออกจาก loop
                } else {
                    System.out.println("Invalid input! Please enter 1, 2, or 3.");
                }
            } else {
                System.out.println("Invalid input! Please enter an integer.");
                scanner.next(); // ล้าง buffer ของ Scanner
            }
        }

        scanner.close();
    }
}
