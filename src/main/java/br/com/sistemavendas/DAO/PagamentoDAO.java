package br.com.sistemavendas.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import br.com.sistemavendas.model.Pagamento;

@RepositoryRestResource
public interface PagamentoDAO extends CrudRepository<Pagamento, Long>{

}
