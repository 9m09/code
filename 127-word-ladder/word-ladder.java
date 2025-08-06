import java.util.*;

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;

        Set<String> remainingWords = new HashSet<>(wordList);
        Set<String> currentWords = new HashSet<>();
        currentWords.add(beginWord);
        int stepCount = 1;

        while (!currentWords.isEmpty()) {
            Set<String> nextWords = new HashSet<>();

            for (String word : currentWords) {
                List<String> toRemove = new ArrayList<>();

                for (String candidate : remainingWords) {
                    if (isOneLetterDifferent(word, candidate)) {
                        if (candidate.equals(endWord)) {
                            return stepCount + 1;
                        }
                        nextWords.add(candidate);
                        toRemove.add(candidate);
                    }
                }

                for (String rem : toRemove) {
                    remainingWords.remove(rem);
                }
            }

            currentWords = nextWords;
            stepCount++;
        }

        return 0;
    }

    private boolean isOneLetterDifferent(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
            if (diff > 1) return false;
        }
        return diff == 1;
    }
}
