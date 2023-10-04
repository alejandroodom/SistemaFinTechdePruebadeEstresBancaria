public class Cuenta {
    //La clase Cuenta representa una cuenta bancaria con un saldo determinado, en este caso 10.000€.
    private double saldo;

    public Cuenta(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    //Contiene métodos para depositar y retirar dinero de la cuenta, así como para obtener el saldo actual.
    public synchronized void depositar(double cantidad) {
        saldo += cantidad;  //Depositar saldo
    }

    public synchronized void retirar(double cantidad) {
        saldo -= cantidad;  //Retirar saldo
    }

    public synchronized double obtenerSaldo() {
        return saldo;    //Obtener saldo
    }
}

