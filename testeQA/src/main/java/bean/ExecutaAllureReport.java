package bean;

import java.io.IOException;

public class ExecutaAllureReport {

	static Process process = null;

	public static void executarRelatorio() throws InterruptedException, IOException {

		// Copiar Arquivo bat para dentro da pasta do Windows

		try {

			process = Runtime.getRuntime().exec("C:\\relatorio\\executar-relatorio-AllureReporte.cmd");
			Thread.sleep(1000);
			System.out.println("Relatorio executado");

		} catch (IOException e) {
			e.printStackTrace();

			process.destroy();
		}

		process = Runtime.getRuntime()
				.exec("taskkill /F /IM C:\\relatorio\\executar-relatorio-AllureReporte.cmd");
		process.destroy();
		process.destroyForcibly();
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Processo finalizado");

	}

	public static void main(String[] args) throws InterruptedException, IOException {
		executarRelatorio();
	}
	
}
