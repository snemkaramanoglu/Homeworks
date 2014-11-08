#include<stdio.h>
#include<conio.h>


void caticiz(int catiyuksekligi, int genislik){
	int i, j;
	char solCiz[1000], sagCiz[1000], bosluk[1000];
	strcpy(solCiz,"");
	strcpy(sagCiz,"");
	strcpy(bosluk, "");
    //Catının sol tarafındaki sayılar
	for (i = 0; i<catiyuksekligi; i++){
         printf("%d",(i+1)%10);


		// Çati Yüksekligi  9
		if (i == 0){
          if (genislik % 2 == 0 ){
                if(genislik%4!=0){
				for (j = 0; j < (genislik / 2); j++){
					printf(" ");
				}

			  }
			  else {
                    printf(" ");
                    for (j = 0; j < (genislik / 2); j++){
					printf(" ");
				}

			  }
			}
			else{
                    printf(" ");
                    for (j = 0; j < (genislik / 2); j++){
					printf(" ");
				}

			  }
               printf("+\n");
		}
		else{
			if (genislik % 4 == 3)printf("  ");
			else printf(" ");
				for (j = (genislik / 4); j>i; j--){

					strcat(bosluk, "  ");
				}
		strcat(solCiz, "//");
				if(i==catiyuksekligi-1){
                 strcat(sagCiz, "\\");

				}
				else{
				strcat(sagCiz, "\\\\");
				}

                if(i==catiyuksekligi-1 && (genislik%4==2)) strcat(sagCiz,"\\");
               else if(i== catiyuksekligi-1 && (genislik%4==3)) strcat(sagCiz,"\\");
				printf("%s%s+%s\n", bosluk, solCiz, sagCiz);

				strcpy(bosluk, "");
			}
		}
	}

   void govdeCiz(int govdeBoyu, int genislik){
	int i, j, tutucu1, tutucu2, tutucu3,x;
	char ortaSifir[1000]={"\0"};
	tutucu1 = ((govdeBoyu)-(2 * ((govdeBoyu / 4) + 1)));
	tutucu2 = govdeBoyu / 4 + 1;  // Pencere ve kapı boyu
	tutucu3 = govdeBoyu / 2 + 1;  // Pencere ve kapı eni

	for(i=0;i<((genislik - (2 * tutucu3)) / 3);i++){
        strcat(ortaSifir,"O");
	}
    //Evin sol tarafındaki sayılar
	for (i = 0; i < govdeBoyu; i++){
		printf("%d", (i%10));
		printf(" ");

   //Pencerelerin Üst Kısımındaki O lar
		if (i < tutucu1 / 2){
			for (j = 0; j < genislik; j++){
				printf("O");
			}
		}
		//   Pencerelerin bitimine kadar

		//Pencere kısımları
          if (i >= tutucu1 / 2 && i < tutucu1/2 + tutucu2){
			for (j = 0; j < genislik; j++){
				if (j < ((genislik - (2 * tutucu3)) / 3) ){
                    printf("O");
				}

		//Pencere orta kısmı (yıldızların art arda geldiği kısım)
           if (j >= (genislik - (2 * tutucu2)) / 3 && j < ((genislik - (2 * tutucu2)) / 3) + tutucu3){
					if (i ==(tutucu1/2)+(tutucu2/2)){
						printf("*");
					}
				}
			}

        // Orta kısım hariç pencerelerin tek yıldızları ve boşlukları
			for(j=0;j<tutucu3;j++){
               if(j==tutucu3/2  &&  i!= (tutucu1/2)+(tutucu2/2)) printf("*");
               else if(i!= (tutucu1/2)+(tutucu2/2)) printf(" ");
			}

		 //İki pencere arası O ların sayısı
              for (j = 0; j < genislik; j++){
				if (j < ((genislik - (2 * tutucu3)) / 3) ){
                    printf("O");
				}
              }

			if((genislik-(2*tutucu3))%3==1)printf("O");
			else if((genislik-(2*tutucu3))%3==2)printf("OO");

          //İkinci pencere kısmı
			for(j=0;j<tutucu3;j++){
               if(j==tutucu3/2  &&  i!= (tutucu1/2)+(tutucu2/2)) printf("*");
               else if(i!= (tutucu1/2)+(tutucu2/2)) printf(" ");
			}

         // Pencere ortası hariç O ların koyulduğu yer
			for (j = 0; j < genislik; j++){
				if (j < ((genislik - (2 * tutucu3)) / 3) && i!= (tutucu1/2)+(tutucu2/2)){
                  printf("O");
					x=0;
				}

        //Pencere orta kısımı (yıldızların art arda geldiği kısım)
             else if (j >= (genislik - (2 * tutucu2)) / 3 && j < ((genislik - (2 * tutucu2)) / 3) + tutucu3){
					 if (i ==(tutucu1/2)+(tutucu2/2)){
						printf("*");
						x=-1;
						}
             }
             }
            if(x==-1 && i==(tutucu1/2)+(tutucu2/2) ){
            printf("%s",ortaSifir);
            }
          }

        //Pencerelerin altı
            if(i>=(tutucu1/2)+tutucu2 && i<govdeBoyu-tutucu2)
            for(j=0;j<genislik;j++){
		       printf("O");
	         	}

          // Pencere Çizimi Bitimi


         // Kapının olduğu yer başlangıcı
            if(i>=govdeBoyu-tutucu2){
            for(j=0;j<(genislik-tutucu3)/2;j++){
                printf("O");
            }
            //Kapının orta kısımı
			for(j=0;j<tutucu3;j++){
               if(j==tutucu3/2  &&  i!= (tutucu1/2)+(tutucu2/2)) printf("*");
               else if(i!= (tutucu1/2)+(tutucu2/2)) printf(" ");
			}
             //Kapının sağ tarafı
         if(i>=govdeBoyu-tutucu2){
            for(j=0;j<(genislik-tutucu3)/2 ;j++){
                printf("O");
            }
           if(((genislik-tutucu3))%2==1)printf("O");
         }
            }

     //Döngü biterken alta geç
		printf("\n");
	  }
        // Döngü bitti
        //Evin altındaki sayılar
	  printf("  ");
        for(j=0;j<genislik;j++){
            printf("%d", (j%10));
        }
	}
       int main(){

	int genislik, yukseklik;
	printf("Lutfen Genisligi Giriniz: ");
	scanf("%d", &genislik);
	printf("\n\n");
	caticiz((genislik / 4) + 1, genislik);
	govdeCiz((genislik / 2), genislik);
	getch();
}
