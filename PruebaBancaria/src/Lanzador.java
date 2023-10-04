import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Lanzador {
    //La clase Lanzador tiene la función de lanzar la simulación, ejecutará las operaciones de forma paralela y al final imprimirá el saldo final de la cuenta.
    public void ejecutarSimulacion() throws InterruptedException {

        Cuenta cuenta = new Cuenta(10000); //Creamos una cuenta con un saldo inicial de 10000€.
        ExecutorService executor = Executors.newFixedThreadPool(10);   //Número de hilos que se ejecutarán simultáneamente.

        //Creamos variables enteras para almacenar el número de depósitos y retiradas que se realizarán.
        int numDepositos = 400;
        int numDepositos2 = 200;
        int numDepositos3 = 600;
        int numRetiros = 400;
        int numRetiros2 = 200;
        int numRetiros3 = 600;

        //Cada bucle for es una operación de depósito o retirada, en este caso se han creado 6 bucles, 3 para depósitos y 3 para retiradas, como nos indican los requisitos.
        for (int i = 0; i < numDepositos; i++) {
            executor.execute(new HiloCliente(cuenta, 100, true));
            System.out.println("Deposito 100");
        }

        for (int i = 0; i < numDepositos2; i++) {
            executor.execute(new HiloCliente(cuenta, 50, true));
            System.out.println("Deposito 50");
        }

        for (int i = 0; i < numDepositos3; i++) {
            executor.execute(new HiloCliente(cuenta, 20, true));
            System.out.println("Deposito 20");
        }

        for (int i = 0; i < numRetiros; i++) {
            executor.execute(new HiloCliente(cuenta, 100, false));
            System.out.println("Retiro 100");
        }

        for (int i = 0; i < numRetiros2; i++) {
            executor.execute(new HiloCliente(cuenta, 50, false));
            System.out.println("Retiro 50");
        }

        for (int i = 0; i < numRetiros3; i++) {
            executor.execute(new HiloCliente(cuenta, 20, false));
            System.out.println("Retiro 20");
        }

        //Cerramos el executor y esperamos a que termine.
        executor.shutdown();
        executor.awaitTermination(1, java.util.concurrent.TimeUnit.DAYS);

        double saldoFinal = cuenta.obtenerSaldo();  //Obtenemos el saldo final de la cuenta.
        if (saldoFinal == 10000) {
            //Si ha funcionado correctamente se imprimirá el mensaje y el saldo, que debería ser de 10000€.
            System.out.println("La simulación se ha completado correctamente. Saldo final: " + saldoFinal + "€");
        } else {
            //Este caso imprimirá el mensaje de que ha fallado, en caso de que el saldo final no sea 10000€, si cambiaramos algún valor en los métodos de depositar o retirar variaría, pero está diseñado para estos valores en caso de condiciones de carrera u otros problemas de concurrencia.
            System.out.println("La simulación ha fallado. Saldo final: " + saldoFinal + "€");
        }
    }
}
