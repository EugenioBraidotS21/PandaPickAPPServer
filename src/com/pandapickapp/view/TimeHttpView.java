package com.pandapickapp.view;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class TimeHttpView implements TimeView {

    @Override
    public void renderSuccess(HttpExchange exchange, String formattedTime) throws IOException {
        String json = "{\"serverHs\": \"" + formattedTime + "\"}";
        sendResponse(exchange, 200, json);
    }

    @Override
    public void renderMethodNotAllowed(HttpExchange exchange) throws IOException {
        String json = "{\"error\": \"Metodo no permitido. Solo se acepta GET\"}";
        sendResponse(exchange, 405, json);
    }

    @Override
    public void renderError(HttpExchange exchange, String message) throws IOException {
        String json = "{\"error\": \"" + message + "\"}";
        sendResponse(exchange, 500, json);
    }

    private void sendResponse(HttpExchange exchange, int statusCode, String responseBody) throws IOException {
        byte[] bytes = responseBody.getBytes(StandardCharsets.UTF_8);
        Headers headers = exchange.getResponseHeaders();
        headers.set("Content-Type", "application/json; charset=UTF-8");
        
        exchange.sendResponseHeaders(statusCode, bytes.length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(bytes);
        }
    }
}
