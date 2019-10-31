#include <stdio.h>
#include <stdlib.h>
#include <string.h>


typedef struct heap{
	int *vet;
	int tam_heap;
	int comprimento;
	
}Heap;


void maxheapify(struct heap *heap,int pai) {
	 
	int aux;
	int esquerda = 2 * pai + 1;
	int direita = 2 * pai + 2;
	int maior, menor;
	
	if((esquerda < heap->tam_heap-1) && (heap->vet[esquerda] > heap->vet[pai])) {
		maior = esquerda;
		menor = pai;
	}
	else{
		maior = pai;
	}
	if((direita < heap->tam_heap-1) && (heap->vet[direita] > heap->vet[pai])) {
		maior = direita;
		menor = pai;
	}
	
	if(maior != pai) {
		aux = heap->vet[pai];
		heap->vet[pai] = heap->vet[maior];
		heap->vet[maior] = aux;
		maxheapify(heap, maior);
		maxheapify(heap, menor);
	}
		
}

void biuld_max_heap(struct heap *heap) {
	int i;
	
	for(i = (heap->comprimento - 1)/2; i >= 0; i-- ) {
		maxheapify(heap, i);
		
	}
}

void heapsort(struct heap *heap) {

	biuld_max_heap(heap);
	
	for(int i = (heap->comprimento -1); i > 0 ;i-- ){
		int aux = heap->vet[0];
		heap->vet[0] = heap->vet[i];
		heap->vet[i] = aux;

		heap->tam_heap--;
		
		maxheapify(heap,0);
	}
}





int main(int argc, char* argv[]) {


	Heap *heap;
	char pasta[50] = "instancias/";
	strcat(pasta, argv[1]);
	heap = (Heap*)malloc(sizeof(Heap)); 
	
	FILE* f = fopen(pasta, "r");
	if (f == NULL) {
		printf("Erro ao abrir o arquivo\n");
		abort();
	}

	
	char* v = NULL;
	size_t n = 0;
	int i =0;
	while (getline(&v, &n, f) != EOF) {
		int a = atoi(v);
		
		if(heap->comprimento == 0){
			heap->comprimento = a;
			heap->vet = (int*)malloc(sizeof(int) * heap->comprimento);
			heap->tam_heap = 0;
			
		}
			heap->vet[i] = a;
					
		i++;
		
	}
	heap->tam_heap = heap->comprimento;

	heapsort(heap);
	//biuld_max_heap(heap);
	for(i=0; i < heap->comprimento; i++) {
		printf("%d\n",heap->vet[i]);
	}
	
	return 0;
}
