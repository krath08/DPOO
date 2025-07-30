package visual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import logico.*;
import java.util.List;
import java.util.ArrayList;

public class RegistrarPostulacion extends JFrame {
	private JComboBox<String> cbCandidatos;
	private JComboBox<String> cbVacantes;
	private JPanel panelRequisitos;
	private JTextArea txtComentarios;
	private JButton btnGuardar;
	private JComboBox<EstadoPostulacion> cbEstado;
	private java.util.List<JCheckBox> checkboxes = new ArrayList<>();

	public RegistrarPostulacion() {
	    setTitle("Registrar Postulación");
	    setSize(600, 600);
	    setLocationRelativeTo(null);
	    setLayout(null);

	    JLabel lblCandidato = new JLabel("Candidato:");
	    lblCandidato.setBounds(30, 20, 100, 25);
	    add(lblCandidato);

	    cbCandidatos = new JComboBox<>();
	    cbCandidatos.setBounds(150, 20, 400, 25);
	    for (Candidato c : BolsaLaboral.getInstancia().getCandidatos()) {
	        cbCandidatos.addItem(c.getUsuario() + " - " + c.getNombre());
	    }
	    add(cbCandidatos);

	    JLabel lblVacante = new JLabel("Vacante:");
	    lblVacante.setBounds(30, 60, 100, 25);
	    add(lblVacante);

	    cbVacantes = new JComboBox<>();
	    cbVacantes.setBounds(150, 60, 400, 25);
	    for (Vacante v : BolsaLaboral.getInstancia().getVacantes()) {
	        cbVacantes.addItem(v.getId() + " - " + v.getTitulo());
	    }
	    add(cbVacantes);

	    JLabel lblEstado = new JLabel("Estado:");
	    lblEstado.setBounds(30, 100, 100, 25);
	    add(lblEstado);

	    cbEstado = new JComboBox<>(EstadoPostulacion.values());
	    cbEstado.setBounds(150, 100, 200, 25);
	    add(cbEstado);

	    JLabel lblRequisitos = new JLabel("Requisitos Cumplidos:");
	    lblRequisitos.setBounds(30, 140, 200, 25);
	    add(lblRequisitos);

	    panelRequisitos = new JPanel();
	    panelRequisitos.setLayout(new BoxLayout(panelRequisitos, BoxLayout.Y_AXIS));
	    JScrollPane scroll = new JScrollPane(panelRequisitos);
	    scroll.setBounds(30, 170, 520, 150);
	    add(scroll);

	    cbVacantes.addActionListener(e -> cargarRequisitos());
	    if (cbVacantes.getItemCount() > 0) cargarRequisitos();

	    JLabel lblComentarios = new JLabel("Comentarios:");
	    lblComentarios.setBounds(30, 330, 100, 25);
	    add(lblComentarios);

	    txtComentarios = new JTextArea();
	    JScrollPane scrollComentarios = new JScrollPane(txtComentarios);
	    scrollComentarios.setBounds(30, 360, 520, 80);
	    add(scrollComentarios);

	    btnGuardar = new JButton("Guardar Postulación");
	    btnGuardar.setBounds(200, 470, 200, 40);
	    add(btnGuardar);

	    btnGuardar.addActionListener(e -> guardarPostulacion());

	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    setVisible(true);
	}

	private void cargarRequisitos() {
	    panelRequisitos.removeAll();
	    checkboxes.clear();

	    String vacanteId = (String) cbVacantes.getSelectedItem();
	    if (vacanteId == null) return;
	    vacanteId = vacanteId.split(" - ")[0];

	    Vacante vacante = null;
	    for (Vacante v : BolsaLaboral.getInstancia().getVacantes()) {
	        if (v.getId().equals(vacanteId)) {
	            vacante = v;
	            break;
	        }
	    }
	    if (vacante == null) return;

	    for (String req : vacante.getRequisitos()) {
	        JCheckBox chk = new JCheckBox(req);
	        panelRequisitos.add(chk);
	        checkboxes.add(chk);
	    }

	    panelRequisitos.revalidate();
	    panelRequisitos.repaint();
	}

	private void guardarPostulacion() {
	    String candidatoUsuario = ((String) cbCandidatos.getSelectedItem()).split(" - ")[0];
	    Candidato candidato = null;
	    for (Candidato c : BolsaLaboral.getInstancia().getCandidatos()) {
	        if (c.getUsuario().equals(candidatoUsuario)) {
	            candidato = c;
	            break;
	        }
	    }

	    String vacanteId = ((String) cbVacantes.getSelectedItem()).split(" - ")[0];
	    Vacante vacante = null;
	    for (Vacante v : BolsaLaboral.getInstancia().getVacantes()) {
	        if (v.getId().equals(vacanteId)) {
	            vacante = v;
	            break;
	        }
	    }

	    List<String> requisitosCumplidos = new ArrayList<>();
	    for (JCheckBox chk : checkboxes) {
	        if (chk.isSelected()) requisitosCumplidos.add(chk.getText());
	    }

	    String comentarios = txtComentarios.getText();
	    EstadoPostulacion estado = (EstadoPostulacion) cbEstado.getSelectedItem();
	    String id = "POST-" + System.currentTimeMillis();

	    Postulacion nueva = new Postulacion(id, candidato, vacante, new Date(), estado, comentarios, requisitosCumplidos);
	    BolsaLaboral.getInstancia().agregarPostulacion(nueva);

	    JOptionPane.showMessageDialog(this, "Postulación registrada exitosamente.");
	    dispose();
	}
}