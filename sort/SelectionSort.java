package sort;

/**
 * 선택 정렬 : 가장 작은 숫자를 찾아 맨 앞에 놓는 방식으로 정렬하는 방법
 * 시간 복잡도 : O(N^2)
 * 비효율적
 * 배열에서 최소값 찾는 알고리즘 익혀두기
 */
public class SelectionSort {

    private static int[] values = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

    private static void process() {
        for (int changeIndex = 0; changeIndex < values.length; changeIndex++) {
            int minimumNumberIndex = changeIndex;

            // changeIndex 다음부터 끝까지 수 중 가장 작은 수 찾기
            for (int findMinimum = changeIndex + 1; findMinimum < values.length; findMinimum++) {
                if (values[minimumNumberIndex] > values[findMinimum]) {
                    minimumNumberIndex = findMinimum;
                }
            }

            // values[changeIndex] <-> values[minimumNumberIndex]
            int temp = values[changeIndex];
            values[changeIndex] = values[minimumNumberIndex];
            values[minimumNumberIndex] = temp;
        }

        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }
    }

    public static void main(String[] args) {
        process();
    }
}
