public class Eletronico {

    private String descricao;
    private double valor;
    @Override
    public String toString() {
        return "["+ descricao + "] R$" +  String.format(" %.6f", valor);
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public Eletronico(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    
}
