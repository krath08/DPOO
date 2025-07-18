package visual;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RegEmpresa extends JFrame {

    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtCedula;
    private JTextField txtTelefono;
    private JTextField txtDireccion;
    private JTextField txtEmail;
    private JTextField txtFechaRegistro;
    private JComboBox<String> comboTipoEmpresa;

    public RegEmpresa() {
        setTitle("Registrar Empresa");
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        
        JLabel lblId = new JLabel("Id:");
        lblId.setBounds(30, 20, 100, 25);
        add(lblId);

        txtId = new JTextField();
        txtId.setBounds(150, 20, 200, 25);
        add(txtId);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(30, 60, 100, 25);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(150, 60, 200, 25);
        add(txtNombre);

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

        JLabel lblFechaRegistro = new JLabel("Fecha Registro:");
        lblFechaRegistro.setBounds(30, 220, 120, 25);
        add(lblFechaRegistro);

        txtFechaRegistro = new JTextField("dd/mm/aaaa"); 
        txtFechaRegistro.setBounds(150, 220, 200, 25);
        add(txtFechaRegistro);

        JLabel lblTipo = new JLabel("Tipo empresa:");
        lblTipo.setBounds(30, 260, 120, 25);
        add(lblTipo);

        comboTipoEmpresa = new JComboBox<>(new String[] {
            "Turismo", "Salud", "Educación","Tecnología","Construcción","Comercio","Industria","Servicios"
        });
        comboTipoEmpresa.setBounds(150, 260, 200, 25);
        add(comboTipoEmpresa);

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
            JOptionPane.showMessageDialog(this, "La empresa ha sido guardada");
        });
    }
}
