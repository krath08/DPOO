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

    private JComboBox<String> comboTipoCandidato;

    private JSpinner spinnerDia;
    private JSpinner spinnerMes;
    private JComboBox<Integer> comboAnio;

    private VentanaPrincipal ventanaPrincipal; 

    public RegCandidato(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;

        setTitle("Registrar Candidato");
        setIconImage(new ImageIcon(getClass().getResource("/imagen/IconoRegCandi.png")).getImage());
        setSize(474, 589);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblNombre.setBounds(30, 33, 100, 25);
        getContentPane().add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(112, 34, 200, 25);
        getContentPane().add(txtNombre);

        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblApellido.setBounds(30, 91, 100, 25);
        getContentPane().add(lblApellido);

        txtApellido = new JTextField();
        txtApellido.setBounds(112, 92, 200, 25);
        getContentPane().add(txtApellido);

        JLabel lblCedula = new JLabel("Cédula:");
        lblCedula.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblCedula.setBounds(30, 149, 100, 25);
        getContentPane().add(lblCedula);

        txtCedula = new JTextField();
        txtCedula.setBounds(112, 150, 200, 25);
        getContentPane().add(txtCedula);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblTelefono.setBounds(30, 207, 100, 25);
        getContentPane().add(lblTelefono);

        txtTelefono = new JTextField();
        txtTelefono.setBounds(112, 208, 200, 25);
        getContentPane().add(txtTelefono);

        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblDireccion.setBounds(30, 265, 100, 25);
        getContentPane().add(lblDireccion);

        txtDireccion = new JTextField();
        txtDireccion.setBounds(112, 266, 274, 25);
        getContentPane().add(txtDireccion);

        JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento:");
        lblFechaNacimiento.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblFechaNacimiento.setBounds(30, 323, 144, 25);
        getContentPane().add(lblFechaNacimiento);

        spinnerDia = new JSpinner(new SpinnerNumberModel(1, 1, 31, 1));
        spinnerDia.setBounds(186, 323, 50, 25);
        getContentPane().add(spinnerDia);

        spinnerMes = new JSpinner(new SpinnerNumberModel(1, 1, 12, 1));
        spinnerMes.setBounds(241, 323, 50, 25);
        getContentPane().add(spinnerMes);

        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        comboAnio = new JComboBox<>();
        for (int y = currentYear; y >= 1965; y--) {
            comboAnio.addItem(y);
        }
        comboAnio.setBounds(296, 323, 90, 25);
        getContentPane().add(comboAnio);

        JLabel lblDia = new JLabel("Día");
        lblDia.setFont(new Font("SansSerif", Font.PLAIN, 11));
        lblDia.setBounds(186, 305, 30, 15);
        getContentPane().add(lblDia);

        JLabel lblMes = new JLabel("Mes");
        lblMes.setFont(new Font("SansSerif", Font.PLAIN, 11));
        lblMes.setBounds(241, 305, 30, 15);
        getContentPane().add(lblMes);

        JLabel lblAnio = new JLabel("Año");
        lblAnio.setFont(new Font("SansSerif", Font.PLAIN, 11));
        lblAnio.setBounds(296, 305, 30, 15);
        getContentPane().add(lblAnio);

        JLabel lblTipo = new JLabel("Tipo Candidato:");
        lblTipo.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblTipo.setBounds(30, 381, 120, 25);
        getContentPane().add(lblTipo);

        comboTipoCandidato = new JComboBox(new String[] { "Universitario", "Técnico Superior", "Obrero" });
        comboTipoCandidato.setFont(new Font("SansSerif", Font.PLAIN, 14));
        comboTipoCandidato.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Universitario", "T\u00E9cnico Superior", "Obrero"}));
        comboTipoCandidato.setBounds(186, 381, 200, 25);
        getContentPane().add(comboTipoCandidato);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblEmail.setBounds(30, 439, 100, 25);
        getContentPane().add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(186, 440, 200, 25);
        getContentPane().add(txtEmail);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnGuardar.setBounds(344, 499, 100, 30);
        getContentPane().add(btnGuardar);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(RegCandidato.class.getResource("/imagen/ImagenRegCandi.png")));
        lblNewLabel.setBounds(340, 29, 90, 106);
        getContentPane().add(lblNewLabel);

        btnGuardar.addActionListener(e -> {
            String id = txtCedula.getText();
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();
            String cedula = txtCedula.getText();
            String telefono = txtTelefono.getText();
            String email = txtEmail.getText();
            String direccion = txtDireccion.getText();

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
                    fechaNacimiento, fechaRegistro,
                    "Universidad", "Carrera", 2024, "Título", "Especialidad"
                );
            } else if (tipo.equals("Técnico Superior")) {
                candidato = new logico.TecnicoSuperior(
                    id, nombre, apellido, cedula, telefono, email, direccion,
                    fechaNacimiento, fechaRegistro,
                    "Instituto", "Especialidad", 2024, new java.util.ArrayList<>()
                );
            } else if (tipo.equals("Obrero")) {
                candidato = new logico.Obrero(
                    id, nombre, apellido, cedula, telefono, email, direccion,
                    fechaNacimiento, fechaRegistro,
                    "Oficio", 5, new java.util.ArrayList<>(), new java.util.ArrayList<>()
                );
            }

            if (candidato != null) {
                logico.BolsaLaboral.getInstancia().agregarCandidato(candidato);
                ventanaPrincipal.actualizarResumen();
                JOptionPane.showMessageDialog(this, "El candidato ha sido guardado");
                dispose();
            }
        });

    }
}
