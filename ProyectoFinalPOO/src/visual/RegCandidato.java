package visual;

import javax.swing.*;
import java.awt.*;

public class RegCandidato extends JFrame {

	protected JTextField txtNombre;
	protected JTextField txtApellido;
	protected JTextField txtCedula;
	protected JTextField txtTelefono;
	protected JTextField txtDireccion;
	protected JTextField txtEmail;
	protected JTextField txtUsuario;
	protected JPasswordField txtContrasena;

	protected JComboBox<String> comboTipoCandidato;

	protected JSpinner spinnerDia;
	protected JSpinner spinnerMes;
	protected JComboBox<Integer> comboAnio;


    private VentanaPrincipal ventanaPrincipal;

    public RegCandidato(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;

        setTitle("Registrar Candidato");
        setIconImage(new ImageIcon(getClass().getResource("/imagen/IconoRegCandi.png")).getImage());
        setSize(474, 703); 
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        int yBase = 33;

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblNombre.setBounds(30, yBase, 100, 25);
        getContentPane().add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(112, yBase + 1, 200, 25);
        getContentPane().add(txtNombre);

        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblApellido.setBounds(30, yBase + 58, 100, 25);
        getContentPane().add(lblApellido);

        txtApellido = new JTextField();
        txtApellido.setBounds(112, yBase + 59, 200, 25);
        getContentPane().add(txtApellido);

        JLabel lblCedula = new JLabel("Cédula:");
        lblCedula.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblCedula.setBounds(30, yBase + 116, 100, 25);
        getContentPane().add(lblCedula);

        txtCedula = new JTextField();
        txtCedula.setBounds(112, yBase + 117, 200, 25);
        getContentPane().add(txtCedula);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblTelefono.setBounds(30, yBase + 174, 100, 25);
        getContentPane().add(lblTelefono);

        txtTelefono = new JTextField();
        txtTelefono.setBounds(112, yBase + 175, 200, 25);
        getContentPane().add(txtTelefono);

        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblDireccion.setBounds(30, yBase + 232, 100, 25);
        getContentPane().add(lblDireccion);

        txtDireccion = new JTextField();
        txtDireccion.setBounds(112, yBase + 233, 274, 25);
        getContentPane().add(txtDireccion);

        JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento:");
        lblFechaNacimiento.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblFechaNacimiento.setBounds(30, yBase + 290, 144, 25);
        getContentPane().add(lblFechaNacimiento);

        spinnerDia = new JSpinner(new SpinnerNumberModel(1, 1, 31, 1));
        spinnerDia.setBounds(186, yBase + 290, 50, 25);
        getContentPane().add(spinnerDia);

        spinnerMes = new JSpinner(new SpinnerNumberModel(1, 1, 12, 1));
        spinnerMes.setBounds(241, yBase + 290, 50, 25);
        getContentPane().add(spinnerMes);

        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        comboAnio = new JComboBox<>();
        for (int y = currentYear; y >= 1965; y--) {
            comboAnio.addItem(y);
        }
        comboAnio.setBounds(296, yBase + 290, 90, 25);
        getContentPane().add(comboAnio);

        JLabel lblDia = new JLabel("Día");
        lblDia.setFont(new Font("SansSerif", Font.PLAIN, 11));
        lblDia.setBounds(186, yBase + 272, 30, 15);
        getContentPane().add(lblDia);

        JLabel lblMes = new JLabel("Mes");
        lblMes.setFont(new Font("SansSerif", Font.PLAIN, 11));
        lblMes.setBounds(241, yBase + 272, 30, 15);
        getContentPane().add(lblMes);

        JLabel lblAnio = new JLabel("Año");
        lblAnio.setFont(new Font("SansSerif", Font.PLAIN, 11));
        lblAnio.setBounds(296, yBase + 272, 30, 15);
        getContentPane().add(lblAnio);

        JLabel lblTipo = new JLabel("Tipo Candidato:");
        lblTipo.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblTipo.setBounds(30, yBase + 348, 120, 25);
        getContentPane().add(lblTipo);

        comboTipoCandidato = new JComboBox(new String[] {"<Seleccione>", "Universitario", "Técnico Superior", "Obrero"});
        comboTipoCandidato.setFont(new Font("SansSerif", Font.PLAIN, 14));
        comboTipoCandidato.setBounds(186, yBase + 348, 200, 25);
        getContentPane().add(comboTipoCandidato);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblEmail.setBounds(30, yBase + 406, 100, 25);
        getContentPane().add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(186, yBase + 407, 200, 25);
        getContentPane().add(txtEmail);

        // NUEVOS CAMPOS usuario y contraseña
        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblUsuario.setBounds(30, yBase + 464, 100, 25);
        getContentPane().add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(186, yBase + 465, 200, 25);
        getContentPane().add(txtUsuario);

        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblContrasena.setBounds(30, yBase + 522, 100, 25);
        getContentPane().add(lblContrasena);

        txtContrasena = new JPasswordField();
        txtContrasena.setBounds(186, yBase + 523, 200, 25);
        getContentPane().add(txtContrasena);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnGuardar.setBounds(344, yBase + 575, 100, 30);
        getContentPane().add(btnGuardar);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(RegCandidato.class.getResource("/imagen/ImagenRegCandi.png")));
        lblNewLabel.setBounds(340, yBase, 90, 106);
        getContentPane().add(lblNewLabel);

