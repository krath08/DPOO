package visual;

import javax.swing.*;
import java.awt.Font;

public class RegEmpresa extends JFrame {

    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtTelefono;
    private JTextField txtDireccion;
    private JTextField txtEmail;
    private JTextField txtFechaRegistro;
    private JTextField txtUsuario;
    private JPasswordField txtContrasena;
    private JComboBox<String> comboTipoEmpresa;

    private VentanaPrincipal ventanaPrincipal;

    public RegEmpresa(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;

        setTitle("Registrar Empresa");
        setIconImage(new ImageIcon(getClass().getResource("/imagen/IconoRegEmpresa.png")).getImage());
        setSize(544, 737);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblId = new JLabel("Id:");
        lblId.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblId.setBounds(30, 42, 100, 25);
        getContentPane().add(lblId);

        txtId = new JTextField();
        txtId.setBounds(157, 43, 200, 25);
        getContentPane().add(txtId);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblNombre.setBounds(30, 109, 100, 25);
        getContentPane().add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(157, 110, 200, 25);
        getContentPane().add(txtNombre);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblTelefono.setBounds(30, 176, 100, 25);
        getContentPane().add(lblTelefono);

        txtTelefono = new JTextField();
        txtTelefono.setBounds(157, 177, 200, 25);
        getContentPane().add(txtTelefono);

        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblDireccion.setBounds(30, 243, 100, 25);
        getContentPane().add(lblDireccion);

        txtDireccion = new JTextField();
        txtDireccion.setBounds(157, 244, 200, 25);
        getContentPane().add(txtDireccion);

        JLabel lblFechaRegistro = new JLabel("Fecha Registro:");
        lblFechaRegistro.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblFechaRegistro.setBounds(30, 310, 120, 25);
        getContentPane().add(lblFechaRegistro);

        txtFechaRegistro = new JTextField(); 
        txtFechaRegistro.setFont(new Font("SansSerif", Font.ITALIC, 14));
        txtFechaRegistro.setBounds(157, 310, 200, 25);
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
        txtFechaRegistro.setText(sdf.format(new java.util.Date()));
        txtFechaRegistro.setEditable(false);
        getContentPane().add(txtFechaRegistro);

        JLabel lblTipo = new JLabel("Tipo empresa:");
        lblTipo.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblTipo.setBounds(30, 377, 120, 25);
        getContentPane().add(lblTipo);

        comboTipoEmpresa = new JComboBox(new String[] {
            "<Seleccione>", "Turismo", "Salud", "Educacion", "Tecnologia", "Construccion", "Comercio", "Industria", "Servicios"
        });
        comboTipoEmpresa.setFont(new Font("SansSerif", Font.PLAIN, 14));
        comboTipoEmpresa.setBounds(157, 377, 200, 25);
        getContentPane().add(comboTipoEmpresa);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblEmail.setBounds(30, 444, 100, 25);
        getContentPane().add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(157, 445, 200, 25);
        getContentPane().add(txtEmail);

        // USUARIO
        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblUsuario.setBounds(30, 511, 100, 25);
        getContentPane().add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(157, 512, 200, 25);
        getContentPane().add(txtUsuario);

        // CONTRASEÑA
        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblContrasena.setBounds(30, 578, 100, 25);
        getContentPane().add(lblContrasena);

        txtContrasena = new JPasswordField();
        txtContrasena.setBounds(157, 579, 200, 25);
        getContentPane().add(txtContrasena);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnGuardar.setBounds(392, 647, 100, 30);
        getContentPane().add(btnGuardar);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(RegEmpresa.class.getResource("/imagen/ImagenRegEmpresa.png")));
        lblNewLabel.setBounds(392, 49, 100, 117);
        getContentPane().add(lblNewLabel);

        btnGuardar.addActionListener(e -> {
            java.util.Date fechaRegistro;
            try {
                fechaRegistro = new java.text.SimpleDateFormat("dd/MM/yyyy").parse(txtFechaRegistro.getText());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Fecha de registro inválida. Usa el formato dd/mm/aaaa");
                return;
            }

            String usuario = txtUsuario.getText();
            String contrasena = new String(txtContrasena.getPassword());

            logico.empresa nuevaEmpresa = new logico.empresa(
                txtId.getText(),
                txtNombre.getText(),
                logico.TipoEmpresa.valueOf(comboTipoEmpresa.getSelectedItem().toString().toUpperCase()),
                txtDireccion.getText(),
                txtTelefono.getText(),
                txtEmail.getText(),
                fechaRegistro,
                true,
                usuario,
                contrasena
            );

            logico.BolsaLaboral.getInstancia().agregarEmpresa(nuevaEmpresa);

            // Validación para evitar NullPointerException
            if (ventanaPrincipal != null) {
                ventanaPrincipal.actualizarResumen();
            }

            JOptionPane.showMessageDialog(this, "La empresa ha sido guardada");
            dispose();
        });
    }
}
