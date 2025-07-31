import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
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
        
        listaPost.sort(Comparator.comparing(Post :: getCategoria));
        int i = 0;
        for ( Post post : listaPost) {
            
            if(map.get(post.getCategoria()) == null){
                i=1;
                map.put(post.getCategoria(), i);    
            }else{
                i++;
                map.put(post.getCategoria(), i);
            }
        
        }
        Map<String, Integer> ordernar = map.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue())
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1, e2) -> e1,
                LinkedHashMap::new
            ));




      return ordernar;  



    }

    
}
