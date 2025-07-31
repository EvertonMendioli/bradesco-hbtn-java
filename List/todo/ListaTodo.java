import java.util.ArrayList;
import java.util.List;

public class ListaTodo {

    private List<Tarefa> tarefas;

    public ListaTodo() {
       tarefas = new ArrayList<Tarefa>();
        this.tarefas = tarefas;
    }

    public void adicionarTarefa(Tarefa tarefa) throws IllegalArgumentException{
        boolean existe = false;
        for (Tarefa item : tarefas) {
            if(item.getIdentificador() == tarefa.getIdentificador()){
                existe = true;
            }
        }
        if(existe){
            throw new IllegalArgumentException("Tarefa com identificador " +tarefa.getIdentificador()+ " ja existente na lista");
        }else{
        tarefa.modificarDescricao(tarefa.getDescricao());
        tarefas.add(tarefa);
        }

    }

    public boolean marcarTarefaFeita(int identificador){

        for (Tarefa item : tarefas) {
            if(item.getIdentificador() == identificador){
                item.setEstahFeita(true);
                return true;
            }
        }

        return false;
    }

    public boolean desfazerTarefa(int identificador){

        for (Tarefa item : tarefas) {
            if(item.getIdentificador() == identificador){
                item.setEstahFeita(false);
                return true;
            }
        }

        return false;

        
    }

    public void desfazerTodas(){
        for (Tarefa item : tarefas) {         
                item.setEstahFeita(false);          
        }
    }

    public void fazerTodas(){
        for (Tarefa item : tarefas) {         
                item.setEstahFeita(true);          
        }
    }

    public void listarTarefas(){
        String marcarX = " ";
        int i = 1;
        for (Tarefa item : tarefas) {         
            marcarX = " ";
            if(item.isEstahFeita() == true){
                marcarX = "X";
            }
            System.out.println("[" + marcarX + "]  Id: " + i + " - Descricao: "  + item.getDescricao());
            i++;
         
        }

    }
    
}
