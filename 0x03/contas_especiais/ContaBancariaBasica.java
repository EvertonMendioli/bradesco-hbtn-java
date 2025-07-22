import exceptions.OperacaoInvalidaException;

public class ContaBancariaBasica {

    private String numeracao;
    private double saldo;
    private double taxaJurosAnual;
    public String getNumeracao() {
        return numeracao;
    }
    public double getSaldo() {
        return saldo;
    }
    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public ContaBancariaBasica(String numeracao, double taxaJurosAnual) {
        this.numeracao = numeracao;
        this.taxaJurosAnual = taxaJurosAnual;
        this.saldo = 0;
    }

    public void depositar(double valor) throws OperacaoInvalidaException{
        if(valor>0){
            setSaldo(getSaldo() + valor );
           
        }else{
            throw new OperacaoInvalidaException("Valor para deposito deve ser maior que 0");
        }

    }

    public void sacar(double valor) throws OperacaoInvalidaException{
        if(valor>0){
            if(getSaldo()>= valor){
         
                setSaldo(getSaldo() - valor );
                
            }else{
            throw new OperacaoInvalidaException("Valor de saque deve ser menor que o saldo atual");    
            }   
        }else{
            throw new OperacaoInvalidaException("Valor de saque deve ser maior que 0");
        }
    }

    public double calcularTarifaMensal(){

        double pelovalor = 10.0;
        double porcentagem = getSaldo() * 0.1;
        
        if(pelovalor < porcentagem){
            return pelovalor;
        }else if(porcentagem < pelovalor){
            return porcentagem;
        }else{
            return pelovalor;
        }
        
    }

    public double calcularJurosMensal(){
        if(getSaldo()<0){

            return getSaldo() * 0;
        }else{
            
            return (getSaldo() * (getTaxaJurosAnual()/100))/12;
        }
        
    }

    public void aplicarAtualizacaoMensal(){
        saldo = saldo - calcularTarifaMensal() + calcularJurosMensal();
    }
    
    
}
