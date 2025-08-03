package visual;

import javax.swing.*;
import logico.*;

public class ModCandidato extends RegCandidato {

    private Candidato original;

    public ModCandidato(Candidato candidato) {
        super(null); // No necesitamos VentanaPrincipal aquí
        this.original = candidato;

        setTitle("Modificar Candidato");

        // Llenar campos con los datos del candidato original
        cargarDatos(candidato);

        // Cambiar texto del botón
        JButton btnGuardar = (JButton) getContentPane().getComponent(getContentPane().getComponentCount() - 2);
        btnGuardar.setText("Actualizar");

        // Reemplazar action listener
        for (java.awt.event.ActionListener al : btnGuardar.getActionListeners()) {
            btnGuardar.removeActionListener(al);
        }

        btnGuardar.addActionListener(e -> {
            Candidato actualizado = construirCandidatoDesdeCampos();

            if (actualizado != null) {
                BolsaLaboral.getInstancia().modificarCandidato(actualizado);
                JOptionPane.showMessageDialog(this, "Candidato actualizado correctamente");
                dispose();
            }
        });
    }

    private void cargarDatos(Candidato c) {
        txtNombre.setText(c.getNombre());
        txtApellido.setText(c.getApellido());
        txtCedula.setText(c.getCedula());
        txtTelefono.setText(c.getTelefono());
        txtDireccion.setText(c.getDireccion());
        txtEmail.setText(c.getEmail());
        txtUsuario.setText(c.getUsuario());
        txtContrasena.setText(c.getContrasena());

        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.setTime(c.getFechaNacimiento());
        spinnerDia.setValue(cal.get(java.util.Calendar.DAY_OF_MONTH));
        spinnerMes.setValue(cal.get(java.util.Calendar.MONTH) + 1);
        comboAnio.setSelectedItem(cal.get(java.util.Calendar.YEAR));

        if (c instanceof Universitario) {
            comboTipoCandidato.setSelectedItem("Universitario");
        } else if (c instanceof TecnicoSuperior) {
            comboTipoCandidato.setSelectedItem("Técnico Superior");
        } else {
            comboTipoCandidato.setSelectedItem("Obrero");
        }
    }
}
