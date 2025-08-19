import java.util.LinkedList;

public class Fila {

    private LinkedList<Integer> lista = new LinkedList<>();
    

    public void adicionar(int item){
        this.lista.add(item);

    }    
    public void retirar(){
        this.lista.remove();
    }

  

}
