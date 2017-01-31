package br.com.caelum.loja.util;

import org.springframework.http.HttpStatus;

/**
 * Created by mauyr on 31/01/17.
 */
public enum Messages {
    ITEM_SAVED(HttpStatus.OK, "$1 cadastro com sucesso");

    private HttpStatus httpStatus;
    private String message;

    Messages(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public String getMessage(String... args) {
        return args.length > 0 ? String.format(this.message, args) : this.message;
    }
}
