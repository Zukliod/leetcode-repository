class Solution {

    public static int[] count0strail(int[][] grid, int n) {
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    break;
                }
                count++;
            }

            arr[i] = count;
        }

        return arr;
    }

    public int minSwaps(int[][] grid) {
        int n = grid.length;

        int[] trailingZeros = count0strail(grid, n);

        int swaps = 0;

        for (int i = 0; i < n; i++) {
            int requiredZeros = n - i - 1;
            int j = i;
            while (j < n && trailingZeros[j] < requiredZeros) {
                j++;
            }
            if (j == n) {
                return -1;
            }
            while (j > i) {
                int temp = trailingZeros[j];
                trailingZeros[j] = trailingZeros[j - 1];
                trailingZeros[j - 1] = temp;

                swaps++;
                j--;
            }
        }

        return swaps;
    }
}