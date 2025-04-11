package Models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListaModel {
    private static final String FILE = "invitados.txt";

    public List<String[]> cargarInvitados() throws IOException {
        List<String[]> invitados = new ArrayList<>();
        File file = new File(FILE);

        if (!file.exists()) return invitados;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                invitados.add(line.split(";"));
            }
        }
        return invitados;
    }
}