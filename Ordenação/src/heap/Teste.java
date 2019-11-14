package heap;
import heap.MaxHeap;
import heap.MinHeap;
import java.io.FileReader;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;


public class Teste {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		
		
		String nome = "couting.txt";
		
		try {
		      FileReader arq = new FileReader(nome);
		      BufferedReader lerArq = new BufferedReader(arq);
		 
		      String linha = lerArq.readLine();
		      int tamanho1 = Integer.parseInt(linha);
		      
		     // System.out.println(tamanho1);
		      
		      int array[] = new int[tamanho1];
		      int i = 0;
		      
		     
		      while (linha != null) {
		 
		        linha = lerArq.readLine(); // lê da segunda até a última linha
		        if(linha !=null) {
		        	array[i] = Integer.parseInt(linha);
		        	//System.out.println(array[i]);
		        	i++;
		        }
		       
		      }
		      MaxHeap mp = new MaxHeap(array,tamanho1);
		      //MinHeap mp = new MinHeap(array,tamanho1);
		      
		      //mp.HeapSort(array);
		      mp.HeapSort(array);
		      
		      for(int j=0; j < tamanho1; j++) {
					System.out.println(array[j]);
				}
		 
		      arq.close();
		    }catch (IOException e) {
		        System.err.printf("Erro na abertura do arquivo: %s.\n",
		                e.getMessage());
		          }

		ler.close();	
	}
	

}
