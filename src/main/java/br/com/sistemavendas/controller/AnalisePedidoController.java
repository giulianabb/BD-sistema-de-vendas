package br.com.sistemavendas.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.sistemavendas.DAO.PagamentoDAO;
import br.com.sistemavendas.DAO.PedidoDAO;
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
	
	// PEDIDOS ATIVOS
	
	@RequestMapping("/ativos")
	private String pedidosAtivos(Model model) {
		List<Pedido> ativos = pedidoDAO.findPedidosAtivos();
		model.addAttribute("ativos", ativos);
		StatusPedido[] status = StatusPedido.values();
		model.addAttribute("status", status);
		return "pedido/ativos";
	}
	
	@RequestMapping("/ativos/editar/{pedidoId}")
	private String atualizarStatus(@PathVariable Long pedidoId, @RequestParam StatusPedido statusNovo, Model model) {
		Pedido pedidoAlterado = null;
		List<Pedido> ativos = pedidoDAO.findPedidosAtivos();
		for(Pedido pedido : ativos) {
			if(pedido.getId()==pedidoId) {
				pedidoAlterado = pedido;
				pedido.setStatus(statusNovo.name());
				pedidoDAO.save(pedido);
			}
		}
		
		if(pedidoAlterado!=null && statusNovo.equals(StatusPedido.finalizado)) {
			ativos.remove(pedidoAlterado);
		}
		
		model.addAttribute("ativos", ativos);
		StatusPedido[] status = StatusPedido.values();
		model.addAttribute("status", status);
		return "pedido/ativos";
	}
	
	// DELETAR PEDIDO - TODO deletar itensPedidos?
	@RequestMapping(value="/{pagina}/{pedidoId}/deletar")
	private String deletarPedido(@PathVariable(value = "pedidoId") Long pedidoId, @PathVariable String pagina, Model model) {
		pedidoDAO.delete(pedidoId);
		StatusPedido[] status = StatusPedido.values();
		model.addAttribute("status", status);
		if(pagina.equals("todos")) {
			List<Pedido> todos = (List<Pedido>) pedidoDAO.findAll();
			model.addAttribute("todos", todos);
			return "pedido/todos";
		}
		List<Pedido> ativos = pedidoDAO.findPedidosAtivos();
		model.addAttribute("ativos", ativos);
		return "pedido/ativos";
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
	
	@RequestMapping("/nao-pagos/editar/{pagamentoId}")
	private String salvarComoPago(@PathVariable(value="pagamentoId") Long pagamentoId, Model model) {
		Pagamento pagamento = pagamentoDAO.findOne(pagamentoId);
		pagamento.setEfetuado(true);
		pagamento.setDataPagamento(new Date());
		
		pagamentoDAO.save(pagamento);
		
		List<Solicita> naoPagos = (List<Solicita>) pedidoDAO.findPedidosNaoPagos();
		model.addAttribute("naoPagos", naoPagos);
		return "pedido/semPagar";
	}
	
	// PEDIDOS POR TORRE
	@RequestMapping("/por/torre")
	private String pedidosPorTorre(Model model) {
		List<PedidosPorTorre> pedidos = pedidoDAO.findPedidosPorTorre();
		model.addAttribute("pedidos", pedidos);
		return "pedido/porTorre";
	}
}
