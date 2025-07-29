import java.util.ArrayList;

public class Biblioteca<T extends Midia> {

    List<Object> listaValores = new ArrayList<>();

    public String obterListaMidias(){
            return listaValores.toString();
    }

    public void adicionarMidia(Livro livro1) {
        listaValores.add(livro1);
    }

    public void adicionarMidia(Video video1) {
        listaValores.add(video1);
    }

    public void adicionarMidia(Jornal jornal2) {
        listaValores.add(jornal2);
    }



}
