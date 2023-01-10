package hilos.semaforos.pabellon;

import java.util.concurrent.Semaphore;

public class MiPartido extends Thread{
    private Semaphore semaforo;

    MiPartido(String nombre, Semaphore semaforo){
        super(nombre);
        this.semaforo = semaforo;
    }

    @Override
    public void run() {
        try {
            semaforo.acquire();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Partido " + getName() + " jugando");

        try {
            sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Partido " + getName() + " termina y deja el balon");
        semaforo.release();
    }
}
