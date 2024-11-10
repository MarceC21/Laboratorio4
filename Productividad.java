import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

class Productividad extends Modo {
    private Random random;
    private ArrayList<String> climate;

    public Productividad() {
        this.nombre = "Productividad";
        this.random = new Random();
        this.climate= new ArrayList<>(Arrays.asList("Soleado", "Nublado", "Chubuzcos", "LLuvia","Llovizna","Tormenta"));

    }

    public String obtenerPronostico() {
        double min=-5.5;
        double max=40;
        double degree=min + (random.nextDouble() * (max - min));
        String strdegre=Double.toString(degree);
        String clima=climate.get(random.nextInt((climate.size())));
        return "Hoy la temperatura es de "+strdegre+" con un tiempo: "+clima;

    }

    @Override
    public void cambiarModo() {
        this.radio.modo(this);
    }
}