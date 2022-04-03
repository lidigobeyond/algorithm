/**
 * https://leetcode.com/problems/number-of-1-bits/
 *
 * 부호가 없는 32비트로 표현 가능한 임의의 정수가 주어졌을 때, 정수를 이진수로 표현했을 때 값이 1인 비트의 개수를 구하는 문제.
 *
 * 자바스크립트에서도 비트 연산이 가능하다는걸 새삼스럽게 깨닫게 됐다.
 * 그리고 자바스크립트에서는 비트 연산을 수행할 때 피연산자들을 32비트 정수로 변환한다는 것도 새롭게 알게 됐다.
 * 만약에 피연산자가 32비트 이상의 숫자이면, 32비트 이상의 최상위 비트들은 모두 삭제된다고 한다.
 *
 * 자바스크립트에는 right shift 연산이 두가지가 있다.
 * 부호 비트를 사용하여 비워진 공간을 채워주는 signed right shift(>>) 연산과,
 * 비워진 공간을 그냥 0으로 채워주는 unsigned right shift(>>>) 연산이다.
 */

function hammingWeight(n: number): number {
  let count = 0;

  while(n != 0) {
    if (n & 1) {
      count += 1;
    }

    n >>>= 1;
  }

  return count;
}