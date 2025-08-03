package visual;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import logico.BolsaLaboral;
import logico.Candidato;
import java.awt.*;
import java.util.List;

public class ListarCandidatos extends JFrame {
    private JTable table;
    private DefaultTableModel model;

    public ListarCandidatos() {
        setTitle("Lista de Candidatos");
        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        model = new DefaultTableModel(new Object[]{"ID", "Nombre", "Apellido", "Tipo", "Usuario"}, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        JButton btnModificar = new JButton("Modificar");
        getContentPane().add(btnModificar, BorderLayout.SOUTH);

        JButton btnEliminar = new JButton("Eliminar");
        getContentPane().add(btnEliminar, BorderLayout.NORTH);

        btnEliminar.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) {
                String id = model.getValueAt(row, 0).toString();
                int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar este candidato?", "Confirmar", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    logico.BolsaLaboral.getInstancia().eliminarCandidatoPorId(id);
                    model.removeRow(row);
                    JOptionPane.showMessageDialog(this, "Candidato eliminado.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un candidato primero.");
            }
        });


        cargarCandidatos();

        btnModificar.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) {
                String id = model.getValueAt(row, 0).toString();
                Candidato seleccionado = BolsaLaboral.getInstancia().getCandidatos()
                        .stream()
                        .filter(c -> c.getId().equals(id))
                        .findFirst()
                        .orElse(null);
                if (seleccionado != null) {
                    new ModCandidato(seleccionado).setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un candidato primero");
            }
        });
    }

    private void cargarCandidatos() {
        List<Candidato> lista = BolsaLaboral.getInstancia().getCandidatos();
        for (Candidato c : lista) {
            String tipo = c instanceof logico.Universitario ? "Universitario"
                        : c instanceof logico.TecnicoSuperior ? "Técnico Superior"
                        : "Obrero";
            model.addRow(new Object[]{c.getId(), c.getNombre(), c.getApellido(), tipo, c.getUsuario()});
        }
    }
}
