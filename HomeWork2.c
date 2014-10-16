//Furkan Özbay and Sinem Karamanoðlu are pair for this project

#include<stdio.h>
#include<conio.h>


void yatayciz(int width, int numbers[], int k, int u, int j,char yildiz[],char eksi[], int max, char bosluk[]){

        printf("Horizontal Chart\n");
        strcat(eksi,"  +");
       for(k=0;k<max;k++){
        strcat(eksi,"-");
       }
       strcat(eksi,"+");


       printf("%s\n",eksi);


    for(k=0;k<9;k++){
        for(u=0;u<numbers[k];u++){
           strcat(yildiz,"*");
          }
           for(j=0;j<max-numbers[k];j++){
          strcat(bosluk," ");
            }
        for(j=1;j<width+1;j++){

            if(j!=(width/2)+1)printf("  |%s%s%c\n",yildiz,bosluk,'|');
            else printf("%2d|%s%s%c\n",numbers[k],yildiz,bosluk,'|');

        }
            strcpy(yildiz,"");
            strcpy(bosluk,"");
            printf("%s\n",eksi);

        }
    }


main(){


  printf("Enter 9 numbers (all less than 50): ");
  int numbers[9];
  int i, width, k,j,u,max,temp;
  char yildiz[50]={0}, v1[8]="   ",v2[8]="   ",v3[8]="   ",v4[8]="   ",v5[8]="   ",v6[8]="   ",v7[8]="   ",
  v8[8]="   ",v9[8]="   ", v10[8]="   ",eksi[50]={0}, bosluk[50]={0};

  for(i=0;i<9;i++){
    scanf("%d",&numbers[i]);
  }
  {

      int k;
  }
  max=numbers[0];
  for(i=1;i<9;i++){
        if(numbers[i]>max) max=numbers[i];

  }
  printf("Enter the width of the charts (1, 3, 5 or 7): ");
  scanf("%d",&width);


  yatayciz(width, numbers, k, u , j, yildiz,eksi,max,bosluk);



printf("      Vertical Chart\n");


   switch(width){
   case 1:
                strcpy(v1," ");
                strcpy(v2," ");
                strcpy(v3," ");
                strcpy(v4," ");
                strcpy(v5," ");
                strcpy(v6," ");
                strcpy(v7," ");
                strcpy(v8," ");
                strcpy(v9," ");
                strcpy(v10," ");
     printf("+-+-+-+-+-+-+-+-+-+\n");
           for(j=max;j>0;j--){
                if(numbers[0]==j) strcpy(v1,"*");
                if(numbers[1]==j) strcpy(v2,"*");
                if(numbers[2]==j) strcpy(v3,"*");
                if(numbers[3]==j) strcpy(v4,"*");
                if(numbers[4]==j) strcpy(v5,"*");
                if(numbers[5]==j) strcpy(v6,"*");
                if(numbers[6]==j) strcpy(v7,"*");
                if(numbers[7]==j) strcpy(v8,"*");
                if(numbers[8]==j) strcpy(v9,"*");
                if(numbers[9]==j) strcpy(v10,"*");

            printf("|%s|%s|%s|%s|%s|%s|%s|%s|%s|\n",v1,v2,v3,v4,v5,v6,v7,v8,v9 );

           }
            printf("+-+-+-+-+-+-+-+-+-+\n");
            for(i=0;i<9;i++){
                 printf("%2d",numbers[i]);
            }
            break;


    case 3:
        printf("+---+---+---+---+---+---+---+---+---+\n");
           for(j=max;j>0;j--){
                if(numbers[0]==j) strcpy(v1,"***");
                if(numbers[1]==j) strcpy(v2,"***");
                if(numbers[2]==j) strcpy(v3,"***");
                if(numbers[3]==j) strcpy(v4,"***");
                if(numbers[4]==j) strcpy(v5,"***");
                if(numbers[5]==j) strcpy(v6,"***");
                if(numbers[6]==j) strcpy(v7,"***");
                if(numbers[7]==j) strcpy(v8,"***");
                if(numbers[8]==j) strcpy(v9,"***");
                if(numbers[9]==j) strcpy(v10,"***");

            printf("|%s|%s|%s|%s|%s|%s|%s|%s|%s|\n",v1,v2,v3,v4,v5,v6,v7,v8,v9 );

           }
            printf("+---+---+---+---+---+---+---+---+---+\n");

            for(j=0;j<9;j++){
                 if(j==0)printf("%3d",numbers[j]);
                 else printf("%4d",numbers[j]);
            }
            break;
            break;

            case 5:
                printf("+-----+-----+-----+-----+-----+-----+-----+-----+-----+\n");
                strcpy(v1,"     ");
                strcpy(v2,"     ");
                strcpy(v3,"     ");
                strcpy(v4,"     ");
                strcpy(v5,"     ");
                strcpy(v6,"     ");
                strcpy(v7,"     ");
                strcpy(v8,"     ");
                strcpy(v9,"     ");
                strcpy(v10,"     ");

           for(j=max;j>0;j--){
                if(numbers[0]==j) strcpy(v1,"*****");
                if(numbers[1]==j) strcpy(v2,"*****");
                if(numbers[2]==j) strcpy(v3,"*****");
                if(numbers[3]==j) strcpy(v4,"*****");
                if(numbers[4]==j) strcpy(v5,"*****");
                if(numbers[5]==j) strcpy(v6,"*****");
                if(numbers[6]==j) strcpy(v7,"*****");
                if(numbers[7]==j) strcpy(v8,"*****");
                if(numbers[8]==j) strcpy(v9,"*****");
                if(numbers[9]==j) strcpy(v10,"*****");

        printf("|%s|%s|%s|%s|%s|%s|%s|%s|%s|\n",v1,v2,v3,v4,v5,v6,v7,v8,v9 );

           }
            printf("+-----+-----+-----+-----+-----+-----+-----+-----+-----+\n");

             for(j=0;j<9;j++){
              if(j==0)  printf("%4d",numbers[j]);
              else printf("%6d",numbers[j]);

                }
            break;

                case 7:
                printf("+-------+-------+-------+-------+-------+-------+-------+-------+-------+\n");
                strcpy(v1,"       ");
                strcpy(v2,"       ");
                strcpy(v3,"       ");
                strcpy(v4,"       ");
                strcpy(v5,"       ");
                strcpy(v6,"       ");
                strcpy(v7,"       ");
                strcpy(v8,"       ");
                strcpy(v9,"       ");
                strcpy(v10,"      ");

           for(j=max;j>0;j--){



                if(numbers[0]==j) strcpy(v1,"*******");
                if(numbers[1]==j) strcpy(v2,"*******");
                if(numbers[2]==j) strcpy(v3,"*******");
                if(numbers[3]==j) strcpy(v4,"*******");
                if(numbers[4]==j) strcpy(v5,"*******");
                if(numbers[5]==j) strcpy(v6,"*******");
                if(numbers[6]==j) strcpy(v7,"*******");
                if(numbers[7]==j) strcpy(v8,"*******");
                if(numbers[8]==j) strcpy(v9,"*******");
                if(numbers[9]==j) strcpy(v10,"*******");

        printf("|%s|%s|%s|%s|%s|%s|%s|%s|%s|\n",v1,v2,v3,v4,v5,v6,v7,v8,v9 );

           }
            printf("+-------+-------+-------+-------+-------+-------+-------+-------+-------+\n");

          for(j=0;j<9;j++){
              if(j==0)  printf("%5d",numbers[j]);
              else printf("%8d",numbers[j]);

                }

            }
        }





