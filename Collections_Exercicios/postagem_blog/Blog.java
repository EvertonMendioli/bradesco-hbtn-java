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

    public void adicionarPostagem(Post post) throws IllegalArgumentException{
        String verificar = post.getAutor() + post.getTitulo();
        for (Post post2 : listaPost) {
            if((post2.getAutor()+post2.getTitulo()).equals(verificar)){
                throw new IllegalArgumentException("Postagem jah existente");
            }
        }

        listaPost.add(post);
    }

    public Set<Post> obterPostsPorAutor(Autor autor){
        List<Post> post2 = new ArrayList<>();
        for (Post post : listaPost) {
            if((post.getAutor().getNome().equals(autor.getNome())) && 
            (post.getAutor().getSobrenome().equals(autor.getSobrenome()))){
                post2.add(post);
            }
        }
        
        Set<Post> post = new TreeSet<>(post2);
        return post;
    }

    public Set<Post> obterPostsPorCategoria(Categorias categorias){
                List<Post> post2 = new ArrayList<>();
        for (Post post : listaPost) {
            if(post.getCategoria().equals(categorias)){
                post2.add(post);
            }
        }
        Set<Post> post = new TreeSet<>(post2);
        return post;
        
    }

    public Map<Categorias, Set<Post>> obterTodosPostsPorCategorias(){
            Map<Categorias, Set<Post>> map = new HashMap<>();


        for (Post post : listaPost) {
            map.put(post.getCategoria(), obterPostsPorCategoria(post.getCategoria()));
        }

        
        return map;
    }


        public Map<Autor, Set<Post>> obterTodosPostsPorAutor(){
            
            Map<Autor, Set<Post>> map = new HashMap<>();


        for (Post post : listaPost) {
            map.put(post.getAutor(), obterPostsPorAutor(post.getAutor()));
        }

        
        return map;
    }

    public Set<Autor> obterTodosAutores(){
        List<Autor> listaAutor = new ArrayList<>();
        for (Post post : listaPost) {

            listaAutor.add(post.getAutor());
        }

        Set<Autor> conjuntoOrdenado = new TreeSet<>(listaAutor);

        

        return conjuntoOrdenado;
    } 

    public Map<Categorias, Integer> obterContagemPorCategoria(){
        
        Map<Categorias, Integer> map = new HashMap<>();
        
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
        




      return map;  



    }

    
}
