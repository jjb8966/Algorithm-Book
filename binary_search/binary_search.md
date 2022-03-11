# 5. 이진 탐색
> 데이터의 탐색 범위를 절반씩 좁혀가며 데이터를 탐색하는 방법
> 
- 배열 내부의 데이터가 정렬된 상태여야 함
- 변수 3개 사용
    - start, mid, end
- 동작 과정
    1. 배열의 시작 인덱스를 start, 마지막 인덱스를 end로 설정
    2. mid = (start + end) / 2로 설정
        - 실수인 경우 내림
        - ex) 4.5 → 4
    3. arr[mid]와 찾으려는 숫자(target)을 비교
        1. arr[mid] > target
            - mid 이후의 숫자는 안봐도 target보다 클 것이므로 mid의 왼쪽만 보면 됨
        2. arr[mid] > target
            - mid 이전의 숫자는 안봐도 target보다 작을 것이므로 mid의 오른쪽만 보면 됨
        3. arr[mid] == target
            - 찾고자하는 숫자를 찾음 → 결과로 mid 반환
- 시간 복잡도 : O(logN)

  → 한번 탐색할 때마다 탐색 범위가 절반으로 줄어듦

- 코드
    1. 재귀 함수 이용

        ```java
        public static void binarySearch(int start, int end) {
                int mid = (start + end) / 2;
        
                // 찾는 원소가 없는 경우
                if (start > end) {
                    System.out.println("원소가 존재하지 않습니다.");
                    return;
                }
        
                // 찾은 경우 결과 출력
                if (arr[mid] == target) {
                    result = mid + 1;
                    System.out.println(result);
                }
                // 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
                else if (arr[mid] > target) {
                    binarySearch(start, mid - 1);
                }
                // 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
                else {
                    binarySearch(mid + 1, end);
                }
            }
        ```

    2. 반복문 이용

        ```java
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
        ```
