class HardwareRadio implements RadioC {
    private boolean estado;
    private int volumen;
    public Modo modoActual;

    // Constructor
    public HardwareRadio() {
        this.estado = false;
        this.volumen = 0;
        this.modoActual = null;
    }

    @Override
    public void encenderApagar(boolean nuevoEstado) {
        //
    }

    @Override
    public void cambiarVolumen(int nuevoVolumen) {
        //
    }

    @Override
    public void modo(Modo nuevoModo) {
        modoActual = nuevoModo;
    }
}