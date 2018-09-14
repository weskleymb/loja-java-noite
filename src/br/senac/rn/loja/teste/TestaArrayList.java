package br.senac.rn.loja.teste;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import br.senac.rn.loja.model.Sexo;

public class TestaArrayList {

	public static void main(String[] args) {

		Set<Sexo> sexos = new HashSet<Sexo>();
		
		int resposta = 1;
		int id = 1;
		
		Scanner entrada = new Scanner(System.in);
		
		do {
			Sexo sexo = new Sexo();
//			sexo.setId((int) (Math.random()*100));
			sexo.setId(1);
			System.out.println("Informe o nome do Sexo:");
			sexo.setNome(entrada.next());
			System.out.println("Informe a sigla do Sexo:");
			sexo.setSigla(entrada.next());
			sexos.add(sexo);
			System.out.println("Digite 0 (ZERO) para SAIR");
			resposta = entrada.nextInt();
			id++;
		} while(resposta != 0);
		
		entrada.close();
		
		sexos.forEach(sexo -> System.out.println(sexo));
		
//		for (Sexo s : sexos) {
//			System.out.println(sexo);				
//		}
		
//		for (int i = 0; i < sexos.size(); i++) {
//			Sexo s = sexos.get(i);
//			System.out.println(s);
//		}
		
	}

}
