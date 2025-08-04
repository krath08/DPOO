package visual;

import javax.swing.*;
import logico.*;
import java.util.Date;

public class ModPostulacion extends JFrame {
    private JTextField txtComentarios;
    private JComboBox<EstadoPostulacion> comboEstado;
    private Postulacion postulacion;

    public ModPostulacion(Postulacion postulacion, VentanaPrincipal ventanaPrincipal) {
        this.postulacion = postulacion;

        setTitle("Modificar Postulación");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblEstado = new JLabel("Estado:");
        lblEstado.setBounds(30, 30, 80, 25);
        getContentPane().add(lblEstado);

        comboEstado = new JComboBox<>(EstadoPostulacion.values());
        comboEstado.setBounds(120, 30, 200, 25);
        comboEstado.setSelectedItem(postulacion.getEstado());
        getContentPane().add(comboEstado);

        JLabel lblComentarios = new JLabel("Comentarios:");
        lblComentarios.setBounds(30, 70, 100, 25);
        getContentPane().add(lblComentarios);

        txtComentarios = new JTextField(postulacion.getComentarios());
        txtComentarios.setBounds(120, 70, 230, 25);
        getContentPane().add(txtComentarios);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(250, 120, 100, 30);
        getContentPane().add(btnGuardar);

        btnGuardar.addActionListener(e -> {
            try {
                postulacion.setEstado((EstadoPostulacion) comboEstado.getSelectedItem());
                postulacion.setComentarios(txtComentarios.getText());
                postulacion.setFechaPostulacion(new Date());

                BolsaLaboral.getInstancia().guardarPostulaciones();
                ventanaPrincipal.actualizarResumen();
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al guardar cambios: " + ex.getMessage());
            }
        });
    }
}
