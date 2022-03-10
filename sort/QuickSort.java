package sort;

/**
 * 퀵 정렬 : 기준 데이터(피벗)을 정하고 기준 데이터보다 큰 데이터와 작은 데이터의 위치를 바꾸는 방식으로 정렬
 * 가장 많이 사용되는 정렬 방식
 * 피벗을 정하고 리스트를 분할하는 방법에 따라 여러 방식으로 퀵 정렬을 구분
 * 예제는 가장 대표적인 분할 방식인 호어 분할(Hoare Partition)
 */
public class QuickSort {

    private static int[] values = {9, 5, 8, 0, 3, 1, 6, 2, 4, 7};

    private static void quickSort(int start, int end) {
        int pivot = start;
        int left = start + 1;
        int right = end;

        // 원소가 1개인 경우 종료
        if (start >= end) {
            return;
        }

        while (left <= right) {
            // 왼쪽에서부터 피벗보다 큰 숫자 찾기
            while (left <= end && values[left] <= values[pivot]) {
                left++;
            }

            // 오른쪽에서부터 피벗보다 작은 숫자 찾기
            while (right > start && values[right] >= values[pivot]) {
                right--;
            }

            // left, right 가 엇갈리지 않았다면 둘을 교체
            if (left <= right) {
                int temp = values[left];
                values[left] = values[right];
                values[right] = temp;
            } else {        // left, right 가 엇갈렸다면 pivot 과 values[right] (작은 수)를 교체
                int temp = values[pivot];
                values[pivot] = values[right];
                values[right] = temp;
            }
        }

        // pivot 기준으로 왼쪽, 오른쪽 리스트에 대해 다시 퀵 정렬
        quickSort(start, right - 1);
        quickSort(right + 1, end);
    }

    private static void process() {
        quickSort(0, values.length - 1);

        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }
    }

    public static void main(String[] args) {
        process();
    }
}
