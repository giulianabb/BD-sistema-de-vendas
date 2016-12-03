package br.com.sistemavendas.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.sistemavendas.DAOCustom.ClienteDAOCustom;
import br.com.sistemavendas.model.Cliente;

@RepositoryRestResource
public interface ClienteDAO extends CrudRepository<Cliente, Long>, ClienteDAOCustom {

}


