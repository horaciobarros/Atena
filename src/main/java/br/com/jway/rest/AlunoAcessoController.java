package br.com.jway.rest;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.jway.model.Aluno;
import br.com.jway.service.AlunoService;


@Controller
@RequestMapping("/aluno")
@Transactional
public class AlunoAcessoController {

	@Inject
	private AlunoService alunoService;

	@RequestMapping(method = RequestMethod.GET, value = "/login",produces = "application/json")
	public @ResponseBody Aluno login(@ModelAttribute("matricula") String matricula, String senha) {
		try {
			Aluno aluno = alunoService.findByMatricula(matricula);
			if (aluno!=null && aluno.getId() > 0 && senha.equals(aluno.getPessoa().getSenha())){
				return aluno;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Aluno();
	}
	
}
