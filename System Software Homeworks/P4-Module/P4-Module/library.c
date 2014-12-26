#include "library.h"


/*****************************************************
 * Computes x^b
 *****************************************************/
int Power(int x, int b){
	int power = 1;
	for (int i = 0; i < b; i++){
		power *= x;
	}
	return power;
} /* end-Power */

/*****************************************************
 * Computes the absolute value of an integer.
 *****************************************************/
int Abs(int x){
	return (x < 0) ? -x : x;
} /* end-Abs */

/*****************************************************
 * Computes the sum of the numbers from a to b
 * That is, a+(a+1)+(a+2)+...+(b-1)+b
 *****************************************************/
int Sum(int a, int b){
	int sum = 0;
	for (int i = a; i <= b; i++){
		sum += i;
	}
	return sum;
} /* end-Sum */

/*****************************************************
 * Computes n!
 * Recall: 0! = 1, n! = n*(n-1)*(n-2)*...*1
 * Must return -1 if n < 0
 *****************************************************/
int Factorial(int n){
	if (n >= 0){
		if (n == 0) return 1;
		if (n == 1) return 1;
		int partialFac = Factorial(n - 1);
		return  partialFac*n;
	}
	else return -1;
} /* end-Factorial */

/*****************************************************
 * Computes (n k) = n!/((n-k)!*k!)
 * If the input is invalid, i.e., n < 0 or k > n
 * then returns -1
 *****************************************************/
int Combination(int n, int k){
	if (n < 0 || k < 0 || n < k)
		return -1;
	else return Factorial(n) / (Factorial(n - k)*Factorial(k));
} /* end-Combination */

/*****************************************************
 * Computes the nth fibonacci number. Fibonacci numbers
 * are defined as follows:
 * F(0) = 0;
 * F(1) = 1;
 * F(n) = F(n-1)+F(n-2);
 *****************************************************/
int Fibonacci(int n){
	if (n <= 1) return n;
	int current=1, prev=1,temp;
	for (int i = 2; i < n; i++){
		temp = current;
		current += prev;
		prev = temp;
	}

	return current;
} /* end-ToLower */

/*****************************************************
 * Converts a character to uppercase if the char ch
 * is a letter in lowercase. Otherwise returns the input
 * without modification
 *****************************************************/
char ToUpper(char ch){
	char lower[32] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'ð', 'h',
		'j', 'k', 'l', 'm', 'n', 'o', 'ö', 'p', 'r', 's', 'þ', 't', 'u', 'ü', 'v', 'y', 'z', 'x', 'q' };
	char upper[32] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'Ð', 'H', 'I', 'Ý', 'J', 'K', 'L', 'M', 'N', 'O', 'Ö', 'P', 'R', 'S',
		'Þ', 'T', 'U', 'Ü', 'V', 'Y', 'Z', 'X', 'Q' };
	for (int i = 0; i < 29; i++){
		if (ch == lower[i]){
			ch = upper[i];
			break;
		}
	}
		return ch;
} /* end-ToUpper */

/*****************************************************
 * Converts a character to lowercase if the char ch
 * is a letter in uppercase. Otherwise returns the input
 * without modification
 *****************************************************/
char ToLower(char ch){
	char lower[32] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'ð', 'h',
		'j', 'k', 'l', 'm', 'n', 'o', 'ö', 'p', 'r', 's', 'þ', 't', 'u', 'ü', 'v', 'y', 'z','x','q'};
	char upper[32] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'Ð', 'H', 'I', 'Ý', 'J', 'K', 'L', 'M', 'N', 'O', 'Ö', 'P', 'R', 'S',
		'Þ', 'T', 'U', 'Ü', 'V', 'Y', 'Z', 'X', 'Q' };
	for (int i = 0; i < 29; i++){
		if (ch == upper[i]) {
			ch = lower[i];
			break;
		}
	}
		return ch;
		

} /* end-ToLower */

/*****************************************************
 * Returns 1 if the input is a digit char, i.e.,
 * one of '0', '1', '2', ...'9',
 * Returns 0 if the input ch is not a digit
 *****************************************************/
int IsDigit(char ch){
	int bool=0;
	int array[10] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	for (int i = 0; i < 10; i++){
		if (ch == array[i]){
			bool = 1;
			break;
		}
	}
	return bool;
} /* end-IsDigit */


/*****************************************************
 * Returns 1 if n is a prime number.
 * Returns 0 if n <= 0 or is not a prime number
 *****************************************************/
int IsPrime(int n){
	int bool;
	if (n >= 2){
		for (int i = 1; i < ((n / 2) + 1); i++){
			if (n % i == 0) bool = 0;
			else bool = 1;
			}
		return bool;
		}
 	else if(n<=0) return 0;
} 
