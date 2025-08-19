import java.util.LinkedList;

public class SistemaFilas {

    public static void main(String[] args) {

        LinkedList<Integer> lista = new LinkedList<>();
        Fila fila;
        for (int i = 0; lista.size() < 10; i++) {

            lista.add(i);
            fila = new Fila(lista);

            Produtor produtor = new Produtor(fila);
            Consumidor consumidor = new Consumidor(fila);
            produtor.start();
            consumidor.start();

        }

    }

}
