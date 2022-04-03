/**
 * https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 *
 * 주어진 정수의 각 자릿수를 곱한 결과와 각 자리수를 합한 결과의 차를 구하는 문제.
 *
 * solution 1 은 내가 처음에 짰던 코드, 그리고 solution 2 는 다른 사람이 짠 코드를 참조해서 다시 짠 코드.
 * solution 1 보다 오히려 solution 2 가 더 이해하기 쉬운거 같다.
 * 정수의 각 자릿수를 차례대로 순회해서 뭔가를 해야하는 알고리즘 문제를 풀 때 자주 쓰이는 패턴인거 같다.
 */

// solution 1
function subtractProductAndSum(n: number): number {
  const product = getProductOfDigits(n);
  const sum = getSumOfDigits(n);

  return product - sum;

};

function getProductOfDigits(n: number): number {
  let product = 1;
  while(n >= 1) {
    const lastDigit = n % 10;

    product *= lastDigit;

    n = Math.floor(n / 10);
  }

  return product;
}

function getSumOfDigits(n: number): number {
  let sum = 0;
  while(n >= 1) {
    const lastDigit = n % 10;

    sum += lastDigit;

    n = Math.floor(n / 10);
  }

  return sum;
}

// solution 2
function subtractProductAndSum(n: number): number {
  const product = (n + '').split('').map(Number).reduce((prod, cur) => prod * cur);
  const sum = (n + '').split('').map(Number).reduce((acc, cur) => acc + cur);

  return product - sum;

};