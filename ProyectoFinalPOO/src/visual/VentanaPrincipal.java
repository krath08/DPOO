import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class VentanaPrincipal extends JFrame {


    private JLabel lblCandidatosRegistrados;
    private JLabel lblEmpresasActivas;
    private JLabel lblVacantesAbiertas;
    private JLabel lblPostulacionesPendientes;

    private JTable tablaPostulaciones;
    private DefaultTableModel modeloTabla;

    public VentanaPrincipal() {
        setTitle("Sistema de Bolsa Laboral - Ventana Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(794, 612);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        menuBar.add(new JMenu("Archivo"));
        menuBar.add(new JMenu("Candidatos"));
        menuBar.add(new JMenu("Empresas"));
        menuBar.add(new JMenu("Vacantes"));
        menuBar.add(new JMenu("Postulaciones"));
        menuBar.add(new JMenu("Reportes"));

        JPanel panelResumen = new JPanel();
        panelResumen.setBorder(BorderFactory.createTitledBorder("Resumen del Sistema"));
        panelResumen.setBounds(12, 28, 250, 160);
        panelResumen.setLayout(new GridLayout(4, 1));

        lblCandidatosRegistrados = new JLabel("Candidatos registrados: ");
        lblEmpresasActivas = new JLabel("Empresas activas: ");
        lblVacantesAbiertas = new JLabel("Vacantes abiertas: ");
        lblPostulacionesPendientes = new JLabel("Postulaciones pendientes: ");

        panelResumen.add(lblCandidatosRegistrados);
        panelResumen.add(lblEmpresasActivas);
        panelResumen.add(lblVacantesAbiertas);
        panelResumen.add(lblPostulacionesPendientes);
        getContentPane().add(panelResumen);

        JPanel panelAcciones = new JPanel();
        panelAcciones.setBorder(BorderFactory.createTitledBorder("Acciones Rápidas"));
        panelAcciones.setBounds(267, 28, 500, 160);
        panelAcciones.setLayout(new GridLayout(4, 1, 10, 10));

        JButton btnRegistrarCandidato = new JButton("Registrar Nuevo Candidato");
        JButton btnBuscarCandidatos = new JButton("Buscar Candidatos");
        JButton btnVerVacantes = new JButton("Ver Vacantes Activas");
        JButton btnReporteMensual = new JButton("Generar Reporte Mensual");

        panelAcciones.add(btnRegistrarCandidato);
        panelAcciones.add(btnBuscarCandidatos);
        panelAcciones.add(btnVerVacantes);
        panelAcciones.add(btnReporteMensual);
        getContentPane().add(panelAcciones);

        JPanel panelTabla = new JPanel();
        panelTabla.setBorder(BorderFactory.createTitledBorder("Últimas Postulaciones"));
        panelTabla.setBounds(10, 205, 760, 300);
        panelTabla.setLayout(new BorderLayout());

        String[] columnas = {"Candidato", "Empresa", "Vacante", "Fecha", "Estado"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaPostulaciones = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaPostulaciones);
        panelTabla.add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(panelTabla);
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

            // Ejemplo de cómo llenar datos (puedes borrar esto)
            ventana.setCandidatosRegistrados(0);
            ventana.setEmpresasActivas(0);
            ventana.setVacantesAbiertas(0);
            ventana.setPostulacionesPendientes(0);
        });
    }
}
