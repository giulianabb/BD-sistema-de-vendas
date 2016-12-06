package br.com.sistemavendas.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.sistemavendas.DAO.ClienteDAO;
import br.com.sistemavendas.DAO.FuncionarioDAO;
import br.com.sistemavendas.DAO.ItemDAO;
import br.com.sistemavendas.DAO.ItemPedidoDAO;
import br.com.sistemavendas.DAO.PagamentoDAO;
import br.com.sistemavendas.DAO.PedidoDAO;
import br.com.sistemavendas.DAO.SolicitaDAO;
import br.com.sistemavendas.model.Cliente;
import br.com.sistemavendas.model.Funcionario;
import br.com.sistemavendas.model.ItemPedido;
import br.com.sistemavendas.model.Pagamento;
import br.com.sistemavendas.model.Pedido;
import br.com.sistemavendas.model.Solicita;
import br.com.sistemavendas.service.PedidoService;
import br.com.sistemavendas.type.DiaDaSemana;
import br.com.sistemavendas.type.Funcao;
import br.com.sistemavendas.type.MeioDeContato;
import br.com.sistemavendas.type.StatusPedido;
import br.com.sistemavendas.type.TipoPagamento;

@Controller
@RequestMapping("/pedido")
public class CriarPedidoController {
	
	@Autowired
	private ClienteDAO clienteDAO;
	@Autowired
	private FuncionarioDAO funcionarioDAO;
	@Autowired
	private ItemPedidoDAO itemPedidoDAO;
	@Autowired
	private ItemDAO itemDAO;
	@Autowired
	private PedidoDAO pedidoDAO;
	@Autowired
	private PagamentoDAO pagamentoDAO;
	@Autowired
	private SolicitaDAO solicitaDAO;
	@Autowired
	private PedidoService pedidoService;
	
	// CRIAÇÃO DE PEDIDO
	
	@RequestMapping("/novo")
	private String novoPedido(Model model) {
		model.addAttribute("diasSemana", DiaDaSemana.values());
		model.addAttribute("statusPedido", StatusPedido.values());
		model.addAttribute("meiosContato", MeioDeContato.values());
		return "pedido/criar";
	}
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	private String salvarPedido(@ModelAttribute Pedido pedido,  @RequestParam(required=false) Long id, Model model) {
		if(id!=null) {
			pedido.setId(id);
		}
		pedido = pedidoDAO.save(pedido);
		
		model.addAttribute("itens", itemDAO.findAll());
		model.addAttribute("pedidoId", pedido.getId());
		return "pedido/adicionarItem";
	}
	
	// ADICIONAR ITENS
	
	@RequestMapping("/{pedidoId}/novo/item")
	private String adicionarItem(@PathVariable("pedidoId") Long pedidoId, Model model) {
		model.addAttribute("itens", itemDAO.findAll());
		model.addAttribute("pedidoId", pedidoId);
		return "pedido/adicionarItem";
	}
	
	@RequestMapping(value = "/{pedidoId}/salvar/item", method = RequestMethod.POST)
	private String salvarItem(@PathVariable("pedidoId") Long pedidoId, @ModelAttribute ItemPedido itemPedido, Model model) {
		Pedido pedido = pedidoDAO.findOne(pedidoId);
		itemPedido.setPedido(pedido);
		
		itemPedido = itemPedidoDAO.save(itemPedido);
		
		List<ItemPedido> itensPedidos = itemPedidoDAO.findByPedido(pedido);
		model.addAttribute("itensPedidos", itensPedidos);
		model.addAttribute("pedido", pedido);
		return "pedido/situacaoAtual";
	}
	
	@RequestMapping("/{pedidoId}/editar/{itemPedidoId}")
	private String editarItem(@PathVariable(value = "itemPedidoId") Long itemPedidoId, 
			@PathVariable(value = "pedidoId") Long pedidoId, Model model) {
		ItemPedido item = itemPedidoDAO.findOne(itemPedidoId);

		model.addAttribute("itens", itemDAO.findAll());
		model.addAttribute("itemPedido", item);
		model.addAttribute("pedidoId", pedidoId);
		return "pedido/editarItem";
	}
	
	@RequestMapping("/{pedidoId}/deletar/item/{itemPedidoId}")
	private String deletarItem(@PathVariable(value="itemPedidoId") Long itemPedidoId, 
			@PathVariable(value = "pedidoId") Long pedidoId, Model model) {
		itemPedidoDAO.delete(itemPedidoId);
		
		Pedido pedido = pedidoDAO.findOne(pedidoId);
		model.addAttribute("pedido", pedido);
		List<ItemPedido> itensPedidos = itemPedidoDAO.findByPedido(pedido);
		model.addAttribute("itensPedidos", itensPedidos);
		return "pedido/situacaoAtual";
	}
	
	// PAGAMENTO
	
	@RequestMapping("/{pedidoId}/pagamento/dados")
	private String avancarParaPagamento(@PathVariable(value = "pedidoId") Long pedidoId, Model model) {
		
		model.addAttribute("pedidoId", pedidoId);
		model.addAttribute("tipoPagamento", TipoPagamento.values());
		
		Iterable<Cliente> clientes = clienteDAO.findAll();
		model.addAttribute("clientes", clientes);
		
		Double precofinal = pedidoService.calcularPrecoTotal(pedidoId);
		model.addAttribute("precoFinal", precofinal);
		
		return "pedido/pagamento";
	}

	
	@RequestMapping(value="/{pedidoId}/pagamento/salvar", method = RequestMethod.POST)
	private String salvarPagamento(@PathVariable(value = "pedidoId") Long pedidoId,
			@RequestParam Boolean efetuado, @RequestParam Long clienteId, 
			@RequestParam TipoPagamento tipo, @RequestParam Double valor,
			@RequestParam(required=false) Date dataPagamento, Model model) {
		
		Pedido pedido = pedidoDAO.findOne(pedidoId);
		Cliente cliente = clienteDAO.findOne(clienteId);
		
		if(!efetuado) {
			dataPagamento = null;
		} else if(efetuado && dataPagamento==null) {
			dataPagamento = new Date();
		}
		
		Pagamento pagamento = new Pagamento(null, tipo, valor, efetuado, dataPagamento);
		
		pagamento = pagamentoDAO.save(pagamento);
		
		Solicita solicita = new Solicita(null, pedido, cliente, pagamento);
		solicita = solicitaDAO.save(solicita);
		
		Iterable<Funcionario> funcionarios = funcionarioDAO.findAll();
		model.addAttribute("funcionarios", funcionarios);
		model.addAttribute("funcoes", Funcao.values());
		
		return "pedido/funcionarios";
	}
	
	// ADICIONA SERVIÇO
	
	@RequestMapping(value="/{pedidoId}/servico", method = RequestMethod.POST)
	private String adicionarServico(@PathVariable(value = "pedidoId") Long pedidoId,
			@RequestParam Long funcionario_atendimento, @RequestParam Long funcionario_cozinha,
			@RequestParam Long funcionario_entrega, Model model) {
		
		pedidoService.montaServicos(funcionario_atendimento, funcionario_cozinha, funcionario_entrega, pedidoId);
		return "pedido/fim";
	}
	
}