package io.lenur.sort;

import java.util.Map;
import java.util.TreeMap;

public class CountingSort implements Sortable {
    @Override
    public void sort(int[] data) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i : data) {
            Integer v = map.get(i);
            map.put(i, v == null ? 1 : ++v);
        }

        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            while (count > 0) {
                data[index++] = entry.getKey();
                count--;
            }
        }
    }
}
