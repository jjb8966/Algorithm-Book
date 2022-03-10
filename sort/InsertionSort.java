package sort;

/**
 * 삽입 정렬 : 데이터를 하나씩 확인해 정렬된 숫자 사이에 삽입하는 방식으로 정렬
 * 시간 복잡도 : O(N^)
 * 배열이 어느 정도 정렬되어 있으면 매우 빠르게 동작
 */
public class InsertionSort {

    private static int[] values = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

    private static void process() {
        // 가장 첫번째 인덱스는 정렬되어있다고 생각하고 두번째 인덱스부터 정렬 시작
        for (int i = 1; i < values.length; i++) {
            for (int j = i; j > 0; j--) {
                if (values[j] < values[j - 1]) {
                    int temp = values[j];
                    values[j] = values[j - 1];
                    values[j - 1] = temp;
                } else {
                    break;      // 정렬하려는 숫자보다 작은 숫자를 만나게되면 그 왼쪽은 더 이상 볼 필요가 없으므로 break
                }
            }
        }

        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }
    }

    public static void main(String[] args) {
        process();
    }

}
