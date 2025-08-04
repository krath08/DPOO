package visual;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.List;
import logico.BolsaLaboral;
import logico.Candidato;
import logico.Postulacion;
import logico.Vacante;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuCandidato extends JFrame {

    private JLabel lblNombre;
    private JLabel lblEmail;
    private JLabel lblTipoCandidato;
    private Candidato candidato;

    public MenuCandidato(Candidato candidato) {
        this.candidato = candidato;

        setTitle("Menú Candidato - Bolsa Laboral");
        setIconImage(Toolkit.getDefaultToolkit().getImage(MenuCandidato.class.getResource("/imagen/IconoPrincipal.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        Image imgFondo = new ImageIcon(getClass().getResource("/imagen/imagenCandidato.png")).getImage();
        FondoPanel fondoPanel = new FondoPanel(imgFondo);
        fondoPanel.setLayout(null);
        setContentPane(fondoPanel);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menuPerfil = new JMenu("Mi Perfil");
        menuPerfil.setIcon(new ImageIcon(MenuCandidato.class.getResource("/imagen/iconoMiPerfil.png")));
        menuPerfil.setFont(new Font("SansSerif", Font.PLAIN, 16));
        menuBar.add(menuPerfil);

        JMenuItem itemEditarPerfil = new JMenuItem("Editar Perfil");
        itemEditarPerfil.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new EditarCandidato(candidato).setVisible(true);
        	}
        });
        itemEditarPerfil.setIcon(new ImageIcon(MenuCandidato.class.getResource("/imagen/iconitoEditar.png")));
        itemEditarPerfil.setFont(new Font("SansSerif", Font.PLAIN, 14));
        menuPerfil.add(itemEditarPerfil);

        JMenu menuSalir = new JMenu("Salir");
        menuSalir.setIcon(new ImageIcon(MenuCandidato.class.getResource("/imagen/IconoSalir.png")));
        menuSalir.setFont(new Font("SansSerif", Font.PLAIN, 16));
        menuBar.add(menuSalir);
        JMenuItem itemCerrarSesion = new JMenuItem("Cerrar sesión");
        itemCerrarSesion.setIcon(new ImageIcon(MenuCandidato.class.getResource("/imagen/iconitoSalir.png")));
        menuSalir.add(itemCerrarSesion);
        itemCerrarSesion.addActionListener(e -> {
            dispose();
            new Login().setVisible(true);
        });

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

        JPanel panelAcciones = new JPanel();
        panelAcciones.setBounds(430, 40, 400, 200);
        panelAcciones.setOpaque(false);
        panelAcciones.setLayout(new GridLayout(3, 1, 20, 20));

        JButton btnRegistrarPostulacion = new JButton("Registrar Postulación");
        btnRegistrarPostulacion.setFont(new Font("SansSerif", Font.BOLD, 15));
        panelAcciones.add(btnRegistrarPostulacion);

        JButton btnVerVacantes = new JButton("Ver Vacantes Disponibles");
        btnVerVacantes.setFont(new Font("SansSerif", Font.BOLD, 15));
        panelAcciones.add(btnVerVacantes);

        JButton btnVerPostulaciones = new JButton("Mis Postulaciones");
        btnVerPostulaciones.setFont(new Font("SansSerif", Font.BOLD, 15));
        panelAcciones.add(btnVerPostulaciones);

        fondoPanel.add(panelAcciones);

        btnRegistrarPostulacion.addActionListener(e -> {
            new RegPostulacionCandidato(candidato).setVisible(true);
        });

        btnVerVacantes.addActionListener(e -> mostrarVacantesDialog());

        btnVerPostulaciones.addActionListener(e -> mostrarPostulacionesDialog());
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

    private String getTipoCandidatoTexto(Candidato c) {
        if (c.getClass().getSimpleName().equals("Universitario")) return "Universitario";
        if (c.getClass().getSimpleName().equals("TecnicoSuperior")) return "Técnico Superior";
        if (c.getClass().getSimpleName().equals("Obrero")) return "Obrero";
        return "Desconocido";
    }

    private void mostrarVacantesDialog() {
        List<Vacante> vacantes = logico.BolsaLaboral.getInstancia().getVacantes();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"ID", "Título", "Empresa", "Salario", "Tipo Empleo"});
        for (Vacante v : vacantes) {
            if (v.isAbierta()) {
                modelo.addRow(new Object[]{
                    v.getId(),
                    v.getTitulo(),
                    v.getEmpresa().getNombre(),
                    v.getSalario(),
                    v.getTipoEmpleo()
                });
            }
        }
        JTable table = new JTable(modelo);
        table.setEnabled(false);
        JScrollPane scrollPane = new JScrollPane(table);
        JDialog dialog = new JDialog(this, "Vacantes Disponibles", true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.getContentPane().add(scrollPane);
        dialog.setSize(600, 350);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private void mostrarPostulacionesDialog() {
        List<Postulacion> postulaciones = logico.BolsaLaboral.getInstancia().getPostulaciones();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"Vacante", "Empresa", "Estado", "Fecha", "Comentarios"});
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        for (Postulacion p : postulaciones) {
            if (p.getCandidato().getUsuario().equals(candidato.getUsuario())) {
                String fechaFormateada = "";
                if (p.getFechaPostulacion() != null) {
                    fechaFormateada = sdf.format(p.getFechaPostulacion());
                }
                modelo.addRow(new Object[]{
                    p.getVacante().getTitulo(),
                    p.getVacante().getEmpresa().getNombre(),
                    p.getEstado(),
                    fechaFormateada,
                    p.getComentarios()
                });
            }
        }
        JTable table = new JTable(modelo);
        table.setEnabled(false);
        JScrollPane scrollPane = new JScrollPane(table);
        JDialog dialog = new JDialog(this, "Mis Postulaciones", true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.getContentPane().add(scrollPane);
        dialog.setSize(700, 350);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }
}
