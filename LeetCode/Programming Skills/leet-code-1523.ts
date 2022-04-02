/**
 * https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/
 *
 * 두 개의 양의 정수 low 와 high 가 주어졌을 때, (low 와 high 를 포함한) low 와 high 사이에 있는 홀수의 개수를 구하는 문제.
 *
 * low 부터 high 까지 순회하면서 홀수의 개수를 세는 방식으로도 통과할 수 있다.
 * 하지만 O(1) 만에 답을 구할 수 있는 방법이 있었다.
 * 모든 숫자는 짝수 아니면 홀수니까, low 와 high 사이에 있는 홀수의 개수는 low 와 high 사이에 숫자의 개수의 절반과 거의 같을 거라는 것을 유추할 수 있다.
 * 하지만 항상 절반인 것은 아니고 low 와 high 가 홀수인지 짝수인지에 따라서 달라진다.
 * low 와 high 모두 홀수일 때 low 와 high 사이에 있는 홀수의 개수는 ⌊(high - low + 1) / 2⌋ + 1 개이고,
 * low 와 high 가 모두 홀수가 아닐 때 low 와 high 사이에 있는 홀수의 개수는 ⌊(high - low + 1) / 2⌋ 개이다.
 */

// solution 1
function countOdds(low: number, high: number): number {
  let count = 0;
  for(let i = low; i <= high; i++) {
    if (i % 2 == 1) {
      count += 1;
    }
  }

  return count;
}

// solution 2
function countOdds(low: number, high: number): number {
  if (isOdd(low) && isOdd(high)) {
    return Math.floor((high - low + 1) / 2) + 1;
  } else {
    return Math.floor((high - low + 1) / 2);
  }
}

function isOdd(num: number) {
  return num % 2 == 1;
}