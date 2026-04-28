import java.util.Arrays;

public class Experiment {
    private Sorter sorter = new Sorter();
    private Searcher searcher = new Searcher();

    public long measureSortTime(int[] arr, String type) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        long start = System.nanoTime();
        if (type.equals("basic")) sorter.basicSort(copy);
        else if (type.equals("advanced")) sorter.advancedSort(copy);
        return System.nanoTime() - start;
    }

    public long measureSearchTime(int[] sortedArr, int target) {
        long start = System.nanoTime();
        searcher.search(sortedArr, target);
        return System.nanoTime() - start;
    }

    public void runAllExperiments() {
        int[] sizes = {10, 100, 1000};
        System.out.printf("%-6s %-12s %-14s %-12s %-14s %-8s%n",
                "Size", "Basic(Rand)", "Advanced(Rand)", "Basic(Sort)", "Advanced(Sort)", "Search");
        System.out.println("---------------------------------------------------------------");

        for (int size : sizes) {
            int[] random = Sorter.generateRandomArray(size);
            int[] sorted = new int[size];
            for (int i = 0; i < size; i++) sorted[i] = i;

            long basicRand = measureSortTime(random, "basic");
            long advancedRand = measureSortTime(random, "advanced");
            long basicSort = measureSortTime(sorted, "basic");
            long advancedSort = measureSortTime(sorted, "advanced");

            int[] randomSorted = Arrays.copyOf(random, random.length);
            sorter.advancedSort(randomSorted);
            int target = randomSorted[size / 2];
            long searchTime = measureSearchTime(randomSorted, target);

            System.out.printf("%-6d %-12d %-14d %-12d %-14d %-8d%n",
                    size, basicRand, advancedRand, basicSort, advancedSort, searchTime);
        }
    }
}