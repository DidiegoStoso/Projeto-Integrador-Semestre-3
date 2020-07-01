package br.ifsc.slo.tecinfo.pi.projetointegrador.repositorio;

import br.ifsc.slo.tecinfo.pi.projetointegrador.model.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepositorio extends CrudRepository<Item, Integer> {
    }
