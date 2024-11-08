class Cancion {
    private String nombre;
    private double duracion;
    private String autor;
    private String genero;

    public Cancion(String nombre, double duracion, String autor, String genero) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.autor = autor;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "";
    }
}