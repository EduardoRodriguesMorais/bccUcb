#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/* Prototipos */

FILE *abreArq (char *nomeArq, char *modoAbertura, char *msgErro);
int populaMTZ(FILE* arq, int **mtz,int qtdL, int qtdC);
int ** alocaMatriz (int qtdL, int qtdC);
int validaVariavel(char *str);
void verificaLinhasColunas(int *qtdL, int *qtdC);



int main(int argc, char *argv[]) {
	int **mtz,qtdL=-1, qtdC=1;
	FILE *arq = abreArq("modelo.txt","r","Erro ao abrir arquivo");
	
	verificaLinhasColunas(&qtdL,&qtdC);
	
	
	mtz = alocaMatriz(qtdL, qtdC);
	
	return populaMTZ(arq, mtz, qtdL, qtdC);
	
	
	return 0;
}



//
//
//
int ** alocaMatriz (int qtdL, int qtdC){
	int i,j; //Variáveis Auxiliares
	int **mtz = (int**)malloc(qtdL * sizeof(int*)); //Aloca um Vetor de Ponteiros 
	
	for (i = 0; i < qtdL; i++){ //Percorre as linhas do Vetor de Ponteiros
       mtz[i] = (int*) malloc(qtdC * sizeof(int)); //Aloca um Vetor de Inteiros para cada posição do Vetor de Ponteiros.
	   for (j = 0; j < qtdC; j++){ //Percorre o Vetor de Inteiros atual.
			mtz[i][j] = 0; //Inicializa com 0.
		}
	}
	
	return mtz; 
}

//
//
//
void verificaLinhasColunas(int *qtdL, int *qtdC){
	char ch;
	FILE *arq = abreArq("modelo.txt","r","Erro ao abrir arquivo");
	while( (ch=fgetc(arq)) != EOF ){
		if(ch == 'x' && *qtdL == 0 ){
			*qtdC+=1;
		}else if(ch == '\n'){
			*qtdL+=1;
		}
	}
}

//Objetivo: Le valores de uma variavel de acordo com o Modelo Simplex
//Parametros: Uma string
//Retorno: Valor em inteiro que essa string representa para o modelo
int validaVariavel(char *str){
	int i =0;
	char vet[50];

	for(i=0; i < strlen(str); i++){
		if(isdigit(str[i])){
			vet[i] = (int) str[i];	
			return atoi(vet);
		}
	}
	return -1;
}

//Objetivo: Ler um arquivo e validar
//Parametros: Ponteiro para um0 arquivo
//Retorno: Tue or False
int populaMTZ(FILE* arq, int **mtz,int qtdL, int qtdC){
    int aux, auxL=0, auxC=0, sa = 0;
	char str[100] ;
	
	while( (fscanf(arq,"%s\n", &str))!=EOF){
		//printf("\n_STRING__%s____", &str);
		if(!strcmp(str,"sa")){
			sa = 1;
		}
		aux = validaVariavel(str);
		if(aux != -1 && sa == 1){
			if(auxL <= qtdL){
				if(auxC <= qtdC){		
					mtz[auxL][auxC] = validaVariavel(str);
					printf("_%d_", mtz[auxL][auxC]);
					auxC++;
				}else{
					auxL++;	
					printf("\n");
				}
			}
		}
		printf("\nLINHA__%d__COLUNA__%d",auxL,auxC);
	}
	return 0;
}

//Objetivo: abrir um arquivo
//Parametros: referencia ao nome do arquivo , ao modo de abertura e a mensagem de erro
//Retorno: endereco da stream arquivo ou null 
FILE *abreArq (char *nomeArq, char *modoAbertura, char *msgErro){
	FILE *arq;
	
	arq=fopen(nomeArq,modoAbertura);
	if(arq==NULL){
		printf(msgErro);
	}
	
	return arq;
}

