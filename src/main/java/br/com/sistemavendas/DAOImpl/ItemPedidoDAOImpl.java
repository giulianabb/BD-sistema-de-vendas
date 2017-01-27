package br.com.sistemavendas.DAOImpl;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.sistemavendas.DAOCustom.ItemPedidoDAOCustom;
import br.com.sistemavendas.container.ItemPedidoPorDia;

public class ItemPedidoDAOImpl implements ItemPedidoDAOCustom {

	@PersistenceContext
    private EntityManager em;
	
	@Override
	public List<ItemPedidoPorDia> findItensPedidosPorDia(Date date) {
		Query query = em.createNativeQuery("SELECT i.nome, count(ip.item_id) * ip.quantidade as quantidade, "
										+ "count(ip.item_id) * ip.quantidade * i.preco total "
										+ " from pedido p  "
										+ "inner join item_pedido ip on p.id = ip.pedido_id  "
										+ "inner join item i on i.id = ip.item_id    "
										+ "where p.data_pedido = ?1   "
										+ "group by i.nome      "
										+ "order by i.nome");
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
		query.setParameter(1, sf.format(date));
		@SuppressWarnings("unchecked")
		List<Object[]> results = (List<Object[]>) query.getResultList();
		List<ItemPedidoPorDia> itens = new ArrayList<>();
		for(Object[] result : results) {
			ItemPedidoPorDia item = new ItemPedidoPorDia();
			item.setNome((String) result[0]); 
			item.setQuantidade(((BigInteger) result[1]).intValue());
			item.setTotal((Double) result[2]);
			item.setFuncionario(null);
			
			itens.add(item);
		}
		return itens;
	}

}
