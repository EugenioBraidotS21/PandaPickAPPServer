package com.pandapickapp.presenter;

import com.pandapickapp.model.TimeModel;
import com.pandapickapp.view.TimeView;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

public class TimePresenter implements HttpHandler {
    private final TimeModel model;
    private final TimeView view;

    public TimePresenter(TimeModel model, TimeView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        try {
            if (!"GET".equalsIgnoreCase(exchange.getRequestMethod())) {
                view.renderMethodNotAllowed(exchange);
                return;
            }

            String currentDateTime = model.getCurrentFormattedTime();
            view.renderSuccess(exchange, currentDateTime);
        } catch (Exception e) {
            view.renderError(exchange, e.getMessage());
        }
    }
}