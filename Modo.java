abstract class Modo {
    protected String nombre;

    public HardwareRadio radio;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public abstract void cambiarModo();
}
