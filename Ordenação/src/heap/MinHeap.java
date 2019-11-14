package heap;

public class MinHeap {

	
	public int array[];
	public int tamHeap;
	public int tamArray;
	
	MinHeap(int array[],int tamArray) {
		
		this.array = array;
		this.tamArray = tamArray;
		
		
	}
	
	public void Maxheapfy(int array[], int i) {
		
		int esquerda = 2*i + 1;
		int direita = 2*i + 2;
		int maior;
		int menor;
		
		if((esquerda < this.tamHeap) && (this.array[esquerda] > this.array[i])) {
			maior = esquerda;
			menor = i;
			
		}
		else {
			maior = i;
			menor = esquerda;
		}
		
		if((direita < this.tamHeap) && (this.array[direita] > this.array[maior])) {
			menor = maior;
			maior = direita;
			
		}
		if(menor != i ) {
			int aux;
			aux = this.array[i];
			this.array[i] = this.array[menor];
			this.array[menor] =aux;
			
			Maxheapfy(array,menor);
			Maxheapfy(array,maior);
		}
		
	}
	
	public void Build_Max(int array[]) {
		this.tamHeap = this.tamArray;
		for(int i = (this.tamArray-1 )/2; i >=0 ;i--) {
			
			Maxheapfy(array,i);
		}
	}
	
	public void HeapSort(int array[]) {
		Build_Max(array);
		for(int i = (this.tamArray -1); i>0; i--) {
			int aux;
			aux = this.array[0];
			this.array[0] = this.array[i];
			this.array[i] = aux;
			this.tamHeap --;
			Maxheapfy(array, 0);
		}
		
		
	}
	

}
