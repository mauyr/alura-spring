package br.com.caelum.loja.conf;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.Locale;

/**
 * Created by mauyr on 06/02/17.
 */
public class JsonViewResolver implements ViewResolver {

    @Override
    public View resolveViewName(String arg0, Locale arg1) throws Exception {
        MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
        jsonView.setPrettyPrint(true);
        return jsonView;
    }
}
