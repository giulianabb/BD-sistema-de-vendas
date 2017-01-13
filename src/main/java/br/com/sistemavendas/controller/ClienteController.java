package br.com.sistemavendas.controller;

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
import br.com.sistemavendas.container.GastoPorCliente;
import br.com.sistemavendas.model.Cliente;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteDAO clienteDAO;

	@RequestMapping("/novo")
	private String criarCliente(Model model) {
		return "cliente/criar";
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	private String salvarCliente(@ModelAttribute Cliente cliente,  @RequestParam(required=false) Long id, Model model) {
		if(id!=null) {
			cliente.setId(id);
		}
		cliente = clienteDAO.save(cliente);
		return "redirect:/cliente/sucesso";
	}
	
	@RequestMapping("/sucesso")
	private String sucessoCliente(Model model) {
		return "cliente/dados";
	}
	

	@RequestMapping("/todos")
	private String mostrarTodosClientes(Model model) {
		Iterable<Cliente> clientes = clienteDAO.findAll();
		model.addAttribute("clientes", clientes);
		return "cliente/todos";
	}

	@RequestMapping("/editar/{id}")
	private String editarCliente(Model model, @PathVariable("id") Long id) {
		Cliente cliente = clienteDAO.findOne(id);
		model.addAttribute("cliente", cliente);
		return "cliente/editar";
	}
	
	@RequestMapping(value="/deletar/{id}", method=RequestMethod.POST)
	private String deletarCliente(Model model, @PathVariable("id") Long id) {
		clienteDAO.delete(id);
		return "redirect:/cliente/todos";
	}

	// GASTOS POR CLIENTE
	@RequestMapping("/gastos")
	private String gastosPorCliente(Model model) {
		List<GastoPorCliente> clientes = clienteDAO.findGastosPorCliente();
		model.addAttribute("clientes", clientes);
		return "cliente/gastos";
	}
	
}
