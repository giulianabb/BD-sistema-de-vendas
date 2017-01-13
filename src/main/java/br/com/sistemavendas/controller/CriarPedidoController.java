package br.com.sistemavendas.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
		return "redirect:/pedido/" + pedido.getId() + "/novo/item";
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
		
		return "redirect:/pedido/" + pedidoId + "/status";
	}
	
	@RequestMapping(value="/{pedidoId}/status")
	private String statusPedido(@PathVariable("pedidoId") Long pedidoId, Model model) {
		List<ItemPedido> itensPedidos = itemPedidoDAO.findByPedidoId(pedidoId);
		model.addAttribute("itensPedidos", itensPedidos);
		model.addAttribute("pedidoId", pedidoId);
		
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
	
	@RequestMapping(value="/{pedidoId}/deletar/item/{itemPedidoId}", method=RequestMethod.POST)
	private String deletarItem(@PathVariable(value="itemPedidoId") Long itemPedidoId, 
			@PathVariable(value = "pedidoId") Long pedidoId, Model model) {
		itemPedidoDAO.delete(itemPedidoId);
		return "redirect:/pedido/" + pedidoId + "/status";
	}
	
	// PAGAMENTO
	
	@RequestMapping("/{pedidoId}/pagamento/dados")
	private String avancarParaPagamento(@PathVariable(value = "pedidoId") Long pedidoId, Model model) {
		
		model.addAttribute("pedidoId", pedidoId);
		model.addAttribute("tipoPagamento", TipoPagamento.values());
		
		Iterable<Cliente> clientes = clienteDAO.findAllOrderByTorreAndAptAsc();
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
		
		return "redirect:/pedido/" + pedidoId + "/servico";
	}
	
	// ADICIONA SERVIÇO
	
	@RequestMapping(value="/{pedidoId}/servico")
	private String mostrarServico(Model model, @PathVariable(value="pedidoId") Long pedidoId) {
		Iterable<Funcionario> funcionarios = funcionarioDAO.findAll();
		model.addAttribute("funcionarios", funcionarios);
		model.addAttribute("funcoes", Funcao.values());
		model.addAttribute("pedidoId", pedidoId);
		
		return "pedido/funcionarios";
	}
	
	
	@RequestMapping(value="/{pedidoId}/servico/salvar", method = RequestMethod.POST)
	private String adicionarServico(@PathVariable(value = "pedidoId") Long pedidoId,
			@RequestParam Long funcionario_atendimento, @RequestParam Long funcionario_cozinha,
			@RequestParam Long funcionario_entrega, Model model) {
		pedidoService.montaServicos(funcionario_atendimento, funcionario_cozinha, funcionario_entrega, pedidoId);
		return "redirect:/pedido/sucesso";
	}
	
	@RequestMapping("/sucesso")
	private String sucessoPedido(Model model) {
		return "pedido/fim";
	}
	
	
	// INIT BINDER PARA FORMATAR A DATA RECEBIDA
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
}
