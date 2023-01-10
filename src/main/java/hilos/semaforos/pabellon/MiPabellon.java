package hilos.semaforos.pabellon;

import java.util.concurrent.Semaphore;

public class MiPabellon {
    public static void main(String[] args) {
        Semaphore semaforo = new Semaphore(8);

        for (int i = 1; i <= 10 ; i++) {
            MiPartido partido = new MiPartido(Integer.toString(i), semaforo);
            partido.start();
        }
    }
}
