package br.com.sistemavendas.DAOCustom;

import java.util.Date;
import java.util.List;

import br.com.sistemavendas.container.ItemPedidoPorDia;

public interface ItemPedidoDAOCustom {
	
	List<ItemPedidoPorDia> findItensPedidosPorDia(Date date);
	
}
