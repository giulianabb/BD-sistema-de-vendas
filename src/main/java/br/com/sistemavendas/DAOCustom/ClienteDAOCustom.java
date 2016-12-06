package br.com.sistemavendas.DAOCustom;

import java.util.List;

import br.com.sistemavendas.container.GastoPorCliente;

public interface ClienteDAOCustom {
	
	List<GastoPorCliente> findGastosPorCliente();
}
