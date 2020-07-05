package br.ifsc.slo.tecinfo.pi.projetointegrador.security;

import br.ifsc.slo.tecinfo.pi.projetointegrador.model.Garcom;
import br.ifsc.slo.tecinfo.pi.projetointegrador.model.Role;
import br.ifsc.slo.tecinfo.pi.projetointegrador.repositorio.GarcomRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ImplementsUserDetailsService implements UserDetailsService {

    @Autowired
    private GarcomRepositorio ur;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Garcom garcom =ur.findByLogin(login);

        if(garcom == null){
            throw new UsernameNotFoundException("Garçom não encontrado");
        }
        return new User(garcom.getLogin(), garcom.getSenha(), true, true, true, true, garcom.getAuthorities());
    }

}
