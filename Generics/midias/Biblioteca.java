import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Biblioteca<T> {

    
    
    //Set<? super Midia> listaValores = (Set<? super Midia>) new List<>();


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
