import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Blog {

    private List<Post> listaPost;

    public Blog() {
        listaPost = new ArrayList<>();
        this.listaPost = listaPost;
    }

    public void adicionarPostagem(Post post){
        listaPost.add(post);
    }

    public Set<String> obterTodosAutores(){
        List<String> listaAutor = new ArrayList<>();
        for (Post post : listaPost) {

            listaAutor.add(post.getAutor());
        }

        Set<String> conjuntoOrdenado = new TreeSet<>(listaAutor);

        

        return conjuntoOrdenado;
    } 

    public Map<String, Integer> obterContagemPorCategoria(){
        
        Map<String, Integer> map = new HashMap<>();
        
        List<Post> novaLista = listaPost.stream()
            .collect(Collectors.groupingBy(Post::getCategoria))
            .entrySet()
            .stream()
            .map(entry -> new Teste(entry.getValue(), entry.getKey(), null))
            .sorted(Comparator.comparing(Teste::getNome))
            .collect(Collectors.toList());
        
        
        
        
        
        listaPost.sort(Comparator.comparing(Post :: getCategoria));

       
       
       
        List<Post> listarteste = new ArrayList<>(); 
        


        for (Post post : listaPost) {

          

            
            
        }
        

      return map;  



    }

    
}
