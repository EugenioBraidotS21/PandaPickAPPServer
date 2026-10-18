package com.pandapickapp.view;

import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;

public interface TimeView {
    void renderSuccess(HttpExchange exchange, String formattedTime) throws IOException;
    void renderMethodNotAllowed(HttpExchange exchange) throws IOException;
    void renderError(HttpExchange exchange, String message) throws IOException;
}