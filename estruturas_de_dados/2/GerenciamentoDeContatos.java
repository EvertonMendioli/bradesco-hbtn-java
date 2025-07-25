import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class GerenciamentoDeContatos {
private Map<String, Contato> contatos;


    // Construtor
    public GerenciamentoDeContatos() {
        contatos = new HashMap<>();
    }

        // Adiciona um novo contato
        public void adicionarContato(String nome, String telefone, String email) {
            Contato contatoVar = new Contato();
            boolean existe = false;
            for (Map.Entry<String, Contato> entry : contatos.entrySet()) {
                if(entry.getKey().equalsIgnoreCase(nome)){
                    System.out.println("Erro: Contato com nome " + nome  + " já existe!");
                    existe = true;
                }
            } 
            
            if(!existe){
            contatoVar.adicionarEmail(email);
            contatoVar.adicionarTelefone(telefone);
            contatos.put(nome, contatoVar);
            System.out.println("Contato " + nome  + " adicionado com sucesso!");
            }
            }
        
        
            // Exibe todos os contatos
            public void exibirContatos() {
                
                for (Map.Entry<String, Contato> entry : contatos.entrySet()) {
                    System.out.println("Nome: " + entry.getKey() );
                    entry.getValue().exibirContato();
                    System.out.println("-------------------------------");
                }
            }
        
        
            // Busca um contato pelo nome
            public void buscarContato(String nome) {
                 for (Map.Entry<String, Contato> entry : contatos.entrySet()) {
                    if(entry.getKey().equalsIgnoreCase(nome)){
                    System.out.println("Contato encontrado: " + entry.getKey() );
                    entry.getValue().exibirContato();
                    }
                }

            }
        
        
            // Remove um contato pelo nome
            public void removerContato(String nome) {
                boolean existe = false;
                for (Map.Entry<String, Contato> entry : contatos.entrySet()) {
                    if(entry.getKey().equalsIgnoreCase(nome)){
                         contatos.remove(entry.getKey());
                         System.out.println("Contato " + entry.getKey() + " removido com sucesso!" );
                         existe = true;
                    }
                }
                if(!existe){
                    System.out.println("Contato " + nome + " não encontrado." );
                }


                
            }

            public static void main(String[] args){
            GerenciamentoDeContatos gestao = new GerenciamentoDeContatos();


            // Adicionando contatos
            gestao.adicionarContato("Carlos", "1234-5678", "carlos@email.com");
            gestao.adicionarContato("Maria", "8765-4321", "maria@email.com");
            gestao.adicionarContato("Ana", "1122-3344", "ana@email.com");
            gestao.adicionarContato("Carlos", "1234-5678", "carlos@email.com"); // Tentando duplicar
    
    
            // Exibindo todos os contatos
            System.out.println("\nExibindo todos os contatos:");
            gestao.exibirContatos();
    
    
            // Buscando um contato
            System.out.println("\nBuscando contato 'Maria':");
            gestao.buscarContato("Maria");
    
    
            // Removendo um contato
            System.out.println("\nRemovendo contato 'Carlos':");
            gestao.removerContato("Carlos");
    
    
            // Tentando remover um contato inexistente
            System.out.println("\nTentando remover contato 'João' que não existe:");
            gestao.removerContato("João");
    
    
            // Exibindo todos os contatos após remoções
            System.out.println("\nExibindo todos os contatos após remoções:");
            gestao.exibirContatos();
        }

}
