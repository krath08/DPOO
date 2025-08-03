
package visual;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import logico.*;
import java.awt.event.*;
import java.util.List;

public class ListarVacantes extends JFrame {
    private JTable table;
    private DefaultTableModel model;

    public ListarVacantes() {
        setTitle("Lista de Vacantes");
        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(20, 20, 750, 250);
        getContentPane().add(scrollPane);

        table = new JTable();
        model = new DefaultTableModel(new Object[]{"ID", "Título", "Empresa", "Salario", "Tipo Empleo"}, 0);
        table.setModel(model);
        scrollPane.setViewportView(table);

        JButton btnModificar = new JButton("Modificar");
        btnModificar.setBounds(540, 290, 110, 30);
        getContentPane().add(btnModificar);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(660, 290, 110, 30);
        getContentPane().add(btnEliminar);

        cargarVacantes();

        btnModificar.addActionListener(e -> {
            int fila = table.getSelectedRow();
            if (fila >= 0) {
                String id = model.getValueAt(fila, 0).toString();
                Vacante v = BolsaLaboral.getInstancia().buscarVacantePorId(id);
                if (v != null) {
                    new ModVacante(v).setVisible(true);
                    dispose();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una vacante para modificar");
            }
        });

        btnEliminar.addActionListener(e -> {
            int fila = table.getSelectedRow();
            if (fila >= 0) {
                String id = model.getValueAt(fila, 0).toString();
                BolsaLaboral.getInstancia().eliminarVacantePorId(id);
                cargarVacantes();
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una vacante para eliminar");
            }
        });
    }

    private void cargarVacantes() {
        model.setRowCount(0);
        List<Vacante> vacantes = BolsaLaboral.getInstancia().getVacantes();
        for (Vacante v : vacantes) {
            model.addRow(new Object[]{v.getId(), v.getTitulo(), v.getEmpresa().getNombre(), v.getSalario(), v.getTipoEmpleo()});
        }
    }
}
