package visual;

import javax.swing.*;
import java.awt.*;
import logico.empresa;

public class MenuEmpresa extends JFrame {

    private JLabel lblNombre;
    private JLabel lblTipoEmpresa;
    private JLabel lblEmail;
    private empresa empresaActual; // referencia a la empresa logueada

    public MenuEmpresa(empresa empresaActual) {
        this.empresaActual = empresaActual;

        setTitle("Menú Empresa - Bolsa Laboral");
        setIconImage(Toolkit.getDefaultToolkit().getImage(MenuEmpresa.class.getResource("/imagen/IconoPrincipal.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);

        // Fondo decorativo
        Image imgFondo = new ImageIcon(getClass().getResource("/imagen/ImagenPrincipal.jpg")).getImage();
        FondoPanel fondoPanel = new FondoPanel(imgFondo);
        fondoPanel.setLayout(null);
        setContentPane(fondoPanel);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menuPerfil = new JMenu("Mi Empresa");
        menuPerfil.setFont(new Font("SansSerif", Font.PLAIN, 16));
        menuBar.add(menuPerfil);

        JMenuItem itemEditarPerfil = new JMenuItem("Editar Perfil");
        itemEditarPerfil.setFont(new Font("SansSerif", Font.PLAIN, 14));
        menuPerfil.add(itemEditarPerfil);

        JMenu menuSalir = new JMenu("Salir");
        menuSalir.setFont(new Font("SansSerif", Font.PLAIN, 16));
        menuBar.add(menuSalir);
        JMenuItem itemCerrarSesion = new JMenuItem("Cerrar sesión");
        menuSalir.add(itemCerrarSesion);
        itemCerrarSesion.addActionListener(e -> {
            dispose();
            new Login().setVisible(true);
        });

        // Panel datos de la empresa
        JPanel panelDatos = new JPanel();
        panelDatos.setBounds(30, 40, 350, 160);
        panelDatos.setOpaque(false);
        panelDatos.setBorder(BorderFactory.createTitledBorder("Datos Empresa"));
        panelDatos.setLayout(new GridLayout(3, 1));

        lblNombre = new JLabel("Nombre: " + empresaActual.getNombre());
        lblNombre.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblTipoEmpresa = new JLabel("Tipo: " + empresaActual.getTipo());
        lblTipoEmpresa.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblEmail = new JLabel("Email: " + empresaActual.getEmail());
        lblEmail.setFont(new Font("SansSerif", Font.BOLD, 14));

        panelDatos.add(lblNombre);
        panelDatos.add(lblTipoEmpresa);
        panelDatos.add(lblEmail);
        fondoPanel.add(panelDatos);

        // Panel de acciones principales
        JPanel panelAcciones = new JPanel();
        panelAcciones.setBounds(430, 40, 400, 160);
        panelAcciones.setOpaque(false);
        panelAcciones.setLayout(new GridLayout(3, 1, 20, 20));

        JButton btnVerVacantes = new JButton("Ver Mis Vacantes");
        btnVerVacantes.setFont(new Font("SansSerif", Font.BOLD, 15));
        panelAcciones.add(btnVerVacantes);

        JButton btnRegistrarVacante = new JButton("Registrar Nueva Vacante");
        btnRegistrarVacante.setFont(new Font("SansSerif", Font.BOLD, 15));
        panelAcciones.add(btnRegistrarVacante);

        JButton btnVerPostulaciones = new JButton("Postulaciones Recibidas");
        btnVerPostulaciones.setFont(new Font("SansSerif", Font.BOLD, 15));
        panelAcciones.add(btnVerPostulaciones);

        fondoPanel.add(panelAcciones);

        // --- LISTENERS DE LOS BOTONES ---
        btnRegistrarVacante.addActionListener(e -> {
            // Aquí abres tu formulario de registrar vacante, pasando la empresa actual
            new RegVacanteEmpresa(empresaActual).setVisible(true);
        });

        btnVerVacantes.addActionListener(e -> {
            // Aquí puedes abrir la ventana de "Ver Mis Vacantes"
            // new VerVacantesEmpresa(empresaActual).setVisible(true);
            JOptionPane.showMessageDialog(this, "Aquí irá la ventana de Vacantes de esta empresa.");
        });

        btnVerPostulaciones.addActionListener(e -> {
            // Aquí puedes abrir la ventana de "Ver Postulaciones Recibidas"
            // new VerPostulacionesEmpresa(empresaActual).setVisible(true);
            JOptionPane.showMessageDialog(this, "Aquí irá la ventana de Postulaciones recibidas por esta empresa.");
        });
    }

    // Panel de fondo igual al de VentanaPrincipal
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
}
