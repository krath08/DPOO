package visual;

import javax.swing.*;
import java.awt.*;
import logico.*;
import java.util.*;

public class EditarCandidato extends JFrame {

	private JTextField txtNombre, txtApellido, txtCedula, txtTelefono, txtDireccion, txtEmail, txtUsuario;
	private JPasswordField txtContrasena;
	private JSpinner spinnerDia, spinnerMes;
	private JComboBox<Integer> comboAnio;
	private Candidato candidato;

	public EditarCandidato(Candidato candidato) {
		this.candidato = candidato;
		setTitle("Editar Candidato");
		setIconImage(new ImageIcon(getClass().getResource("/imagen/IconoRegCandi.png")).getImage());
		setSize(470, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		int yBase = 33;

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNombre.setBounds(30, yBase, 100, 25);
		getContentPane().add(lblNombre);

		txtNombre = new JTextField(candidato.getNombre());
		txtNombre.setBounds(140, yBase + 1, 200, 25);
		getContentPane().add(txtNombre);

		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblApellido.setBounds(30, yBase + 40, 100, 25);
		getContentPane().add(lblApellido);

		txtApellido = new JTextField(candidato.getApellido());
		txtApellido.setBounds(140, yBase + 41, 200, 25);
		getContentPane().add(txtApellido);

		JLabel lblCedula = new JLabel("Cédula:");
		lblCedula.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCedula.setBounds(30, yBase + 80, 100, 25);
		getContentPane().add(lblCedula);

		txtCedula = new JTextField(candidato.getCedula());
		txtCedula.setBounds(140, yBase + 81, 200, 25);
		getContentPane().add(txtCedula);

		JLabel lblTelefono = new JLabel("Teléfono:");
		lblTelefono.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblTelefono.setBounds(30, yBase + 120, 100, 25);
		getContentPane().add(lblTelefono);

		txtTelefono = new JTextField(candidato.getTelefono());
		txtTelefono.setBounds(140, yBase + 121, 200, 25);
		getContentPane().add(txtTelefono);

		JLabel lblDireccion = new JLabel("Dirección:");
		lblDireccion.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblDireccion.setBounds(30, yBase + 160, 100, 25);
		getContentPane().add(lblDireccion);

		txtDireccion = new JTextField(candidato.getDireccion());
		txtDireccion.setBounds(140, yBase + 161, 250, 25);
		getContentPane().add(txtDireccion);

		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento:");
		lblFechaNacimiento.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblFechaNacimiento.setBounds(30, yBase + 200, 144, 25);
		getContentPane().add(lblFechaNacimiento);

		spinnerDia = new JSpinner(new SpinnerNumberModel(1, 1, 31, 1));
		spinnerMes = new JSpinner(new SpinnerNumberModel(1, 1, 12, 1));
		comboAnio = new JComboBox<>();
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		for (int y = currentYear; y >= 1965; y--)
			comboAnio.addItem(y);

		Calendar cal = Calendar.getInstance();
		cal.setTime(candidato.getFechaNacimiento());
		spinnerDia.setValue(cal.get(Calendar.DAY_OF_MONTH));
		spinnerMes.setValue(cal.get(Calendar.MONTH) + 1);
		comboAnio.setSelectedItem(cal.get(Calendar.YEAR));

		spinnerDia.setBounds(180, yBase + 200, 50, 25);
		spinnerMes.setBounds(235, yBase + 200, 50, 25);
		comboAnio.setBounds(290, yBase + 200, 90, 25);
		getContentPane().add(spinnerDia);
		getContentPane().add(spinnerMes);
		getContentPane().add(comboAnio);

		JLabel lblDia = new JLabel("Día");
		lblDia.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblDia.setBounds(180, yBase + 185, 30, 15);
		getContentPane().add(lblDia);

		JLabel lblMes = new JLabel("Mes");
		lblMes.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblMes.setBounds(235, yBase + 185, 30, 15);
		getContentPane().add(lblMes);

		JLabel lblAnio = new JLabel("Año");
		lblAnio.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblAnio.setBounds(290, yBase + 185, 30, 15);
		getContentPane().add(lblAnio);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblEmail.setBounds(30, yBase + 240, 100, 25);
		getContentPane().add(lblEmail);

		txtEmail = new JTextField(candidato.getEmail());
		txtEmail.setBounds(140, yBase + 241, 200, 25);
		getContentPane().add(txtEmail);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblUsuario.setBounds(30, yBase + 280, 100, 25);
		getContentPane().add(lblUsuario);

		txtUsuario = new JTextField(candidato.getUsuario());
		txtUsuario.setBounds(140, yBase + 281, 200, 25);
		getContentPane().add(txtUsuario);

		JLabel lblContrasena = new JLabel("Contraseña:");
		lblContrasena.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblContrasena.setBounds(30, yBase + 320, 100, 25);
		getContentPane().add(lblContrasena);

		txtContrasena = new JPasswordField(candidato.getContrasena());
		txtContrasena.setBounds(140, yBase + 321, 200, 25);
		getContentPane().add(txtContrasena);

		JButton btnGuardar = new JButton("Guardar Cambios");
		btnGuardar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnGuardar.setBounds(290, yBase + 370, 170, 35);
		getContentPane().add(btnGuardar);

		btnGuardar.addActionListener(e -> {
			candidato.setNombre(txtNombre.getText());
			candidato.setApellido(txtApellido.getText());
			candidato.setCedula(txtCedula.getText());
			candidato.setTelefono(txtTelefono.getText());
			candidato.setDireccion(txtDireccion.getText());
			candidato.setEmail(txtEmail.getText());
			candidato.setUsuario(txtUsuario.getText());
			candidato.setContrasena(new String(txtContrasena.getPassword()));

			int dia = (int) spinnerDia.getValue();
			int mes = (int) spinnerMes.getValue();
			int anio = (int) comboAnio.getSelectedItem();
			Calendar c = Calendar.getInstance();
			c.set(anio, mes - 1, dia);
			candidato.setFechaNacimiento(c.getTime());

			JOptionPane.showMessageDialog(this, "Datos modificados correctamente");
			this.dispose();
		});
	}
}
