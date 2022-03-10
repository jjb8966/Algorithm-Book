package sort;

import java.util.Arrays;

/**
 * 계수 정렬 : 인덱스의 계수를 이용해 정렬하는 방법
 * 양의 정수이고 데이터 사이의 가장 큰 차이가 1,000,000을 넘지 않을 때 사용하면 효과적
 * 특정 조건이 부합해야만 사용할 수 있지만 매우 빠름
 * 시간, 공간 복잡도 : O(N+K) - N : 데이터 갯수, K : 최대값
 * 어떤 경우 메모리 사용이 매우 비효율적일 수 있음
 * ex) 0, 999 -> 데이터의 갯수가 2개인데 int[1000]이 필요
 */
public class CountSort {

    private static int[] values = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8, 1, 1, 4, 3};

    private static void process() {
        int maxValue = Arrays.stream(values).max().getAsInt();
        int[] countCoefficient = new int[maxValue + 1];

        for (int number : values) {
            countCoefficient[number]++;
        }

        for (int i = 0; i <= maxValue; i++) {
            for (int j = 0; j < countCoefficient[i]; j++) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        process();
    }
}
