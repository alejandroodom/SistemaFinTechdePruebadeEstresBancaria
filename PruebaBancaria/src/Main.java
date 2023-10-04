public class Main {
    public static void main(String[] args) throws InterruptedException {
        //Esta clase únicamente se encarga de lanzar la simulación llamando al método ejecutarSimulacion() de la clase Lanzador.
        Lanzador lanzador = new Lanzador();
        lanzador.ejecutarSimulacion(); //De esta forma el código está mucho más limpio y ordenado.
    }
}