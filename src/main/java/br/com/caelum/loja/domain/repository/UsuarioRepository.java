package br.com.caelum.loja.domain.repository;

import br.com.caelum.loja.model.Usuario;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by mauyr on 23/02/17.
 */
@Cacheable(value = "usuarios")
public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{

    UserDetails findByEmail(String email);
}
