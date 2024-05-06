/*package visao;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class test {
	
	public static int contador = 0;

	public static void main(String[] args) {

		ScheduledExecutorService servico = Executors.newSingleThreadScheduledExecutor();

		Runnable run = new Runnable() {

			@Override
			public void run() {
				call();
			}
		};
		
		servico.scheduleAtFixedRate(run, 0, 5, TimeUnit.SECONDS);

	}

	public static void call() {
		contador++;
		System.out.println(contador);
	}

}*/