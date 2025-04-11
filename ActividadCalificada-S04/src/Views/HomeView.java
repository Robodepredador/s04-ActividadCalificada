package Views;

import javax.swing.*;

public class HomeView extends JFrame {
    private JTabbedPane pestanas;

    public HomeView(JPanel registro, JPanel lista) {
        setTitle("Sistema de Invitados");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pestanas = new JTabbedPane();
        pestanas.addTab("Registro", registro);
        pestanas.addTab("Lista", lista);

        add(pestanas);
    }
}
