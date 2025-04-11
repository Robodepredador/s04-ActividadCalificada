package Models;

import java.io.*;

public class RegistroModel {
    private static final String FILE = "invitados.txt";

    public void guardarInvitado(String datos) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE, true))) {
            writer.write(datos);
            writer.newLine();
        }
    }
}