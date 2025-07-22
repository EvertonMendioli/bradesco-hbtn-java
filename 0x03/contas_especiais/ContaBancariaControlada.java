public class ContaBancariaControlada extends ContaBancariaBasica {

    public double saldoMinimo;
    public double valorPenalidade;

    public ContaBancariaControlada(String numeracao, double taxaJurosAnual, double saldoMinimo,
            double valorPenalidade) {
        super(numeracao, taxaJurosAnual);
        this.saldoMinimo = saldoMinimo;
        this.valorPenalidade = valorPenalidade;
    }

    @Override
    public void aplicarAtualizacaoMensal() {
        if (getSaldo() <= this.saldoMinimo) {
            super.aplicarAtualizacaoMensal();
            setSaldo(getSaldo() - this.valorPenalidade);
        }

    }
}