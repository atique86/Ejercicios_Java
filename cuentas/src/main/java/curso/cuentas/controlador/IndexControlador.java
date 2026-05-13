package curso.cuentas.controlador;

import curso.cuentas.modelo.Cuenta;
import curso.cuentas.servicio.CuentaServicio;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.primefaces.PrimeFaces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@ViewScoped
public class IndexControlador {
    @Autowired
    CuentaServicio cuentaServicio;
    private List<Cuenta> cuentas;
    private Cuenta cuentaSeleccionada;
    private static final Logger logger = LoggerFactory.getLogger(IndexControlador.class);

    @PostConstruct
    public void init(){
        cargarDatos();
    }

    public void cargarDatos(){
        logger.info("Cargando datos...");
        this.cuentas = cuentaServicio.listarCuentas();
        cuentas.forEach(cuenta -> logger.info("Cuenta: {}", cuenta));
    }

    public void agregarCuenta(){
        this.cuentaSeleccionada = new Cuenta();
    }

    public void guardarCuenta() {
        logger.info("Guardando cuenta: {}", this.cuentaSeleccionada);
        boolean esNueva = this.cuentaSeleccionada.getIdCuenta() == null;

        try {
            this.cuentaServicio.guardarCuenta(this.cuentaSeleccionada);

            if (esNueva) {
                this.cuentas.add(this.cuentaSeleccionada);
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Cuenta registrada",
                                "La cuenta se ha guardado correctamente."));
                logger.info("Cuenta registrada exitosamente: {}", this.cuentaSeleccionada);
            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Cuenta actualizada",
                                "Los cambios en la cuenta se han guardado correctamente."));
                logger.info("Cuenta actualizada exitosamente: {}", this.cuentaSeleccionada);
            }

            // Oculta la ventana modal
            PrimeFaces.current().executeScript("PF('ventanaModalCuenta').hide()");
            // Actualiza mensajes y tabla
            PrimeFaces.current().ajax().update("forma-cuentas:mensajes", "forma-cuentas:cuentas-tabla");

        } catch (Exception e) {
            logger.error("Error al guardar la cuenta: {}", this.cuentaSeleccionada, e);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Error al guardar",
                            "Ocurrió un error al intentar guardar la cuenta. Inténtelo nuevamente."));
        }
        // Reset
        this.cuentaSeleccionada = null;
    }

    public void eliminarCuenta(){
        logger.info("Eliminando cuenta: {}", this.cuentaSeleccionada);
        this.cuentaServicio.eliminarCuenta(this.cuentaSeleccionada);
        this.cuentas.remove(this.cuentaSeleccionada); //Eliminar el registro de la lista
        this.cuentaSeleccionada = null; // Reset de la cuenta seleccionada
        //FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Cuenta eliminada"));
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Cuenta eliminada",
                        "La cuenta se ha eliminado de manera correcta."));
        PrimeFaces.current().ajax().update("forma-cuentas:mensajes","forma-cuentas:cuentas-tabla");
    }
}
