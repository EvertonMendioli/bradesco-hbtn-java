
public class Principal{
    
    
   public static void main(String[] args){

        Contador contador = new Contador();

        ThreadContador threads = new ThreadContador(contador);
        threads.start();
        threads.start();
        //threads.join();

        System.out.println("Valor final do contador: " + contador.getContagem());

    }
    


    


}