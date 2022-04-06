/**
 * https://leetcode.com/problems/sign-of-the-product-of-an-array/
 *
 * 정수 배열 nums 가 주어질 때, nums 배열의 모든 원소를 곱한 결과값을 구하고 그 결과값이 양수이면 1, 0이면 0, 음수이면 -1를 반환하는 문제.
 *
 * nums 배열의 모든 원소를 곱한 결과값은 최대 100^1000 이 될 수 있기 때문에 Number 타입의 값으로 저장할 수 없다.
 * Number 타입으로 저장할 수 있는 값의 범위는 -(2^53 - 1) ~ (2^53 + 1) 이다.
 * 그런데 자바스크립트의 BigInt 객체(타입 아님)를 사용하면 Number 타입 보다 더 큰 정수값을 다룰 수 있다.
 * 다만 연산을 할 때 Number 타입의 값과 혼합해서 사용할 수 없다.
 */

// solution 1
function arraySign(nums: number[]): number {
    let numOfNegative = 0;
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] == 0) {
            return 0;
        }

        if (nums[i] < 0) {
            numOfNegative += 1;
        }
    }

    return numOfNegative % 2 == 0 ? 1 : -1;
}

// solution 2
function arraySign(nums: number[]): number {
  let product = BigInt(1);

  nums.forEach((num) => {
    product *= BigInt(num);
  });

  if (product > BigInt(0)) {
    return 1;
  } else if (product == BigInt(0)) {
    return 0;
  } else {
    return -1;
  }
}