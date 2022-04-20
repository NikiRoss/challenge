package com.synalogik.challenge;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChallengeApplicationTests {
    StatService service = new StatService();

    String test = "Hello world & good morning The date is 18/05/2016";

    @Test
    public void getWordCount() {
        Assert.assertEquals(9, service.returnWordCount(test));
    }

    @Test
    public void getAverageWord() {
        Assert.assertEquals("4.56", service.returnAverageWordLength(test));
    }

    @Test
    public void getNumberOfWordsOfLength() {
        List<String> list = service.returnNumberOfWordsOfLength(test);
        Assert.assertTrue(String.valueOf(list), list.contains("Number of words of length 10 is 1"));
    }

    @Test
    public void getMostFrequentlyOccurringWordLength() {
        Map<Integer, List<Integer>> list = service.returnMostFrequentlyOccurringWordLength(test);
        Map.Entry<Integer, List<Integer>> entry = list.entrySet().iterator().next();
        List<Integer> response = list.get(entry.getKey());
        Assert.assertEquals(response.get(0), Optional.of(4).get());
    }
}
