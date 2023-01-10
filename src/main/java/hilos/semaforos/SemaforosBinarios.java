package hilos.semaforos;

import java.util.concurrent.Semaphore;

public class SemaforosBinarios extends Thread {

    private static int contador = 0;
    private static Semaphore semaforo = new Semaphore(1);

    SemaforosBinarios(String hilo) {
        super(hilo);
    }

    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            try {
                semaforo.acquire();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + ": " + contador++);
            semaforo.release();
        }
        }

    public static void main(String[] args) {
        new SemaforosBinarios("Hilo 1").start();
        new SemaforosBinarios("Hilo 2").start();
    }
}

