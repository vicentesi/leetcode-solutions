import java.util.Arrays;

class Solution2418 {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (heights[i] < heights[j]) {
                    int aux = heights[i];
                    heights[i] = heights[j];
                    heights[j] = aux;

                    String auxName = names[i];
                    names[i] = names[j];
                    names[j] = auxName;
                }
            }
        }

        return names;
    }

    public static void main(String[] args) {
        Solution2418 s = new Solution2418();

        String[] names = { "Mary", "John", "Emma" };
        int[] heights = { 180, 165, 170 };

        String[] names2 = { "Alice", "Bob", "Bob" };
        int[] heights2 = { 155, 185, 150 };

        // s.sortPeople(names, heights);

        // System.out.println(Arrays.toString(s.sortPeople(names, heights)));
        // System.out.println(Arrays.toString(s.sortPeople(names2, heights2)));

        // Get the runtime instance
        Runtime runtime = Runtime.getRuntime();

        // Run the garbage collector to get a more accurate measurement of memory usage
        runtime.gc();

        // Record the start time and memory usage
        long startTime = System.nanoTime();
        long startMemory = runtime.totalMemory() - runtime.freeMemory();

        // Your code here
        System.out.println(Arrays.toString(s.sortPeople(names2, heights2)));

        // Record the end time and memory usage
        long endTime = System.nanoTime();
        long endMemory = runtime.totalMemory() - runtime.freeMemory();

        // Calculate the duration and memory usage
        long duration = endTime - startTime;
        double durationInMilliseconds = (double) duration / 1_000_000.0;
        long memoryUsed = endMemory - startMemory;

        // Print the results
        System.out.println("Execution time: " + durationInMilliseconds + " milliseconds");
        System.out.println("Memory used: " + memoryUsed + " bytes");
    }
}