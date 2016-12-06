package br.com.sistemavendas.DAOCustom;

import java.util.List;

import br.com.sistemavendas.container.ItemVendido;

public interface ItemDAOCustom {

	public List<ItemVendido> findItensMaisVendidos();
}
