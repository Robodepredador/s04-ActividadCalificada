package Controllers;

import Models.ListaModel;
import Views.ListaInvitadosView;
import java.io.IOException;
import java.util.Collections;

public class ListaInvitadosController {
    private ListaModel model;
    private ListaInvitadosView view;

    public ListaInvitadosController(ListaModel model, ListaInvitadosView view) {
        this.model = model;
        this.view = view;
        actualizarTabla();
    }

    public void actualizarTabla() {
        try {
            view.actualizarTabla(model.cargarInvitados());
        } catch (IOException e) {
            view.actualizarTabla(Collections.emptyList());
        }
    }
}