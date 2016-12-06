package br.com.sistemavendas.DAOImpl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.sistemavendas.DAOCustom.PedidoDAOCustom;
import br.com.sistemavendas.container.PedidosPorDia;
import br.com.sistemavendas.container.PedidosPorTorre;
import br.com.sistemavendas.model.Cliente;
import br.com.sistemavendas.model.Pagamento;
import br.com.sistemavendas.model.Pedido;
import br.com.sistemavendas.model.Solicita;
import br.com.sistemavendas.type.DiaDaSemana;
import br.com.sistemavendas.type.MeioDeContato;
import br.com.sistemavendas.type.TipoPagamento;

public class PedidoDAOImpl implements PedidoDAOCustom  {

	@PersistenceContext
    private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pedido> findPedidosAtivos() {
		return em.createQuery("select p from Pedido p where (status_pedido = 'preparo' "
				+ " or status_pedido = 'para_entrega')").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PedidosPorTorre> findPedidosPorTorre() {
		List<Object[]> results = em.createNativeQuery("SELECT c.torre, sum(pag.valor) as valorTotal, count(p.id) as numPedidos, avg(pag.valor) as mediaPorPedido FROM Solicita s inner join Cliente c on s.cliente_id = c.id inner join Pedido p on s.pedido_id = p.id inner join Pagamento pag on pag.id = s.pagamento_id group by c.torre;").getResultList();
		
		List<PedidosPorTorre> pedidos = new ArrayList<>();
		for(Object[] result : results) {
			PedidosPorTorre pedido = new PedidosPorTorre();
			pedido.setTorre((Integer)result[0]);
			pedido.setValorTotal((Double)result[1]);
			pedido.setNumPedidos(((BigInteger) result[2]).intValue());
			pedido.setMediaPorPedido((Double) result[3]);
			
			pedidos.add(pedido);
		}
		
		return pedidos; 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PedidosPorDia> findPedidosPorDia() {
		List<Object[]> results = em.createNativeQuery("SELECT p.dia_semana, sum(pag.valor) as valor_total, count(p.id) as pedido, avg(pag.valor) as valor_medio FROM  Solicita s inner join Pedido p on s.pedido_id = p.id inner join Pagamento pag on pag.id = s.pagamento_id group by p.dia_semana order by sum(pag.valor) desc;").getResultList();
		
		List<PedidosPorDia> pedidos = new ArrayList<>();
		for(Object[] result : results) {
			PedidosPorDia pedido = new PedidosPorDia();
			pedido.setDia(DiaDaSemana.valueOf((String)result[0]));
			pedido.setValorTotal((Double)result[1]);
			pedido.setNumPedidos(((BigInteger) result[2]).intValue());
			pedido.setMediaPorPedido((Double) result[3]);
			
			pedidos.add(pedido);
		}
		
		return pedidos; 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Solicita> findPedidosNaoPagos() {
		String sql = " select p.id pid, p.data_pedido, p.dia_semana, p.status_pedido, p.cortesia, p.meio_de_contato, "
				+ " c.id cid, c.nome_completo, c.torre, c.apartamento, c.telefone, "
				+ " pag.id pagid, pag.tipo, pag.valor, pag.efetuado, pag.data_pagamento from "
				+ " Solicita s inner join Pedido p on p.id = s.pedido_id "
				+ "  inner join Pagamento pag on s.pagamento_id = pag.id "
				+ "  inner join Cliente c on s.cliente_id = c.id "
				+ " where pag.efetuado=false";
		
		List<Object[]> results = em.createNativeQuery(sql).getResultList();
		List<Solicita> solicitacoes = new ArrayList<>();
		for(Object[] result : results) {
			Pedido pedido = new Pedido();
			pedido.setId(((Integer)result[0]).longValue());
			pedido.setData((Date) result[1]);
			pedido.setDiaDaSemana(DiaDaSemana.valueOf((String) result[2]));
			pedido.setStatus((String) result[3]);
			pedido.setCortesia((Boolean) result[4]);
			pedido.setMeioDeContato(MeioDeContato.valueOf((String) result[5]));
			
			Cliente cliente = new Cliente();
			cliente.setId(((Integer) result[6]).longValue());
			cliente.setNomeCompleto((String) result[7]);
			cliente.setTorre((Integer) result[8]);
			cliente.setApartamento((Integer) result[9]);
			cliente.setTelefone((String) result[10]);
			
			Pagamento pagamento = new Pagamento();
			pagamento.setId(((Integer) result[11]).longValue());
			pagamento.setTipo(TipoPagamento.valueOf((String) result[12]));
			pagamento.setValor((Double) result[13]);
			pagamento.setEfetuado((Boolean) result[14]);
			pagamento.setDataPagamento((Date) result[15]);
			
			Solicita solicitacao = new Solicita(null, pedido, cliente, pagamento);
			solicitacoes.add(solicitacao);
		}
		
		return solicitacoes; 
	}

}
