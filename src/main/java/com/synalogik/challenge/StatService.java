package com.synalogik.challenge;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StatService {
    
    public int returnWordCount(String string) {
        String[] strArr = string.split(" ");
        if (strArr.length != 0) {
            return strArr.length;
        }
        return 0;
    }

    public String returnAverageWordLength(String string) {
        String str1 = string.replaceAll("[!@£$%*?.,;:#]", "");
        str1 = str1.replaceAll(" ", "");
        float res1 = str1.length();
        float res2 = returnWordCount(string);
        float result = res1 / res2;
        return String.format("%.2f", result);
    }

    public List<String> returnNumberOfWordsOfLength(String string) {
        Map<Integer, Integer> count = wordCountMap(string);
        List<String> response = new ArrayList<>();
        count.forEach((k, v) -> {
            response.add(String.format("Number of words of length %s is %s \n", k, v));
        });
        return response;
    }

    public Map<Integer, List<Integer>> returnMostFrequentlyOccurringWordLength(String string) {
        Map<Integer, Integer> countMap = wordCountMap(string);
        Integer value = Collections.max(countMap.entrySet(), Map.Entry.comparingByValue()).getValue();

        List<Integer> keys = getMultiple(countMap, value);
        Map<Integer, List<Integer>> multiValueMap = new HashMap<>();
        multiValueMap.put(value, keys);
        return multiValueMap;
    }

    public final Map<Integer, Integer> wordCountMap(String string) {
        String str1 = string.replaceAll("[!@£$%*?.,;:#]", "");
        String[] strArr = str1.split(" ");
        Map<Integer, Integer> count = new HashMap<>();

        for(String s : strArr) {
            if (count.containsKey(s.length())) {
                count.put(s.length(),count.get(s.length()) + 1);
            } else {
                count.put(s.length(), 1);
            }
        }
        return count;
    }

    private List<Integer> getMultiple(Map<Integer, Integer> countMap, int maxValue) {
        List<Integer> keyList = new ArrayList<>();
        countMap.forEach((k, v) -> {
            if(v.equals(maxValue)) {
                keyList.add(k);
            }
        });
        return keyList;
    }
}
