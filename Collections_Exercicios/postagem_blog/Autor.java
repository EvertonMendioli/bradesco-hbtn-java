public class Autor implements Comparable<Autor> {

    private String nome;
    private String sobrenome;
    @Override
    public String toString() {
        return nome + " " + sobrenome;
    }

    
    public Autor(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSobrenome() {
        return sobrenome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }


    @Override
    public int compareTo(Autor o) {
        return this.nome.compareTo(o.nome);
        //return this.compareTo(o);
    }


    



    
}
