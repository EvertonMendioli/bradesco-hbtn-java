 import java.io.BufferedReader;
 import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
 import java.io.IOException;
 import java.util.Scanner;


 public class FileWritingExercise {
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);


         // Solicita o nome do arquivo
         System.out.print("Digite o nome do arquivo (com extensão .txt): ");
         String fileName = scanner.nextLine();
            System.out.println("o nome do arquivo é: " + fileName);
        
try {
        FileWriter fileWriter = new FileWriter(fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);


            String texto = "";


        while (true) {
            System.out.print("Digite varias linhas de texto: ");
            texto = scanner.nextLine();  
            if("sair".equalsIgnoreCase(texto)){
              break;
            }
                bufferedWriter.write(texto);
                bufferedWriter.newLine();
            
            

        }
        bufferedWriter.close(); 
        
    } catch (IOException e) {
                
                e.printStackTrace();
    }finally{       
        
        scanner.close();

     }
    }
 }