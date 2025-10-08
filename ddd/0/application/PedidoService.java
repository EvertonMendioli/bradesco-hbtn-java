package application;


import domain.Cliente;
import domain.Pedido;
import domain.Produto;
import infrastructure.PedidoRepository;


public class PedidoService {


    private final PedidoRepository pedidoRepository;


    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }


    public Pedido criarPedido(Cliente cliente) {
        Pedido p = new Pedido(cliente);
        pedidoRepository.salvar(p);
    }


    public void adicionarProduto(String pedidoId, Produto produto) {
        
        Pedido p = pedidoRepository.buscarPorId(pedidoId);
        p.adicionarProduto(produto);
        pedidoRepository.salvar(p);

    }


    public void pagarPedido(String pedidoId) {
        Pedido p = pedidoRepository.buscarPorId(pedidoId);
        p.pagar();
        pedidoRepository.salvar(p);
    }


    public void cancelarPedido(String pedidoId) {
        Pedido p = pedidoRepository.buscarPorId(pedidoId);
        p.cancelar();
        pedidoRepository.salvar(p);
    }
}