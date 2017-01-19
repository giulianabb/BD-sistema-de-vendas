package br.com.sistemavendas.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.sistemavendas.DAOCustom.ItemDAOCustom;
import br.com.sistemavendas.model.Item;

public interface ItemDAO extends CrudRepository<Item, Long>, ItemDAOCustom{
	
	public List<Item> findAllByOrderByNome();
}
