import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Radio extends Modo {
    private HashMap<Double, String> frequencyList;
    private String banda;
    private double frecuencia;

    public Radio() {
        this.frequencyList = new HashMap<Double, String>();
        this.banda = "FM";
        this.frecuencia = 0.0;
    }

    public HashMap<Double, String> getFrequencyList() {
        return frequencyList;
    }

    public void setFrequencyList(HashMap<Double, String> frequencyList) {
        this.frequencyList = frequencyList;
    }

    public String getBanda() {
        return banda;
    }

    public void setBanda(String banda) {
        this.banda = banda;
    }

    public double getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(double frecuencia) {
        this.frecuencia = frecuencia;
    }

    public void cambiarEmisora(int add) {
        double nuevaFrecuencia=0;
    
        if (add == 1) {
            nuevaFrecuencia = this.frecuencia + 0.5;
        } else if (add == -1) {
            nuevaFrecuencia = this.frecuencia - 0.5;
        } 

        // Validación de rango, suponiendo que estamos en la banda FM
        if (nuevaFrecuencia >= 87.5 && nuevaFrecuencia <= 108.0) {
            setFrecuencia(nuevaFrecuencia);
        } else if(nuevaFrecuencia<=87.5) {
            setFrecuencia(87.5);
        }else if (nuevaFrecuencia>108.0){
            setFrecuencia(108.0);
        }

    }
    

    public void guardarEmisora(String nombre ,double frecuencia) {
        this.frequencyList.put(frecuencia, nombre);
    }
    public void cargarEmisora(double frecuencia) {
        for (int i=0; i<=this.frequencyList.size(); i++) {
            if (this.frequencyList.containsKey(frecuencia)) {
                setFrecuencia(frecuencia);
            }
        }
    }

    @Override
    public void cambiarModo() {
        this.radio.modo(this);
    }
}