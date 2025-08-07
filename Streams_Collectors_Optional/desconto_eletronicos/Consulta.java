import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Consulta {

    public static List<Produto> obterLivrosDoPedido(Pedido pedido) {
        List<Produto> produtos = pedido.getProdutos().stream()
                .filter(produto -> produto.getCategoria().name() == CategoriaProduto.LIVRO.toString())
                .collect(Collectors.toList());

        return produtos;

    }

    public static Produto obterProdutoMaiorPreco(List<Produto> produtos) {

        Produto produto = produtos.get(0);

        Optional<Produto> produtos2 = produtos.stream()
                .max(Comparator.comparing(Produto::getPreco));

        if (produtos2.isPresent()) {
            produto = produtos2.get();
        }

        return produto;

    }

    public static List<Produto> obterProdutosPorPrecoMinimo(List<Produto> produtos, double precoMinimo) {

        List<Produto> produtos2 = produtos.stream()
                .filter(produto -> produto.getPreco() >= precoMinimo)
                .collect(Collectors.toList());

        return produtos2;

    }

    public static List<Pedido> obterPedidosComEletronicos(List<Pedido> pedidos) {

        List<Pedido> pedido3 = new ArrayList<>();

        /*
         * for (Pedido pedido : pedidos) {
         * List<Produto> prod = pedido.getProdutos();
         * 
         * Optional<Produto> ppr = prod.stream().anyMatch(prd ->
         * prd.getCategoria().equals(CategoriaProduto.ELETRONICO.toString()));
         * if(ppr.isPresent){
         * pedidos.stream().filter(produ -) ppr.get;
         * }
         * 
         * 
         * Optional<Pedido> pedido2 = pedidos.stream()
         * .anyMatch(cat -> cat.getProdutos().get
         * List<Pedido> pedido3 = new ArrayList<>();
         * /* if(pedido2.isPresent()){
         * pedido3.add(pedido2.get());
         * 
         * }
         */

        return pedido3;

    }

    public static List<Produto> aplicar15PorcentoDescontoEletronicos(List<Produto> produtos) {

        List<Produto> produtos2 = produtos.stream()
                .filter(produto -> produto.getCategoria().name() == CategoriaProduto.ELETRONICO.toString())
                .map(getPreco::getPreco * 1, 15)
                .collect(Collectors.toList());

        return produtos2;
    }
}
