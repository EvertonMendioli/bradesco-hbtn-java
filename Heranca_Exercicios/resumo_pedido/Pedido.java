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

    public void apresentarResumoPedido(){
       String tipo = "";
       String teste = "";
       int qtde = 0;
       double total = 0;
        System.out.printf("------- RESUMO PEDIDO -------");
for (ItemPedido itemPedido : itens) {
            
          if(itemPedido.getProduto().getClass().getName().equals("produtos.Dvd")){   
                 tipo = "Dvd"; 
            }

            if(itemPedido.getProduto().getClass().getName().equals("produtos.Livro")){
                tipo = "Livro";
            }
            qtde += itemPedido.getQuantidade();
            total += itemPedido.getProduto().obterPrecoLiquido() * itemPedido.getQuantidade();
            //qtdeLivro += itemPedido.getQuantidade()* itemPedido.getProduto().obterPrecoLiquido();
          System.out.printf("\nTipo: " + tipo + 
        "  Titulo: " + itemPedido.getProduto().getTitulo() + 
        "  Preco: "   + String.format("%.2f",itemPedido.getProduto().obterPrecoLiquido()) + 
        "  Quant: " + itemPedido.getQuantidade() + 
        "  Total: " + String.format("%.2f",itemPedido.getProduto().obterPrecoLiquido() * itemPedido.getQuantidade()));
        


        }
        double totalGeral= total - (total * (getPercentualDesconto()/100));
        String resultado = 
        "\n----------------------------\n" 
        +"DESCONTO: " + (String.format("%.2f",total * (getPercentualDesconto()/100))) 
        +"\nTOTAL PRODUTOS: " + (String.format("%.2f",total)) 
        + "\n----------------------------\n" 
        +"TOTAL PEDIDO: "   + String.format("%.2f",totalGeral)
        + "\n----------------------------\n";

        System.out.printf(resultado);

       
       
       
        
        


    }


    
}
