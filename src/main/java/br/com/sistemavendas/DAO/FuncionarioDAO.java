package br.com.sistemavendas.DAO;

import org.springframework.data.repository.CrudRepository;

import br.com.sistemavendas.model.Funcionario;

public interface FuncionarioDAO extends CrudRepository<Funcionario, Long>{

}
