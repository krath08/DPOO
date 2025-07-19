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
    private JTextField txtTelefono;
    private JTextField txtDireccion;
    private JTextField txtEmail;
    private JTextField txtFechaRegistro;
    private JComboBox<String> comboTipoEmpresa;

    private VentanaPrincipal ventanaPrincipal;

    public RegEmpresa(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;

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

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setBounds(30, 100, 100, 25);
        add(lblTelefono);

        txtTelefono = new JTextField();
        txtTelefono.setBounds(150, 100, 200, 25);
        add(txtTelefono);

        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setBounds(30, 140, 100, 25);
        add(lblDireccion);

        txtDireccion = new JTextField();
        txtDireccion.setBounds(150, 140, 200, 25);
        add(txtDireccion);

        JLabel lblFechaRegistro = new JLabel("Fecha Registro:");
        lblFechaRegistro.setBounds(30, 180, 120, 25);
        add(lblFechaRegistro);

        txtFechaRegistro = new JTextField("dd/mm/aaaa"); 
        txtFechaRegistro.setBounds(150, 180, 200, 25);
        add(txtFechaRegistro);

        JLabel lblTipo = new JLabel("Tipo empresa:");
        lblTipo.setBounds(30, 220, 120, 25);
        add(lblTipo);

        comboTipoEmpresa = new JComboBox<>(new String[] {
            "Turismo", "Salud", "Educacion", "Tecnologia", "Construccion", "Comercio", "Industria", "Servicios"
        });
        comboTipoEmpresa.setBounds(150, 220, 200, 25);
        add(comboTipoEmpresa);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(30, 260, 100, 25);
        add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(150, 260, 200, 25);
        add(txtEmail);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(150, 320, 100, 30);
        add(btnGuardar);

        btnGuardar.addActionListener(e -> {
            // Parsea la fecha de registro
            java.util.Date fechaRegistro;
            try {
                fechaRegistro = new java.text.SimpleDateFormat("dd/MM/yyyy").parse(txtFechaRegistro.getText());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Fecha de registro inválida. Usa el formato dd/mm/aaaa");
                return;
            }

            // Crea el objeto empresa
            logico.empresa nuevaEmpresa = new logico.empresa(
                txtId.getText(),
                txtNombre.getText(),
                logico.TipoEmpresa.valueOf(comboTipoEmpresa.getSelectedItem().toString().toUpperCase()),
                txtDireccion.getText(),
                txtTelefono.getText(),
                txtEmail.getText(),
                fechaRegistro,
                true // o según tu lógica de activación
            );

            logico.BolsaLaboral.getInstancia().agregarEmpresa(nuevaEmpresa);

            ventanaPrincipal.actualizarResumen();

            JOptionPane.showMessageDialog(this, "La empresa ha sido guardada");
            dispose();
        });
    }
}
