import produtos.Dvd;
import produtos.Produto;

public class Pedido {

    private double percentualDesconto;
    private ItemPedido[] itens;

    public Pedido(double percentualDesconto, ItemPedido[] itens) {
        this.percentualDesconto = percentualDesconto;
        this.itens = itens;
    }


    public double calcularTotal() {
        double qtdeDvd = 0;
        double qtdeLivro = 0;
        
        
        for (ItemPedido itemPedido : itens) {
            if(itemPedido.getProduto().getClass().getName().equals("produtos.Dvd")){   
                 qtdeDvd += itemPedido.getQuantidade() * itemPedido.getProduto().obterPrecoLiquido();
                
            }

            if(itemPedido.getProduto().getClass().getName().equals("produtos.Livro")){
                qtdeLivro += itemPedido.getQuantidade()* itemPedido.getProduto().obterPrecoLiquido();;
            }
        }

        return (qtdeDvd + qtdeLivro) - ((qtdeDvd + qtdeLivro) * (getPercentualDesconto()/100));
    }


    public double getPercentualDesconto() {
        return percentualDesconto;
    }


    
}
