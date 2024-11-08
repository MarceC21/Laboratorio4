import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Radio extends Modo {
    private List<HashMap<String, Double>> frequencyList;
    private String banda;
    private double frecuencia;

    public Radio() {
        this.nombre = "Radio";
        this.frequencyList = new ArrayList<>();
        this.banda = "FM";
        this.frecuencia = 87.5;
    }

    public void cambiarEmisora(double cambio) {
        //
    }

    public void cambiarBanda() {
        //
    }

    public void guardarEmisora() {
        //
    }

    public void cargarEmisora(int index) {
        //
    }

    @Override
    public void cambiarModo() {}
}