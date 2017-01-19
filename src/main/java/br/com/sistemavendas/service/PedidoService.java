package br.com.sistemavendas.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistemavendas.DAO.FuncionarioDAO;
import br.com.sistemavendas.DAO.ItemPedidoDAO;
import br.com.sistemavendas.DAO.PedidoDAO;
import br.com.sistemavendas.DAO.ServicoDAO;
import br.com.sistemavendas.DAO.SolicitaDAO;
import br.com.sistemavendas.container.HistoricoPedidos;
import br.com.sistemavendas.model.Cliente;
import br.com.sistemavendas.model.Funcionario;
import br.com.sistemavendas.model.Item;
import br.com.sistemavendas.model.ItemPedido;
import br.com.sistemavendas.model.Pedido;
import br.com.sistemavendas.model.Servico;
import br.com.sistemavendas.model.Solicita;
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
	@Autowired
	private SolicitaDAO solicitaDAO;
	
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
		List<Funcionario> funcionarios = (List<Funcionario>) funcionarioDAO.findAll(ids);
		
		HashMap<Integer, Funcionario> responsaveis = new HashMap<>();
		for(Funcionario funcionario : funcionarios) {
			if(funcionario.getId() == funcionario_atendimento) {
				responsaveis.put(0, funcionario);
			}
			if(funcionario.getId() == funcionario_cozinha) {
				responsaveis.put(1, funcionario);
			}
			if(funcionario.getId() == funcionario_entrega) {
				responsaveis.put(2, funcionario);
			}
		}
		
		Pedido pedido = pedidoDAO.findOne(pedidoId);
		
		Funcao[] funcoes = Funcao.values();	
		Integer i = 0;
		List<Servico> servicos = new ArrayList<Servico>();
		
		for(i = 0; i < 3; i++) {
			Servico servico = new Servico(null, pedido, responsaveis.get(i), funcoes[i]);
			servicos.add(servico);
		}
		
		servicos = (List<Servico>) servicoDAO.save(servicos);
		
		return servicos;
	}
	
	public HistoricoPedidos montaHistoricoCliente(Long clienteId) {
		List<Solicita> solicitacoes = solicitaDAO.findByClienteIdOrderByPedidoDataDesc(clienteId);
		if(solicitacoes.isEmpty()) {
			return null;
		}
		Cliente cliente = solicitacoes.get(0).getCliente();
		List<Long> pedidosId = new ArrayList<>();
		Pedido pedido;
		for(Solicita solicita : solicitacoes) {
			if((pedido = solicita.getPedido()) != null) {
				pedidosId.add(pedido.getId());
			}
		}
		
		List<ItemPedido> itensPedidosMisturados = itemPedidoDAO.findByPedidoIdIn(pedidosId);
		Map<Long, List<ItemPedido>> itensPedidos = separarPorPedido(itensPedidosMisturados);
		
		HistoricoPedidos historico = new HistoricoPedidos(cliente, solicitacoes, itensPedidos);
		return historico;
	}
	
	private Map<Long, List<ItemPedido>> separarPorPedido(List<ItemPedido> itensPedidos) {
		Map<Long, List<ItemPedido>> mapeamento = new HashMap<Long, List<ItemPedido>>();
		for(ItemPedido itemPedido : itensPedidos) {
			Pedido pedido = itemPedido.getPedido();
			List<ItemPedido> itens ;
			if(mapeamento.containsKey(pedido.getId())) {
				itens = mapeamento.get(pedido.getId());
			} else {
				itens = new ArrayList<ItemPedido>();
			}
			itens.add(itemPedido);
			mapeamento.put(pedido.getId(), itens);
		}
		return mapeamento;
	}
	
}
