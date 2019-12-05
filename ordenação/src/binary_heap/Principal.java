package binary_heap;

import binary_heap.Heap;
import java.util.Locale;
import java.util.Scanner;


public class Principal {
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		int tamvec;
		
		
		System.out.println("Digite o tamanho do vetor: ");
		tamvec = sc.nextInt();
		
		Heap heap = new Heap(tamvec);
		
		for(int i = 0 ; i < tamvec; i++) {
			System.out.println("Digite o numero da posiçao" + tamvec);
			
			
		}
		
		
		
		sc.close();
	}
}
