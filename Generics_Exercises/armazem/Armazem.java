import java.util.HashMap;
import java.util.Map;

public class Armazem <T> implements Armazenavel {

    private Map<String, Object> map = new HashMap<>();


    @Override
    public void adicionarAoInventario(String nome, Object valor) {
        map.put(nome, valor);   
    }

    @Override
    public Object obterDoInventario(String nome) {
      return map.get(nome);
    }


    

}
