package novidades.java13;

public class BlocosTexto {

	public static void main(String[] args) {
// A maneira antiga
		String textoVariasLinhasFormatado = " Para que um texto de varias linhas apareça formatado você pode usar a maneira antiga \n"
				+ " que exige o uso de conjuntos de caracteres especiais de escape (o \\n para pular linha) \n"
				+ " e concatenação das várias linhas. \n"
				+ " Com os blocos de texto (Text Blocks) isso se torna mais fácil.";
		
		System.out.println(textoVariasLinhasFormatado);
				
// Usando Text Blocks
		String textBlock = """ 
				 Para que um texto de varias linhas apareça formatado você pode usar a maneira antiga 
				 que exige o uso de conjuntos de caracteres especiais de escape (o \\n para pular linha) 
				 e concatenação das várias linhas. 
				 Com os blocos de texto (Text Blocks) isso se torna mais fácil.
				 """;
		
		System.out.println(textBlock);
	}
}