#ifndef _LIBRARY_H_
#define _LIBRARY_H_

/*****************************************************
 * Computes x^b
 *****************************************************/
int Power(int x, int b);

/*****************************************************
 * Computes the absolute value of an integer.
 *****************************************************/
int Abs(int x);

/*****************************************************
 * Computes the sum of the numbers from a to b
 * That is, a+(a+1)+(a+2)+...+(b-1)+b
 *****************************************************/
int Sum(int a, int b);

/*****************************************************
 * Computes n!
 * Recall: 0! = 1, n! = n*(n-1)*(n-2)*...*1
 * Must return -1 if n < 0
 *****************************************************/
int Factorial(int n);

/*****************************************************
 * Computes (n k) = n!/((n-k)!*k!) 
 * If the input is invalid, i.e., n < 0 or k > n
 * then returns -1
 *****************************************************/
int Combination(int n, int k);

/*****************************************************
 * Computes the nth fibonacci number. Fibonacci numbers
 * are defined as follows:
 * F(0) = 0;
 * F(1) = 1;
 * F(n) = F(n-1)+F(n-2);
 *****************************************************/
int Fibonacci(int n);

/*****************************************************
 * Converts a character to uppercase if the char ch
 * is a letter in lowercase. Otherwise returns the input
 * without modification
 *****************************************************/
char ToUpper(char ch);

/*****************************************************
 * Converts a character to lowercase if the char ch
 * is a letter in uppercase. Otherwise returns the input
 * without modification
 *****************************************************/
char ToLower(char ch);

/*****************************************************
 * Returns 1 if the input is a digit char, i.e.,
 * one of '0', '1', '2', ...'9',
 * Returns 0 if the input ch is not a digit
 *****************************************************/
int IsDigit(char ch);

/*****************************************************
 * Returns 1 if n is a prime number.
 * Returns 0 if n <= 0 or is not a prime number
 *****************************************************/
int IsPrime(int n);

#endif
