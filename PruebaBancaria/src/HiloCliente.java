public class HiloCliente implements Runnable {
    //La clase HiloCliente representa un hilo que ejecutará una operación de depósito o retirada en la cuenta. También implementa la interfaz Runnable.
    private final Cuenta cuenta;
    private final double cantidad;
    private final boolean seDeposita;

    public HiloCliente(Cuenta cuenta, double cantidad, boolean depositar) {
        this.cuenta = cuenta;
        this.cantidad = cantidad;
        this.seDeposita = depositar;
    }

    @Override
    public void run() {
        if (seDeposita) {
            cuenta.depositar(cantidad);
        } else {
            cuenta.retirar(cantidad);
        }
    }
}

