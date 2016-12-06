package br.com.sistemavendas.DAOImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.sistemavendas.DAOCustom.PedidoDAOCustom;
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

	@Override
	public List<Pedido> findPedidosPorTorre() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pedido> findPedidosPorDia() {
		// TODO Auto-generated method stub
		return null;
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
