package visual;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import logico.BolsaLaboral;
import logico.TipoEmpleo;
import logico.Vacante;
import logico.empresa;

public class RegVacante extends JFrame {
	protected JTextField txtId;
	protected JTextField txtTitulo;
	protected JTextField txtDescripcion;
	protected JTextField txtSalario;
	protected JComboBox<String> comboEmpresa;
	protected JTextField txtExperiencia;
	protected JComboBox<Object> comboTipoEmpleo;
	protected JButton btnGuardar;

	private VentanaPrincipal ventanaPrincipal;

	public RegVacante(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;

		setTitle("Registrar Vacante");
		setIconImage(new ImageIcon(getClass().getResource("/imagen/IconoRegVacante.png")).getImage());
		setSize(593, 689);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblId.setBounds(30, 24, 80, 25);
		getContentPane().add(lblId);

		txtId = new JTextField();
		txtId.setBounds(192, 25, 150, 25);
		txtId.setEditable(false);
		txtId.setText(BolsaLaboral.getInstancia().generarIdVacante());
		getContentPane().add(txtId);

		JLabel lblTitulo = new JLabel("Título:");
		lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblTitulo.setBounds(30, 73, 80, 25);
		getContentPane().add(lblTitulo);

		txtTitulo = new JTextField();
		txtTitulo.setBounds(192, 74, 190, 25);
		getContentPane().add(txtTitulo);

		JLabel lblDescripcion = new JLabel("Descripción:");
		lblDescripcion.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblDescripcion.setBounds(30, 122, 100, 25);
		getContentPane().add(lblDescripcion);

		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(192, 123, 232, 25);
		getContentPane().add(txtDescripcion);

		JLabel lblEmpresa = new JLabel("Empresa:");
		lblEmpresa.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblEmpresa.setBounds(30, 171, 100, 25);
		getContentPane().add(lblEmpresa);

		comboEmpresa = new JComboBox<>();

		for (empresa e : BolsaLaboral.getInstancia().getEmpresas()) {
			if (e.isActiva())
				comboEmpresa.addItem(e.getNombre());
		}
		comboEmpresa.setBounds(192, 172, 232, 25);
		getContentPane().add(comboEmpresa);

		JLabel lblSalario = new JLabel("Salario:");
		lblSalario.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblSalario.setBounds(30, 220, 100, 25);
		getContentPane().add(lblSalario);

		txtSalario = new JTextField();
		txtSalario.setBounds(192, 221, 150, 25);
		getContentPane().add(txtSalario);

		JLabel lblTipoEmpleo = new JLabel("Tipo de Empleo:");
		lblTipoEmpleo.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblTipoEmpleo.setBounds(30, 269, 120, 25);
		getContentPane().add(lblTipoEmpleo);

		comboTipoEmpleo = new JComboBox<>();
		comboTipoEmpleo.addItem("<Seleccione>");
		for (TipoEmpleo t : TipoEmpleo.values()) {
			comboTipoEmpleo.addItem(t);
		}
		comboTipoEmpleo.setBounds(192, 270, 200, 25);
		getContentPane().add(comboTipoEmpleo);

		JLabel lblExperiencia = new JLabel("Experiencia (años):");
		lblExperiencia.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblExperiencia.setBounds(30, 318, 150, 25);
		getContentPane().add(lblExperiencia);

		txtExperiencia = new JTextField();
		txtExperiencia.setBounds(192, 319, 60, 25);
		getContentPane().add(txtExperiencia);

		Font checkFont = new Font("SansSerif", Font.PLAIN, 13);

		JCheckBox chkExperiencia = new JCheckBox("Experiencia previa en el área");
		chkExperiencia.setFont(checkFont);
		JCheckBox chkVehiculo = new JCheckBox("Vehículo propio");
		chkVehiculo.setFont(checkFont);
		JCheckBox chkViajar = new JCheckBox("Disponibilidad para viajar");
		chkViajar.setFont(checkFont);
		JCheckBox chkOffice = new JCheckBox("Manejo de paquetes Office");
		chkOffice.setFont(checkFont);
		JCheckBox chkIngles = new JCheckBox("Inglés intermedio/avanzado");
		chkIngles.setFont(checkFont);
		JCheckBox chkPresion = new JCheckBox("Capacidad para trabajar bajo presión");
		chkPresion.setFont(checkFont);
		JCheckBox chkLicencia = new JCheckBox("Licencia de conducir");
		chkLicencia.setFont(checkFont);
		JCheckBox chkReferencias = new JCheckBox("Referencias comprobables");
		chkReferencias.setFont(checkFont);
		JCheckBox chkTrabajoEquipo = new JCheckBox("Trabajo en equipo");
		chkTrabajoEquipo.setFont(checkFont);

		JPanel panelRequisitos = new JPanel();
		panelRequisitos.setLayout(new GridLayout(0, 1));
		panelRequisitos.setBorder(BorderFactory.createTitledBorder("Requisitos"));
		panelRequisitos.setBounds(30, 367, 290, 246);

		panelRequisitos.add(chkExperiencia);
		panelRequisitos.add(chkVehiculo);
		panelRequisitos.add(chkViajar);
		panelRequisitos.add(chkOffice);
		panelRequisitos.add(chkIngles);
		panelRequisitos.add(chkPresion);
		panelRequisitos.add(chkLicencia);
		panelRequisitos.add(chkReferencias);
		panelRequisitos.add(chkTrabajoEquipo);

		getContentPane().add(panelRequisitos);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnGuardar.setBounds(461, 599, 100, 30);
		getContentPane().add(btnGuardar);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(RegVacante.class.getResource("/imagen/ImagenRegVacante.png")));
		lblNewLabel.setBounds(449, 43, 100, 110);
		getContentPane().add(lblNewLabel);

