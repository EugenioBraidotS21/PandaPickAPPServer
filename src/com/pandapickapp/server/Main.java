package com.pandapickapp.server;
import com.pandapickapp.model.*;
import com.pandapickapp.presenter.TimePresenter;
import com.pandapickapp.view.*;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) {
        int port = 8080;

        try {
            // Instanciar componentes MVP
            TimeModel model = new TimeModel();
            TimeView view = new TimeHttpView();
            TimePresenter presenter = new TimePresenter(model, view);

            // Crear servidor HTTP en localhost:8080
            HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

            // Registrar el endpoint /hourFromServer atendido por el Presenter
            server.createContext("/hourFromServer", presenter);
            server.setExecutor(null); // Usa el ejecutor predeterminado

            server.start();
            System.out.println("Servidor iniciado en http://localhost:" + port + "/hourFromServer");

        } catch (IOException e) {
            System.err.println("Fallo al iniciar el servidor: " + e.getMessage());
        }
    }
}