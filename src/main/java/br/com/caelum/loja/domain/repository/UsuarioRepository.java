package br.com.caelum.loja.domain.repository;

import br.com.caelum.loja.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by mauyr on 23/02/17.
 */
public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{

    UserDetails findByEmail(String email);
}
