package com.pb.savosh.hw9;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class FileNumbers {

    Random rand = new Random();
    Path path = Paths.get("files/numbers.txt");
    Path path2 = Paths.get("files/odd-numbers.txt");

    //write to file
    public void createNumbersFile() {
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    int x = rand.nextInt(99) + 1;
                    String text = String.valueOf(x);
                    writer.write(text);
                    writer.write(" ");
                    System.out.print(x);
                    System.out.print(" ");
                }
                writer.newLine();
                System.out.print("\n");
            }
        } catch (IOException ex) {
            System.out.println("Error! " + ex.getMessage());
        }
        System.out.println("Write to file " + path.toAbsolutePath() + " done!");
    }

    //read from file
    public void createOddNumbersFile() {
        try (BufferedWriter writer = Files.newBufferedWriter(path2)) {
            Scanner scan = new Scanner(path);
            while (scan.hasNextLine()) {
                Scanner line = new Scanner(scan.nextLine());
                while (line.hasNextInt()) {
                    int x = line.nextInt();
                    if (x % 2 == 0) {
                        x = 0;
                    }
                    String text = String.valueOf(x);
                    writer.write(text);
                    writer.write(" ");
                    System.out.print(x + " ");
                }
                writer.newLine();
                System.out.println();
            }
        } catch (IOException | NoSuchElementException ex) {
            System.out.println("Error! " + ex.getMessage());
        }
        System.out.println("Read and rewrite to file " + path2.toAbsolutePath() + " done!");
    }

    public static void main(String[] args) {
        FileNumbers file = new FileNumbers();
        file.createNumbersFile();
        file.createOddNumbersFile();
    }
}


