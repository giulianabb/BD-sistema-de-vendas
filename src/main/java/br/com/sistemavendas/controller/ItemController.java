package br.com.sistemavendas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.sistemavendas.DAO.ItemDAO;
import br.com.sistemavendas.model.Item;

@Controller
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemDAO itemDAO;	
	
	@RequestMapping("/novo")
	private String criarItem(Model model) {
		return "item/criar";
	}
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	private String salvarItem(@ModelAttribute Item item,  @RequestParam(required=false) Long id, Model model) {
		if(id!=null) {
			item.setId(id);
		}
		item = itemDAO.save(item);
		return "item/dados";
	}

	@RequestMapping("/todos")
	private String mostrarTodosItens(Model model) {
		Iterable<Item> itens = itemDAO.findAll();
		model.addAttribute("itens", itens);
		return "item/todos";
	}

	@RequestMapping("/editar/{id}")
	private String editarItem(Model model, @PathVariable("id") Long id) {
		Item item = itemDAO.findOne(id);
		model.addAttribute("item", item);
		return "item/editar";
	}
	
	@RequestMapping("/deletar/{id}")
	private String deletarItem(Model model, @PathVariable("id") Long id) {
		itemDAO.delete(id);
		Iterable<Item> itens = itemDAO.findAll();
		model.addAttribute("itens", itens);
		return "item/todos";
	}
}
