import java.util.ArrayList;
import java.util.List;
import java.lang.StringBuilder;

class Telefono extends Modo {
    private boolean conectado;
    private List<Contacto> contactosLista;

    public Telefono(HardwareRadio radio) {
        this.radio = radio;
        this.nombre = "Teléfono";
        this.conectado = false;
        this.contactosLista = new ArrayList<>();
    }

    public String conectarDesconectar() {
        conectado = !conectado;
        return conectado ? "Teléfono conectado" : "Teléfono desconectado";
    }

    public String mostrarContactos() {
        if (!contactosLista.isEmpty()) {
            StringBuilder contactos = new StringBuilder("Lista de contactos:\n");
            for (Contacto contacto : contactosLista) {
                contactos.append(contacto).append("\n");
            }
            return contactos.toString();
        } else {
            return "No hay contactos en la lista.";
        }
    }

    public void agregarContacto(Contacto contacto) {
        contactosLista.add(contacto);
    }

    @Override
    public void cambiarModo() {
        this.radio.modo(this);
    }
}