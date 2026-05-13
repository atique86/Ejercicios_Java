package curso.contactos.servicio;

import curso.contactos.modelo.Contacto;
import curso.contactos.repositorio.ContactoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactoServicio implements IContactoServicio{

    private final ContactoRepositorio contactoRepositorio;

    public ContactoServicio(ContactoRepositorio contactoRepositorio) {
        this.contactoRepositorio = contactoRepositorio;
    }

    @Override
    public List<Contacto> listarContactos() {
        return contactoRepositorio.findAll();
    }

    @Override
    public Contacto buscarContactoPorId(Integer idContacto) {
        if (idContacto == null) {
            return null;
        }
        return contactoRepositorio.findById(idContacto).orElse(null);
    }

    @Override
    public void guardarContacto(Contacto contacto) {
        if (contacto == null) {
            return;
        }
        contactoRepositorio.save(contacto);
    }

    @Override
    public void eliminarContacto(Contacto contacto) {
        if (contacto == null) {
            return;
        }
        contactoRepositorio.delete(contacto);
    }
}
