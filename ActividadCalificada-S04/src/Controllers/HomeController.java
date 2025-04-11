package Controllers;

import Models.*;
import Views.*;

public class HomeController {
    public HomeController() {
        // 1. Crear modelos
        RegistroModel registroModel = new RegistroModel();
        ListaModel listaModel = new ListaModel();

        // 2. Crear vistas
        RegistrarInvitadoView registroView = new RegistrarInvitadoView();
        ListaInvitadosView listaView = new ListaInvitadosView();
        HomeView homeView = new HomeView(registroView, listaView);

        // 3. Crear controladores
        ListaInvitadosController listaController = new ListaInvitadosController(listaModel, listaView);
        new RegistrarInvitadoController(registroModel, registroView, listaController);

        // 4. Mostrar ventana principal
        homeView.setVisible(true);
    }
}