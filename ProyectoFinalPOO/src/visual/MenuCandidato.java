package visual;

import javax.swing.*;
import java.awt.*;
import logico.Candidato;

public class MenuCandidato extends JFrame {

    private JLabel lblNombre;
    private JLabel lblEmail;
    private JLabel lblTipoCandidato;
    private Candidato candidato; // Para acceso a los datos

    public MenuCandidato(Candidato candidato) {
        this.candidato = candidato;

        setTitle("Menú Candidato - Bolsa Laboral");
        setIconImage(Toolkit.getDefaultToolkit().getImage(MenuCandidato.class.getResource("/imagen/IconoPrincipal.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);

        // Fondo (puedes quitar esto si no quieres fondo)
        Image imgFondo = new ImageIcon(getClass().getResource("/imagen/ImagenPrincipal.jpg")).getImage();
        FondoPanel fondoPanel = new FondoPanel(imgFondo);
        fondoPanel.setLayout(null);
        setContentPane(fondoPanel);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menuPerfil = new JMenu("Mi Perfil");
        menuPerfil.setFont(new Font("SansSerif", Font.PLAIN, 16));
        menuBar.add(menuPerfil);

        JMenuItem itemEditarPerfil = new JMenuItem("Editar Perfil");
        itemEditarPerfil.setFont(new Font("SansSerif", Font.PLAIN, 14));
        menuPerfil.add(itemEditarPerfil);

        // Puedes agregar más menús si quieres (por ejemplo, ayuda/salir)
        JMenu menuSalir = new JMenu("Salir");
        menuSalir.setFont(new Font("SansSerif", Font.PLAIN, 16));
        menuBar.add(menuSalir);
        JMenuItem itemCerrarSesion = new JMenuItem("Cerrar sesión");
        menuSalir.add(itemCerrarSesion);
        itemCerrarSesion.addActionListener(e -> {
            dispose();
            new Login().setVisible(true);
        });

        // Panel resumen de datos personales
        JPanel panelDatos = new JPanel();
        panelDatos.setBounds(30, 40, 350, 160);
        panelDatos.setOpaque(false);
        panelDatos.setBorder(BorderFactory.createTitledBorder("Datos Personales"));
        panelDatos.setLayout(new GridLayout(3, 1));

        lblNombre = new JLabel("Nombre: " + candidato.getNombre() + " " + candidato.getApellido());
        lblNombre.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblEmail = new JLabel("Email: " + candidato.getEmail());
        lblEmail.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblTipoCandidato = new JLabel("Tipo: " + getTipoCandidatoTexto(candidato));
        lblTipoCandidato.setFont(new Font("SansSerif", Font.BOLD, 14));

        panelDatos.add(lblNombre);
        panelDatos.add(lblEmail);
        panelDatos.add(lblTipoCandidato);
        fondoPanel.add(panelDatos);

        // Botones principales
        JPanel panelAcciones = new JPanel();
        panelAcciones.setBounds(430, 40, 400, 160);
        panelAcciones.setOpaque(false);
        panelAcciones.setLayout(new GridLayout(2, 1, 20, 20));

        JButton btnVerVacantes = new JButton("Ver Vacantes Disponibles");
        btnVerVacantes.setFont(new Font("SansSerif", Font.BOLD, 15));
        panelAcciones.add(btnVerVacantes);

        JButton btnVerPostulaciones = new JButton("Mis Postulaciones");
        btnVerPostulaciones.setFont(new Font("SansSerif", Font.BOLD, 15));
        panelAcciones.add(btnVerPostulaciones);

        fondoPanel.add(panelAcciones);

        // Puedes agregar ActionListener a los botones para abrir ventanas de vacantes o postulaciones

    }

    // FondoPanel igual que en VentanaPrincipal
    class FondoPanel extends JPanel {
        private Image imagen;
        public FondoPanel(Image imagen) {
            this.imagen = imagen;
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (imagen != null)
                g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        }
    }

    // Opcional: Devuelve el tipo textual del candidato
    private String getTipoCandidatoTexto(Candidato c) {
        if (c.getClass().getSimpleName().equals("Universitario")) return "Universitario";
        if (c.getClass().getSimpleName().equals("TecnicoSuperior")) return "Técnico Superior";
        if (c.getClass().getSimpleName().equals("Obrero")) return "Obrero";
        return "Desconocido";
    }
}
