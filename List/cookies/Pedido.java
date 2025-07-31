import java.util.ArrayList;

public class Pedido {

    private ArrayList<PedidoCookie> cookies;

    public Pedido() {
        ArrayList<PedidoCookie> cookies = new ArrayList<>();
        this.cookies = cookies;
    }

    public void adicionarPedidoCookie(PedidoCookie pedidoCookie){
        
        cookies.add(pedidoCookie);
    }

    public int obterTotalCaixas(){
        int totalCaixas = 0;
        for (PedidoCookie pedido : cookies) {
           totalCaixas += pedido.getQuantidadeCaixas();
        }
        return totalCaixas;
    }

    public int removerSabor(String sabor){
       //int i = 0;
       int z = 0;
        
        for (int i = 0; i<cookies.size(); i++) {
            
            if(cookies.get(i).getSabor().equals(sabor)){
                z += cookies.get(i).getQuantidadeCaixas();
                cookies.remove(i);
            }
            
        }
            return z;
    }
    
}
