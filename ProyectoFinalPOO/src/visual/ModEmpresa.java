
package visual;

import javax.swing.*;
import logico.empresa;
import logico.BolsaLaboral;

public class ModEmpresa extends RegEmpresa {

    private empresa original;

    public ModEmpresa(empresa e) {
        super(null);
        this.original = e;
        setTitle("Modificar Empresa");

        // Llenar campos
        txtId.setText(e.getId());
        txtNombre.setText(e.getNombre());
        txtTelefono.setText(e.getTelefono());
        txtDireccion.setText(e.getDireccion());
        txtEmail.setText(e.getEmail());
        txtUsuario.setText(e.getUsuario());
        txtContrasena.setText(e.getContrasena());
        comboTipoEmpresa.setSelectedItem(e.getTipo().toString());
        txtFechaRegistro.setText(new java.text.SimpleDateFormat("dd/MM/yyyy").format(e.getFechaRegistro()));

        // Cambiar texto del botón
        JButton btnGuardar = (JButton) getContentPane().getComponent(getContentPane().getComponentCount() - 2);
        btnGuardar.setText("Actualizar");

        for (java.awt.event.ActionListener al : btnGuardar.getActionListeners()) {
            btnGuardar.removeActionListener(al);
        }

        btnGuardar.addActionListener(ev -> {
            e.setNombre(txtNombre.getText());
            e.setTelefono(txtTelefono.getText());
            e.setDireccion(txtDireccion.getText());
            e.setEmail(txtEmail.getText());
            e.setUsuario(txtUsuario.getText());
            e.setContrasena(new String(txtContrasena.getPassword()));
            e.setTipo(logico.TipoEmpresa.valueOf(comboTipoEmpresa.getSelectedItem().toString()));
            BolsaLaboral.getInstancia().guardarEmpresas(); // Puedes crear este método si no lo tienes
            JOptionPane.showMessageDialog(this, "Empresa actualizada correctamente");
            dispose();
        });
    }
}
