package visual;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.List;
import logico.BolsaLaboral;
import logico.empresa;
import logico.Vacante;
import logico.Postulacion;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuEmpresa extends JFrame {

    private JLabel lblNombre;
    private JLabel lblTipoEmpresa;
    private JLabel lblEmail;
    private empresa empresaActual;

    public MenuEmpresa(empresa empresaActual) {
        this.empresaActual = empresaActual;

        setTitle("Menú Empresa - Bolsa Laboral");
        setIconImage(Toolkit.getDefaultToolkit().getImage(MenuEmpresa.class.getResource("/imagen/IconoPrincipal.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        Image imgFondo = new ImageIcon(getClass().getResource("/imagen/imagenEmpresa.png")).getImage();
        FondoPanel fondoPanel = new FondoPanel(imgFondo);
        fondoPanel.setLayout(null);
        setContentPane(fondoPanel);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menuPerfil = new JMenu("Mi Empresa");
        menuPerfil.setIcon(new ImageIcon(MenuEmpresa.class.getResource("/imagen/iconoMiPerfil.png")));
        menuPerfil.setFont(new Font("SansSerif", Font.PLAIN, 16));
        menuBar.add(menuPerfil);

        JMenuItem itemEditarPerfil = new JMenuItem("Editar Perfil");
        itemEditarPerfil.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new EditarEmpresa(empresaActual).setVisible(true);
        	}
        });
        itemEditarPerfil.setIcon(new ImageIcon(MenuEmpresa.class.getResource("/imagen/iconitoEditar.png")));
        itemEditarPerfil.setFont(new Font("SansSerif", Font.PLAIN, 14));
        menuPerfil.add(itemEditarPerfil);

        JMenu menuSalir = new JMenu("Salir");
        menuSalir.setIcon(new ImageIcon(MenuEmpresa.class.getResource("/imagen/IconoSalir.png")));
        menuSalir.setFont(new Font("SansSerif", Font.PLAIN, 16));
        menuBar.add(menuSalir);
        JMenuItem itemCerrarSesion = new JMenuItem("Cerrar sesión");
        itemCerrarSesion.setIcon(new ImageIcon(MenuEmpresa.class.getResource("/imagen/iconitoSalir.png")));
        menuSalir.add(itemCerrarSesion);
        itemCerrarSesion.addActionListener(e -> {
            dispose();
            new Login().setVisible(true);
        });

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

        btnRegistrarVacante.addActionListener(e -> {
            new RegVacanteEmpresa(empresaActual).setVisible(true);
        });

        btnVerVacantes.addActionListener(e -> mostrarVacantesEmpresa());

        btnVerPostulaciones.addActionListener(e -> mostrarPostulacionesEmpresa());
    }

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

    private void mostrarVacantesEmpresa() {
        List<Vacante> vacantes = BolsaLaboral.getInstancia().getVacantes();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID", "Título", "Salario", "Tipo Empleo", "Abierta"});
        for (Vacante v : vacantes) {
            if (v.getEmpresa().getUsuario().equals(empresaActual.getUsuario())) {
                modelo.addRow(new Object[]{
                    v.getId(),
                    v.getTitulo(),
                    v.getSalario(),
                    v.getTipoEmpleo(),
                    v.isAbierta() ? "Sí" : "No"
                });
            }
        }
        JTable table = new JTable(modelo);
        table.setEnabled(false);
        JScrollPane scrollPane = new JScrollPane(table);
        JDialog dialog = new JDialog(this, "Mis Vacantes", true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.getContentPane().add(scrollPane);
        dialog.setSize(600, 350);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private void mostrarPostulacionesEmpresa() {
        List<Postulacion> postulaciones = BolsaLaboral.getInstancia().getPostulaciones();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"Vacante", "Candidato", "Estado", "Fecha", "Comentarios"});
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        for (Postulacion p : postulaciones) {
            if (p.getVacante().getEmpresa().getUsuario().equals(empresaActual.getUsuario())) {
                String fechaFormateada = "";
                if (p.getFechaPostulacion() != null) {
                    fechaFormateada = sdf.format(p.getFechaPostulacion());
                }
                String nombreCandidato = p.getCandidato().getNombre() + " " + p.getCandidato().getApellido();
                modelo.addRow(new Object[]{
                    p.getVacante().getTitulo(),
                    nombreCandidato,
                    p.getEstado(),
                    fechaFormateada,
                    p.getComentarios()
                });
            }
        }
        JTable table = new JTable(modelo);
        table.setEnabled(false);
        JScrollPane scrollPane = new JScrollPane(table);
        JDialog dialog = new JDialog(this, "Postulaciones Recibidas", true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.getContentPane().add(scrollPane);
        dialog.setSize(750, 350);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }
}
