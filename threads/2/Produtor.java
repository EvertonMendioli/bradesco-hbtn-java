public class Produtor extends Thread  {


    public Fila fila;


    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                wait();
                fila.adicionar(i);
                Thread.sleep(500); 
                notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
