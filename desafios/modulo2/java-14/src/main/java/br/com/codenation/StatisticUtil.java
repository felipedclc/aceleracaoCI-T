package br.com.codenation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StatisticUtil {

    public static int average(int[] elements) {
        int sum = 0, average;
        for (int element : elements) {
            sum += element;
        }
        average = sum / elements.length;
        return average;
    }

    public static int mode(int[] elements) {
        // https://stackoverflow.com/questions/60354070/how-to-count-duplicate-elements-in-array-in-java
        Map<Integer, Integer> mapList = new HashMap<>();
        Arrays.stream(elements).forEach(i -> { // n precisa declarar i como int
            if (mapList.containsKey(i)) mapList.put(i, mapList.get(i) + 1);
            else mapList.put(i, 1);
        });

        int numMaisRepetido = 0, rep = 0;
        for (Map.Entry<Integer, Integer> entry : mapList.entrySet()) {
            if (entry.getValue() > rep) {
                rep = entry.getValue();
                numMaisRepetido = entry.getKey();
            }
        }
        return numMaisRepetido;
    }

    public static int median(int[] elements) {
        Arrays.sort(elements);
        int middle = elements.length / 2;

        if (elements.length % 2 == 1) return elements[middle];
        return (int) ((elements[middle - 1] + elements[middle]) / 2.0);
    }
}