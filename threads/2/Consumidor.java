public class Consumidor extends Thread  {

    public Fila fila;


    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                wait();
                fila.retirar();
                Thread.sleep(500); 
                notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
