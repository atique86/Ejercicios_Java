package curso.tienda_libros.vista;

import curso.tienda_libros.modelo.Libro;
import curso.tienda_libros.servicio.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Component
public class LibroForm extends JFrame {
    private final LibroServicio libroServicio;
    private JPanel panel;
    private JTable tablaLibros;
    private JTextField idTexto;
    private JTextField libroTexto;
    private JTextField autorTexto;
    private JTextField precioTexto;
    private JTextField existenciasTexto;
    private JButton agregarButton;
    private JButton modificarButton;
    private JButton eliminarButton;
    private DefaultTableModel tablaModeloLibros;

    @Autowired
    public LibroForm(LibroServicio libroServicio){
        this.libroServicio = libroServicio;
        crearComponentes();
        iniciarForma();

        agregarButton.addActionListener(e -> agregarLibro());
        tablaLibros.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                cargarLibroSeleccionado();
            }
        });
        modificarButton.addActionListener(e -> modificarLibro());
        eliminarButton.addActionListener(e -> eliminarLibro());
        listarLibros();
    }

    private void crearComponentes() {
        panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));

        idTexto = new JTextField();
        idTexto.setVisible(false);
        libroTexto = new JTextField(22);
        autorTexto = new JTextField(22);
        precioTexto = new JTextField(14);
        existenciasTexto = new JTextField(14);

        agregarButton = new JButton("Agregar");
        modificarButton = new JButton("Modificar");
        eliminarButton = new JButton("Eliminar");

        tablaModeloLibros = new DefaultTableModel(new Object[]{"Id", "Libro", "Autor", "Precio", "Existencias"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaLibros = new JTable(tablaModeloLibros);
        tablaLibros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaLibros.setFillsViewportHeight(true);

        JPanel camposPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.0;

        gbc.gridx = 0;
        gbc.gridy = 0;
        camposPanel.add(new JLabel("Nombre del libro:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        camposPanel.add(libroTexto, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.0;
        camposPanel.add(new JLabel("Autor:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        camposPanel.add(autorTexto, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.0;
        camposPanel.add(new JLabel("Precio:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        camposPanel.add(precioTexto, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0.0;
        camposPanel.add(new JLabel("Existencias:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        camposPanel.add(existenciasTexto, gbc);

        JPanel botonesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        botonesPanel.add(agregarButton);
        botonesPanel.add(modificarButton);
        botonesPanel.add(eliminarButton);

        JPanel nortePanel = new JPanel(new BorderLayout(0, 10));
        nortePanel.add(camposPanel, BorderLayout.CENTER);
        nortePanel.add(botonesPanel, BorderLayout.SOUTH);

        JScrollPane tablaScroll = new JScrollPane(tablaLibros);
        tablaScroll.setPreferredSize(new Dimension(860, 360));

        panel.add(nortePanel, BorderLayout.NORTH);
        panel.add(tablaScroll, BorderLayout.CENTER);
    }

    private void iniciarForma(){
        setTitle("Tienda de Libros");
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void agregarLibro(){
        if(libroTexto.getText().isBlank()){
            mostrarMensaje("Proporcione el nombre del libro.");
            libroTexto.requestFocusInWindow();
            return;
        }
        var nombreLibro = libroTexto.getText();
        var autor = autorTexto.getText();
        var precio = Double.parseDouble(precioTexto.getText());
        var existencias = Integer.parseInt(existenciasTexto.getText());
        var libro = new Libro(null, nombreLibro, autor, precio, existencias);
        this.libroServicio.guardarLibro(libro);
        mostrarMensaje("¡Se agregó el libro de manera correcta!");
        limpiarFormulario();
        listarLibros();
    }

    private void modificarLibro(){
        if(this.idTexto.getText().isBlank()){
            mostrarMensaje("Debe seleccionar el libro a modificar ...");
        } else {
            var idLibro = Integer.parseInt(idTexto.getText());
            if(libroTexto.getText().isBlank()){
                mostrarMensaje("Proporcione el nombre del libro.");
                libroTexto.requestFocusInWindow();
                return;
            }
            var nombreLibro = libroTexto.getText();
            if(autorTexto.getText().isBlank()){
                mostrarMensaje("Proporcione el autor del libro.");
                autorTexto.requestFocusInWindow();
                return;
            }
            var autor = autorTexto.getText();
            if(precioTexto.getText().isBlank()){
                mostrarMensaje("Proporcione el precio del libro.");
                precioTexto.requestFocusInWindow();
                return;
            }
            var precio = Double.parseDouble(precioTexto.getText());
            if(existenciasTexto.getText().isBlank()){
                mostrarMensaje("Proporcione la(s) existencia(s) del libro.");
                existenciasTexto.requestFocusInWindow();
                return;
            }
            var existencias = Integer.parseInt(existenciasTexto.getText());
            var libro = new Libro(idLibro, nombreLibro, autor, precio, existencias);
            this.libroServicio.guardarLibro(libro);
            mostrarMensaje("¡Se actualizaron los datos del libro de manera correcta!");
            limpiarFormulario();
            listarLibros();
        }
    }

    public void eliminarLibro(){
        var renglon = tablaLibros.getSelectedRow();
        if(renglon != -1){
            String idLibro = tablaLibros.getModel().getValueAt(renglon, 0).toString();
            var libro = new Libro();
            libro.setIdLibro(Integer.parseInt(idLibro));
            libroServicio.eliminarLibro(libro);
            mostrarMensaje("Libro " + idLibro + " eliminado de manera correcta.");
            limpiarFormulario();
            listarLibros();
        } else {
            mostrarMensaje("Seleccione el libro a eliminar ...");
        }
    }

    private void cargarLibroSeleccionado(){
        var renglon = tablaLibros.getSelectedRow();
        if(renglon != -1){
            String idLibro = tablaLibros.getModel().getValueAt(renglon, 0).toString();
            idTexto.setText(idLibro);
            String nombreLibro = tablaLibros.getModel().getValueAt(renglon, 1).toString();
            libroTexto.setText(nombreLibro);
            String autor = tablaLibros.getModel().getValueAt(renglon, 2).toString();
            autorTexto.setText(autor);
            String precio = tablaLibros.getModel().getValueAt(renglon, 3).toString();
            precioTexto.setText(precio);
            String existencias = tablaLibros.getModel().getValueAt(renglon, 4).toString();
            existenciasTexto.setText(existencias);
        }
    }

    private void limpiarFormulario(){
        libroTexto.setText("");
        autorTexto.setText("");
        precioTexto.setText("");
        existenciasTexto.setText("");
        idTexto.setText("");
    }

    private void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje);
    }

    private void listarLibros(){
        tablaModeloLibros.setRowCount(0);
        var libros = libroServicio.listarLibros();
        libros.forEach((libro) -> {
            Object[] renglonLibro = {
                    libro.getIdLibro(),
                    libro.getNombreLibro(),
                    libro.getAutor(),
                    libro.getPrecio(),
                    libro.getExistencias()
            };
            this.tablaModeloLibros.addRow(renglonLibro);
        });
    }
}
