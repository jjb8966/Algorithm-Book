package binary_search;

import java.util.*;

public class BinarySearchByWhile {

    private static int n;
    private static int target;
    private static int result;
    private static int[] arr;

    // 이진 탐색 소스코드 구현(재귀 함수)
    private static void input() {
        Scanner sc = new Scanner(System.in);

        // 원소의 개수(n)와 찾고자 하는 값(target)을 입력받기
        n = sc.nextInt();
        target = sc.nextInt();

        // 전체 원소 입력받기
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
    }

    // 이진 탐색 소스코드 구현(반복문)
    public static void binarySearch(int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;

            // 찾은 경우 중간점 인덱스 반환
            if (arr[mid] == target) {
                result = mid + 1;
                System.out.println(result);
                return;
            }
            // 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
            else if (arr[mid] > target) {
                end = mid - 1;
            }
            // 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
            else {
                start = mid + 1;
            }
        }

        System.out.println("원소가 존재하지 않습니다.");
    }

    public static void main(String[] args) {
        input();
        binarySearch(0, n - 1);
    }
}