package br.com.sistemavendas.DAO;

import org.springframework.data.repository.CrudRepository;

import br.com.sistemavendas.model.Servico;

public interface ServicoDAO extends CrudRepository<Servico, Long> {

}
