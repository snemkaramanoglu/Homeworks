#include <stdio.h>
#include "library.h"

/*************************************
 * Program entry point
 *************************************/
int main(void){
  int grade = 0;

  /* Test Power */
  if (Power(3, 4) == 3*3*3*3) grade += 5;
  if (Power(2, 10) == 1024) grade += 5;

  /* Test Abs */
  if (Abs(-2) == 2) grade += 3;
  if (Abs(5) == 5) grade += 2;

  /* Test Sum */
  if (Sum(1, 10) == 55) grade += 5;
  if (Sum(11, 20) == 210-55) grade += 5;
  if (Sum(100, 200) == 20100-4950) grade += 5;

  /* Test Factorial */
  if (Factorial(-2) < 0) grade += 2;
  if (Factorial(0) == 1) grade += 3;
  if (Factorial(7) == 7*6*5*4*3*2) grade += 5;

  /* Test Combination */
  if (Combination(-2, 2) < 0) grade += 2;
  if (Combination(3, 4) < 0) grade += 2;
  if (Combination(5,1) == 5) grade += 3;
  if (Combination(10, 4) == 210) grade += 3;

  /* Test Fibonacci */
  if (Fibonacci(0) == 0) grade += 2;
  if (Fibonacci(1) == 1) grade += 2;
  if (Fibonacci(6) == 8) grade += 3;
  if (Fibonacci(13) == 233) grade += 3;

  /* Test ToUpper */
  if (ToUpper('9') == '9') grade += 3;
  if (ToUpper('F') == 'F') grade += 3;
  if (ToUpper('d') == 'D') grade += 4;

  /* Test ToLower */
  if (ToLower('6') == '6') grade += 3;
  if (ToLower('f') == 'f') grade += 3;
  if (ToLower('D') == 'd') grade += 4;

  /* Test IsDigit */
  if (!IsDigit('f')) grade += 3;
  if (!IsDigit('D')) grade += 3;
  if (IsDigit('5')) grade += 4;

  /* Test IsPrime */
  if (IsPrime(-3) == 0) grade += 2;
  if (IsPrime(100) == 0) grade += 3;
  if (IsPrime(97)) grade += 5;

  /* Print the student's grade */
  printf("Your grade is: %d\n", grade);

  system("PAUSE");
} /* end-main */
