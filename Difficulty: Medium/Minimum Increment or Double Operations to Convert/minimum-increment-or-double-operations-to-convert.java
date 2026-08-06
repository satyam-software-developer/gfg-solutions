class Solution {
    public int countMinOperations(int arr[]) {
        int operations = 0;

        while (true) {
            boolean allZero = true;

            for (int num : arr) {
                if (num != 0) {
                    allZero = false;
                    break;
                }
            }

            if (allZero) {
                break;
            }

            for (int i = 0; i < arr.length; i++) {
                if ((arr[i] & 1) == 1) {
                    arr[i]--;
                    operations++;
                }
            }

            boolean canDivide = true;

            for (int num : arr) {
                if (num != 0 && (num & 1) == 1) {
                    canDivide = false;
                    break;
                }
            }

            if (canDivide) {
                boolean hasNonZero = false;

                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] != 0) {
                        arr[i] /= 2;
                        hasNonZero = true;
                    }
                }

                if (hasNonZero) {
                    operations++;
                }
            }
        }

        return operations;
    }
}