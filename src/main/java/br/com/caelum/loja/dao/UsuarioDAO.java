package br.com.caelum.loja.dao;

import br.com.caelum.loja.model.Usuario;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mauyr on 10/02/17.
 */
@Repository
public class UsuarioDAO extends GenericDao<Usuario, Integer> implements UserDetailsService {

    public UsuarioDAO() {
        super(Usuario.class);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        List<Usuario> usuarios = entityManager.createQuery("select u from Usuario where u.email = :email", Usuario.class)
                .setParameter("email", email).getResultList();

        if (usuarios.isEmpty()) {
            throw new UsernameNotFoundException("O usuário " + email + " não foi encontrado");
        }

        return usuarios.get(0);
    }

}
