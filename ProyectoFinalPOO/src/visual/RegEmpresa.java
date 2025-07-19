package visual;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

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
        setIconImage(new ImageIcon(getClass().getResource("/imagen/IconoRegEmpresa.png")).getImage());
        setSize(529, 627);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblId = new JLabel("Id:");
        lblId.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblId.setBounds(30, 45, 100, 25);
        getContentPane().add(lblId);

        txtId = new JTextField();
        txtId.setBounds(157, 45, 200, 25);
        getContentPane().add(txtId);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblNombre.setBounds(30, 115, 100, 25);
        getContentPane().add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(157, 115, 200, 25);
        getContentPane().add(txtNombre);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblTelefono.setBounds(30, 185, 100, 25);
        getContentPane().add(lblTelefono);

        txtTelefono = new JTextField();
        txtTelefono.setBounds(157, 185, 200, 25);
        getContentPane().add(txtTelefono);

        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblDireccion.setBounds(30, 255, 100, 25);
        getContentPane().add(lblDireccion);

        txtDireccion = new JTextField();
        txtDireccion.setBounds(157, 255, 200, 25);
        getContentPane().add(txtDireccion);

        JLabel lblFechaRegistro = new JLabel("Fecha Registro:");
        lblFechaRegistro.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblFechaRegistro.setBounds(30, 325, 120, 25);
        getContentPane().add(lblFechaRegistro);

        txtFechaRegistro = new JTextField(); 
        txtFechaRegistro.setFont(new Font("SansSerif", Font.ITALIC, 14));
        txtFechaRegistro.setBounds(157, 325, 200, 25);
        // --- Aquí asignas la fecha actual ---
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
        txtFechaRegistro.setText(sdf.format(new java.util.Date()));
        txtFechaRegistro.setEditable(false); // No editable por el usuario
        getContentPane().add(txtFechaRegistro);

        JLabel lblTipo = new JLabel("Tipo empresa:");
        lblTipo.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblTipo.setBounds(30, 395, 120, 25);
        getContentPane().add(lblTipo);

        comboTipoEmpresa = new JComboBox(new String[] {
                "Turismo", "Salud", "Educacion", "Tecnologia", "Construccion", "Comercio", "Industria", "Servicios"
            });
        comboTipoEmpresa.setFont(new Font("SansSerif", Font.PLAIN, 14));
        comboTipoEmpresa.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Turismo", "Salud", "Educacion", "Tecnologia", "Construccion", "Comercio", "Industria", "Servicios"}));
        comboTipoEmpresa.setBounds(157, 395, 200, 25);
        getContentPane().add(comboTipoEmpresa);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblEmail.setBounds(30, 465, 100, 25);
        getContentPane().add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(157, 465, 200, 25);
        getContentPane().add(txtEmail);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnGuardar.setBounds(366, 527, 100, 30);
        getContentPane().add(btnGuardar);

        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon(RegEmpresa.class.getResource("/imagen/ImagenRegEmpresa.png")));
        lblNewLabel.setBounds(392, 55, 100, 117);
        getContentPane().add(lblNewLabel);

        btnGuardar.addActionListener(e -> {
            // Parsea la fecha de registro (ya está validada)
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
