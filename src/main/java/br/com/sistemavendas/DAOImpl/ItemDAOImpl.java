package br.com.sistemavendas.DAOImpl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.sistemavendas.DAOCustom.ItemDAOCustom;
import br.com.sistemavendas.container.ItemVendido;

public class ItemDAOImpl implements ItemDAOCustom {

	@PersistenceContext
    private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ItemVendido> findItensMaisVendidos() {
		List<Object[]> results = em.createNativeQuery("SELECT i.nome, i.sabor, i.preco,  count(ip.item_id) * ip.quantidade as quantidade, count(ip.item_id) * ip.quantidade * i.preco total  from pedido p  inner join item_pedido ip on p.id = ip.pedido_id  inner join item i on i.id = ip.item_id     group by i.nome, i.sabor      order by i.nome").getResultList();
		
		List<ItemVendido> itens = new ArrayList<>();
		for(Object[] result : results) {
			ItemVendido itemVendido = new ItemVendido();
			itemVendido.setNome((String)result[0]);
			itemVendido.setSabor((String)result[1]);
			itemVendido.setPreco((Double)result[2]);
			itemVendido.setQuantidade(((BigInteger) result[3]).intValue());
			itemVendido.setTotal((Double)result[4]);
			
			itens.add(itemVendido);
		}
		return itens;
	}
	
	
}
