package Views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ListaInvitadosView extends JPanel {
    private JTable tabla;
    private DefaultTableModel modeloTabla;

    public ListaInvitadosView() {
        setLayout(new BorderLayout());

        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Teléfono");
        modeloTabla.addColumn("Género");
        modeloTabla.addColumn("Fecha de Nacimiento");
        modeloTabla.addColumn("Dirección");

        tabla = new JTable(modeloTabla);
        add(new JScrollPane(tabla), BorderLayout.CENTER);
    }

    public void actualizarTabla(List<String[]> datos) {
        modeloTabla.setRowCount(0);
        for (String[] fila : datos) {
            modeloTabla.addRow(fila);
        }
    }
}