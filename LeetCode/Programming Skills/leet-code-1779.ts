/**
 * https://leetcode.com/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/
 */

function nearestValidPoint(x: number, y: number, points: number[][]): number {
  let smallestIndex = -1;
  let smallestDistance = Infinity;

  for(let i = 0; i < points.length; i++) {
    if (x != points[i][0] && y != points[i][1]) {
      continue;
    }

    const distance = Math.abs(x - points[i][0]) + Math.abs(y - points[i][1]);
    if (distance < smallestDistance) {
      smallestIndex = i;
      smallestDistance = distance;
    }
  }

  return smallestIndex;
}