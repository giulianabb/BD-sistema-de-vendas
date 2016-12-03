package br.com.sistemavendas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistemavendas.DAO.FuncionarioDAO;
import br.com.sistemavendas.DAO.ItemPedidoDAO;
import br.com.sistemavendas.DAO.PedidoDAO;
import br.com.sistemavendas.DAO.ServicoDAO;
import br.com.sistemavendas.model.Funcionario;
import br.com.sistemavendas.model.Item;
import br.com.sistemavendas.model.ItemPedido;
import br.com.sistemavendas.model.Pedido;
import br.com.sistemavendas.model.Servico;
import br.com.sistemavendas.type.Funcao;

@Service
public class PedidoService  {
	
	@Autowired
	private ItemPedidoDAO itemPedidoDAO;
	@Autowired
	private PedidoDAO pedidoDAO;
	@Autowired
	private FuncionarioDAO funcionarioDAO;
	@Autowired
	private ServicoDAO servicoDAO;
	
	public Double calcularPrecoTotal(Long pedidoId) {
		Double valorfinal = 0D;
		Pedido pedido = pedidoDAO.findOne(pedidoId);
		List<ItemPedido> itens = itemPedidoDAO.findByPedido(pedido);
		
		for(ItemPedido itemPedido : itens ) {
			Item item = itemPedido.getItem();
			valorfinal += item.getPreco() * itemPedido.getQuantidade();
		}
	
		return valorfinal;
	}
	
	public List<Servico> montaServicos(Long funcionario_atendimento, Long funcionario_cozinha, Long funcionario_entrega, Long pedidoId) {
		List<Long> ids = new ArrayList<Long>();
		ids.add(funcionario_atendimento);
		ids.add(funcionario_cozinha);
		ids.add(funcionario_entrega);
		Iterable<Funcionario> funcionarios = funcionarioDAO.findAll(ids);
		
		Pedido pedido = pedidoDAO.findOne(pedidoId);
		
		Funcao[] funcoes = Funcao.values();	
		Integer i = 0;
		
		List<Servico> servicos = new ArrayList<Servico>();
		
		for(Funcionario funcionario : funcionarios) {
			Servico servico = new Servico(null, pedido, funcionario, funcoes[i]);
			servicos.add(servico);
			i++;
		}
		
		servicos = (List<Servico>) servicoDAO.save(servicos);
		
		return servicos;
	}
	
}
