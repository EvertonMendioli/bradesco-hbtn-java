import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;

public class Estoque {

    private String nomeArquivo;

    public Estoque(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public void adicionarProduto(String nome, int quantidade, double preco) {

        Produto produto;
        try {
            int novoID=1;
            while (true) {
                if (!verificarID(novoID)){
                    break;
                }
                novoID++;
            }
        
            int linhaAtual = 0;
            
                FileReader fileReader = new FileReader(nomeArquivo);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                ArrayList<String> arquivoTemporario = new ArrayList<>();
                String linha;
                while ((linha = bufferedReader.readLine()) != null) {
                    String[] valor = linha.split(",");
                        produto = new Produto(Integer.parseInt(valor[0]), valor[1], Integer.parseInt(valor[2]), Double.parseDouble(valor[3]));
                        arquivoTemporario.add(produto.toCsv());
                }

                produto = new Produto(novoID, nome, quantidade, preco);
                arquivoTemporario.add(produto.toCsv());
    
                        Path nomeArquivoOriginal = Paths.get(nomeArquivo);
                        Files.delete(nomeArquivoOriginal);
                        
                        FileWriter fileWriter = new FileWriter(this.nomeArquivo);
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                        for (String linhaConteudo : arquivoTemporario) {
                            if(linhaAtual==0){
                                bufferedWriter.write(linhaConteudo);  
                                linhaAtual++;  
                            }else{
                                bufferedWriter.newLine();
                                bufferedWriter.write(linhaConteudo);
                                linhaAtual++;
                            }
                        }
        
                        bufferedWriter.close();
               
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    public void excluirProduto(int idExcluir) {
        try {
            FileReader fileReader = new FileReader(nomeArquivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            ArrayList<String> arquivoTemporario = new ArrayList<>();
            String verificarID = "";
            String linha;
            Produto produto;
            while ((linha = bufferedReader.readLine()) != null) {
                String[] valor = linha.split(",");

                if (Integer.parseInt(valor[0].trim()) != idExcluir) {
                    produto = new Produto(Integer.parseInt(valor[0]), valor[1], Integer.parseInt(valor[2]),
                            Double.parseDouble(valor[3]));
                    arquivoTemporario.add(produto.toCsv());
                } else {
                    verificarID = "encontrado";
                }

            }

            bufferedReader.close();

            if (verificarID.equals("")) {
                throw new IOException("ID não encontrado: " + idExcluir);
            } else {

                Path nomeArquivoOriginal = Paths.get(nomeArquivo);
                Files.delete(nomeArquivoOriginal);
                int linhaAtual = 0;
                FileWriter fileWriter = new FileWriter(this.nomeArquivo);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                for (String linhaConteudo : arquivoTemporario) {
                    if (linhaAtual == 0) {
                        bufferedWriter.write(linhaConteudo);
                        linhaAtual++;
                    } else {
                        bufferedWriter.newLine();
                        bufferedWriter.write(linhaConteudo);
                        linhaAtual++;
                    }

                }

                bufferedWriter.close();

            }

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public void exibirEstoque() {
        try {
            FileReader fileReader = new FileReader(nomeArquivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linha;
            Produto produto;
            while ((linha = bufferedReader.readLine()) != null) {
                String[] valor = linha.split(",");
                produto = new Produto(Integer.parseInt(valor[0]), valor[1], Integer.parseInt(valor[2]),
                        Double.parseDouble(valor[3]));
                System.out.println(produto.toString());
            }

        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    public void atualizarQuantidade(int idAtualizar, int novaQuantidade) {
        String nome;
        double preco;
        String verificarID = "";
        int linhaAtual = 0;
        try {
            FileReader fileReader = new FileReader(nomeArquivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            ArrayList<String> arquivoTemporario = new ArrayList<>();

            Produto produto;

            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                String[] valor = linha.split(",");

                if (Integer.parseInt(valor[0].trim()) == idAtualizar) {
                    nome = valor[1];
                    preco = Double.parseDouble(valor[3]);
                    produto = new Produto(idAtualizar, nome, novaQuantidade, preco);
                    arquivoTemporario.add(produto.toCsv());
                    verificarID = "encontrado";
                } else {
                    produto = new Produto(Integer.parseInt(valor[0]), valor[1], Integer.parseInt(valor[2]),
                            Double.parseDouble(valor[3]));
                    arquivoTemporario.add(produto.toCsv());
                }

            }
            bufferedReader.close();

            if (verificarID.equals("")) {
                throw new IOException("ID não encontrado: " + idAtualizar);
            } else {

                Path nomeArquivoOriginal = Paths.get(nomeArquivo);
                Files.delete(nomeArquivoOriginal);

                FileWriter fileWriter = new FileWriter(this.nomeArquivo);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                for (String linhaConteudo : arquivoTemporario) {
                    if (linhaAtual == 0) {
                        bufferedWriter.write(linhaConteudo);
                        linhaAtual++;
                    } else {
                        bufferedWriter.newLine();
                        bufferedWriter.write(linhaConteudo);
                        linhaAtual++;
                    }
                }

                bufferedWriter.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public boolean verificarID(int Id) {
        try {
            FileReader fileReader = new FileReader(nomeArquivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                String[] valor = linha.split(",");

                if (Integer.parseInt(valor[0].trim()) == Id) {
                    bufferedReader.close();
                    return true;
                }

            }

            bufferedReader.close();
            return false;

        } catch (IOException e) {

            e.printStackTrace();
        }
        return false;
    }
}
