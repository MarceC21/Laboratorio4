import java.util.ArrayList;
import java.util.List;

class Reproduccion extends Modo {
    private List<Cancion> listaDeReproduccion;
    private int indiceActual;

    public Reproduccion() {
        this.nombre = "Reproducción";
        this.listaDeReproduccion = new ArrayList<>();
        this.indiceActual = 0;
    }

    public void cambiarCancion() {
        indiceActual = (indiceActual + 1) % listaDeReproduccion.size();
        mostrarCancionActual();
    }

    public void mostrarCancionActual() {
        //
    }

    public void agregarCancion(Cancion cancion) {
        //
    }

    @Override
    public void cambiarModo() {}
}