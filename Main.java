public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        long startTime = System.nanoTime();

        try {
            TextStats stats = new TextStats("input1.text");
            displayStatistics(stats);
        } catch (Exception e) {
            System.err.println("Error processing file: " + e.getMessage());
        }

        long endTime = System.nanoTime();
        double executionTime = (endTime - startTime) / 1e9;
        System.out.printf("Execution time: %.3f seconds%n", executionTime);

        System.out.println("Program terminated properly.");
    }

    private void displayStatistics(TextStats stats) {
        System.out.printf("Total Character Count: %d%n", stats.getCharCount());
        System.out.printf("Total Palindromes Found: %d%n", stats.getPalindromeCount());
        System.out.printf("Total Number of Tokens: %d%n", stats.getTokenCount());
        System.out.printf("Total Number of Emoticons: %d%n", stats.getEmoticonCount());
        System.out.printf("Total New Lines: %d%n", stats.getNewLineCount());
        System.out.printf("Longest Token: %s%n", stats.getLongestToken());
        System.out.printf("Average Token Size: %.2f%n", stats.getAverageTokenSize());
    }
}
