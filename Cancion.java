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

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return  nombre + "\n" + 
               "Duración: " + duracion + " min\n" + 
               "Autor: " + autor + "\n" + 
               "Género: " + genero;
    }
    
}