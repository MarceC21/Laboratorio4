import java.util.ArrayList;
import java.util.List;

class Reproduccion extends Modo {
    private List<Cancion> listaDeReproduccion;
    private int indiceActual;

    public Reproduccion() {
        this.nombre = "Reproducción";
        this.listaDeReproduccion = new ArrayList<>();
        this.indiceActual = 0;
        //Agregar canciones 
        agregarCancion(new Cancion("Canción 1", 3.5, "Autor 1", "Pop"));
        agregarCancion(new Cancion("Canción 2", 4.0, "Autor 2", "Rock"));
        agregarCancion(new Cancion("Canción 3", 2.8, "Autor 3", "Jazz"));
        agregarCancion(new Cancion("Canción 4", 5.0, "Autor 4", "Clásica"));
    }

    // Método para cambiar a la siguiente canción y devuelbe un mensaje si no hay canciones 
    public String cambiarCancion() {
        if (!listaDeReproduccion.isEmpty()) {
            indiceActual = (indiceActual + 1) % listaDeReproduccion.size();
            return mostrarCancionActual();
        } else {
            return "No hay canciones en la lista de reproducción.";
        }
    }

    // Método para obtener la canción actual con el toString de la cancion
    public String mostrarCancionActual() {
        if (!listaDeReproduccion.isEmpty()) {
            Cancion cancionActual = listaDeReproduccion.get(indiceActual);
            return "Reproduciendo: " + cancionActual.toString();
        } else {
            return "No hay canciones en la lista de reproducción.";
        }
    }

    // Método para agregar una canción a la lista de reproducción
    public void agregarCancion(Cancion cancion) {
        listaDeReproduccion.add(cancion);
    }

    @Override
    public void cambiarModo() {
        this.radio.modo(this);
    }
}
