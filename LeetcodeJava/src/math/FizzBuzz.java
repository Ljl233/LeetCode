package math;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        String[] strings = new String[]{"Fizz", "Buzz"};
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                list.add("FizzBuzz");
                continue;
            } else if (i % 3 == 0) {
                list.add("Fizz");
                continue;
            } else if
            (i % 5 == 0) {
                list.add("Buzz");
                continue;
            } else {
                list.add(String.valueOf(i));
            }
        }
        return list;

    }
}
