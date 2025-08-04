package visual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import logico.BolsaLaboral;
import logico.Candidato;
import logico.empresa;
import server.Servidor;

public class Login extends JFrame {

	private JTextField usuarioField;
	private JPasswordField contrasenaField;
	private JLabel mensajeError;

	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/imagen/IconoPrincipal.png")));
		setTitle("Sistema de Bolsa Laboral - Iniciar Sesión");
		setSize(413, 422);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		setContentPane(panel);

		JLabel titulo = new JLabel("¿No tiene cuenta?");
		titulo.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		titulo.setBounds(266, 291, 114, 30);
		panel.add(titulo);

		JLabel usuarioLabel = new JLabel("Usuario:");
		usuarioLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
		usuarioLabel.setBounds(12, 64, 120, 30);
		panel.add(usuarioLabel);

		usuarioField = new JTextField();
		usuarioField.setFont(new Font("Arial", Font.PLAIN, 18));
		usuarioField.setBounds(12, 107, 229, 35);
		panel.add(usuarioField);

		JLabel contrasenaLabel = new JLabel("Contraseña:");
		contrasenaLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
		contrasenaLabel.setBounds(12, 180, 120, 30);
		panel.add(contrasenaLabel);

		contrasenaField = new JPasswordField();
		contrasenaField.setFont(new Font("Arial", Font.PLAIN, 18));
		contrasenaField.setBounds(12, 223, 229, 35);
		panel.add(contrasenaField);

		JButton loginButton = new JButton("Iniciar Sesión");
		loginButton.setFont(new Font("SansSerif", Font.BOLD, 14));
		loginButton.setBounds(113, 320, 141, 40);
		loginButton.setBackground(new Color(100, 149, 237));
		loginButton.setForeground(Color.WHITE);
		loginButton.setFocusPainted(false);
		panel.add(loginButton);

		JButton registrarseButton = new JButton("Registrarse");
		registrarseButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
		registrarseButton.setBounds(266, 320, 122, 40);
		registrarseButton.setBackground(new Color(200, 200, 200));
		registrarseButton.setForeground(Color.BLACK);
		registrarseButton.setFocusPainted(false);
		panel.add(registrarseButton);

		registrarseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] opciones = { "Candidato", "Empresa" };
				int seleccion = JOptionPane.showOptionDialog(Login.this, "¿Qué tipo de usuario desea registrar?",
						"Registro", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones,
						opciones[0]);
				if (seleccion == 0) { // Candidato
					RegCandidato regCandidato = new RegCandidato(null);
					regCandidato.setVisible(true);
				} else if (seleccion == 1) { // Empresa
					RegEmpresa regEmpresa = new RegEmpresa(null);
					regEmpresa.setVisible(true);
				}
			}
		});

		mensajeError = new JLabel("");
		mensajeError.setBounds(30, 280, 350, 30);
		mensajeError.setFont(new Font("Arial", Font.BOLD, 16));
		mensajeError.setForeground(Color.RED);
		panel.add(mensajeError);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/imagen/ImagenLogin.png")));
		lblNewLabel.setBounds(283, 54, 97, 110);
		panel.add(lblNewLabel);

		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = usuarioField.getText().trim();
				String contrasena = new String(contrasenaField.getPassword()).trim();

				if (usuario.isEmpty() || contrasena.isEmpty()) {
					mensajeError.setText("Ingrese usuario y contraseña.");
					return;
				}

				// --- Admin ---
				if (usuario.equals("admin") && contrasena.equals("admin")) {
					dispose();
					SwingUtilities.invokeLater(() -> {
						VentanaPrincipal vp = new VentanaPrincipal();
						vp.setVisible(true);
					});
					return;
				}

				// --- Candidato ---
				Candidato candidato = BolsaLaboral.getInstancia().buscarCandidatoPorUsuario(usuario, contrasena);
				if (candidato != null) {
					dispose();
					SwingUtilities.invokeLater(() -> {
						MenuCandidato menu = new MenuCandidato(candidato);
						menu.setVisible(true);
					});
					return;
				}

				// --- Empresa ---
				empresa emp = BolsaLaboral.getInstancia().buscarEmpresaPorUsuario(usuario, contrasena);
				if (emp != null) {
					dispose();
					SwingUtilities.invokeLater(() -> {
						MenuEmpresa menu = new MenuEmpresa(emp);
						menu.setVisible(true);
					});
					return;
				}

				mensajeError.setText("Usuario o contraseña incorrectos.");
			}
		});
	}

	public static void main(String[] args) {
		Servidor servidor = new Servidor();
		new Servidor().start();

		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			servidor.detenerServidor();
		}));

		SwingUtilities.invokeLater(() -> {
			new Login().setVisible(true);
		});
	}
}
