import java.util.*;
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

            Map<Categorias, Integer> mapOrdem =  obterContagemPorCategoria();
            Set<Categorias> chaves = mapOrdem.keySet();
        
        for (Categorias categoria : chaves) {
            map.put(categoria, obterPostsPorCategoria(categoria));
        }

       
      return map;
        
        
    }


    public Map<Autor, Set<Post>> obterTodosPostsPorAutor(){
            
            Map<Autor, Set<Post>> map = new HashMap<>();
            Set<Autor> chaves = obterTodosAutores();
            //Set<Autor> chaves2 = new TreeSet<>(obterTodosAutores());

        for (Autor autor : chaves) {
            map.put(autor, obterPostsPorAutor(autor));
        }
         map = new TreeMap<>(map);

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
        
        for ( Post post : listaPost) {
            
            if(map.containsKey(post.getCategoria())){
                map.put(post.getCategoria(), map.get(post.getCategoria()) + 1);
            }else{
                map.put(post.getCategoria(), 1);
            }

        
        
        }

        Map<Categorias, Integer> ordernar = map.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1, e2) -> e2,
                LinkedHashMap::new
            ));
      return ordernar;  



    }

    
}
