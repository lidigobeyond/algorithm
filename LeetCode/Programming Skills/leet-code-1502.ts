/**
 * https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/
 *
 * 정수 배열 arr 가 주어질 때, 배열을 재정렬해서 arithmetic progression 으로 만들 수 있는지 여부를 반환하는 문제.
 * arithmetic progression 란 임의의 연속된 두 숫자의 차이가 동일한 수열을 뜻한다.
 *
 * 문제를 제대로 안읽고 너무 어렵게 생각했다...
 * 만약 어떤 수열에서 임의의 연속된 두 숫자의 차이가 동일하다면, 해당 수열은 내림차순이나 오름차순으로 정렬된 상태일 것이다.
 * 그러므로 arr 을 재정렬해서 arithmetic progression 으로 만들 수 있는지 여부는,
 * arr 을 내림차순이나 오름차순으로 정렬한 다음, 모든 연속된 원소들의 차이가 동일한지 확인하면 알 수 있다.
 */

function canMakeArithmeticProgression(arr: number[]): boolean {
  arr.sort((a, b) => a - b);

  const diff = arr[0] - arr[1];
  for(let i = 1; i < arr.length - 1; i++) {
    if (arr[i] - arr[i+1] != diff) {
      return false;
    }
  }

  return true;
};