        btnGuardar.addActionListener(e -> {
            String id = txtCedula.getText();
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();
            String cedula = txtCedula.getText();
            String telefono = txtTelefono.getText();
            String email = txtEmail.getText();
            String direccion = txtDireccion.getText();
            String usuario = txtUsuario.getText();
            String contrasena = new String(txtContrasena.getPassword());

            int dia = (int) spinnerDia.getValue();
            int mes = (int) spinnerMes.getValue();
            int anio = (int) comboAnio.getSelectedItem();

            java.util.Calendar cal = java.util.Calendar.getInstance();
            cal.set(anio, mes - 1, dia);
            java.util.Date fechaNacimiento = cal.getTime();

            java.util.Date fechaRegistro = new java.util.Date();

            String tipo = comboTipoCandidato.getSelectedItem().toString();

            logico.Candidato candidato = null;

            if (tipo.equals("Universitario")) {
                candidato = new logico.Universitario(
                    id, nombre, apellido, cedula, telefono, email, direccion,
                    fechaNacimiento, fechaRegistro, usuario, contrasena,
                    "Universidad", "Carrera", 2024, "Título", "Especialidad"
                );
            } else if (tipo.equals("Técnico Superior")) {
                candidato = new logico.TecnicoSuperior(
                    id, nombre, apellido, cedula, telefono, email, direccion,
                    fechaNacimiento, fechaRegistro, usuario, contrasena,
                    "Instituto", "Especialidad", 2024, new java.util.ArrayList<>()
                );
            } else if (tipo.equals("Obrero")) {
                candidato = new logico.Obrero(
                    id, nombre, apellido, cedula, telefono, email, direccion,
                    fechaNacimiento, fechaRegistro, usuario, contrasena,
                    "Oficio", 5, new java.util.ArrayList<>(), new java.util.ArrayList<>()
                );
            }

            if (candidato != null) {
                logico.BolsaLaboral.getInstancia().agregarCandidato(candidato);
                // --- Validación para evitar NullPointerException ---
                if (ventanaPrincipal != null) {
                    ventanaPrincipal.actualizarResumen();
                }
                JOptionPane.showMessageDialog(this, "El candidato ha sido guardado");
                dispose();
            }
        });

    }

    protected logico.Candidato construirCandidatoDesdeCampos() {
        String id = txtCedula.getText();
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String cedula = txtCedula.getText();
        String telefono = txtTelefono.getText();
        String email = txtEmail.getText();
        String direccion = txtDireccion.getText();
        String usuario = txtUsuario.getText();
        String contrasena = new String(txtContrasena.getPassword());

        int dia = (int) spinnerDia.getValue();
        int mes = (int) spinnerMes.getValue();
        int anio = (int) comboAnio.getSelectedItem();

        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(anio, mes - 1, dia);
        java.util.Date fechaNacimiento = cal.getTime();
        java.util.Date fechaRegistro = new java.util.Date();

        String tipo = comboTipoCandidato.getSelectedItem().toString();

        if (tipo.equals("Universitario")) {
            return new logico.Universitario(
                id, nombre, apellido, cedula, telefono, email, direccion,
                fechaNacimiento, fechaRegistro, usuario, contrasena,
                "Universidad", "Carrera", 2024, "Título", "Especialidad"
            );
        } else if (tipo.equals("Técnico Superior")) {
            return new logico.TecnicoSuperior(
                id, nombre, apellido, cedula, telefono, email, direccion,
                fechaNacimiento, fechaRegistro, usuario, contrasena,
                "Instituto", "Especialidad", 2024, new java.util.ArrayList<>()
            );
        } else if (tipo.equals("Obrero")) {
            return new logico.Obrero(
                id, nombre, apellido, cedula, telefono, email, direccion,
                fechaNacimiento, fechaRegistro, usuario, contrasena,
                "Oficio", 5, new java.util.ArrayList<>(), new java.util.ArrayList<>()
            );
        }

        return null;
    }
}
