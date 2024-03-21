package view;

import java.util.concurrent.Semaphore;

import controller.ThreadAviao;

public class Main {

	public static void main(String[] args) {
		Semaphore semaforo1 = new Semaphore(1);
		Semaphore semaforo2 = new Semaphore(1);

		for (int id = 1; id <= 12; id++) {
			Thread voar = new ThreadAviao(id, semaforo1, semaforo2);
			voar.start();
		}

	}

}