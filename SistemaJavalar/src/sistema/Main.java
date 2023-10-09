package sistema;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Menu menu = new Menu();
		SistemaJavalar sistema = new SistemaJavalar();
		Scanner entrada = new Scanner(System.in);
		
		menu.menu(sistema, entrada);

	}
}
