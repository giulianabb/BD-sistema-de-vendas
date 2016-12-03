package br.com.sistemavendas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.sistemavendas.DAO.ClienteDAO;
import br.com.sistemavendas.DAO.FuncionarioDAO;
import br.com.sistemavendas.DAO.ItemDAO;
import br.com.sistemavendas.DAO.ItemPedidoDAO;
import br.com.sistemavendas.DAO.PedidoDAO;
import br.com.sistemavendas.model.ItemPedido;
import br.com.sistemavendas.model.Pedido;
import br.com.sistemavendas.type.DiaDaSemana;
import br.com.sistemavendas.type.MeioDeContato;
import br.com.sistemavendas.type.StatusPedido;

@Controller
@RequestMapping("/pedido")
public class PedidoController {
	
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
		model.addAttribute("pedido", pedido);
		return "pedido/adicionarItem";
	}
	
	@RequestMapping(value = "/adicionar/item", method = RequestMethod.POST)
	private String adicionarItem(@RequestParam Integer pedidoId, @ModelAttribute ItemPedido itemPedido, Model model) {
		Pedido pedido = pedidoDAO.findOne(pedidoId.longValue());
		itemPedido.setPedido(pedido);
		
		itemPedido = itemPedidoDAO.save(itemPedido);
		
		List<ItemPedido> itensPedidos = itemPedidoDAO.findByPedido(pedido);
		model.addAttribute("itensPedidos", itensPedidos);
		model.addAttribute("pedido", pedido);
		return "pedido/situacaoAtual";
	}

}
