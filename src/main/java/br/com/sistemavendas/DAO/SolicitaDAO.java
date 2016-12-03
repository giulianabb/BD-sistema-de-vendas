package br.com.sistemavendas.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.sistemavendas.DAOCustom.SolicitaDAOCustom;
import br.com.sistemavendas.model.Solicita;

@RepositoryRestResource
public interface SolicitaDAO extends CrudRepository<Solicita, Long>, SolicitaDAOCustom {

}
