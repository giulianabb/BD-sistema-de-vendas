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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.sistemavendas.DAO.ItemPedidoDAO;
import br.com.sistemavendas.DAO.PagamentoDAO;
import br.com.sistemavendas.DAO.PedidoDAO;
import br.com.sistemavendas.container.ItemPedidoPorDia;
import br.com.sistemavendas.container.PedidoComCliente;
import br.com.sistemavendas.container.PedidosPorDia;
import br.com.sistemavendas.container.PedidosPorTorre;
import br.com.sistemavendas.model.Pagamento;
import br.com.sistemavendas.model.Pedido;
import br.com.sistemavendas.model.Solicita;
import br.com.sistemavendas.type.StatusPedido;

@Controller
@RequestMapping("/pedido/info")
public class AnalisePedidoController {

	@Autowired
	private PedidoDAO pedidoDAO;
	@Autowired
	private PagamentoDAO pagamentoDAO;
	@Autowired
	private ItemPedidoDAO itemPedidoDAO;
	
	// PEDIDOS ATIVOS
	
	@RequestMapping("/ativos")
	private String pedidosAtivos(Model model) {
		List<PedidoComCliente> ativos = pedidoDAO.findPedidosAtivos();
		model.addAttribute("ativos", ativos);
		StatusPedido[] status = StatusPedido.values();
		model.addAttribute("status", status);
		return "pedido/ativos";
	}
	
	@RequestMapping(value="/ativos/editar/{pedidoId}", method=RequestMethod.POST)
	private String atualizarStatus(@PathVariable Long pedidoId, @RequestParam StatusPedido statusNovo, Model model) {
		Pedido pedido = pedidoDAO.findOne(pedidoId);	
		pedido.setStatus(statusNovo.name());
		pedidoDAO.save(pedido);
		return "redirect:/pedido/info/ativos";
	}
	
	// DELETAR PEDIDO
	
	@RequestMapping(value="/{pagina}/{pedidoId}/deletar", method=RequestMethod.POST)
	private String deletarPedido(@PathVariable(value = "pedidoId") Long pedidoId, @PathVariable String pagina, Model model) {
		pedidoDAO.delete(pedidoId);
		if(pagina.equals("todos")) {
			return "redirect:/pedido/info/todos";
		}
		return "redirect:/pedido/info/ativos";
	}
	
	// TODOS
	
	@RequestMapping("/todos")
	private String todosPedidos(Model model) {
		List<Pedido> todos = (List<Pedido>) pedidoDAO.findAll();
		model.addAttribute("todos", todos);
		return "pedido/todos";
	}
	
	// PEDIDOS NÃO PAGOS
	
	@RequestMapping("/nao-pagos")
	private String pedidosNaoPagos(Model model) {
		List<Solicita> naoPagos = (List<Solicita>) pedidoDAO.findPedidosNaoPagos();
		model.addAttribute("naoPagos", naoPagos);
		return "pedido/semPagar";
	}
	
	@RequestMapping(value="/nao-pagos/editar/{pagamentoId}", method=RequestMethod.POST)
	private String salvarComoPago(@PathVariable(value="pagamentoId") Long pagamentoId, Model model) {
		Pagamento pagamento = pagamentoDAO.findOne(pagamentoId);
		pagamento.setEfetuado(true);
		pagamento.setDataPagamento(new Date());
		pagamentoDAO.save(pagamento);
		return "redirect:/pedido/info/nao-pagos";
	}
	
	// PEDIDOS POR TORRE
	@RequestMapping("/por/torre")
	private String pedidosPorTorre(Model model) {
		List<PedidosPorTorre> pedidos = pedidoDAO.findPedidosPorTorre();
		model.addAttribute("pedidos", pedidos);
		return "pedido/porTorre";
	}
	
	// PEDIDOS POR DIA
	@RequestMapping("/por/dia")
	private String pedidosPorDiaDaSemana(Model model) {
		List<PedidosPorDia> pedidos = pedidoDAO.findPedidosPorDiaDaSemana();
		model.addAttribute("pedidos", pedidos);
		return "pedido/porDia";
	}
	
	// FECHAMENTO DO DIA
	@RequestMapping("/fechamento/dia")
	private String fechamentoDoDia(@RequestParam(required=false) Date dia, Model model) {
		if(dia==null) {
			dia = new Date();
		}
		List<ItemPedidoPorDia> itensPedidos = itemPedidoDAO.findItensPedidosPorDia(dia);
		model.addAttribute("dia", dia);
		model.addAttribute("itensPedidos", itensPedidos);
		return "pedido/fechamentoPorDia";
	}
	
	// INIT BINDER PARA FORMATAR A DATA RECEBIDA
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
}