		btnGuardar.addActionListener(e -> {
			try {
				if (comboTipoEmpleo.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de empleo.");
					return;
				}

				String id = txtId.getText().trim();
				String titulo = txtTitulo.getText().trim();
				String descripcion = txtDescripcion.getText().trim();
				empresa emp = BolsaLaboral.getInstancia()
						.buscarEmpresaPorNombre((String) comboEmpresa.getSelectedItem());
				double salario = Double.parseDouble(txtSalario.getText().trim());
				TipoEmpleo tipoEmpleo = (TipoEmpleo) comboTipoEmpleo.getSelectedItem();
				int experiencia = Integer.parseInt(txtExperiencia.getText().trim());
				Date fechaPublicacion = new Date();

				List<String> requisitos = new ArrayList<>();
				if (chkExperiencia.isSelected())
					requisitos.add("Experiencia previa en el área");
				if (chkVehiculo.isSelected())
					requisitos.add("Vehículo propio");
				if (chkViajar.isSelected())
					requisitos.add("Disponibilidad para viajar");
				if (chkOffice.isSelected())
					requisitos.add("Manejo de paquetes Office");
				if (chkIngles.isSelected())
					requisitos.add("Inglés intermedio/avanzado");
				if (chkPresion.isSelected())
					requisitos.add("Capacidad para trabajar bajo presión");
				if (chkLicencia.isSelected())
					requisitos.add("Licencia de conducir");
				if (chkReferencias.isSelected())
					requisitos.add("Referencias comprobables");
				if (chkTrabajoEquipo.isSelected())
					requisitos.add("Trabajo en equipo");

				Vacante vacante = new Vacante(id, titulo, descripcion, requisitos, salario, emp, fechaPublicacion, true,
						tipoEmpleo, experiencia);

				BolsaLaboral.getInstancia().agregarVacante(vacante);
				ventanaPrincipal.actualizarResumen();
				JOptionPane.showMessageDialog(this, "Vacante registrada con éxito");
				dispose();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Error al guardar la vacante: " + ex.getMessage());
			}
		});
	}
}
