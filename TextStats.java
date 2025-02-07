import java.io.*;
import java.util.regex.*;

public class TextStats {
    private final String text;

    public TextStats(String filePath) {
        this.text = readFile(filePath);
    }

    private String readFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return content.toString();
    }

    public int getCharCount() {
        return text.length();
    }

    public int getPalindromeCount() {
        int count = 0;
        String[] words = tokenizeText();
        for (String word : words) {
            if (!word.isEmpty() && isPalindrome(word.toLowerCase())) {
                count++;
            }
        }
        return count;
    }

    public int getTokenCount() {
        return tokenizeText().length;
    }

    public int getEmoticonCount() {
        Pattern emoticonPattern = Pattern.compile("[:;]-?[)D]");
        Matcher matcher = emoticonPattern.matcher(text);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    public int getNewLineCount() {
        return text.split("\n").length - 1;
    }

    public String getLongestToken() {
        String longestToken = "";
        for (String word : tokenizeText()) {
            if (word.length() > longestToken.length()) {
                longestToken = word;
            }
        }
        return longestToken;
    }

    public double getAverageTokenSize() {
        String[] words = tokenizeText();
        int totalLength = 0;
        for (String word : words) {
            totalLength += word.length();
        }
        return words.length == 0 ? 0 : (double) totalLength / words.length;
    }

    private boolean isPalindrome(String word) {
        int left = 0, right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private String[] tokenizeText() {
        return text.split("\\W+");
    }
}
