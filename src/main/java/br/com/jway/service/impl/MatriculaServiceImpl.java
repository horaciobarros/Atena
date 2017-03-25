package br.com.jway.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.jway.dao.MatriculaDao;
import br.com.jway.model.Matricula;
import br.com.jway.model.ServicoMatricula;
import br.com.jway.service.MatriculaService;
import br.com.jway.service.ServicoMatriculaService;
import br.com.jway.service.ServicoService;

@Named
public class MatriculaServiceImpl implements MatriculaService {

	private static final long serialVersionUID = 1L;

	@Inject
	private MatriculaDao dao;

	@Inject
	private ServicoMatriculaService servicoMatriculaService;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void create(Matricula matricula) {
		dao.create(matricula);
		if (!matricula.getServicoMatriculaList().isEmpty()) {
			for (ServicoMatricula sm : matricula.getServicoMatriculaList()) {
				sm.setMatricula(matricula);
				servicoMatriculaService.create(sm);
			}

		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Matricula matricula) {
		dao.delete(matricula);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(Matricula matricula) {
		deleteServicoMatriculaList(matricula);
		dao.update(matricula);
		if (!matricula.getServicoMatriculaList().isEmpty()) {

			for (ServicoMatricula sm : matricula.getServicoMatriculaList()) {
				if (sm.getId() == null) {
					sm.setMatricula(matricula);
					servicoMatriculaService.create(sm);
				}
			}

		}
	}

	@Override
	public Matricula read(long id) {
		return dao.read(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(long id) {
		dao.delete(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private void deleteServicoMatriculaList(Matricula item) {
		if (item.getServicoMatriculaListToRemove() != null && 
				!item.getServicoMatriculaListToRemove().isEmpty()) {
			for (ServicoMatricula sm : item.getServicoMatriculaListToRemove()) {
				if (sm.getId() != null) {
					servicoMatriculaService.delete(sm);
				}
			}
		}
	}

	@Override
	public List<Matricula> list() {
		List<Matricula> lista = dao.list();

		for (Matricula matricula : lista) { 
			matricula.setServicoMatriculaList(servicoMatriculaService.findByMatriculaId(matricula.getId()));
		}

		return lista;

	}

	@Override
	public List<Matricula> pesquisa(Matricula matricula) {
		return dao.pesquisa(matricula);
	}

	@Override
	public BigDecimal getValorLiquidoMatricula(Matricula matricula) {
		BigDecimal valorMatricula = new BigDecimal(0);
		matricula.setServicoMatriculaList(servicoMatriculaService.findByMatriculaId(matricula.getId()));
		for (ServicoMatricula sm : matricula.getServicoMatriculaList()) {
			if (sm.getPercDesconto() != null) {
				BigDecimal valorServico = sm.getServico().getValor().
						subtract(sm.getServico().getValor().multiply(BigDecimal.valueOf(sm.getPercDesconto()).divide(new BigDecimal(100))));
				valorMatricula = valorMatricula
						.add(valorServico);
			} else {
				valorMatricula = valorMatricula
						.add(sm.getServico().getValor());
			}
		}
		return valorMatricula;
	}

	@Override
	public List<Matricula> listSemServicos() {
		return dao.list();
	}

}
