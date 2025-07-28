public class PessoasArray {

    private String[] nomes;

    public PessoasArray() {
        nomes =new String[]{"Amanda", "Beatriz", "Carlos","Daniela","Eduardo",
                "Fabio","Gustavo", "Hingrid","Isabela","Joao","Leise","Maria",
                "Norberto","Otavio","Paulo", "Quirino","Renata","Sabata",
                "Tais","Umberto","Vanessa","Xavier"};
    }

    public String[] getNomes() {
        return nomes;
    }

    public void setNomes(String[] nomes) {
        this.nomes = nomes;
    }

    // implementar o método de pesquisaConstante
    public void pesquisaTempoConstante(int id){
        
        if(id<=22){
         int cont = 0;
        
        for (String teste0 : getNomes()) {
          
            if(cont == id){
                System.out.println("Nome pesquisado é " + teste0 + " que está na posição "+id);
            }
            cont++;
        }

        
        }else{
            throw new IllegalArgumentException("O array de nomes possui :22 nomes.");

        }
    }
    }

