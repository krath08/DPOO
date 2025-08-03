
package visual;

import logico.BolsaLaboral;
import logico.Vacante;

public class ModVacante extends RegVacante {
    private Vacante vacanteOriginal;

    public ModVacante(Vacante vacante) {
        super(null);
        this.vacanteOriginal = vacante;
        setTitle("Modificar Vacante");

        txtId.setText(vacante.getId());
        txtId.setEditable(false);
        txtTitulo.setText(vacante.getTitulo());
        txtDescripcion.setText(vacante.getDescripcion());
        txtSalario.setText(String.valueOf(vacante.getSalario()));
        comboTipoEmpleo.setSelectedItem(vacante.getTipoEmpleo());

        btnGuardar.setText("Guardar Cambios");
        btnGuardar.addActionListener(e -> {
            vacanteOriginal.setTitulo(txtTitulo.getText());
            vacanteOriginal.setDescripcion(txtDescripcion.getText());
            vacanteOriginal.setSalario(Float.parseFloat(txtSalario.getText()));
            vacanteOriginal.setTipoEmpleo(comboTipoEmpleo.getSelectedItem().toString());

            BolsaLaboral.getInstancia().guardarVacantes();
            dispose();
        });
    }
}
