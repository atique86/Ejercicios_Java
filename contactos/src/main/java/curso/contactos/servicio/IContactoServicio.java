package curso.contactos.servicio;

import curso.contactos.modelo.Contacto;

import java.util.List;

public interface IContactoServicio {
    List<Contacto> listarContactos();

    Contacto buscarContactoPorId(Integer idContacto);

    void guardarContacto(Contacto contacto);

    void eliminarContacto(Contacto contacto);
}
