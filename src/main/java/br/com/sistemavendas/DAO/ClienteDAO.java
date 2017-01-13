package br.com.sistemavendas.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.sistemavendas.DAOCustom.ClienteDAOCustom;
import br.com.sistemavendas.model.Cliente;

@RepositoryRestResource
public interface ClienteDAO extends CrudRepository<Cliente, Long>, ClienteDAOCustom {
	
	@Query(value="select c from Cliente c order by torre, apartamento asc")
	public List<Cliente> findAllOrderByTorreAndAptAsc();
	
}


