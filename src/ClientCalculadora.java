import java.rmi.Naming;
import java.util.Scanner;

public class ClientCalculadora {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		String service = "rmi://localhost/HelloService";
		try {
			Calculadora remote = (Calculadora) Naming.lookup(service);
			int opcao = 99;
			while (opcao != 0) {
				System.out.println("-------------------------------------------------");
				System.out.println("Digite 1 para Somar");
				System.out.println("Digite 2 para Subtrair");
				System.out.println("Digite 3 para Dividir");
				System.out.println("Digite 4 para Multiplicar");
				System.out.println("Digite 5 para Calcular MMC");
				System.out.println("Digite 6 para Calcular MDC");
				System.out.println("-------------------------------------------------");

				opcao = scan.nextInt();
				switch (opcao) {
				case 1:
					System.out.println("Resultado :"+ remote.soma(pedir_valor1(), pedir_valor2()));
					break;
				case 2:
					System.out.println("Resultado :"+ remote.subtracao(pedir_valor1(), pedir_valor2()));
					break;
				case 3:
					System.out.println("Resultado :"+ remote.divisao(pedir_valor1(), pedir_valor2()));
					break;
				case 4:
					System.out.println("Resultado :"+ remote.multiplicacao(pedir_valor1(), pedir_valor2()));
					break;
				case 5:
					System.out.println("Resultado :"+ remote.mmc(pedir_valor1(), pedir_valor2()));
					break;
				case 6:
					System.out.println("Resultado :"+ remote.mdc(pedir_valor1(), pedir_valor2()));
					break;
				case 0:
					break;
				default:
					System.out.println("Valor Invalido!!!");
					break;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int pedir_valor1() {
		System.out.println("Digite o Primeiro Valor:");
		return scan.nextInt();
	}

	public static int pedir_valor2() {
		System.out.println("Digite o Segundo Valor:");
		return scan.nextInt();
	}

}
