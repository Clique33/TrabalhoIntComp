#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(){
	int i,j,k,n;
	FILE *f = fopen("grafos.txt","w");
	srand((unsigned)time(NULL));
	rand();rand();rand();rand();
	
	for(i = 0; i < 10; i++){
		n = rand()%64;
		fprintf(f,"%d\n",n);
		
		for(j = 0; j < n; j++){
			for(k = j+1; k < n; k++){
				if(rand()%2)
					fprintf(f,"%d %d\n",j,k);
			}
		}
		fprintf(f,"%d\n",-1);	
	}
	fclose(f);
	//getchar();
}