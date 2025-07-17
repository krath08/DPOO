package visual;

import javax.swing.*;
import java.awt.*;

public class RegCandidato extends JFrame {

    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtCedula;
    private JTextField txtTelefono;
    private JTextField txtDireccion;
    private JTextField txtEmail;
    private JTextField txtFechaNacimiento;
    private JComboBox<String> comboTipoCandidato;

    public RegCandidato() {
        setTitle("Registrar Nuevo Candidato");
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(30, 20, 100, 25);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(150, 20, 200, 25);
        add(txtNombre);

        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setBounds(30, 60, 100, 25);
        add(lblApellido);

        txtApellido = new JTextField();
        txtApellido.setBounds(150, 60, 200, 25);
        add(txtApellido);

        JLabel lblCedula = new JLabel("Cédula:");
        lblCedula.setBounds(30, 100, 100, 25);
        add(lblCedula);

        txtCedula = new JTextField();
        txtCedula.setBounds(150, 100, 200, 25);
        add(txtCedula);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setBounds(30, 140, 100, 25);
        add(lblTelefono);

        txtTelefono = new JTextField();
        txtTelefono.setBounds(150, 140, 200, 25);
        add(txtTelefono);

        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setBounds(30, 180, 100, 25);
        add(lblDireccion);

        txtDireccion = new JTextField();
        txtDireccion.setBounds(150, 180, 200, 25);
        add(txtDireccion);

        JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento:");
        lblFechaNacimiento.setBounds(30, 220, 120, 25);
        add(lblFechaNacimiento);

        txtFechaNacimiento = new JTextField("dd/mm/aaaa"); 
        txtFechaNacimiento.setBounds(150, 220, 200, 25);
        add(txtFechaNacimiento);

        JLabel lblTipo = new JLabel("Tipo Candidato:");
        lblTipo.setBounds(30, 260, 120, 25);
        add(lblTipo);

        comboTipoCandidato = new JComboBox<>(new String[] {
            "Universitario", "Técnico Superior", "Obrero"
        });
        comboTipoCandidato.setBounds(150, 260, 200, 25);
        add(comboTipoCandidato);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(30, 300, 100, 25);
        add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(150, 300, 200, 25);
        add(txtEmail);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(150, 360, 100, 30);
        add(btnGuardar);

        btnGuardar.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "El candidato ha sido guardado");
        });
    }
}
