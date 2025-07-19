package visual;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import logico.BolsaLaboral;
import javax.swing.border.TitledBorder;

public class VentanaPrincipal extends JFrame {

    private JLabel lblCandidatosRegistrados;
    private JLabel lblEmpresasActivas;
    private JLabel lblVacantesAbiertas;
    private JLabel lblPostulacionesPendientes;
    private JTable tablaPostulaciones;
    private DefaultTableModel modeloTabla;

    // Clase interna para fondo escalable
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

    public VentanaPrincipal() {
        setTitle("Sistema de Bolsa Laboral - Ventana Principal");
        setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/imagen/IconoPrincipal.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Fondo directo (asegúrate que la imagen está en la carpeta correcta)
        Image imgFondo = new ImageIcon(getClass().getResource("/imagen/ImagenPrincipal.jpg")).getImage();
        FondoPanel fondoPanel = new FondoPanel(imgFondo);
        fondoPanel.setLayout(null);
        setContentPane(fondoPanel);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("Archivo");
        menu.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagen/IconoArchivo.png")));
        menu.setFont(new Font("SansSerif", Font.PLAIN, 16));
        menuBar.add(menu);

        JMenu menuCandidatos = new JMenu("Candidatos");
        menuCandidatos.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagen/iconitoRegCandi.png")));
        menuCandidatos.setFont(new Font("SansSerif", Font.PLAIN, 16));
        menuBar.add(menuCandidatos);

        JMenuItem itemRegistrarCandidato = new JMenuItem("Registrar Candidato");
        itemRegistrarCandidato.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagen/miniIconRegCandi.png")));
        itemRegistrarCandidato.setFont(new Font("SansSerif", Font.PLAIN, 14));
        menuCandidatos.add(itemRegistrarCandidato);
        itemRegistrarCandidato.addActionListener(e -> {
            RegCandidato ventana = new RegCandidato(this);
            ventana.setVisible(true);
        });

        JMenu menuEmpresa = new JMenu("Empresa");
        menuEmpresa.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagen/iconitoRegEmpresa.png")));
        menuEmpresa.setFont(new Font("SansSerif", Font.PLAIN, 16));
        menuBar.add(menuEmpresa);

        JMenuItem itemRegistrarEmpresa = new JMenuItem("Registrar Empresa");
        itemRegistrarEmpresa.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagen/miniIconRegEmpre.png")));
        itemRegistrarEmpresa.setFont(new Font("SansSerif", Font.PLAIN, 14));
        menuEmpresa.add(itemRegistrarEmpresa);
        itemRegistrarEmpresa.addActionListener(e -> {
            RegEmpresa ventana = new RegEmpresa(this);
            ventana.setVisible(true);
        });

        JMenu menu_1 = new JMenu("Vacantes");
        menu_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagen/iconitoRegVacante.png")));
        menu_1.setFont(new Font("SansSerif", Font.PLAIN, 16));
        menuBar.add(menu_1);

        JMenuItem itemRegistrarVacante = new JMenuItem("Registrar Vacante");
        itemRegistrarVacante.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagen/miniIconRegVacant.png")));
        itemRegistrarVacante.setFont(new Font("SansSerif", Font.PLAIN, 14));
        menu_1.add(itemRegistrarVacante);
        itemRegistrarVacante.addActionListener(e -> {
            RegVacante ventana = new RegVacante(this);
            ventana.setVisible(true);
        });

        JMenu menu_2 = new JMenu("Postulaciones");
        menu_2.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagen/IconoRegPostu.png")));
        menu_2.setFont(new Font("SansSerif", Font.PLAIN, 16));
        menuBar.add(menu_2);
        JMenu menu_3 = new JMenu("Reportes");
        menu_3.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagen/IconoReport.png")));
        menu_3.setFont(new Font("SansSerif", Font.PLAIN, 16));
        menuBar.add(menu_3);

        // Paneles de la UI
        JPanel panelResumen = new JPanel();
        panelResumen.setBounds(12, 28, 194, 194);
        panelResumen.setOpaque(false);
        panelResumen.setBorder(BorderFactory.createTitledBorder("Resumen del Sistema"));
        panelResumen.setLayout(new GridLayout(4, 1));

        lblCandidatosRegistrados = new JLabel("Candidatos registrados: ");
        lblCandidatosRegistrados.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 13));
        lblEmpresasActivas = new JLabel("Empresas activas: ");
        lblEmpresasActivas.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 13));
        lblVacantesAbiertas = new JLabel("Vacantes abiertas: ");
        lblVacantesAbiertas.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 13));
        lblPostulacionesPendientes = new JLabel("Postulaciones pendientes: ");
        lblPostulacionesPendientes.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 13));
        panelResumen.add(lblCandidatosRegistrados);
        panelResumen.add(lblEmpresasActivas);
        panelResumen.add(lblVacantesAbiertas);
        panelResumen.add(lblPostulacionesPendientes);
        fondoPanel.add(panelResumen);

        JPanel panelAcciones = new JPanel();
        panelAcciones.setBounds(246, 28, 518, 194);
        panelAcciones.setOpaque(false);
        panelAcciones.setBorder(BorderFactory.createTitledBorder("Acciones Rápidas"));
        panelAcciones.setLayout(new GridLayout(4, 1, 10, 10));

        JButton btnRegistrarCandidato = new JButton("Registrar Nuevo Candidato");
        btnRegistrarCandidato.setFont(new Font("SansSerif", Font.PLAIN, 14));
        btnRegistrarCandidato.addActionListener(e -> {
            RegCandidato ventana = new RegCandidato(this);
            ventana.setVisible(true);
        });
        JButton btnBuscarCandidatos = new JButton("Buscar Candidatos");
        btnBuscarCandidatos.setFont(new Font("SansSerif", Font.PLAIN, 14));
        JButton btnVerVacantes = new JButton("Ver Vacantes Activas");
        btnVerVacantes.setFont(new Font("SansSerif", Font.PLAIN, 14));
        JButton btnReporteMensual = new JButton("Generar Reporte Mensual");
        btnReporteMensual.setFont(new Font("SansSerif", Font.PLAIN, 14));

        panelAcciones.add(btnRegistrarCandidato);
        panelAcciones.add(btnBuscarCandidatos);
        panelAcciones.add(btnVerVacantes);
        panelAcciones.add(btnReporteMensual);
        fondoPanel.add(panelAcciones);

        JPanel panelTabla = new JPanel();
        panelTabla.setBounds(12, 290, 666, 236);
        panelTabla.setOpaque(false);
        panelTabla.setBorder(BorderFactory.createTitledBorder("Últimas Postulaciones"));
        panelTabla.setLayout(new BorderLayout());

        String[] columnas = {"Candidato", "Empresa", "Vacante", "Fecha", "Estado"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaPostulaciones = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaPostulaciones);
        scrollPane.setViewportBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panelTabla.add(scrollPane, BorderLayout.CENTER);
        fondoPanel.add(panelTabla);

        // Actualiza resumen al iniciar
        actualizarResumen();
    }

    public void actualizarResumen() {
        setCandidatosRegistrados(BolsaLaboral.getInstancia().getCantidadCandidatos());
        setEmpresasActivas(BolsaLaboral.getInstancia().getCantidadEmpresasActivas());
        setVacantesAbiertas(BolsaLaboral.getInstancia().getCantidadVacantesAbiertas());
        setPostulacionesPendientes(BolsaLaboral.getInstancia().getCantidadPostulacionesPendientes());
    }
    public void setCandidatosRegistrados(int cantidad) {
        lblCandidatosRegistrados.setText("Candidatos registrados: " + cantidad);
    }
    public void setEmpresasActivas(int cantidad) {
        lblEmpresasActivas.setText("Empresas activas: " + cantidad);
    }
    public void setVacantesAbiertas(int cantidad) {
        lblVacantesAbiertas.setText("Vacantes abiertas: " + cantidad);
    }
    public void setPostulacionesPendientes(int cantidad) {
        lblPostulacionesPendientes.setText("Postulaciones pendientes: " + cantidad);
    }
    public void agregarPostulacion(String candidato, String empresa, String vacante, String fecha, String estado) {
        modeloTabla.addRow(new Object[]{candidato, empresa, vacante, fecha, estado});
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventana = new VentanaPrincipal();
            ventana.setVisible(true);
        });
    }
}
