import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class FileReadingExercise {
    public static void main(String[] args) {
        String fileName = "exemplo.txt"; // Nome do arquivo fixo para leitura

        Scanner scanner;
        try {
            scanner = new Scanner(new File(fileName), "UTF-8");
            System.out.println("Conteúdo do arquivo 'exemplo.txt':\n");
            System.out.println(scanner.nextLine());
            System.out.println(scanner.nextLine());
            System.out.println(scanner.nextLine());
            System.out.println(scanner.nextLine());
            System.out.println("\nLeitura do arquivo concluída.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // efetue a leitura do arquivo

    }
}