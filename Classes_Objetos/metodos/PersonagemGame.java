public class PersonagemGame {
    private int saudeAtual;
    private String nome;


    
    public PersonagemGame() {
    }

    public int getSaudeAtual() {
        return saudeAtual;
    }

    public void setSaudeAtual(int saudeAtual) {
        this.saudeAtual = saudeAtual;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
