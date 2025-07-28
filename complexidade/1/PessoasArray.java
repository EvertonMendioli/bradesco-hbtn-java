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
    public void buscaLinear(String nome){
        boolean encontrado  = false;
        System.out.println("Procurando pelo nome: \"" + nome + "\"");
        for (int count = 0; count < nomes.length; count++) {
            
            System.out.println("Passando pelo indice: " +  count);
            if(nomes[count]==nome){
                System.out.println("Nome pesquisado é " + nome + " que está na posição " + count);
                encontrado  = true;
            }
        }
        if(!encontrado ){
            throw new IllegalArgumentException("O nome "+ nome + " não se encontra no array de nomes");

        }
    }
    }

