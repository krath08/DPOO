package visual;

import logico.BolsaLaboral;
import logico.Vacante;
import logico.TipoEmpleo;

public class ModVacante extends RegVacante {
    private Vacante vacanteOriginal;

    public ModVacante(Vacante vacante, VentanaPrincipal ventanaPrincipal) {
        super(ventanaPrincipal);
        this.vacanteOriginal = vacante;
        setTitle("Modificar Vacante");

        txtId.setText(vacante.getId());
        txtId.setEditable(false);
        txtTitulo.setText(vacante.getTitulo());
        txtDescripcion.setText(vacante.getDescripcion());
        txtSalario.setText(String.valueOf(vacante.getSalario()));
        txtExperiencia.setText(String.valueOf(vacante.getExperiencia()));
        comboTipoEmpleo.setSelectedItem(vacante.getTipoEmpleo());

        btnGuardar.setText("Guardar Cambios");
        btnGuardar.addActionListener(e -> {
            try {
                vacanteOriginal.setTitulo(txtTitulo.getText().trim());
                vacanteOriginal.setDescripcion(txtDescripcion.getText().trim());
                vacanteOriginal.setSalario(Double.parseDouble(txtSalario.getText().trim()));
                vacanteOriginal.setTipoEmpleo((TipoEmpleo) comboTipoEmpleo.getSelectedItem());
                vacanteOriginal.setExperiencia(Integer.parseInt(txtExperiencia.getText().trim()));

                BolsaLaboral.getInstancia().getVacantes();
                ventanaPrincipal.actualizarResumen();
                dispose();
                new ListarVacantes(ventanaPrincipal).setVisible(true);
            } catch (Exception ex) {
                javax.swing.JOptionPane.showMessageDialog(this,
                    "Error al guardar los cambios: " + ex.getMessage());
            }
        });
    }
}
