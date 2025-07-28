package visual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class login extends JFrame {

    private JTextField usuarioField;
    private JPasswordField contrasenaField;
    private JLabel mensajeError;

    public login() {
        setTitle("Sistema de Bolsa Laboral - Iniciar Sesión");
        setSize(600, 500); 
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        setContentPane(panel);

        JLabel titulo = new JLabel("Iniciar Sesión");
        titulo.setFont(new Font("Arial", Font.BOLD, 32));
        titulo.setBounds(200, 40, 250, 40);
        panel.add(titulo);

        JLabel usuarioLabel = new JLabel("Usuario:");
        usuarioLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        usuarioLabel.setBounds(100, 120, 120, 30);
        panel.add(usuarioLabel);

        usuarioField = new JTextField();
        usuarioField.setFont(new Font("Arial", Font.PLAIN, 18));
        usuarioField.setBounds(220, 120, 280, 35);
        panel.add(usuarioField);

        JLabel contrasenaLabel = new JLabel("Contraseña:");
        contrasenaLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        contrasenaLabel.setBounds(100, 180, 120, 30);
        panel.add(contrasenaLabel);

        contrasenaField = new JPasswordField();
        contrasenaField.setFont(new Font("Arial", Font.PLAIN, 18));
        contrasenaField.setBounds(220, 180, 280, 35);
        panel.add(contrasenaField);

        JButton loginButton = new JButton("Iniciar Sesión");
        loginButton.setFont(new Font("Arial", Font.BOLD, 18));
        loginButton.setBounds(220, 250, 180, 50);
        loginButton.setBackground(new Color(100, 149, 237));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        panel.add(loginButton);

        mensajeError = new JLabel("");
        mensajeError.setBounds(150, 320, 400, 30);
        mensajeError.setFont(new Font("Arial", Font.BOLD, 16));
        mensajeError.setForeground(Color.RED);
        panel.add(mensajeError);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = usuarioField.getText();
                String contrasena = new String(contrasenaField.getPassword());

                if (validarLogin(usuario, contrasena)) {
                	dispose();
                	SwingUtilities.invokeLater(() -> {
                	    VentanaPrincipal vp = new VentanaPrincipal();
                	    vp.setVisible(true);
                	});
                } else {
                    mensajeError.setText("Usuario o contraseña incorrectos.");
                }
            }
        });
    }

    private boolean validarLogin(String usuario, String contrasena) {
        return usuario.equals("admin") && contrasena.equals("admin");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new login().setVisible(true);
        });
    }
}
