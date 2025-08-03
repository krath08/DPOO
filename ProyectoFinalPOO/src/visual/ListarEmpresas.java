package visual;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import logico.BolsaLaboral;
import logico.empresa;
import java.awt.*;
import java.util.List;

public class ListarEmpresas extends JFrame {
    private JTable table;
    private DefaultTableModel model;

    public ListarEmpresas() {
        setTitle("Lista de Empresas");
        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        model = new DefaultTableModel(new Object[]{"ID", "Nombre", "Teléfono", "Usuario"}, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        JButton btnModificar = new JButton("Modificar");
        getContentPane().add(btnModificar, BorderLayout.SOUTH);

        JButton btnEliminar = new JButton("Eliminar");
        getContentPane().add(btnEliminar, BorderLayout.NORTH);

        cargarEmpresas();

        btnModificar.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) {
                String id = model.getValueAt(row, 0).toString();
                empresa seleccionada = BolsaLaboral.getInstancia().getEmpresas()
                        .stream()
                        .filter(emp -> emp.getId().equals(id))
                        .findFirst()
                        .orElse(null);
                if (seleccionada != null) {
                    new ModEmpresa(seleccionada).setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione una empresa primero");
            }
        });

        btnEliminar.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) {
                String id = model.getValueAt(row, 0).toString();
                int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar esta empresa?", "Confirmar", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    BolsaLaboral.getInstancia().eliminarEmpresaPorId(id);
                    model.removeRow(row);
                    JOptionPane.showMessageDialog(this, "Empresa eliminada.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione una empresa primero.");
            }
        });
    }

    private void cargarEmpresas() {
        List<empresa> lista = BolsaLaboral.getInstancia().getEmpresas();
        for (empresa e : lista) {
            model.addRow(new Object[]{e.getId(), e.getNombre(), e.getTelefono(), e.getUsuario()});
        }
    }
}
