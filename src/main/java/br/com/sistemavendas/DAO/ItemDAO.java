package br.com.sistemavendas.DAO;

import org.springframework.data.repository.CrudRepository;

import br.com.sistemavendas.model.Item;

public interface ItemDAO extends CrudRepository<Item, Long>{

}
