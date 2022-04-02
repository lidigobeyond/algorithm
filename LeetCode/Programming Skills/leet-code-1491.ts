/**
 * https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/
 *
 * 회사 직원들의 연봉 배열 salary 가 주어질 때, 가장 높은 연봉과 가장 낮은 연봉을 제외한 연봉의 평균을 계산하는 문제.
 * 연봉이 서로 같은 직원은 없다.
 *
 * JS Math 라이브러리를 이용하면 배열의 최소 원소값과 최대 원소값을 쉽게 구할 수 있다는걸 알았다.
 */

function average(salary: number[]): number {
  const numOfEmployees = salary.length;

  const min = Math.min(...salary);
  const max = Math.max(...salary);
  const sum = salary.reduce((acc, cur) => acc + cur);

  return (sum - min - max) / (numOfEmployees - 2);
}

