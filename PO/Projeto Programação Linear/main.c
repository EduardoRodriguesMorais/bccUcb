#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

FILE *abreArq (char *nomeArq, char *modoAbertura, char *msgErro);
int validaArquivo(FILE* arq);

int main(int argc, char *argv[]) {
	
	FILE *arq = abreArq("modelo.txt","r","Erro ao abrir arquivo");
	
	return validaArquivo(arq);
	
	
	return 0;
}

//Objetivo: Le valores de uma variavel de acordo com o Modelo Simplex
//Parametros: Uma string
//Retorno: Valor em inteiro que essa string representa para o modelo
int validaVariavel(char *str){
	int i =0;
	char vet[50];
	
	if(str[0] == 'x' ){
		return 1;
	}else{	
		for(i=0; i < strlen(str); i++){
			if(isdigit(str[i])){
				vet[i] = (int) str[i];	
			}
		}
		return atoi(vet);
	}
}
//Objetivo: Ler um arquivo e validar
//Parametros: Ponteiro para um arquivo
//Retorno: Tue or False
int validaArquivo(FILE* arq){
    int i, qtdLinhas=0,qtdColunas=0;
	char str[100], ch ;
	while( (fscanf(arq,"%s %c\n", &str,&ch))!=EOF){
		if(ch == '\n'){
			qtdLinhas ++;
		}
		
		printf("\n___%s____", &str);
		i = validaVariavel(str);
		printf("___%d____\n", i);		 	
	}
	
	printf("QTD LINHAS: %d   ",qtdLinhas);

	printf("QTD COLUNAS: %d",qtdColunas);
  	
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

