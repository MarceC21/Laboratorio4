import java.util.Random;

class Productividad extends Modo {
    private Random random;

    public Productividad() {
        this.nombre = "Productividad";
        this.random = new Random();
    }

    public void obtenerPronostico() {
        //
    }

    @Override
    public void cambiarModo() {}
}