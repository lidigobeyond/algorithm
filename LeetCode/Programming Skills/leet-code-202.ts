/**
 * https://leetcode.com/problems/happy-number/
 *
 * reduce 메서드를 호출할 때 초기값을 따로 설정하지 않으면,
 * 최초로 호출되는 콜백함수에는 배열의 첫 번째 원소값이 accumulator 로 전달되고 배열의 두 번째 원소값이 current 로 전달된다.
 */

function isHappy(n: number): boolean {
  const set = new Set<number>();

  while(n != 1) {
    set.add(n);

    n = (n + '').split('').map(Number).reduce((acc, cur) => acc + cur ** 2, 0);

    if (set.has(n)) {
      return false;
    }
  }

  return true;
}