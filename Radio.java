import java.util.HashMap;
import java.util.List;

class Radio extends Modo {
    private List<HashMap<String, Double>> frequencyList;
    private String banda;
    private double frecuencia;

    public Radio(List<HashMap<String, Double>> frequencyList, String banda, double frecuencia) {
        this.frequencyList = frequencyList;
        this.banda = banda;
        this.frecuencia = frecuencia;
    }

    public Radio() {
    }

    public List<HashMap<String, Double>> getFrequencyList() {
        return frequencyList;
    }

    public void setFrequencyList(List<HashMap<String, Double>> frequencyList) {
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
            setFrecuencia(nuevaFrecuencia);  // Asigna la nueva frecuencia si está en el rango
        } else if(nuevaFrecuencia<=87.5) {
            setFrecuencia(87.5);
        }else if (nuevaFrecuencia>108.0){
            setFrecuencia(108.0);
        }

    }
    

    public void guardarEmisora(String nombre ,double frecuencia) {
        HashMap<String, Double> estacion = new HashMap<>();
        estacion.put(nombre, frecuencia);  // Asigna el nombre y la frecuencia
        frequencyList.add(estacion);
    }
    public void cargarEmisora(double index) {
        for (HashMap<String,Double> hashMap : frequencyList) {
            for(Double frecuencia: hashMap.values()){
                if(frecuencia.equals(index)){
                    setFrecuencia(index);
                }
            }
        }
    }

    @Override
    public void cambiarModo() {
        this.radio.modo(this);
    }
}