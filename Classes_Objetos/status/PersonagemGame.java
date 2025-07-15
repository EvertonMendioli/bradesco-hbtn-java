public class PersonagemGame {
    private int saudeAtual;
    private String nome;
    private String status;


    
    public PersonagemGame() {
    }

    public int getSaudeAtual() {
        return saudeAtual;
    }

    public void setSaudeAtual(int saudeAtual) {

        if(saudeAtual>0){
            setStatus("vivo");
        }else if(saudeAtual==0){
            setStatus("morto");
        }
        this.saudeAtual = saudeAtual;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    

    public void tomarDano(int quantidadeDeDano){
        int result = getSaudeAtual()-quantidadeDeDano;
        if(result < 0 ){
            result = 0;
        }
        
        setSaudeAtual(result);
    }

    public void receberCura(int quantidadeDeCura){
        int result = getSaudeAtual() + quantidadeDeCura;
        if(result > 100){
            result = 100;
        }
        setSaudeAtual(result);
    }

}
