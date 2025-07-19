package provedores;

public class JadLog implements ProvedorFrete{

    @Override
    public Frete calcularFrete(double peso, double valor) {
        Frete frete = new Frete();
        if(peso > 2000.0 ){
            frete.setValor(valor * 0.07);
        }else{
            frete.setValor(valor * 0.045);
        }   
        return frete;
    }

    @Override
    public TipoProvedorFrete obterTipoProvedorFrete() {
        return TipoProvedorFrete.JADLOG;
    }

}
