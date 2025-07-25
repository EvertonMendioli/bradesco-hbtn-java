import java.util.ArrayList;

public class GestaoAlunos {

public ArrayList<Aluno> listaAlunos = new ArrayList<>();
;

public void adicionarAluno(String nome, int idade){

    Aluno aluno = new Aluno();
    aluno.setNome(nome);
    aluno.setIdade(idade);
    listaAlunos.add(aluno);

}

public void excluirAluno(String nome){
    int i = 0;
    for (Aluno itemAluno : listaAlunos) {
        
        if(itemAluno.getNome().equalsIgnoreCase(nome)){
            
            listaAlunos.remove(i);
        }
        i++;
    }


}

public void buscarAluno(String nome){
    for (Aluno itemAluno : listaAlunos) {
        if(itemAluno.getNome().equalsIgnoreCase(nome)){
            System.out.println(itemAluno.toString());
        }
    }
}

public void listarAlunos(){
    
    for (Aluno itemAluno : listaAlunos) {
        System.out.println(itemAluno.toString());
    }

}

}
