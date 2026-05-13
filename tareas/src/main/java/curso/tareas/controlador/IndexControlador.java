package curso.tareas.controlador;

import curso.tareas.modelo.Tarea;
import curso.tareas.servicio.TareaServicio;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.Observer;
import java.util.ResourceBundle;

@Component
public class IndexControlador implements Initializable {

    private static final Logger logger = LoggerFactory.getLogger(IndexControlador.class);

    @Autowired
    private TareaServicio tareaServicio;

    @FXML
    private TableView<Tarea> tareaTabla;

    @FXML
    private TableColumn<Tarea, Integer> idTareaColumna;
    @FXML
    private TableColumn<Tarea, String> nombreTareaColumna;
    @FXML
    private TableColumn<Tarea, String> responsableColumna;
    @FXML
    private TableColumn<Tarea, String> estatusColumna;

    private final ObservableList<Tarea> tareaList = FXCollections.observableArrayList();

    @FXML
    private TextField nombreTareaTexto;
    @FXML
    private TextField responsableTexto;
    @FXML
    private TextField estatusTexto;

    private Integer idTareaSeleccionada;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tareaTabla.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        configurarColumnas();
        listarTareas();
    }

    private void configurarColumnas() {
        idTareaColumna.setCellValueFactory(new PropertyValueFactory<>("id"));
        nombreTareaColumna.setCellValueFactory(new PropertyValueFactory<>("nombreTarea"));
        responsableColumna.setCellValueFactory(new PropertyValueFactory<>("responsable"));
        estatusColumna.setCellValueFactory(new PropertyValueFactory<>("estatus"));
    }

    private void listarTareas() {
        logger.info("Listando tareas");
        tareaList.clear();
        tareaList.addAll(tareaServicio.listarTareas());
        tareaTabla.setItems(tareaList);
    }

    public void agregarTarea() {
        // Validar campo nombre
        if(nombreTareaTexto.getText().trim().isEmpty()) {
            mostrarMensaje("Error validación", "Debe ingresar el nombre de la tarea");
            nombreTareaTexto.requestFocus();
            return;
        }

        // Validar campo responsable (si es requerido)
        if(responsableTexto.getText().trim().isEmpty()) {
            mostrarMensaje("Error validación", "Debe asignar un responsable para la tarea");
            responsableTexto.requestFocus();
            return;
        }

        // Validar campo estatus (si es requerido)
        if(estatusTexto.getText().trim().isEmpty()) {
            mostrarMensaje("Error validación", "Debe seleccionar un estatus para la tarea");
            estatusTexto.requestFocus();
            return;
        }

        try {
            // Crear y guardar la tarea
            Tarea tarea = new Tarea();
            recolectarDatosFormulario(tarea);
            tarea.setId(null);
            tareaServicio.guardarTarea(tarea);

            // Mostrar confirmación y actualizar UI
            mostrarMensaje("Tarea agregada", "La tarea se ha agregado correctamente");
            limpiarFormulario();
            listarTareas();

        } catch (Exception e) {
            mostrarMensaje("Error", "Ocurrió un error al guardar la tarea: " + e.getMessage());
            logger.error("Error al agregar tarea", e);
        }
    }

    public void cargarTareaFormulario(){
        var tarea = tareaTabla.getSelectionModel().getSelectedItem();
        if(tarea != null){
            idTareaSeleccionada = tarea.getId();
            nombreTareaTexto.setText(tarea.getNombreTarea());
            responsableTexto.setText(tarea.getResponsable());
            estatusTexto.setText(tarea.getEstatus());
        }
    }

    private void mostrarMensaje(String titulo, String mensaje){
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    private void recolectarDatosFormulario(Tarea tarea){
        if(idTareaSeleccionada != null){
            tarea.setId(idTareaSeleccionada);
        }
        tarea.setNombreTarea(nombreTareaTexto.getText());
        tarea.setResponsable(responsableTexto.getText());
        tarea.setEstatus(estatusTexto.getText());
    }

    public void limpiarFormulario(){
        idTareaSeleccionada = null;
        nombreTareaTexto.clear();
        responsableTexto.clear();
        estatusTexto.clear();
    }

    public void modificarTarea() {
        if(idTareaSeleccionada == null){
            mostrarMensaje("Error", "Debe seleccionar una tarea para modificarla");
            return;
        }
        if(nombreTareaTexto.getText().isEmpty()){
            mostrarMensaje("Error validación", "Debe ingresar el nombre de la tarea");
            nombreTareaTexto.requestFocus();
            return;
        }
        var tarea = new Tarea();
        recolectarDatosFormulario(tarea);
        tareaServicio.guardarTarea(tarea);
        mostrarMensaje("Tarea modificada", "La tarea se ha modificado correctamente");
        limpiarFormulario();
        listarTareas();
    }

    public void eliminarTarea() {
        if(idTareaSeleccionada == null){
            mostrarMensaje("Error", "Debe seleccionar una tarea para eliminarla");
            return;
        }
        var tarea = new Tarea();
        tarea.setId(idTareaSeleccionada);
        tareaServicio.eliminarTarea(tarea);
        mostrarMensaje("Tarea eliminada", "La tarea se ha eliminado correctamente");
        limpiarFormulario();
        listarTareas();
    }
}