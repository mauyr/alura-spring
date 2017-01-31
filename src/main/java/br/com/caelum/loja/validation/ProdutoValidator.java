package br.com.caelum.loja.validation;

import br.com.caelum.loja.model.Produto;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by mauyr on 31/01/17.
 */
public class ProdutoValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Produto.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "titulo", "field.required");
        ValidationUtils.rejectIfEmpty(errors, "descricao", "field.required");

        Produto produto = (Produto) o;
        if(produto.getPaginas() <= 0){
            errors.rejectValue("paginas", "field.required");
        }
    }
}
