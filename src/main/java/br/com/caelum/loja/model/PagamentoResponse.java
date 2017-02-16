package br.com.caelum.loja.model;

import org.springframework.http.HttpStatus;

/**
 * Created by mauyr on 16/02/17.
 */
public class PagamentoResponse {
    private HttpStatus status;
    private String message;

    public PagamentoResponse(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
