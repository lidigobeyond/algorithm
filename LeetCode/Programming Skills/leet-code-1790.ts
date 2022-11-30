/**
 * https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/description/
 *
 * 두 개의 문자열이 주어질 때, 한 문자열에 string swap 연산을 수행해서 나머지 문자열과 동등하게 만들 수 있는지 여부를 반환하는 문제.
 * string swap 연산이란 문자열의 i 번째 인덱스에 위치한 문자와 j 번째 인덱스에 위치한 문자를 서로 치환하는 연산. (i와 j는 같아도 상관 없음)
 *
 * 비구조화 할당 문법을 사용하면 임시 변수를 선언하지 않고도 두 변수의 값을 치환할 수 있다.
 */

function areAlmostEqual(s1: string, s2: string): boolean {
  if (s1 === s2) {
    return true;
  }

  for (let i = 0; i < s1.length; i++) {
    for (let j = 0; j < s1.length; j++) {
      if (swap(s1, i, j) === s2) {
        return true;
      }
    }
  }

  return false;
};

function swap(str: string, x: number, y: number): string {
  const arr = str.split('');

  [arr[x], arr[y]] = [arr[y], arr[x]];

  return arr.join('');
}