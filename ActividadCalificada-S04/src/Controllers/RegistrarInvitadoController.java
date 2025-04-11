package Controllers;

import Models.RegistroModel;
import Views.RegistrarInvitadoView;
import java.io.IOException;

public class RegistrarInvitadoController {
    private RegistroModel model;
    private RegistrarInvitadoView view;
    private ListaInvitadosController listaController;

    public RegistrarInvitadoController(RegistroModel model, RegistrarInvitadoView view,
                                       ListaInvitadosController listaController) {
        this.model = model;
        this.view = view;
        this.listaController = listaController;
        configurarEventos();
    }

    private void configurarEventos() {
        view.setRegistrarListener(e -> registrarInvitado());
        view.setResetearListener(e -> view.limpiarCampos());
    }

    private void registrarInvitado() {
        if (!view.aceptaTerminos()) {
            view.mostrarMensaje("Debe aceptar los términos y condiciones");
            return;
        }

        try {
            String datos = view.getNombre() + ";" +
                    view.getCelular() + ";" +
                    view.getGenero() + ";" +
                    view.getFechaNacimiento() + ";" +
                    view.getDireccion();

            model.guardarInvitado(datos);
            view.mostrarMensaje("Invitado registrado exitosamente!");
            view.limpiarCampos();
            listaController.actualizarTabla();
        } catch (IOException ex) {
            view.mostrarMensaje("Error al guardar: " + ex.getMessage());
        }
    }
}