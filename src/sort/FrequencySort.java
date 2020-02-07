package sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencySort {
    public String frequencySort(String s) {

        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        List<Character>[] bucket = new ArrayList[s.length() + 1];
        for (char c : frequencyMap.keySet()) {
            int key = frequencyMap.get(c);
            if (bucket[key] == null) {
                bucket[key] = new ArrayList<>();
            }
            bucket[key].add(c);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] == null) continue;

            for (char c : bucket[i])
                for (int j = i; j > 0; j--)
                    sb.append(c);


        }

        return sb.toString();
    }
}
