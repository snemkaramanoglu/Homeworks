#include<stdio.h>

#define PISAYISI 3.141592

main(){
    //Defining radius, area and perimeter of shapes
	double roC, woS, woR, hoR, aoC, aoS, aoR, poC, poS, poR;
	printf("Enter the radius of the circle: ");
	scanf("%lf", &roC);
	printf("Enter the width of the square: ");
	scanf("%lf", &woS);
	printf("Enter the width and the height of the rectangle: ");
	scanf("%lf %lf", &woR, &hoR);
	aoC = PISAYISI*roC*roC;
	poC = 2*PISAYISI*roC;
	aoS = woS*woS;
	poS = 4*woS;
	aoR = woR*hoR;
	poR = 2*woR + 2*hoR;

    //Print the table
	printf("+--------------+--------------+--------------+\n");
	printf("|              |     AREA     |   PERIMETER  |\n");
    printf("+--------------+--------------+--------------+\n");
    printf("|  CIRCLE      |%14.1lf|%14.1lf|",aoC,poC);  // Put space and print one character after point
    printf("\n|  SQUARE      |%14.1lf|%14.1lf|",aoS,poS);// Same here
    printf("\n|  RECTANGLE   |%14.1lf|%14.1lf|",aoR,poR); // same here
    printf("\n+--------------+--------------+--------------+\n");
    printf("|  AVERAGE     |%14.1lf|%14.1lf|",(aoC+aoS+aoR)/3,(poC+poS+poR)/3); // calculating and printing
    printf("\n+--------------+--------------+--------------+\n");
}




