package br.ifsc.slo.tecinfo.pi.projetointegrador.repositorio;

import br.ifsc.slo.tecinfo.pi.projetointegrador.model.Garcom;
import org.springframework.data.repository.CrudRepository;

public interface GarcomRepositorio extends CrudRepository<Garcom, Integer> {
    Garcom findByLogin(String login);
}
