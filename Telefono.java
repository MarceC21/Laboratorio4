import java.util.ArrayList;
import java.util.List;

class Telefono extends Modo {
    private boolean conectado;
    private List<Contacto> contactosLista;

    public Telefono() {
        this.nombre = "Teléfono";
        this.conectado = false;
        this.contactosLista = new ArrayList<>();
    }

    public void conectarDesconectar() {
        //
    }

    public void mostrarContactos() {
        //
    }

    public void agregarContacto(Contacto contacto) {
        contactosLista.add(contacto);
    }

    @Override
    public void cambiarModo() {}
}