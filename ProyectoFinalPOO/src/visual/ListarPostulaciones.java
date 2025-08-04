package visual;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import logico.*;
import java.awt.event.*;
import java.util.List;

public class ListarPostulaciones extends JFrame {
    private JTable table;
    private DefaultTableModel model;

    public ListarPostulaciones(VentanaPrincipal ventanaPrincipal) {
        setTitle("Lista de Postulaciones");
        setSize(900, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(20, 20, 850, 250);
        getContentPane().add(scrollPane);

        table = new JTable();
        model = new DefaultTableModel(new Object[]{"ID", "Candidato", "Vacante", "Fecha", "Estado"}, 0);
        table.setModel(model);
        scrollPane.setViewportView(table);

        JButton btnModificar = new JButton("Modificar");
        btnModificar.setBounds(620, 290, 120, 30);
        getContentPane().add(btnModificar);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(750, 290, 120, 30);
        getContentPane().add(btnEliminar);

        cargarPostulaciones();

        btnModificar.addActionListener(e -> {
            int fila = table.getSelectedRow();
            if (fila >= 0) {
                String id = model.getValueAt(fila, 0).toString();
                Postulacion p = BolsaLaboral.getInstancia().buscarPostulacionPorId(id);
                if (p != null) {
                    new ModPostulacion(p, ventanaPrincipal).setVisible(true);
                    dispose();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una postulación para modificar");
            }
        });

        btnEliminar.addActionListener(e -> {
            int fila = table.getSelectedRow();
            if (fila >= 0) {
                String id = model.getValueAt(fila, 0).toString();
                BolsaLaboral.getInstancia().eliminarPostulacionPorId(id);
                cargarPostulaciones();
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una postulación para eliminar");
            }
        });
    }

    private void cargarPostulaciones() {
        model.setRowCount(0);
        List<Postulacion> postulaciones = BolsaLaboral.getInstancia().getPostulaciones();
        for (Postulacion p : postulaciones) {
            model.addRow(new Object[]{
                p.getId(),
                p.getCandidato().getNombre(),
                p.getVacante().getTitulo(),
                p.getFechaPostulacion(),
                p.getEstado()
            });
        }
    }
}
