/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12906
 *
 * 0부터 9까지의 자연수로만 이뤄진 배열에서 연속해서 중복으로 나타내는 숫자를 한개만 남기고 제거하는 문제.
 * 단, 제거된 후 남은 숫자들은 원본 배열에 있었던 순서를 유지해야 한다.
 */

function solution(arr) {
  const answer = [];

  arr.map((num) => {
    if (answer[answer.length - 1] === num) {
      answer.push(num);
    }
  });

  return answer;
}