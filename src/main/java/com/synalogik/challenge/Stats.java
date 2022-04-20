package com.synalogik.challenge;

import java.util.List;
import java.util.Map;

public class Stats {

    private final int wordCount;
    private final String averageWordLength;
    private final List<String> numberOfWordsOfLength;
    private final Map<Integer, List<Integer>> mostFrequentlyOccurring;

    private Stats(Builder builder) {
        wordCount = builder.wordCount;
        averageWordLength = builder.averageWordLength;
        numberOfWordsOfLength = builder.numberOfWordsOfLength;
        mostFrequentlyOccurring = builder.mostFrequentlyOccurring;
    }

    public static final class Builder {
        private int wordCount;
        private String averageWordLength;
        private List<String> numberOfWordsOfLength;
        private Map<Integer, List<Integer>> mostFrequentlyOccurring;

        public Builder() {
        }

        public Builder wordCount(int wordCount) {
            this.wordCount = wordCount;
            return this;
        }

        public Builder averageWordLength(String averageWordLength) {
            this.averageWordLength = averageWordLength;
            return this;
        }

        public Builder numberOfWordsOfLength(List<String> numberOfWordsOfLength) {
            this.numberOfWordsOfLength = numberOfWordsOfLength;
            return this;
        }

        public Builder mostFrequentlyOccurring(Map<Integer, List<Integer>> mostFrequentlyOccurring) {
            this.mostFrequentlyOccurring = mostFrequentlyOccurring;
            return this;
        }

        public Stats build() {
            return new Stats(this);
        }
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        String toString = "Word count = "+ wordCount +"\n" +
                "Average word length = "+ averageWordLength +"\n" +
                numberOfWordsOfLength;
        sb.append(toString);
        mostFrequentlyOccurring.forEach((k, v) -> sb.append(String.format("The most frequently occurring word length is %s, for word lengths of %s", k, v)));
        return sb.toString();
    }
}
