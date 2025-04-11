package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RegistrarInvitadoView extends JPanel {
    private JTextField txtNombre, txtCelular;
    private JComboBox<String> cbMes, cbAnio;
    private JRadioButton rbMasculino, rbFemenino;
    private JTextArea taDireccion;
    private JCheckBox cbTerminos;
    private JButton btnRegistrar, btnResetear;

    public RegistrarInvitadoView() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // 1. Fila Nombre
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Ingrese Nombre:"), gbc);

        gbc.gridx = 1;
        txtNombre = new JTextField(20);
        add(txtNombre, gbc);

        // 2. Fila Celular
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Ingrese número celular:"), gbc);

        gbc.gridx = 1;
        txtCelular = new JTextField(20);
        add(txtCelular, gbc);

        // 3. Fila Género
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Género:"), gbc);

        gbc.gridx = 1;
        JPanel panelGenero = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ButtonGroup grupoGenero = new ButtonGroup();
        rbMasculino = new JRadioButton("Masculino");
        rbFemenino = new JRadioButton("Femenino");
        grupoGenero.add(rbMasculino);
        grupoGenero.add(rbFemenino);
        panelGenero.add(rbMasculino);
        panelGenero.add(rbFemenino);
        add(panelGenero, gbc);

        // 4. Fila Fecha de Nacimiento
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Fecha de Nacimiento:"), gbc);

        gbc.gridx = 1;
        JPanel panelFecha = new JPanel(new FlowLayout(FlowLayout.LEFT));
        String[] meses = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        cbMes = new JComboBox<>(meses);
        panelFecha.add(cbMes);

        JTextField txtDia = new JTextField(2);
        panelFecha.add(txtDia);

        String[] anios = new String[30];
        for (int i = 0; i < 30; i++) {
            anios[i] = String.valueOf(1990 + i);
        }
        cbAnio = new JComboBox<>(anios);
        panelFecha.add(cbAnio);

        add(panelFecha, gbc);

        // 5. Fila Dirección
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Dirección:"), gbc);

        gbc.gridx = 1;
        taDireccion = new JTextArea(3, 20);
        add(new JScrollPane(taDireccion), gbc);

        // 6. Fila Términos
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        cbTerminos = new JCheckBox("Acepta Términos y Condiciones");
        add(cbTerminos, gbc);

        // 7. Fila Botones
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        btnRegistrar = new JButton("Registrar");
        btnResetear = new JButton("Resetear");
        panelBotones.add(btnRegistrar);
        panelBotones.add(btnResetear);
        add(panelBotones, gbc);
    }

    // Métodos para obtener datos
    public String getNombre() { return txtNombre.getText(); }
    public String getCelular() { return txtCelular.getText(); }
    public String getGenero() { return rbMasculino.isSelected() ? "Masculino" : "Femenino"; }
    public String getFechaNacimiento() { return cbMes.getSelectedItem() + "/" + cbAnio.getSelectedItem(); }
    public String getDireccion() { return taDireccion.getText(); }
    public boolean aceptaTerminos() { return cbTerminos.isSelected(); }

    // Métodos para eventos
    public void setRegistrarListener(ActionListener listener) {
        btnRegistrar.addActionListener(listener);
    }

    public void setResetearListener(ActionListener listener) {
        btnResetear.addActionListener(listener);
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void limpiarCampos() {
        txtNombre.setText("");
        txtCelular.setText("");
        rbMasculino.setSelected(true);
        taDireccion.setText("");
        cbTerminos.setSelected(false);
    }
}