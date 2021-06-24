package br.com.alura.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.UnidadeTrabalho;
import br.com.alura.spring.data.repository.UnidadeTrabalhoRepository;


@Service
public class CrudUnidadeTrabalhoService {

	private final UnidadeTrabalhoRepository unidadeTrabalhoRespository;
	private Boolean system = true;

	public CrudUnidadeTrabalhoService(UnidadeTrabalhoRepository unidadeTrabalhoRespository) {
		this.unidadeTrabalhoRespository = unidadeTrabalhoRespository;
	}

	public void inicial(Scanner scanner) {
		while (system) {

			System.out.println("Qual acao de unidade de trabalho deseja executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Visualizar");
			System.out.println("4 - Deletar");

			int action = scanner.nextInt();
			switch (action) {
			case 1:
				salvar(scanner);
				break;
			case 2:
				atualizar(scanner);
				break;
			case 3:
				visualizar();
				break;
			case 4:
				deletar(scanner);
				break;
			default:
				system = false;
				break;
			}
		}
	}

	private void salvar(Scanner scanner) {

		System.out.println("Descricao da Unidade de trabalho");
		String descricao = scanner.next();
		UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
		unidadeTrabalho.setDescricao(descricao);
		unidadeTrabalhoRespository.save(unidadeTrabalho);
		System.out.println("Salvo");
	}

	private void atualizar(Scanner scanner) {

		System.out.println("Id");
		int id = scanner.nextInt();
		System.out.println("Descricao da Unidade de trabalho");
		String descricao = scanner.next();
		UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
		unidadeTrabalho.setId(id);
		unidadeTrabalho.setDescricao(descricao);
		unidadeTrabalhoRespository.save(unidadeTrabalho);
		System.out.println("Atualizado");
	}

	private void visualizar() {
		Iterable<UnidadeTrabalho> unidades = unidadeTrabalhoRespository.findAll();
		unidades.forEach(unidadeTrabalho -> System.out.println(unidadeTrabalho));
	}

	private void deletar(Scanner scanner) {
		System.out.println("Id");
		int id = scanner.nextInt();
		unidadeTrabalhoRespository.deleteById(id);
		System.out.println("Deletado");

	}
}
