import java.util.List;

public class ManipularArrayNumeros {

    public static int buscarPosicaoNumero(List<Integer> listaInt, int numerobuscar){
        int i = 0;
        for (Integer numero : listaInt) {
           if(numero == numerobuscar) {

                return i;
           }
           i++;
        }
        return -1;
    }

    public static void adicionarNumero(List<Integer> listaInt, int numeroadicionar) throws Exception{
       int existe =  buscarPosicaoNumero(listaInt, numeroadicionar);

       if(existe == -1){
          listaInt.add(numeroadicionar);
       }else{
            throw new Exception("Numero jah contido na lista");
       }
    }

    public static void removerNumero(List<Integer> listaInt, int numeroremover) throws Exception{
         int existe =  buscarPosicaoNumero(listaInt, numeroremover);
        if(existe > -1){
          listaInt.remove(existe);
       }else{
            throw new Exception("Numero nao encontrado na lista");
       }

    }

    public static void substituirNumero(List<Integer> listaInt, int numeroSubstituir, int numeroSubstituto){

         int existe =  buscarPosicaoNumero(listaInt, numeroSubstituir);
        if(existe > -1){
          listaInt.set(existe, numeroSubstituto);
       }else{
            listaInt.add(numeroSubstituto);       }
    }
}
