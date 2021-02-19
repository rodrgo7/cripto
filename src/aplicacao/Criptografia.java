package aplicacao;

import java.util.Base64;
import java.util.Scanner;

public class Criptografia {
	private Scanner scan;
	private String frase = "";
	private String criptFrase = "";
	private static Criptografia start;
	
	public static void main(String[] argv) {
		start = new Criptografia();
		start.inicio();	
	}

	private void inicio() {
		scan = new Scanner(System.in);
		System.out.print("Digite uma frase para ser criptografada: " + frase);		
		
		frase = scan.nextLine();
		criptFrase = criptografia(frase);
		System.out.println("");
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("*");
		System.out.print("* Frase Criptografada: ");	
		System.out.println(criptografia(frase));	
		System.out.println("*");
		System.out.print("* Deseja Decriptografar? (s/n): ");
		char resp = scan.next().charAt(0);
		if (resp == 's') {
			System.out.println("*");
			System.out.print("* Frase Descriptografada: ");
			System.out.print("");
			System.out.println(descriptografia(criptFrase));
		}		
		System.out.println("*");
		System.out.print("-----------------------------------------------------------------------");
	}
	
	private static String criptografia(String texto) {
		return new String(Base64.getEncoder().encode(texto.getBytes()));
	}
	
	private static String descriptografia(String texto) {
		return new String(Base64.getDecoder().decode(texto.getBytes()));
	}
}