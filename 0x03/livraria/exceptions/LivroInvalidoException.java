package exceptions;

public class LivroInvalidoException extends Exception {

public String mensagem;

        public LivroInvalidoException(String message) {
        super(message);
       
        }
    
}
