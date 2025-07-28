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

    // implementar o método de buscaBinaria
    public void buscaBinaria(String nome){
        boolean encontrado = false;
        int inicio= 0;
        int fim = nomes.length - 1;
        int valorMeio;
        System.out.println("Procurando o nome: \"" + nome + "\"");
        for(int i = 0; i<nomes.length; i++ ){
         valorMeio = (inicio + fim)/2;
            System.out.println("Passando pelo indice:" + valorMeio);

            if (valorMeio==0) {
                throw new IllegalArgumentException("O nome " + nome + " não se encontra no array de nomes");
            }

            if(nomes[valorMeio] == nome){
                encontrado = true;
                System.out.println("Nome "+ nome  + " encontrado na posição " + valorMeio);
                break;
            }else if(nomes[valorMeio].compareTo(nome) < 0){
                inicio = valorMeio + 1;
            }else{
                fim = valorMeio - 1;
            }
        }


    }
}

