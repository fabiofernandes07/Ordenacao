from random import randint;

tamanho = 20;
vetor = []
for i in range(0,tamanho):
    vetor.append(randint(1,tamanho));

def insertionSort(vetor): 
    for i in range(1, len(vetor)): 
  
        key = vetor[i] 
        j = i-1
        while j >= 0 and key < vetor[j] : 
                vetor[j + 1] = vetor[j] 
                j -= 1
        vetor[j + 1] = key
    return vetor

teste = insertionSort(vetor)
print(teste)
