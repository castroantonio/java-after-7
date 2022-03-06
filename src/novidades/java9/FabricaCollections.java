package novidades.java9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class FabricaCollections {

	public static void main(String[] args) {
// A moda antiga
		// criando e adicionando elementos
		List<String> lista = new ArrayList<String>();
		lista.add("Antonio");
		lista.add("Jose");
		lista.add("Castro");
		lista.add("Filho");
		
		System.out.println(lista);
		
		// se quiser passar esta lista sem permitir que seja alterada, deveriamos fazer:
		List<String> listaImutavel = Collections.unmodifiableList(lista);
		// listaImutavel.add("Erro");  // Dá erro pois a lista é imutável!!!

		System.out.println(listaImutavel);
		
		
// Java 9
		List<String> listaImutavelNoJava9 = List.of("Antonio", "Jose", "Castro", "Filho");
        // listaImutavelNoJava9.add("Erro");  // Dá erro pois a lista é imutável!!!
		
		System.out.println(listaImutavelNoJava9);
		
		
		// O mesmo pode ser feito com Set e Map
		Map<String, String> chaveValorImutavel = Map.of("nome", "Antonio", "sobrenome", "Jose", "ultimoNome", "Castro", "designacaoFamiliar", "Filho");
		// chaveValorImutavel.put("erro", "Erro");  // Dá erro, o map é imutavel!!!
		
		System.out.println(chaveValorImutavel);
	}
}