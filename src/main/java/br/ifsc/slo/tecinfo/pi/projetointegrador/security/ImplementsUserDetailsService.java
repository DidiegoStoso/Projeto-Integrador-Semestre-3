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
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.awt.image.BandCombineOp;
import java.util.ArrayList;
import java.util.List;

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

    public Garcom save(Garcom waiter){
        Garcom garcom = new Garcom();
        garcom.setCpf(waiter.getCpf());
        garcom.setNome(waiter.getNome());
        garcom.setEmail(waiter.getEmail());
        garcom.setLogin(waiter.getLogin());
        garcom.setSenha(new BCryptPasswordEncoder().encode(waiter.getPassword()));
        List<Role> roles = new ArrayList<>();
        roles.add(new Role("ROLE_GARCOM"));
        garcom.setRoles(roles);
        return ur.save(garcom);
    }
}
