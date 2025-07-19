import provedores.*;

public class ProcessadorPedido {

    private ProvedorFrete provedorFrete;

    public ProcessadorPedido(ProvedorFrete provedorFrete) {
        this.provedorFrete = provedorFrete;
    }

    public void processar(Pedido pedido){
        Frete teste = this.provedorFrete.calcularFrete(pedido.getPeso(), pedido.getTotal());
        teste.setTipoProvedorFrete(this.provedorFrete.obterTipoProvedorFrete());
        pedido.setFrete(teste);
        
    }
    
}
