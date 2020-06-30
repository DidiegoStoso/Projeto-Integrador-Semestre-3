package br.ifsc.slo.tecinfo.pi.projetointegrador.repositorio;

import br.ifsc.slo.tecinfo.pi.projetointegrador.model.Comida;
import org.springframework.data.repository.CrudRepository;

public interface ComidaRepositorio extends CrudRepository<Comida, Integer> {
    }
