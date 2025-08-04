package visual;

import javax.swing.*;
import java.awt.*;
import logico.*;
import java.util.*;

public class EditarEmpresa extends JFrame {

	private JTextField txtId, txtNombre, txtTelefono, txtDireccion, txtEmail, txtFechaRegistro, txtUsuario;
	private JPasswordField txtContrasena;
	private empresa empresa;

	public EditarEmpresa(empresa empresa) {
		this.empresa = empresa;

		setTitle("Editar Empresa");
		setIconImage(new ImageIcon(getClass().getResource("/imagen/IconoRegEmpresa.png")).getImage());
		setSize(470, 550);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblId = new JLabel("Id:");
		lblId.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblId.setBounds(30, 42, 100, 25);
		getContentPane().add(lblId);

		txtId = new JTextField(empresa.getId());
		txtId.setBounds(157, 43, 200, 25);
		getContentPane().add(txtId);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNombre.setBounds(30, 89, 100, 25);
		getContentPane().add(lblNombre);

		txtNombre = new JTextField(empresa.getNombre());
		txtNombre.setBounds(157, 90, 200, 25);
		getContentPane().add(txtNombre);

		JLabel lblTelefono = new JLabel("Teléfono:");
		lblTelefono.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblTelefono.setBounds(30, 136, 100, 25);
		getContentPane().add(lblTelefono);

		txtTelefono = new JTextField(empresa.getTelefono());
		txtTelefono.setBounds(157, 137, 200, 25);
		getContentPane().add(txtTelefono);

		JLabel lblDireccion = new JLabel("Dirección:");
		lblDireccion.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblDireccion.setBounds(30, 183, 100, 25);
		getContentPane().add(lblDireccion);

		txtDireccion = new JTextField(empresa.getDireccion());
		txtDireccion.setBounds(157, 184, 250, 25);
		getContentPane().add(txtDireccion);

		JLabel lblFechaRegistro = new JLabel("Fecha Registro:");
		lblFechaRegistro.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblFechaRegistro.setBounds(30, 230, 120, 25);
		getContentPane().add(lblFechaRegistro);

		txtFechaRegistro = new JTextField();
		txtFechaRegistro.setFont(new Font("SansSerif", Font.ITALIC, 14));
		txtFechaRegistro.setBounds(157, 231, 200, 25);
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
		txtFechaRegistro.setText(sdf.format(empresa.getFechaRegistro()));
		txtFechaRegistro.setEditable(false);
		getContentPane().add(txtFechaRegistro);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblEmail.setBounds(30, 277, 100, 25);
		getContentPane().add(lblEmail);

		txtEmail = new JTextField(empresa.getEmail());
		txtEmail.setBounds(157, 278, 200, 25);
		getContentPane().add(txtEmail);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblUsuario.setBounds(30, 324, 100, 25);
		getContentPane().add(lblUsuario);

		txtUsuario = new JTextField(empresa.getUsuario());
		txtUsuario.setBounds(157, 325, 200, 25);
		getContentPane().add(txtUsuario);

		JLabel lblContrasena = new JLabel("Contraseña:");
		lblContrasena.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblContrasena.setBounds(30, 371, 100, 25);
		getContentPane().add(lblContrasena);

		txtContrasena = new JPasswordField(empresa.getContrasena());
		txtContrasena.setBounds(157, 372, 200, 25);
		getContentPane().add(txtContrasena);

		JButton btnGuardar = new JButton("Guardar Cambios");
		btnGuardar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnGuardar.setBounds(250, 420, 170, 35);
		getContentPane().add(btnGuardar);

		btnGuardar.addActionListener(e -> {
			empresa.setId(txtId.getText());
			empresa.setNombre(txtNombre.getText());
			empresa.setTelefono(txtTelefono.getText());
			empresa.setDireccion(txtDireccion.getText());
			empresa.setEmail(txtEmail.getText());
			empresa.setUsuario(txtUsuario.getText());
			empresa.setContrasena(new String(txtContrasena.getPassword()));
			JOptionPane.showMessageDialog(this, "Datos de la empresa modificados correctamente");
			this.dispose();
		});
	}
}
