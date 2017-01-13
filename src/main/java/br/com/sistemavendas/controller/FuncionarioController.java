package br.com.sistemavendas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.sistemavendas.DAO.FuncionarioDAO;
import br.com.sistemavendas.model.Funcionario;

@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {
	@Autowired
	private FuncionarioDAO funcionarioDAO;

	@RequestMapping("/novo")
	private String criarFuncionario(Model model) {
		return "funcionario/criar";
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	private String salvarFuncionario(@ModelAttribute Funcionario funcionario,  @RequestParam(required=false) Long id, Model model) {
		if(id!=null) {
			funcionario.setId(id);
		}
		funcionario = funcionarioDAO.save(funcionario);
		return "redirect:/funcionario/sucesso";
	}

	@RequestMapping("/sucesso")
	private String sucessoFuncionario(Model model) {
		return "funcionario/dados";
	}
	
	@RequestMapping("/todos")
	private String mostrarTodosClientes(Model model) {
		Iterable<Funcionario> funcionarios = funcionarioDAO.findAll();
		model.addAttribute("funcionarios", funcionarios);
		return "funcionario/todos";
	}

	@RequestMapping("/editar/{id}")
	private String editarFuncionario(Model model, @PathVariable("id") Long id) {
		Funcionario funcionario = funcionarioDAO.findOne(id);
		model.addAttribute("funcionario", funcionario);
		return "funcionario/editar";
	}
	
	@RequestMapping(value="/deletar/{id}", method=RequestMethod.POST)
	private String deletarFuncionario(Model model, @PathVariable("id") Long id) {
		funcionarioDAO.delete(id);
		return "redirect:/funcionario/todos";
	}
	
}
