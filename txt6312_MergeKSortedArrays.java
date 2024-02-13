import java.util.PriorityQueue;

public class MergeKSortedArrays {
    static class ArrayEntry implements Comparable<ArrayEntry> {
        int value;
        int arrayIndex;
        int elementIndex;

        public ArrayEntry(int value, int arrayIndex, int elementIndex) {
            this.value = value;
            this.arrayIndex = arrayIndex;
            this.elementIndex = elementIndex;
        }

        @Override
        public int compareTo(ArrayEntry other) {
            return Integer.compare(this.value, other.value);
        }
    }

    public static int[] txt6312_mergeKSortedArrays(int[][] arrays) {
        PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<>();
        int totalSize = 0;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > 0) {
                minHeap.add(new ArrayEntry(arrays[i][0], i, 0));
                totalSize += arrays[i].length;
            }
        }

        int[] result = new int[totalSize];
        int resultIndex = 0;
        while (!minHeap.isEmpty()) {
            ArrayEntry currentEntry = minHeap.poll();
            result[resultIndex++] = currentEntry.value;
            if (currentEntry.elementIndex + 1 < arrays[currentEntry.arrayIndex].length) {
                minHeap.add(new ArrayEntry(arrays[currentEntry.arrayIndex][currentEntry.elementIndex + 1], currentEntry.arrayIndex, currentEntry.elementIndex + 1));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] arrays = {
            {1, 3, 5, 7},
            {2, 4, 6, 8},
            {0, 9, 10, 11}
        };

        int[] mergedArray = txt6312_mergeKSortedArrays(arrays);
        System.out.print("New Merged Array : { ");
        for (int num : mergedArray) {
            System.out.print(num + ", ");
        }
        System.out.print("} ");
    }
}
