import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvFileReader {

    public static void main(String[] args) {
    try {
        FileReader fileReader = new FileReader("funcionarios.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String linha;
        while ((linha = bufferedReader.readLine())!= null) {
        String[] valor = linha.split(",");

           System.out.println("Funcionario: " + valor[0]);
           System.out.println("Idade: " + valor[1]);
           System.out.println("Departamento: " + valor[2]);
           System.out.println("Salarial: " + valor[3]);
           System.out.println("------------------------");

        }
        System.out.println("Leitura do arquivo concluída.");
        
        
        
        


    } catch (IOException e) {
                
                e.printStackTrace();
            }
     
}
}
