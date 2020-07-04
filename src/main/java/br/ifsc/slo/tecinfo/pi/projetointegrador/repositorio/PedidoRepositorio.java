package br.ifsc.slo.tecinfo.pi.projetointegrador.repositorio;

import br.ifsc.slo.tecinfo.pi.projetointegrador.model.Pedido;
import org.springframework.data.repository.CrudRepository;

public interface PedidoRepositorio extends CrudRepository<Pedido, Integer> {
}
