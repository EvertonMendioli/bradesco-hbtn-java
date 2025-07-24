import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvFileReader {

    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("funcionarios.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                String[] valor = linha.split(",");

                System.out.println("Funcionário: " + valor[0].trim());
                System.out.println("Idade: " + valor[1].trim());
                System.out.println("Departamento: " + valor[2].trim());
                System.out.println("Salarial: " + valor[3].trim());
                System.out.println("------------------------");

            }
            System.out.println("Leitura do arquivo concluída.");

        } catch (IOException e) {

            e.printStackTrace();
        }

    }
}
