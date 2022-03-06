package novidades.java10;

import java.util.HashMap;
import java.util.Map;

public class InferenciaVariaveis {

	public static void main(String[] args) {
// Da maneira antiga
		Map<String, String> chaveValor = new HashMap<String, String>();
		chaveValor.put("nome", "Antonio");
		chaveValor.put("sobrenome", "Jose");
		chaveValor.put("ultimoNome", "Castro");
		chaveValor.put("designacaoFamiliar", "Filho");
		
		System.out.println(chaveValor);
		
// Utilizando var
		var chaveValorVar = new HashMap<String, String>();
		chaveValorVar.put("nome", "Antonio");
		chaveValorVar.put("sobrenome", "Jose");
		chaveValorVar.put("ultimoNome", "Castro");
		chaveValorVar.put("designacaoFamiliar", "Filho");
		
		System.out.println(chaveValorVar);

		// Ou ainda:
		var chaveValorImutavel = Map.of("nome", "Antonio", "sobrenome", "Jose", "ultimoNome", "Castro", "designacaoFamiliar", "Filho");

		System.out.println(chaveValorImutavel);
	}
}