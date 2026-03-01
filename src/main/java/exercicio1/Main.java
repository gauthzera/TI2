package exercicio1;
import java.util.*;


public class Main {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Digite um número: ");
		int x=sc.nextInt();
		System.out.print("Digite um número: ");
		int y=sc.nextInt();
		
		int soma=x+y;
		System.out.print("Soma: ");
		System.out.println(soma);
		
		sc.close();
	}
}
