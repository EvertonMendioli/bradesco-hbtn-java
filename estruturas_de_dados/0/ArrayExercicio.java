import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;

public class ArrayExercicio {
    
    public static void main (String[] args){

                // Criando o scanner para entrada de dados
        Scanner scanner = new Scanner(System.in);
            // Definindo o tamanho do array
            int tamanhoArray = 10;
            int[] numeros = new int[tamanhoArray];
            int soma = 0;
            int maiorNumero = Integer.MIN_VALUE;
    
    
            // Preenchendo o array com números fornecidos pelo usuário
             //para receber o numero digitado
            System.out.println("Digite 10 números inteiros:");
            int somar = 0;
            int maiorValor = 0;
            for(int i=1; i<=tamanhoArray; i++ ){
                System.out.print("Digite o número " + i + ": "); 
                
                numeros[i-1] = scanner.nextInt();
                if( maiorValor < numeros[i-1]){
                    maiorValor = numeros[i-1];
                }  
                somar += numeros[i-1]; 
            }
            Arrays.sort(numeros);
            String ajustesResultado = Arrays.toString(numeros)
            .replace("[", "") 
            .replace("]", "") 
            .replace(",", ""); 


            System.out.println("Conteúdo do array:\n" +  ajustesResultado);
            System.out.println("Soma de todos os números: " + somar);
            System.out.println("Maior número no array:" + maiorValor);
            
            

    }     
}
