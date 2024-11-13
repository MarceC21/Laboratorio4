class HardwareRadio implements RadioC {
    private boolean estado;
    private int volumen;
    public Modo modoActual;

    public HardwareRadio() {
        this.estado = false;
        this.volumen = 0;
        this.modoActual = null;
    }

    @Override
    public void encenderApagar(boolean nuevoEstado) {
        this.estado = nuevoEstado;
    }

    @Override
    public void cambiarVolumen(int nuevoVolumen) {
        if (nuevoVolumen >= 0 && nuevoVolumen <= 100) {
            this.volumen = nuevoVolumen;
        }
    }

    @Override
    public void modo(Modo nuevoModo) {
        if (estado) {
            this.modoActual = nuevoModo;
        }
    }

    // Métodos adicionales para interacción con los modos
    public String cambiarModo() {
        if (modoActual != null) {
            modoActual.cambiarModo();
            return "Modo cambiado a: " + modoActual.getNombre();
        } else {
            return "No hay un modo activo para cambiar.";
        }
    }

    public boolean isEncendido() {
        return estado;
    }

    public int getVolumen() {
        return volumen;
    }

    public Modo getModoActual() {
        return modoActual;
    }
}