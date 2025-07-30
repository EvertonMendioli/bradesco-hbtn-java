public interface Armazenavel<T> {
    public void adicionarAoInventario(String nome, Object valor);

    public Object obterDoInventario(String nome);
    
}
