package controller;

import java.util.concurrent.Semaphore;

public class ThreadAviao extends Thread {

	private int id;
	private Semaphore semaforo1;
	private Semaphore semaforo2;
	private int pista;
	private int[] fases = new int[4];

	public ThreadAviao(int id, Semaphore semaforo1, Semaphore semaforo2) {
		this.id = id;
		this.semaforo1 = semaforo1;
		this.semaforo2 = semaforo2;
	}

	@Override
	public void run() {
		pista = (int) (Math.random() * 2);
		switch (pista) {
		case 0:
			try {
				semaforo1.acquire();
				System.out.println("O aviao nº" + id + " entrou na pista norte");
				decolagem();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo1.release();
			}
			System.out.println("O aviao nº" + id + " saiu da pista norte");
			break;
		default:
			try {
				semaforo2.acquire();
				System.out.println("O aviao nº" + id + " entrou na pista sul");
				decolagem();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo2.release();
			}
			System.out.println("O aviao nº" + id + " saiu da pista sul");
			break;
		}
	}

	private void decolagem() {
		try {
			fases[0] = (int) ((Math.random() * 401) + 300);
			sleep(fases[0]);
			System.out.println("O aviao nº" + id + " terminou de manobrar");
			fases[1] = (int) ((Math.random() * 501) + 500);
			sleep(fases[1]);
			System.out.println("O aviao nº" + id + " terminou de taxiar");
			fases[2] = (int) ((Math.random() * 201) + 600);
			sleep(fases[2]);
			System.out.println("O aviao nº" + id + " terminou de decolar");
			fases[3] = (int) ((Math.random() * 501) + 300);
			sleep(fases[3]);
			System.out.println("O aviao nº" + id + " terminou de se afastar");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}